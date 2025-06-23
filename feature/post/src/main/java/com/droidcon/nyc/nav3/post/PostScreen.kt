package com.droidcon.nyc.nav3.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.Cat
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Post(@Contextual val cat: Cat): NavKey

@Composable
internal fun PostScreen(backstack: SnapshotStateList<NavKey>, post: Post) {
    val cat = post.cat
    Column {
        Text(cat.author, fontSize = 30.sp)
        Box {
            val imageModifier =
                Modifier.size(300.dp)
            Image(painterResource(cat.imageId), cat.text, imageModifier)
        }
        Text(cat.text, modifier = Modifier.padding(10.dp))
        Spacer(Modifier.width(20.dp))
        Button(
            onClick = { cat.favorite.value = !cat.favorite.value },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Companion.Blue),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = if (cat.favorite.value) "Remove Favorite" else "Add Favorite")
        }
        Button(
            onClick = { backstack.removeLast() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Companion.Red),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Go to Previous screen")
        }
    }
}
