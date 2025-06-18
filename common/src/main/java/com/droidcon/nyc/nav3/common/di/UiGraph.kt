package com.droidcon.nyc.nav3.common.di

import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.Navigator
import com.droidcon.nyc.nav3.metro.BaseNavEntryProvider
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesGraphExtension
import dev.zacsweers.metro.Multibinds
import dev.zacsweers.metro.Provides
import kotlin.reflect.KClass

@ContributesGraphExtension(UiScope::class)
interface UiGraph {
    @Multibinds
    val navEntries: Map<KClass<*>, BaseNavEntryProvider<NavKey>>

    @ContributesGraphExtension.Factory(AppScope::class)
    fun interface Factory {
        fun createUiGraph(@Provides navigator: Navigator): UiGraph
    }
}