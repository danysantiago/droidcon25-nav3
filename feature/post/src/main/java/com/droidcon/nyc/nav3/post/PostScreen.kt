package com.droidcon.nyc.nav3.post

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Serializable

@Serializable
data class Post(val id: Int) : NavKey

@NavEntryContent(key = Post::class, scope = UiScope::class)
@Composable
internal fun PostScreen(post: Post) {
    Text("This is the Post ${post.id}")
}


