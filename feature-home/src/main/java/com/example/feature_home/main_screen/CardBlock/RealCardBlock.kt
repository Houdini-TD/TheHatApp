package com.example.feature_home.main_screen.pictures

import com.arkivanov.decompose.ComponentContext
import com.example.feature_home.domain.DetailedEstablishment
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow

class RealCardBlock @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext
): ComponentContext by componentContext, ICardBlock {

    override val establishmentList = MutableStateFlow(listOf(
        DetailedEstablishment.Placeholder(0),
        DetailedEstablishment.Placeholder(1),
        DetailedEstablishment.Placeholder(2),
        DetailedEstablishment.Placeholder(3),
    ))

    override val currentCardIndex = MutableStateFlow(1)

    @AssistedFactory
    interface Factory: ICardBlock.Factory{
        override fun invoke(componentContext: ComponentContext): RealCardBlock
    }
    override fun onPictureClick() {
        TODO("Not yet implemented")
    }
}