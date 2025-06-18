package com.droidcon.nyc.nav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.droidcon.nyc.nav3.common.Navigator
import com.droidcon.nyc.nav3.common.di.UiGraph
import com.droidcon.nyc.nav3.feed.Feed
import com.droidcon.nyc.nav3.ui.theme.NycDroidConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NycDroidConTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    val backStack = rememberNavBackStack(Feed)
                    val graph = remember<UiGraph> {
                        this.getAppGraph().createUiGraph(
                            object : Navigator {
                                override fun navigateTo(key: NavKey) {
                                    backStack.add(key)
                                }

                                override fun navigateBack() {
                                    backStack.removeAt(backStack.lastIndex)
                                }
                            }
                        )
                    }
                    NavDisplay(backStack, modifier = Modifier.padding(padding)) {
                        graph.navEntries[it::class]?.invoke(it) ?: error("Unknown destination: $it")
                    }
                }
            }
        }
    }
}