package com.droidcon.nyc.nav3.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.Navigator
import com.droidcon.nyc.nav3.common.data.Cat
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Post(@Contextual val cat: Cat) : NavKey

@NavEntryContent(key = Post::class, scope = UiScope::class)
@Composable
internal fun PostScreen(navigator: Navigator, post: Post) {
    val cat = post.cat
    Column {
        Box {
            val imageModifier =
                Modifier.size(300.dp)
            Image(painterResource(cat.imageId), cat.text, imageModifier)
        }
        Text(cat.text)
        Text(cat.author)
        Button(
            onClick = { navigator.navigateBack() },
            colors = ButtonDefaults.buttonColors(containerColor = LightGray),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Go to Previous screen")
        }
    }
}


