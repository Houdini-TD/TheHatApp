package com.example.feature_calculator.presentation.DraftScreen.AdvancedGroupEditScreen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Participant
import com.example.feature_calculator.domain.SpendingGroup
import kotlinx.coroutines.flow.StateFlow

interface IAdvancedGroupEditScreen {

    val participants: StateFlow<List<Participant>>

    val spendingGroup: StateFlow<SpendingGroup>

    fun onNewSpendingClick()

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext
        ) : IAdvancedGroupEditScreen
    }

}