package com.example.feature_calculator.presentation.DraftScreen.AdvancedGroupEditScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.core.utils.compose.CustomizableTextField
import com.example.core.utils.compose.DefaultTopAppBar
import kotlin.math.roundToInt

@Composable
fun AdvancedGroupEditScreenUI(component: IAdvancedGroupEditScreen) {
    val participants by component.participants.collectAsState()
    val spendingGroup by component.spendingGroup.collectAsState()

    Scaffold(
        topBar = { DefaultTopAppBar(label = spendingGroup.name) },
        containerColor = Color.Transparent,
        bottomBar = { SpendingAddBottomAppBar(
            onCreateClick = component::onNewSpendingClick
        ) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            }
        }
    }
}

@Composable
fun SpendingAddBottomAppBar(
    onCreateClick: () -> Unit
) {
    val topCornerRounding = 16.dp

    Surface(
        color = CustomTheme.colors.overlay.primary,
        shape = RoundedCornerShape(topStart = topCornerRounding, topEnd = topCornerRounding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
            ) {
                Text(
                    text = "Новый расход",
                    style = CustomTheme.typography.title.h2
                )
            }
            Surface(
                shape = RoundedCornerShape(6.dp),
                color = CustomTheme.colors.background.card
            ) {
                var nameState by remember { mutableStateOf("") }
                var amountState by remember { mutableIntStateOf(0) }
                var priceState by remember { mutableDoubleStateOf(0.0) }

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val textFieldBox = @Composable { content: @Composable () -> Unit ->
                            Card(
                                modifier = Modifier
                                    .padding(vertical = 2.dp, horizontal = 4.dp)
                                    .fillMaxWidth(),
                                border = BorderStroke(1.dp, Color.Gray),
                                colors = CustomTheme.m3Colors.cardColors.primary,
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    content()
                                }
                            }
                        }
                        Column(
                            modifier = Modifier.weight(2f)
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Наименование",
                                style = CustomTheme.typography.body.regular,
                                color = CustomTheme.colors.text.primary
                            )
                            CustomizableTextField(
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                value = nameState,
                                onValueChange = { nameState = it },
                                textStyle = CustomTheme.typography.body.regular,
                                textColor = CustomTheme.colors.text.primary,
                                decorationBox = textFieldBox,
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Кол-во",
                                style = CustomTheme.typography.body.regular,
                                color = CustomTheme.colors.text.primary
                            )
                            CustomizableTextField(
                                placeholderText = "1",
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                value = if (amountState > 1) amountState.toString() else "",
                                onValueChange = {
                                    if (it.length < 3) {
                                        amountState = it.toIntOrNull() ?: 1
                                    }
                                },
                                textStyle = CustomTheme.typography.body.regular,
                                textColor = CustomTheme.colors.text.primary,
                                decorationBox = textFieldBox,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Цена",
                                style = CustomTheme.typography.body.regular,
                                color = CustomTheme.colors.text.primary
                            )
                            CustomizableTextField(
                                placeholderText = "0",
                                modifier = Modifier.fillMaxWidth(),
                                value = if (priceState > 0) priceState.roundToInt().toString() else "",
                                onValueChange = {
                                    if (it.length < 5) {
                                        priceState = it.toDoubleOrNull() ?: 1.0
                                    }
                                },
                                textStyle = CustomTheme.typography.body.regular,
                                textColor = CustomTheme.colors.text.primary,
                                decorationBox = textFieldBox,
                            )
                        }

                        Button(
                            colors = CustomTheme.m3Colors.buttonColors.primary,
                            onClick = {
                                onCreateClick()
                            },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                tint = CustomTheme.colors.text.inverted,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun DraftScreenPreview() {
    AppTheme {
        AdvancedGroupEditScreenUI(component = FakeAdvancedGroupEditScreen())
    }
}
