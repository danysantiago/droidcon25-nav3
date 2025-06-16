package com.droidcon.nyc.nav3

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
object Profile : NavKey

@Composable
fun ProfileScreen() {
    Text("This is the Profile")
}