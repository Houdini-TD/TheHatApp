package com.example.feature_calculator.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.example.core.utils.toStateFlow
import com.example.feature_calculator.domain.Event
import com.example.feature_calculator.presentation.DraftScreen.FakeDraftScreen
import com.example.feature_calculator.presentation.DraftScreen.IDraftScreen
import com.example.feature_calculator.presentation.InitializationScreen.IInitializationScreen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable

class RealEventFlow @AssistedInject internal constructor(
    private val initializationScreenFactory: IInitializationScreen.Factory,
    private val draftScreenFactory: IDraftScreen.Factory,
    @Assisted private val event: Event? = null,
    @Assisted componentContext: ComponentContext
): ComponentContext by componentContext, IEventFlow {

    val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Initialization,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    override fun onInitializationFinished(newEvent: Event) {
        navigation.push(ChildConfig.Draft)
    }

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): IEventFlow.Child = when (config) {
        is ChildConfig.Initialization -> IEventFlow.Child.InitializationChild(
            initializationScreen(
                componentContext
            )
        )
        is ChildConfig.Draft -> IEventFlow.Child.DraftChild(
            draftScreen(componentContext)
        )
    }

    private fun initializationScreen(componentContext: ComponentContext): IInitializationScreen {
        return initializationScreenFactory.invoke(::onInitializationFinished, componentContext)
    }

    private fun draftScreen(componentContext: ComponentContext): IDraftScreen {
        return FakeDraftScreen()
        //return draftScreenFactory.invoke(componentContext, event ?: Event.Empty)
    }

    @AssistedFactory
    interface Factory: IEventFlow.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            event: Event?
            ): RealEventFlow
    }

    @Serializable
    sealed class ChildConfig{
        @Serializable
        data object Initialization: ChildConfig()
        @Serializable
        data object Draft: ChildConfig()
    }
}