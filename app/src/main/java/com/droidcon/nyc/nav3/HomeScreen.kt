package com.droidcon.nyc.nav3

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object Home : NavKey

@Composable
fun HomeScreen(navigateToProfile: () -> Unit) {
    Column {
        Text("Home")
        Button(onClick = { navigateToProfile() }) {
            Text("Go to Profile")
        }
    }
}