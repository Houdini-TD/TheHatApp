package com.example.feature_feed

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.example.core.utils.toStateFlow
import com.example.feature_feed.feed_screen.IFeedScreen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class RealFeedFlow @AssistedInject internal constructor(
    @Assisted context: ComponentContext,
    private val feedScreenFactory: IFeedScreen.Factory
): ComponentContext by context, IFeedFlow{

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Feed,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): IFeedFlow.Child = when (config) {
        is ChildConfig.Feed -> IFeedFlow.Child.FeedChild(feedScreen(componentContext))
    }

    private fun feedScreen(context: ComponentContext): IFeedScreen =
        feedScreenFactory(
            context
        )

    @AssistedFactory
    interface Factory: IFeedFlow.Factory{
        override fun invoke(componentContext: ComponentContext): RealFeedFlow
    }

    @Serializable
    sealed interface ChildConfig{
        @Serializable
        data object Feed: ChildConfig
    }
}