package com.example.feature_calculator.presentation.DraftScreen

import com.example.feature_calculator.domain.Event
import com.example.feature_calculator.domain.Spending
import com.example.feature_calculator.domain.SpendingGroup
import com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock.FakeSpendingGroupBlock
import com.example.feature_calculator.presentation.InitializationScreen.FakeInitializationScreen
import kotlinx.coroutines.flow.MutableStateFlow

class FakeDraftScreen(): IDraftScreen {

    private val participants =  FakeInitializationScreen().participants

    override val event = MutableStateFlow(
        Event(
            name = "День рождения",
            participants = participants.value,
            spendingGroups = listOf(
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
                ),

//                SpendingGroup(
//                    id = 0,
//                    name = "Баня",
//                    spendings = mutableListOf(
//                        Spending(
//                            id = 0,
//                            name = "Помещение",
//                            price = 9000.0,
//                            amount = 1,
//                            payer = participants.value[1]
//                        ),
//
//                        Spending(
//                            id = 1,
//                            name = "Веники",
//                            price = 800.0,
//                            amount = 5,
//                            payer = participants.value[1]
//                        ),
//
//                        Spending(
//                            id = 3,
//                            name = "Салаты",
//                            price = 900.0,
//                            amount = 2,
//                            payer = participants.value[1]
//                        ),
//
//                        Spending(
//                            id = 2,
//                            name = "Такси",
//                            price = 1000.0,
//                            amount = 1,
//                            payer = participants.value[1]
//                        ),
//                    )
//                )
            )
        )
    )
    override val spendingGroupBlocks = MutableStateFlow(
        listOf(
            FakeSpendingGroupBlock(event.value.spendingGroups[0])
        )
    )

    override fun onNewGroupClick() {

    }

    override fun onNewSpendingClick(name: String, amount: Int, price: Double) {

    }
}
