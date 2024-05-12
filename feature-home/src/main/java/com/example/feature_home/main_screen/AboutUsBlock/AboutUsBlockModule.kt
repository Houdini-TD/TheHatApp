package com.example.feature_home.main_screen.AboutUsBlock

import dagger.Binds
import dagger.Module

@Module
interface AboutUsBlockModule {

    @Binds
    fun componentFactory(impl: RealAboutUsBlock.Factory): IAboutUsBlock.Factory
}