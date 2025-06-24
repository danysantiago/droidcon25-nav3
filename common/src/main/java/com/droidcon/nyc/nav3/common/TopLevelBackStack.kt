package com.droidcon.nyc.nav3.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.TopLevelRoute

class TopLevelBackStack<T : NavKey>(startKey: TopLevelRoute) {

    private val multipleBackstack: MutableMap<TopLevelRoute, MutableList<NavKey>> =

    val currentTopLevelRoute: State<TopLevelRoute> =
        private set

    private val _currentBackstack: SnapshotStateList<NavKey>

    val currentBackStack: List<NavKey>
        get() = _currentBackstack


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