package com.example.feature_calculator.presentation.DraftScreen.AdvancedGroupEditScreen

import com.example.feature_calculator.presentation.DraftScreen.FakeDraftScreen
import com.example.feature_calculator.presentation.InitializationScreen.FakeInitializationScreen

class FakeAdvancedGroupEditScreen(): IAdvancedGroupEditScreen {

    override val participants = FakeInitializationScreen().participants

    override val spendingGroup = FakeDraftScreen().spendingGroupBlocks.value[0].spendingGroup

    override fun onNewSpendingClick() {
        TODO("Not yet implemented")
    }

}
