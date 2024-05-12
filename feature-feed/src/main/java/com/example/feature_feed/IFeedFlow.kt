package com.example.feature_feed

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.feature_feed.feed_screen.IFeedScreen
import kotlinx.coroutines.flow.StateFlow

interface IFeedFlow {

    val childStack: StateFlow<ChildStack<*, Child>>

    sealed class Child {
        class FeedChild(val component: IFeedScreen): Child()
    }

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext
        ): IFeedFlow
    }
}