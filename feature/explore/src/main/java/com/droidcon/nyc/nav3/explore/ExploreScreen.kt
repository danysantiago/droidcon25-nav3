package com.droidcon.nyc.nav3.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.Cat
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.common.data.catList
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import com.droidcon.nyc.nav3.post.Post
import dev.zacsweers.metro.ContributesIntoSet
import kotlinx.serialization.Serializable

@Serializable
@ContributesIntoSet(scope = UiScope::class)
object Explore : TopLevelRoute { override val icon = Icons.Default.Search }

@NavEntryContent(key = Explore::class, scope = UiScope::class)
@Composable
fun ExploreScreen(backstack: TopLevelBackStack<NavKey>) {
    Column {
        Text("Explore", fontSize = 30.sp, color = Color.Blue)
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
            items(catList.distinctBy { it.author }) { cat: Cat ->
                Column {
                    val imageModifier = Modifier.fillMaxWidth().wrapContentWidth().size(100.dp).clickable { backstack.add(Post(cat)) }
                    Image(painterResource(cat.imageId), cat.text, imageModifier)
                    Text(cat.author, modifier = Modifier.fillMaxSize().wrapContentSize(), maxLines = 1)
                }
            }
        }
    }

}