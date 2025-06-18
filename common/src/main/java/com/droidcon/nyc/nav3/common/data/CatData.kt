package com.droidcon.nyc.nav3.common.data

import androidx.annotation.DrawableRes
import com.droidcon.nyc.nav3.common.R
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @DrawableRes val imageId: Int,
    val text: String = "",
    val author: String = "",
    val source: String = "",
    val numberOfVotes: Int = 0,
    val rating: Float = 0f
)

val catList: List<Cat> =
    listOf(
        Cat(R.drawable.cat2, "lucky", "cat playing"),
        Cat(R.drawable.cat3, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat4, "happy", "cat lying down"),
        Cat(R.drawable.cat5, "lucky", "cat playing"),
        Cat(R.drawable.cat6, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat7, "lucky", "cat playing"),
        Cat(R.drawable.cat8, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat9, "lucky", "cat playing"),
        Cat(R.drawable.cat10, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat11, "lucky", "cat playing"),
        Cat(R.drawable.cat12, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat13, "happy", "cat lying down"),
        Cat(R.drawable.cat14, "lucky", "cat playing"),
        Cat(R.drawable.cat15, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat16, "lucky", "cat playing"),
        Cat(R.drawable.cat17, "chocolate cake", "cat upside down"),
        Cat(R.drawable.cat18, "lucky", "cat playing"),
        Cat(R.drawable.cat19, "chocolate cake", "cat upside down"),
    )