package com.example.feature_calculator.presentation.InitializationScreen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Participant
import kotlinx.coroutines.flow.StateFlow

interface IInitializationScreen {

    val name: StateFlow<String>

    val newParticipantName: StateFlow<String>

    val participants: StateFlow<List<Participant>>

    fun onNameChanged(newName: String)
    fun onNewParticipantNameChanged(participantName: String)
    fun addParticipant()
    fun deleteParticipant(id: String)

    fun interface Factory{
        operator fun invoke(
            componentContext: ComponentContext
        ): IInitializationScreen
    }
}