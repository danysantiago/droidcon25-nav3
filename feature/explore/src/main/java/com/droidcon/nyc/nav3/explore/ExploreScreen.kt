package com.droidcon.nyc.nav3.explore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Serializable

@Serializable
object Explore : NavKey

@NavEntryContent(key = Explore::class, scope = UiScope::class)
@Composable
fun ExploreScreen() {
    Text("This is the explore screen!")
}