package com.droidcon.nyc.nav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.droidcon.nyc.nav3.ui.theme.NycDroidConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NycDroidConTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    val backStack = rememberNavBackStack(Home)
                    NavDisplay(backStack, modifier = Modifier.padding(padding)) {
                        when (it) {
                            is Home -> NavEntry(Home) {
                                HomeScreen { backStack.add(Profile) }
                            }

                            is Profile -> NavEntry(Profile) {
                                ProfileScreen()
                            }

                            else -> error("Incorrect destination")
                        }
                    }
                }
            }
        }
    }
}