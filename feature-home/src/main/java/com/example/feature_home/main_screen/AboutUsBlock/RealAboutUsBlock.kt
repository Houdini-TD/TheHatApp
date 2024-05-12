package com.example.feature_home.main_screen.AboutUsBlock

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.StateFlow

class RealAboutUsBlock @AssistedInject internal constructor(
    @Assisted context: ComponentContext
) : ComponentContext by context, IAboutUsBlock{

    override val header: StateFlow<String> = FakeAboutUsBlock().header

    override val content: StateFlow<String> = FakeAboutUsBlock().content

    @AssistedFactory
    interface Factory : IAboutUsBlock.Factory{
        override fun invoke(componentContext: ComponentContext): RealAboutUsBlock
    }
}
