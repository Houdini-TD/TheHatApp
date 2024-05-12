package com.example.feature_home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.example.feature_home.main_screen.MainScreenUI

@Composable
fun HomeComponentUI(component: IHomeComponent) {

    val childStack by component.childStack.collectAsState()

    Children(
        stack = childStack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance){
            is IHomeComponent.Child.MainChild -> MainScreenUI(component = child.component)
        }
    }
}