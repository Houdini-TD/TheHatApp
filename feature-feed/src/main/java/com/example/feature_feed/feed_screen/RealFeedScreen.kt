package com.example.feature_feed.feed_screen

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class RealFeedScreen @AssistedInject internal constructor(
    @Assisted context: ComponentContext
): ComponentContext by context, IFeedScreen{

    override val posts = FakeFeedScreen().posts

    @AssistedFactory
    interface Factory: IFeedScreen.Factory{
        override fun invoke(componentContext: ComponentContext): RealFeedScreen
    }
}