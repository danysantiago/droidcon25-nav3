package com.droidcon.nyc.nav3.metro

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey
import dev.zacsweers.metro.AppScope
import kotlin.reflect.KClass

annotation class NavEntryContent(
    val key: KClass<out NavKey>,
    val scope: KClass<*> = AppScope::class
)

abstract class BaseNavEntryProvider {
    abstract fun install(builder: EntryProviderBuilder<NavKey>)
}