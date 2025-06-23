package com.droidcon.nyc.nav3.common.di

import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.metro.BaseNavEntryProvider
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesGraphExtension
import dev.zacsweers.metro.Provides

@ContributesGraphExtension(UiScope::class)
interface UiGraph {
    val navEntries: Set<BaseNavEntryProvider>

    val topLevelRoutes: Set<TopLevelRoute>

    @ContributesGraphExtension.Factory(AppScope::class)
    fun interface Factory {
        fun createUiGraph(@Provides backstack: TopLevelBackStack<NavKey>): UiGraph
    }
}