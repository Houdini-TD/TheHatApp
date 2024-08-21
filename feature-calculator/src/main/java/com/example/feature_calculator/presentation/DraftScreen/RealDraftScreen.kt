package com.example.feature_calculator.presentation.DraftScreen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Event
import com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock.ISpendingGroupBlock
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RealDraftScreen @AssistedInject internal constructor(
    @Assisted event: Event,
    @Assisted componentContext: ComponentContext
): ComponentContext by componentContext, IDraftScreen {

    override val event = MutableStateFlow(event)
    override val spendingGroupBlocks: StateFlow<List<ISpendingGroupBlock>>
        get() = TODO("Not yet implemented")

    override fun onNewGroupClick() {
        TODO("Not yet implemented")
    }

    override fun onNewSpendingClick(name: String, amount: Int, price: Double) {
        TODO("Not yet implemented")
    }

    @AssistedFactory
    interface Factory: IDraftScreen.Factory{
        override fun invoke(
            componentContext: ComponentContext,
            event: Event
        ): RealDraftScreen
    }
}