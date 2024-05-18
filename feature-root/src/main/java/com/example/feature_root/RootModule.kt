package com.example.feature_root

import com.example.feature_calculator.presentation.EventFlowModule
import com.example.feature_feed.FeedFlowModule
import com.example.feature_home.HomeModule
import dagger.Binds
import dagger.Module

@Module(includes = [HomeModule::class, FeedFlowModule::class, EventFlowModule::class])
interface RootModule {
    @Binds
    fun componentFactory(impl: RealRootComponent.Factory): IRootComponent.Factory
}