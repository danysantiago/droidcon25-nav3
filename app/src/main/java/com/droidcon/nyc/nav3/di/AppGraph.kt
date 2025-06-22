package com.droidcon.nyc.nav3.di

import android.app.Application
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.RandomNameFactory
import com.droidcon.nyc.nav3.feed.feedEntryProvider
import com.droidcon.nyc.nav3.post.postEntryProvider
import com.droidcon.nyc.nav3.profile.profileEntryProvider
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@DependencyGraph(scope = AppScope::class)
interface AppGraph {
    val navEntryProvider: NavEntryProvider

    @Provides
    private fun provideNavEntryProvider(
        topLevelBackStack: TopLevelBackStack<NavKey>,
        nameFactory: RandomNameFactory,
    ): NavEntryProvider = { builder ->
        builder.apply {
            profileEntryProvider(nameFactory.name())
            feedEntryProvider(topLevelBackStack)
            postEntryProvider(topLevelBackStack)
        }
    }

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Provides backStack: TopLevelBackStack<NavKey>): AppGraph
    }
}

typealias NavEntryProvider = (EntryProviderBuilder<NavKey>) -> Unit