package com.example.feature_home.main_screen.pictures

import com.arkivanov.decompose.ComponentContext
import com.example.feature_home.domain.DetailedEstablishment
import kotlinx.coroutines.flow.StateFlow

interface ICardBlock {
    val establishmentList: StateFlow<List<DetailedEstablishment>>

    val currentCardIndex: StateFlow<Int>

    fun onPictureClick()

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext
        ) : ICardBlock
    }
}