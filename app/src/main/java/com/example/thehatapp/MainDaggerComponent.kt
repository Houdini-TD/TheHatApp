package com.example.thehatapp

import com.example.feature_root.RealRootComponent
import com.example.feature_root.RootModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RootModule::class])
interface MainDaggerComponent{
    val rootComponentFactory: RealRootComponent.Factory
}