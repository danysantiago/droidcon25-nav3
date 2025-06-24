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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.feed.Feed
import com.droidcon.nyc.nav3.feed.FeedScreen
import com.droidcon.nyc.nav3.post.Post
import com.droidcon.nyc.nav3.post.PostScreen
import com.droidcon.nyc.nav3.profile.Profile
import com.droidcon.nyc.nav3.profile.ProfileScreen
import com.droidcon.nyc.nav3.ui.theme.NycDroidConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NycDroidConTheme {
                val backStack = remember { mutableStateListOf<NavKey>(Feed) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            val topLevelRoutes: List<TopLevelRoute>
                            topLevelRoutes.forEach { route ->
                                NavigationBarItem(
                                    selected = ,
                                    onClick = ,
                                    icon = {
                                        Icon(imageVector = route.icon, contentDescription = null)
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavDisplay(
                        backStack = backStack,
                        modifier = Modifier.padding(padding),
                        entryProvider = entryProvider {
                            entry<Feed> {
                                FeedScreen(backstack = backStack)
                            }
                            entry<Post> { post ->
                                PostScreen(backstack = backStack, post = post)
                            }
                            entry<Profile> {
                                ProfileScreen()
                            }
                        }
                    )
                }
            }
        }
    }
}
