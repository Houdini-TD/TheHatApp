package com.example.feature_feed

import com.example.feature_feed.feed_screen.FeedScreenModule
import dagger.Binds
import dagger.Module


@Module(includes = [FeedScreenModule::class])
interface FeedFlowModule{
    @Binds
    fun componentFactory(impl: RealFeedFlow.Factory): IFeedFlow.Factory
}