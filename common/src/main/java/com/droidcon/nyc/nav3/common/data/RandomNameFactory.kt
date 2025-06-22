package com.droidcon.nyc.nav3.common.data

import dev.zacsweers.metro.Inject
import kotlin.random.Random

class RandomNameFactory @Inject constructor() {
    fun name(): String {
        return if (Random.nextInt(0, 10) %  2 == 0) "Dany" else "Jeremy"
    }
}