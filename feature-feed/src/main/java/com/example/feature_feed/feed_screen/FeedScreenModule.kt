package com.example.feature_feed.feed_screen

import dagger.Binds
import dagger.Module

@Module
interface FeedScreenModule {

    @Binds
    fun componentFactory(impl: RealFeedScreen.Factory): IFeedScreen.Factory
}