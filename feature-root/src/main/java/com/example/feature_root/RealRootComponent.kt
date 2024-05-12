package com.example.feature_root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.example.core.utils.toStateFlow
import com.example.feature_feed.IFeedFlow
import com.example.feature_home.IHomeComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class RealRootComponent @AssistedInject internal constructor(
    private val homeFactory: IHomeComponent.Factory,
    private val feedFactory: IFeedFlow.Factory,
    @Assisted context: ComponentContext
) : ComponentContext by context, IRootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Feed,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    override fun onHomeTabSelected() {
        navigation.bringToFront(ChildConfig.Home)
    }

    override fun onFeedTabSelected() {
        navigation.bringToFront(ChildConfig.Feed)
    }

    private fun createChild(
        config: ChildConfig,
        context: ComponentContext
    ): IRootComponent.Child = when (config) {
        is ChildConfig.Home -> IRootComponent.Child.HomeChild(homeComponent(context))
        is ChildConfig.Feed -> IRootComponent.Child.FeedChild(feedComponent(context))
    }

    private fun homeComponent(context: ComponentContext): IHomeComponent =
        homeFactory(
            context
        )

    private fun feedComponent(context: ComponentContext): IFeedFlow =
        feedFactory(
            context
        )

    @Serializable
    sealed interface ChildConfig{
        @Serializable
        data object Home: ChildConfig

        @Serializable
        data object Feed: ChildConfig
    }

    @AssistedFactory
    interface Factory : IRootComponent.Factory {
        override fun invoke(componentContext: ComponentContext): RealRootComponent
    }

}