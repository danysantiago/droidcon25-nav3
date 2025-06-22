package com.droidcon.nyc.nav3.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlin.collections.remove

class TopLevelBackStack<T : Any>(startKey: T) {

    // Expose the back stack so it can be rendered by the NavDisplay
    val backStack = mutableStateListOf(startKey)

    private fun updateBackStack() {

    }

    fun swapTopLevel(key: T) {

    }

    fun add(key: T) {

    }

    fun removeLast() {

    }
}