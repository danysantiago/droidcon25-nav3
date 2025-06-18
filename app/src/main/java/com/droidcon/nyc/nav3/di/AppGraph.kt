package com.droidcon.nyc.nav3.di

import android.app.Application
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides

@DependencyGraph(scope = AppScope::class, isExtendable = true)
interface AppGraph {

    @Provides
    @Named("WelcomeMsg")
    private fun provideWelcomeMsg(): String = "Welcome!"

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Provides app: Application): AppGraph
    }
}