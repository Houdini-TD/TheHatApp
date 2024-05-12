package com.example.feature_home.main_screen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_home.main_screen.AboutUsBlock.IAboutUsBlock
import com.example.feature_home.main_screen.pictures.ICardBlock
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class RealMainScreen @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext,
    private val cardBlockFactory: ICardBlock.Factory,
    private val aboutUsBlockFactory: IAboutUsBlock.Factory
): ComponentContext by componentContext, IMainScreen {

    override val cardBlock = cardBlockFactory.invoke(componentContext)
    override val aboutUsBlock = aboutUsBlockFactory.invoke(componentContext)

    @AssistedFactory
    interface Factory : IMainScreen.Factory{
        override fun invoke(
            componentContext: ComponentContext
        ): RealMainScreen
    }
}