package com.example.feature_calculator.presentation.DraftScreen

import dagger.Binds
import dagger.Module


@Module
interface DraftScreenModule {

    @Binds
    fun componentFactory(impl: RealDraftScreen.Factory): IDraftScreen.Factory
}