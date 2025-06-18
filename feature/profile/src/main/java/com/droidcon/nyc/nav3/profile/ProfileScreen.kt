package com.droidcon.nyc.nav3.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Serializable


@Serializable
object Profile : NavKey, TopLevelRoute { override val icon = Icons.Default.Home }

@NavEntryContent(key = Profile::class, scope = UiScope::class)
@Composable
internal fun ProfileScreen() {
    Text("This is the Profile")
}