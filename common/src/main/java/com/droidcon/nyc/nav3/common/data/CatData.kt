package com.droidcon.nyc.nav3.common.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.droidcon.nyc.nav3.common.R
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @DrawableRes val imageId: Int,
    val text: String = "",
    val author: String = "",
    var favorite: MutableState<Boolean> = mutableStateOf(false)
)

val catList: List<Cat> =
    listOf(
        Cat(R.drawable.cat2, "The most important thing is to be able to think what you want, not to say what you want.", "Paul Graham"),
        Cat(R.drawable.cat3, "A clever person solves a problem. A wise person avoids it.", "Albert Einstein"),
        Cat(R.drawable.cat4, "There are some basic techniques to control complexity. Fundamentally, I divide and conquer, break things down, and try to write reasonably precise descriptions of what each piece is supposed to do.", "Butler Lampson"),
        Cat(R.drawable.cat5, "I care not only what the code says but how it looks.", "Peter Roizen"),
        Cat(R.drawable.cat6, "There are two major products that come out of Berkeley: LSD and UNIX. We don't believe this to be a coincidence.", "Jeremy S. Anderson"),
        Cat(R.drawable.cat7, "I think the best way to supervise is by personal example and by frequent code reviews.", "Charles Simonyi"),
        Cat(R.drawable.cat8, "The entire history of software engineering is that of the rise in levels of abstraction.", "Grady Booch"),
        Cat(R.drawable.cat9, "Humanity is acquiring all the right technology for all the wrong reasons.", "Buckminster Fuller"),
        Cat(R.drawable.cat10, "I mean, if 10 years from now, when you are doing something quick and dirty, you suddenly visualize that I am looking over your shoulders and say to yourself \"Dijkstra would not have liked this\", well, that would be enough immortality for me.", "Edsger W. Dijkstra"),
        Cat(R.drawable.cat11, "By June 1949 people had begun to realize that it was not so easy to get programs right as at one time appeared.", "Maurice Wilkes"),
        Cat(R.drawable.cat3, "All of our exalted technological progress, civilization for that matter, is comparable to an axe in the hand of a pathological criminal.", "Albert Einstein"),
        Cat(R.drawable.cat13, "Computers themselves can do only stupidly straightforward things. The reason they are so useful is that they do these things at an incredibly high speed.", "Marijn Haverbeke"),
        Cat(R.drawable.cat14, "One accurate measurement is worth more than a thousand expert opinions.", "Grace Hopper"),
        Cat(R.drawable.cat15, "On two occasions I have been asked [by members of Parliament]: \"Pray, Mr. Babbage, if you put into the machine wrong figures, will the right answers come out?\" I am not able rightly to apprehend the kind of confusion of ideas that could provoke such a question.", "Charles Babbage"),
        Cat(R.drawable.cat16, "Two things are known about requirements:\n1. They will change!\n2. They will be misunderstood!", "Michael A. Jackson"),
        Cat(R.drawable.cat10, "The computing scientist’s main challenge is not to get confused by the complexities of his own making.", "Edsger W. Dijkstra"),
        Cat(R.drawable.cat10, "Don\'t blame me for the fact that competent programming will be too difficult for \"the average programmer\" — you must not fall into the trap of rejecting a surgical technique because it is beyond the capabilities of the barber in his shop around the corner.", "Edsger W. Dijkstra"),
        Cat(R.drawable.cat19, "Never trust a computer you can’t throw out a window.", "Steve Wozniak"),
        Cat(R.drawable.cat12, "Readability of code is now my first priority. It’s more important than being fast, almost as important as being correct, but I think being readable is actually the most likely way of making it correct.", "Douglas Crockford"),
        Cat(R.drawable.cat17, "The cost of adding a feature isn’t just the time it takes to code it. The cost also includes the addition of an obstacle to future expansion. The trick is to pick the features that don’t fight each other.", "John Carmack"),
        Cat(R.drawable.cat10, "As long as there were no machines, programming was no problem at all; when we had a few weak computers, programming became a mild problem, and now we have gigantic computers, programming has become an equally gigantic problem.", "Edsger W. Dijkstra"),
        Cat(R.drawable.cat18, "A display connected to a digital computer gives us a chance to gain familiarity with concepts not realizable in the physical world. It is a looking glass into a mathematical wonderland.", "Ivan Sutherland"),
        Cat(R.drawable.cat13, "A program is a building of thought. It is costless to build, it is weightless, and it grows easily under our typing hands. But without care, a program’s size and complexity will grow out of control, confusing even the person who created it.", "Marijn Haverbeke"),
    )