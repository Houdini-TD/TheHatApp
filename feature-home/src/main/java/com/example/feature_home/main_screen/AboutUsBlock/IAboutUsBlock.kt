package com.example.feature_home.main_screen.AboutUsBlock

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

interface IAboutUsBlock {

    val header: StateFlow<String>

    val content: StateFlow<String>

    interface Factory{
        operator fun invoke(componentContext: ComponentContext) : IAboutUsBlock
    }
}