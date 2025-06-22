package com.droidcon.nyc.nav3.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.TopLevelRoute

class TopLevelBackStack<T : NavKey>(startKey: T) {

    /* Switch to top level destination */
    fun swapTopLevel(key: TopLevelRoute) {

    }

    /* Add to current backstack */
    fun add(key: T) {

    }

    /* Pop from current backstack */
    fun removeLast() {

    }

    /* Updates the active backstack */
    private fun updateBackStack() {

    }
}