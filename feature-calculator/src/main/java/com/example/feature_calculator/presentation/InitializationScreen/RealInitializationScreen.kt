package com.example.feature_calculator.presentation.InitializationScreen

import com.arkivanov.decompose.ComponentContext
import com.example.feature_calculator.domain.Participant
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class RealInitializationScreen @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext
): ComponentContext by componentContext, IInitializationScreen{

    val maxParticipant: Int = 20

    override val name = MutableStateFlow("Dog's Drum")

    override val newParticipantName = MutableStateFlow("")

    override val participants = MutableStateFlow(listOf(
        Participant( name = "Юля"),
        Participant( name  = "Наташа"),
        Participant( name  = "Артем"),
        Participant( name  = "Марина"),
        Participant( name  = "Алина"),
    ))


    override fun onNameChanged(newName: String) {
        name.update { newName }
    }

    override fun onNewParticipantNameChanged(participantName: String) {
        newParticipantName.update { participantName }
    }

    override fun addParticipant() {
        if (participants.value.size < 20){
            participants.update { it.plus(Participant(name = newParticipantName.value)) }
        }
    }

    override fun deleteParticipant(id: String) {
         participants.update { list -> list.filter { it.id != id } }
    }

    @AssistedFactory
    interface Factory: IInitializationScreen.Factory{
        override fun invoke(componentContext: ComponentContext): RealInitializationScreen
    }
}