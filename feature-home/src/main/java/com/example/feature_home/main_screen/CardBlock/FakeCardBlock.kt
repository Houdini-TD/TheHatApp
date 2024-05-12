package com.example.feature_home.main_screen.pictures

import com.example.feature_home.domain.DetailedEstablishment
import kotlinx.coroutines.flow.MutableStateFlow

class FakeCardBlock(): ICardBlock {
    override val establishmentList = MutableStateFlow(listOf(
        DetailedEstablishment.Placeholder(0),
        DetailedEstablishment.Placeholder(1),
        DetailedEstablishment.Placeholder(2),
        DetailedEstablishment.Placeholder(3),
    ))

    override val currentCardIndex = MutableStateFlow(1)

    override fun onPictureClick() {
        TODO("Not yet implemented")
    }
}