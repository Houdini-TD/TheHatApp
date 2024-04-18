package com.example.features.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.example.core.utils.toStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

class RealRootComponent(
    context: ComponentContext
) : ComponentContext by context, IRootComponent  {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Home,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        context: ComponentContext
    ): IRootComponent.Child = when (config) {
        is ChildConfig.Home -> {
            IRootComponent.Child.Home(

            )
        }
    }

    @Serializable
    sealed interface ChildConfig{
        @Serializable
        data object Home : ChildConfig
    }

}