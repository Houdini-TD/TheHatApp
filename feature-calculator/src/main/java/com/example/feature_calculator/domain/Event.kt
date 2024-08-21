package com.example.feature_calculator.domain

import java.util.UUID

data class Event(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val participants: List<Participant>,
    val spendingGroups: List<SpendingGroup>
){
    companion object{
        val Empty = Event(
            id = UUID.randomUUID(),
            name = "NoName",
            participants = listOf(Participant(name = "NoName")),
            spendingGroups = emptyList()
        )
    }
}

data class SpendingGroup(
    val id: Int,
    val name: String,
    val spendings: MutableList<Spending>
){
    fun setPayerForGroup(payer: Participant){
        spendings.map { it.payer = payer }
    }

    fun setPayerWhereEmpty(payer: Participant){
        spendings.map { if (it.payer == null) it.payer = payer }
    }

    val total
        get() = spendings.sumOf { it.price * it.amount }

    val generalPayer : Participant?
        get() = run {
            if (spendings.isNotEmpty()){
                val isEqual = spendings.map { it.payer }.distinct().size == 1
                if (isEqual){
                    return spendings.first().payer
                }
                else
                    return null
            }
            else
                return null
        }
}

data class Spending(
    val id: Int,
    var name: String,
    var price: Double,
    var amount: Int,
    var payer: Participant?
){
    val total
        get() = price * amount
}