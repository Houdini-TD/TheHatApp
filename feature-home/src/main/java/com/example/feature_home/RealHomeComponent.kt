package com.example.feature_home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.example.core.utils.toStateFlow
import com.example.feature_home.main_screen.IMainScreen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class RealHomeComponent @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext,
    private val mainScreenFactory: IMainScreen.Factory
) : ComponentContext by componentContext, IHomeComponent {

    private val navigation = StackNavigation<ChildConfig>()


    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Main,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): IHomeComponent.Child = when (config) {
        is ChildConfig.Main -> IHomeComponent.Child.MainChild(mainScreen(componentContext))
    }

    private fun mainScreen(context: ComponentContext): IMainScreen =
        mainScreenFactory(
            context
        )

    @AssistedFactory
    interface Factory : IHomeComponent.Factory{
        override fun invoke(componentContext: ComponentContext): RealHomeComponent
    }

    @Serializable
    sealed interface ChildConfig{
        @Serializable
        data object Main : ChildConfig

    }
}