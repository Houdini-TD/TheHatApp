package com.example.feature_calculator.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.feature_calculator.domain.Event
import com.example.feature_calculator.presentation.InitializationScreen.IInitializationScreen
import kotlinx.coroutines.flow.StateFlow

interface IEventFlow {

    val childStack: StateFlow<ChildStack<*, Child>>

    fun onInitializationFinished(newEvent: Event)

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext,
            event: Event?
        ): IEventFlow
    }
    sealed class Child(){
        class InitializationChild(val component: IInitializationScreen): Child()
        class DraftChild(val component: IInitializationScreen): Child()
    }

}