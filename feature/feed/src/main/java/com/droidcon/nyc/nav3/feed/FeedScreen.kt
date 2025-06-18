package com.droidcon.nyc.nav3.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.Navigator
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.explore.Explore
import com.droidcon.nyc.nav3.metro.NavEntryContent
import com.droidcon.nyc.nav3.post.Post
import com.droidcon.nyc.nav3.profile.Profile
import dev.zacsweers.metro.Named
import kotlinx.serialization.Serializable

@Serializable
object Feed : NavKey

@NavEntryContent(key = Feed::class, scope = UiScope::class)
@Composable
internal fun FeedScreen(navigator: Navigator, @Named("WelcomeMsg") welcomeMsg: String) {
    Column {
        Text(welcomeMsg)
        Button(onClick = { navigator.navigateTo(Post(1)) }) {
            Text("Go to Post #1")
        }
        Button(onClick = { navigator.navigateTo(Post(2)) }) {
            Text("Go to Post #2")
        }
        Button(onClick = { navigator.navigateTo(Profile) }) {
            Text("Go to Profile")
        }

        Button(onClick = { navigator.navigateTo(Explore) }) {
            Text("Go to Explore")
        }
    }
}