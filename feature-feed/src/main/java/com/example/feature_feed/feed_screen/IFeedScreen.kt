package com.example.feature_feed.feed_screen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_feed.domain.Post
import kotlinx.coroutines.flow.StateFlow

interface IFeedScreen {

    val posts: StateFlow<MutableList<Post>>

    fun interface Factory{
        operator fun invoke(componentContext: ComponentContext): IFeedScreen
    }
}