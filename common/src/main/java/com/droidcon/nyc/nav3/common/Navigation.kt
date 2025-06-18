package com.droidcon.nyc.nav3.common

import androidx.navigation3.runtime.NavKey

interface Navigator {
    fun navigateTo(key: NavKey)
    fun navigateBack()
}
