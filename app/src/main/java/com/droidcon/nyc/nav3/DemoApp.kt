package com.droidcon.nyc.nav3

import android.app.Activity
import android.app.Application
import com.droidcon.nyc.nav3.di.AppGraph
import dev.zacsweers.metro.createGraphFactory

class DemoApp : Application() {
    val graph by lazy { createGraphFactory<AppGraph.Factory>().create(this) }
}

fun Activity.getAppGraph() =
    (application as DemoApp).graph