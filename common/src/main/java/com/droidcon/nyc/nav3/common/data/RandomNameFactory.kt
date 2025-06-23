package com.droidcon.nyc.nav3.common.data

import kotlin.random.Random

class RandomNameFactory {
    fun name(): String {
        return if (Random.nextInt(0, 10) %  2 == 0) "Dany" else "Jeremy"
    }
}