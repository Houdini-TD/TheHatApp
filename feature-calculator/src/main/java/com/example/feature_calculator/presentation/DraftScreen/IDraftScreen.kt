package com.example.feature_calculator.presentation.DraftScreen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Event
import com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock.ISpendingGroupBlock
import kotlinx.coroutines.flow.StateFlow

interface IDraftScreen {

    val event: StateFlow<Event>

    val spendingGroupBlocks: StateFlow<List<ISpendingGroupBlock>>

    fun onNewGroupClick()

    fun onNewSpendingClick(name: String, amount: Int, price: Double)

    fun interface Factory{
        operator fun invoke(componentContext: ComponentContext, event: Event): ComponentContext
    }

}