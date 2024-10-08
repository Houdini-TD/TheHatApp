package com.example.feature_calculator.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.example.feature_calculator.presentation.DraftScreen.DraftScreenUI
import com.example.feature_calculator.presentation.InitializationScreen.InitializationScreenUI

@Composable
fun EventFlowUI(component: IEventFlow){

    val childStack by component.childStack.collectAsState()

    Children(
        stack = childStack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance){
            is IEventFlow.Child.InitializationChild -> InitializationScreenUI(component = child.component)
            is IEventFlow.Child.DraftChild -> DraftScreenUI(component = child.component)
        }
    }

}