package com.example.feature_home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.feature_home.main_screen.IMainScreen
import kotlinx.coroutines.flow.StateFlow

interface IHomeComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    sealed class Child {
        class MainChild(val component: IMainScreen) : Child()
    }

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext
        ): IHomeComponent
    }
}