package com.droidcon.nyc.nav3.metro

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import dev.zacsweers.metro.AppScope
import kotlin.reflect.KClass

annotation class NavEntryContent(
    val key: KClass<out NavKey>,
    val scope: KClass<*> = AppScope::class
)

abstract class BaseNavEntryProvider<T : NavKey> {
    operator fun invoke(key: T): NavEntry<T> {
        return NavEntry(key) { Content(it) }
    }

    @Composable
    abstract fun Content(key: T)
}