package com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Spending
import com.example.feature_calculator.domain.SpendingGroup
import kotlinx.coroutines.flow.StateFlow

interface ISpendingGroupBlock {

    val spendingGroup: StateFlow<SpendingGroup>

    fun onSpendingChanged(newSpending: Spending)

    fun interface Factory{
        operator fun invoke(componentContext: ComponentContext): ISpendingGroupBlock
    }
}