package com.example.feature_home

import com.example.feature_home.main_screen.MainScreenModule
import dagger.Binds
import dagger.Module

@Module(includes = [MainScreenModule::class])
interface HomeModule {
    @Binds
    fun componentFactory(impl: RealHomeComponent.Factory): IHomeComponent.Factory
}