package com.example.feature_calculator.presentation.InitializationScreen

import com.example.feature_calculator.domain.Participant
import kotlinx.coroutines.flow.MutableStateFlow

class FakeInitializationScreen(): IInitializationScreen{

    override val name = MutableStateFlow("Dog's Drum")

    override val newParticipantName = MutableStateFlow("")

    override val participants = MutableStateFlow(mutableListOf(
        Participant( name = "Юля"),
        Participant( name = "Наташа"),
        Participant(name = "Артем"),
        Participant(name = "Марина"),
        Participant(name = "Алина"),
    ))


    override fun onNameChanged(name: String) {
        TODO("Not yet implemented")
    }

    override fun onNewParticipantNameChanged(participantName: String) {
        TODO("Not yet implemented")
    }

    override fun addParticipant() {
        TODO("Not yet implemented")
    }

    override fun deleteParticipant(id: String) {
        TODO("Not yet implemented")
    }

}