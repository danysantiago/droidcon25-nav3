package com.droidcon.nyc.nav3.metro

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.FunctionKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.ksp.toAnnotationSpec
import com.squareup.kotlinpoet.ksp.toClassName
import com.squareup.kotlinpoet.ksp.toTypeName
import com.squareup.kotlinpoet.ksp.writeTo

class NavEntryProcessor(
    val env: SymbolProcessorEnvironment
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver.getSymbolsWithAnnotation("com.droidcon.nyc.nav3.metro.NavEntryContent")
            .filterIsInstance<KSFunctionDeclaration>()
            .mapNotNull { processContentDeclaration(resolver, it) }
            .forEach {
                writeContribution(it)
            }
        return emptyList()
    }

    private fun processContentDeclaration(
        resolver: Resolver,
        declaration: KSFunctionDeclaration
    ): NavContentContribution? {
        val isTopLevel = declaration.functionKind == FunctionKind.TOP_LEVEL
        if (!isTopLevel) {
            env.logger.error("NavEntryContent-annotated function must be top-level.", declaration)
            return null
        }

        val hasComposableAnnotation =
            declaration.annotations.any { it.shortName.asString() == "Composable" }
        if (!hasComposableAnnotation) {
            env.logger.error(
                "NavEntryContent-annotated function must be a @Composable function",
                declaration
            )
            return null
        }

        val returnsUnit = declaration.returnType?.resolve() == resolver.builtIns.unitType
        if (!returnsUnit) {
            env.logger.error("NavEntryContent-annotated function must return $UNIT", declaration)
            return null
        }

        val navEntryContentAnnotation = declaration.annotations.firstOrNull {
            it.shortName.asString() == "NavEntryContent"
        }
        if (navEntryContentAnnotation == null) {
            error("Couldn't find @NavEntryContent")
        }
        val classKey =
            navEntryContentAnnotation.arguments.first { it.name!!.asString() == "key" }.value as KSType
        val classScope =
            navEntryContentAnnotation.arguments.first { it.name!!.asString() == "scope" }.value as KSType

        val parameters = declaration.parameters.mapIndexed { index, param ->
            val paramName = if (param.type.resolve() == classKey) {
                "key"
            } else {
                param.name?.asString() ?: "p$index"
            }

            ParameterSpec.builder(paramName, param.type.toTypeName())
                .addAnnotations(param.annotations.map { it.toAnnotationSpec() }.toList())
                .build()
        }

        return NavContentContribution(
            functionName = declaration.simpleName.asString(),
            packageName = declaration.packageName.asString(),
            classKey = classKey.toClassName(),
            classScope = classScope.toClassName(),
            parameters = parameters,
            originating = declaration.containingFile,
        )
    }

    private fun writeContribution(contribution: NavContentContribution) {
        val providerSimpleName = contribution.functionName + "_NavEntryProvider"
        val providerName = ClassName(contribution.packageName, providerSimpleName)

        val typeSpec = TypeSpec.classBuilder(providerName)
            .addAnnotation(
                AnnotationSpec.builder(ClassName("dev.zacsweers.metro", "ContributesIntoMap"))
                    .addMember("scope = %T::class", contribution.classScope)
                    .addMember(
                        "binding = %T<%T>()",
                        ClassName("dev.zacsweers.metro", "binding"),
                        ClassName(
                            "com.droidcon.nyc.nav3.metro",
                            "BaseNavEntryProvider"
                        ).parameterizedBy(
                            ClassName("androidx.navigation3.runtime", "NavKey")
                        )
                    )
                    .build()
            )
            .addAnnotation(
                AnnotationSpec.builder(ClassName("dev.zacsweers.metro", "ClassKey"))
                    .addMember("%T::class", contribution.classKey)
                    .build()
            )
            .addAnnotation(ClassName("dev.zacsweers.metro", "Inject"))
            .superclass(
                ClassName("com.droidcon.nyc.nav3.metro", "BaseNavEntryProvider")
                    .parameterizedBy(contribution.classKey)
            )
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameters(contribution.parameters.filterNot { it.name == "key" })
                    .build()
            )
            .addProperties(
                contribution.parameters.filterNot { it.name == "key" }.map {
                    PropertySpec.builder(it.name, it.type, KModifier.PRIVATE)
                        .initializer(it.name)
                        .build()
                }
            )
            .addFunction(
                FunSpec.builder("Content")
                    .addAnnotation(ClassName("androidx.compose.runtime", "Composable"))
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameter("key", contribution.classKey)
                    .addStatement(
                        "%L(${contribution.parameters.joinToString { "%L" }})",
                        contribution.functionName,
                        *contribution.parameters.map { it.name }.toTypedArray()
                    )
                    .build()
            )
            .build()

        val fileSpec = FileSpec.builder(providerName)
            .addType(typeSpec)
            .build()

        fileSpec.writeTo(env.codeGenerator, false, listOf(contribution.originating!!))
    }

    data class NavContentContribution(
        val functionName: String,
        val packageName: String,
        val classKey: ClassName,
        val classScope: ClassName,
        val parameters: List<ParameterSpec>,
        val originating: KSFile?,
    )

    class Provider : SymbolProcessorProvider {
        override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
            return NavEntryProcessor(environment)
        }
    }
}