package com.example.features

import com.example.feature_home.HomeModule
import com.example.feature_home.main_screen.pictures.ICardBlock
import dagger.Component


@Component(modules = [com.example.feature_home.HomeModule::class])
interface FeatureComponent{
    fun provideCardBlock(): com.example.feature_home.main_screen.pictures.ICardBlock
}

interface FeatureComponentProvider{
    fun provideFeatureComponent(): FeatureComponent
}