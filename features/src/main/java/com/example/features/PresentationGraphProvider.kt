package com.example.features

import com.arkivanov.decompose.ComponentContext
import com.example.feature_home.HomeModule
import com.example.feature_home.IMainScreen
import dagger.Component

@Component(modules = [com.example.feature_home.HomeModule::class])
interface PresentationGraphProvider {
    fun createMainScreen(componentContext: ComponentContext): com.example.feature_home.IMainScreen
}