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
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.droidcon.nyc.nav3.common.TopLevelBackStack
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
                val backStack = remember { TopLevelBackStack<NavKey>(Feed) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val topLevelRoutes = listOf(Feed, Profile)
                        NavigationBar {
                            topLevelRoutes.forEach { route ->
                                NavigationBarItem(
                                    selected = route == backStack.currentTopLevel,
                                    onClick = {
                                        backStack.swapTopLevel(route)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = route.icon,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavDisplay(
                        backStack = backStack.currentBackStack,
                        modifier = Modifier.padding(padding),
                        entryProvider = { key ->
                            when (key) {
                                is Feed -> NavEntry(Feed) {
                                    FeedScreen(backstack = backStack)
                                }
                                is Post -> NavEntry(Post(key.cat)) {
                                    PostScreen(backstack = backStack, post = key)
                                }
                                is Profile -> NavEntry(Profile) {
                                    ProfileScreen()
                                }
                                else -> error("Unknown key: $key")
                            }
                        }
                    )
                }
            }
        }
    }
}
