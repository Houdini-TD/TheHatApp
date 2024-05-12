package com.example.feature_home.main_screen

import com.example.feature_home.main_screen.AboutUsBlock.AboutUsBlockModule
import com.example.feature_home.main_screen.CardBlock.CardBlockModule
import dagger.Binds
import dagger.Module

@Module(includes = [CardBlockModule::class, AboutUsBlockModule::class])
interface MainScreenModule {
    @Binds
    fun componentFactory(impl: RealMainScreen.Factory) : IMainScreen.Factory
}