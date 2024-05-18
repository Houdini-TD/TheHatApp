package com.example.feature_calculator.presentation.InitializationScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.core.utils.compose.DefaultTextField
import com.example.core.utils.compose.DefaultTopAppBar
import com.example.feature_calculator.domain.Participant
import kotlinx.coroutines.Dispatchers


@Composable
fun InitializationScreenUI(component: IInitializationScreen) {
    val name by component.name.collectAsState(Dispatchers.Main.immediate)
    val newParticipantName by component.newParticipantName.collectAsState(Dispatchers.Main.immediate)
    val participants by component.participants.collectAsState(Dispatchers.Main.immediate)

    Scaffold(
        topBar = { DefaultTopAppBar(label = "Новое событие") },
        containerColor = Color.Transparent
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                EventNameBlock(value = name, onTextChanged = component::onNameChanged)
                Spacer(modifier = Modifier.height(20.dp))
                NewParticipantBlock(
                    value = newParticipantName,
                    onTextChanged = component::onNewParticipantNameChanged,
                    onParticipantAddClick = component::addParticipant
                )
                Spacer(modifier = Modifier.height(8.dp))
                ParticipantList(participants = participants, component::deleteParticipant)
            }
        }
    }
}

@Composable
fun EventNameBlock(
    value: String,
    onTextChanged: (String) -> Unit
) {
    Column() {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Название:",
            style = CustomTheme.typography.title.h2,
            color = CustomTheme.colors.text.primary
        )
        DefaultTextField(
            value = value,
            onTextChanged = { onTextChanged(it) },
            placeholderText = "Введите название события"
        )
    }
}

@Composable
fun NewParticipantBlock(
    value: String,
    onTextChanged: (String) -> Unit,
    onParticipantAddClick: () -> Unit
) {
    Column() {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Добавление участников:",
            style = CustomTheme.typography.title.h2,
            color = CustomTheme.colors.text.primary
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = value,
                onTextChanged = { onTextChanged(it) },
                placeholderText = "Участник"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                modifier = Modifier
                    .height((IntrinsicSize.Min)),
                onClick = { onParticipantAddClick() },
                colors = CustomTheme.m3Colors.buttonColors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = CustomTheme.colors.icon.primary
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ParticipantList(participants: List<Participant>, onDeleteClick: (String) -> Unit) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        participants.forEach { participant ->
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 300, easing = LinearEasing)),
                exit = fadeOut(animationSpec = tween(durationMillis = 300)),
            ) {
                ParticipantView(
                    participant = participant,
                    onDeleteClick
                )
            }
        }
    }
}

@Composable
fun ParticipantView(participant: Participant, onDeleteClick: (String) -> Unit){
    Card(
        modifier = Modifier.padding(4.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = CustomTheme.m3Colors.cardColors.primary
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = participant.name,
                style = CustomTheme.typography.title.h3
            )
            Icon(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(0.dp)
                    .clickable { onDeleteClick(participant.id) },
                imageVector = Icons.Default.Clear,
                contentDescription = "Add",
                tint = CustomTheme.colors.text.secondary
            )
        }
    }
}

@Composable
@Preview
fun InitializationScreenPreview() {
    AppTheme {
        InitializationScreenUI(FakeInitializationScreen())
    }
}