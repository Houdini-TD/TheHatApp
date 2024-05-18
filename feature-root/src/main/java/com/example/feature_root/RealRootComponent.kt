package com.example.feature_root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.example.core.utils.toStateFlow
import com.example.feature_calculator.presentation.IEventFlow
import com.example.feature_feed.IFeedFlow
import com.example.feature_home.IHomeComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class RealRootComponent @AssistedInject internal constructor(
    private val homeFactory: IHomeComponent.Factory,
    private val feedFactory: IFeedFlow.Factory,
    private val eventFactory: IEventFlow.Factory,
    @Assisted context: ComponentContext
) : ComponentContext by context, IRootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Home,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    override fun onTabClicked(tab: IRootComponent.MainNavTab) {
        when (tab){
            is IRootComponent.MainNavTab.Home -> navigation.bringToFront(ChildConfig.Home)
            is IRootComponent.MainNavTab.Feed -> navigation.bringToFront(ChildConfig.Feed)
            is IRootComponent.MainNavTab.Event -> navigation.bringToFront(ChildConfig.Event)
        }
    }

    override fun onNewEventClicked() {
        onTabClicked(IRootComponent.MainNavTab.Event)
    }


    private fun createChild(
        config: ChildConfig,
        context: ComponentContext
    ): IRootComponent.Child = when (config) {
        is ChildConfig.Home -> IRootComponent.Child.HomeChild(homeComponent(context))
        is ChildConfig.Feed -> IRootComponent.Child.FeedChild(feedComponent(context))
        is ChildConfig.Event -> IRootComponent.Child.EventChild(eventComponent(context))
    }

    private fun homeComponent(context: ComponentContext): IHomeComponent =
        homeFactory(
            context
        )

    private fun feedComponent(context: ComponentContext): IFeedFlow =
        feedFactory(
            context
        )

    private fun eventComponent(context: ComponentContext): IEventFlow =
        eventFactory(
            context
        )

    @Serializable
    sealed interface ChildConfig{
        @Serializable
        data object Home: ChildConfig

        @Serializable
        data object Feed: ChildConfig
        @Serializable
        data object Event: ChildConfig
    }

    @AssistedFactory
    interface Factory : IRootComponent.Factory {
        override fun invoke(componentContext: ComponentContext): RealRootComponent
    }

}