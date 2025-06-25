package com.droidcon.nyc.nav3.profile

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.droidcon.nyc.nav3.common.TopLevelBackStack
import com.droidcon.nyc.nav3.common.data.Cat
import com.droidcon.nyc.nav3.common.data.TopLevelRoute
import com.droidcon.nyc.nav3.common.data.catList
import com.droidcon.nyc.nav3.common.di.UiScope
import com.droidcon.nyc.nav3.metro.NavEntryContent
import kotlinx.serialization.Serializable


@Serializable
object Profile : NavKey, TopLevelRoute { override val icon = Icons.Default.Home }

@Composable
fun ProfileScreen() {
    Column {
        Text("My Profile", fontSize = 30.sp, color = Color.Black)
        val imageModifier =
            Modifier.size(300.dp)
        Image(painterResource(R.drawable.cat_3), "My Profile Cat", imageModifier)
        val list = catList.filter { it.favorite.value }
        Text("My Favorites", fontSize = 20.sp, color = Color.Blue)
        if (list.isEmpty()) Text("No favorites")
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list) { cat: Cat ->
                Row {
                    val imageModifier = Modifier
                        .size(100.dp)
                        .padding(10.dp)
                    Image(painterResource(cat.imageId), cat.text, imageModifier)
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight()
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Text(cat.author)
                        Text(
                            "${cat.text.take(70)}${if (cat.text.length > 70) "..." else ""}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth()
                        )
                    }
                }
            }
        }
    }
}