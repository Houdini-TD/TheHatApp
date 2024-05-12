package com.example.feature_home.main_screen.CardBlock

import com.example.feature_home.main_screen.pictures.ICardBlock
import com.example.feature_home.main_screen.pictures.RealCardBlock
import dagger.Binds
import dagger.Module

@Module
interface CardBlockModule {
    @Binds
    fun componentFactory(impl: RealCardBlock.Factory): ICardBlock.Factory
}