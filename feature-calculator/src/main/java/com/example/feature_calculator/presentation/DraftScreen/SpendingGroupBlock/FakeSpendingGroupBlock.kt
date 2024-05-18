package com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock

import com.example.feature_calculator.domain.Spending
import com.example.feature_calculator.domain.SpendingGroup
import com.example.feature_calculator.presentation.InitializationScreen.FakeInitializationScreen
import kotlinx.coroutines.flow.MutableStateFlow

class FakeSpendingGroupBlock() : ISpendingGroupBlock {

    val participants = FakeInitializationScreen().participants

    override val spendingGroup = MutableStateFlow(
        SpendingGroup(
            id = 0,
            name = "Dog's Drum",
            spendings = mutableListOf(
                Spending(
                    id = 0,
                    name = "Мясные чипсы",
                    price = 200.0,
                    amount = 2,
                    payer = participants.value[0]
                ),

                Spending(
                    id = 1,
                    name = "Кока-кола",
                    price = 350.0,
                    amount = 5,
                    payer = participants.value[0]
                ),

                Spending(
                    id = 3,
                    name = "Маринованное яйцо",
                    price = 100.0,
                    amount = 2,
                    payer = participants.value[0]
                ),

                Spending(
                    id = 2,
                    name = "Северное сияние",
                    price = 500.0,
                    amount = 1,
                    payer = participants.value[0]
                ),
            )
        )
    )

    override fun onSpendingChanged(newSpending: Spending) {
        TODO("Not yet implemented")
    }
}