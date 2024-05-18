package com.example.feature_calculator.presentation.InitializationScreen

import dagger.Binds
import dagger.Module

@Module
interface InitializationScreenModule {

    @Binds
    fun componentFactory(impl: RealInitializationScreen.Factory): IInitializationScreen.Factory
}