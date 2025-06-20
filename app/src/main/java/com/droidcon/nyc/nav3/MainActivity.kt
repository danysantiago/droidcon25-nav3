package com.droidcon.nyc.nav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.common.di.UiGraph
import com.droidcon.nyc.nav3.explore.Explore
import com.droidcon.nyc.nav3.feed.Feed
import com.droidcon.nyc.nav3.profile.Profile
import com.droidcon.nyc.nav3.ui.theme.NycDroidConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NycDroidConTheme {
                val topLevelBackStack = remember { TopLevelBackStack<NavKey>(Feed) }
                val graph = remember<UiGraph> {
                    getAppGraph().createUiGraph(topLevelBackStack)
                }
                val routes : List<TopLevelRoute> = listOf(Feed, Profile, Explore)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            routes.forEach { topLevelRoute ->
                                val isSelected = topLevelRoute == topLevelBackStack.topLevelKey
                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        topLevelBackStack.swapTopLevel(topLevelRoute)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = topLevelRoute.icon,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavDisplay(
                        backStack = topLevelBackStack.backStack,
                        modifier = Modifier.padding(padding),
                        entryProvider = entryProvider {
                            graph.navEntries.forEach { it.install(this) }
                        }
                    )
                }
            }
        }
    }
}
