package com.droidcon.nyc.nav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
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
                Scaffold { padding ->
                    NavDisplay(
                        backStack = backStack,
                        modifier = Modifier.padding(padding),
                        entryProvider = { key ->
                            when (key) {
                                is Feed -> NavEntry(Feed) {
                                    FeedScreen(backstack = backStack)
                                }
                                is Profile -> NavEntry(Profile) {
                                    ProfileScreen()
                                }
                                is Post -> NavEntry(Post(key.cat)) {
                                    PostScreen(backstack = backStack, post = key)
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
