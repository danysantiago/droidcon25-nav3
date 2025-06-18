package com.droidcon.nyc.nav3.explore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Serializable

@Serializable
object Explore : NavKey, TopLevelRoute { override val icon = Icons.Default.Search }

@NavEntryContent(key = Explore::class, scope = UiScope::class)
@Composable
fun ExploreScreen() {
    Text("This is the explore screen!")
}