package com.example.feature_root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.feature_feed.IFeedFlow
import com.example.feature_home.IHomeComponent
import kotlinx.coroutines.flow.StateFlow


interface IRootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    fun onHomeTabSelected()

    fun onFeedTabSelected()
    sealed interface Child {
        class HomeChild(val component: IHomeComponent): Child
        class FeedChild(val component: IFeedFlow): Child
    }

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): IRootComponent
    }
}