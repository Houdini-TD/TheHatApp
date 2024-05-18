package com.example.feature_calculator.presentation

import com.example.feature_calculator.presentation.InitializationScreen.InitializationScreenModule
import dagger.Binds
import dagger.Module

@Module(includes = [InitializationScreenModule::class])
interface EventFlowModule {

    @Binds
    fun componentFactory(impl: RealEventFlow.Factory): IEventFlow.Factory
}