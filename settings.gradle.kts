@file:Suppress("UnstableApiUsage")

include(":feature:explore")


include(":extension:metro-nav3-runtime")


include(":extension:metro-nav3-compiler")


include(":feature:feed")


include(":feature:post")


include(":feature:profile")


include(":common")


pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NYCDroidCon25"
include(":app")
 