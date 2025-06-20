package com.droidcon.nyc.nav3.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.data.Cat
import com.droidcon.nyc.nav3.common.data.catList
import com.droidcon.nyc.nav3.post.Post
import com.droidcon.nyc.nav3.profile.Profile
import kotlinx.serialization.Serializable

@Serializable
object Feed : NavKey

@Composable
fun FeedScreen(backstack: MutableList<NavKey>) {
    Column {
        Row {
            Text("Feed", fontSize = 30.sp, color = Color.Blue)
            Spacer(Modifier.weight(1f))
            Button(onClick = { backstack.add(Profile) }) {
                Text("Profile")
            }
        }
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(catList) { cat: Cat ->
                Row(Modifier.clickable { backstack.add(Post(cat)) }) {
                    val imageModifier = Modifier
                        .size(100.dp)
                        .padding(10.dp)
                    Image(painterResource(cat.imageId), cat.text, imageModifier)
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight()) {
                        Spacer(Modifier.height(10.dp))
                        Text(cat.author)
                        Text("${cat.text.take(70)}${if (cat.text.length > 70) "..." else ""}", modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth())
                    }
                }
            }
        }
    }
}