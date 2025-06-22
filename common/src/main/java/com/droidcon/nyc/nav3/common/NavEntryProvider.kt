package com.droidcon.nyc.nav3.common

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey

typealias NavEntryProvider = (EntryProviderBuilder<NavKey>) -> Unit