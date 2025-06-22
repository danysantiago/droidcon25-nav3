package com.droidcon.nyc.nav3.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.TopLevelRoute

class TopLevelBackStack<T : NavKey>(startKey: TopLevelRoute) {

    private val topLevelBackStacks = mutableMapOf(startKey to mutableListOf<NavKey>(startKey))

    // Expose the back stack so it can be rendered by the NavDisplay
    private val _currentBackStack = mutableStateListOf<NavKey>(startKey)
    val currentBackStack: SnapshotStateList<NavKey>
        get() = _currentBackStack

    var currentTopLevel by mutableStateOf(startKey)
        private set

    /* Switch to top level destination */
    fun swapTopLevel(key: TopLevelRoute) {
        if (key !in topLevelBackStacks) {
            topLevelBackStacks[key] = mutableListOf(key)
        }
        currentTopLevel = key
        updateBackStack()
    }

    /* Add to current backstack */
    fun add(key: T) {
        topLevelBackStacks[currentTopLevel]?.add(key)
        updateBackStack()
    }

    /* Pop from current backstack */
    fun removeLast() {
        val removedKey = topLevelBackStacks[currentTopLevel]?.removeLastOrNull()
        topLevelBackStacks.remove(removedKey)
        updateBackStack()
    }

    /* Updates the active backstack */
    private fun updateBackStack() {
        _currentBackStack.clear()
        _currentBackStack.addAll(topLevelBackStacks.getValue(currentTopLevel))
    }
}