package com.example.features.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.example.features.home.IHomeComponent
import kotlinx.coroutines.flow.StateFlow


interface IRootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>
    sealed interface Child {
        class Home(val component: IHomeComponent): Child
    }
}