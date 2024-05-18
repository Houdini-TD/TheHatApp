package com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
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
import com.example.core.utils.compose.ExpandableCard
import com.example.core.utils.compose.plus
import com.example.feature_calculator.domain.Participant
import com.example.feature_calculator.domain.Spending
import com.example.feature_calculator.domain.SpendingGroup
import kotlin.math.roundToInt


@Composable
fun SpendingGroupBlockUI(component: ISpendingGroupBlock) {
    val spendingGroup by component.spendingGroup.collectAsState()

    ExpandableCard(
        topContent = { TopContent(
            spendingGroup = spendingGroup,
            trailingIconPadding = it
        ) },
        expandableContent = { ExpandableContent(
            spendingGroup = spendingGroup,
            component::onSpendingChanged
            ) },
        expanded = true
    )
}

@Composable
fun TopContent(
    spendingGroup: SpendingGroup,
    trailingIconPadding: PaddingValues
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = CustomTheme.colors.overlay.primary
    ) {
        Column(
            modifier = Modifier.padding(PaddingValues(6.dp) + trailingIconPadding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = spendingGroup.name,
                    style = CustomTheme.typography.title.h2,
                    color = CustomTheme.colors.text.inverted
                )
                Row {
                    ParticipantView(spendingGroup.generalPayer)

                    Spacer(modifier = Modifier.width(6.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = CustomTheme.colors.overlay.accent
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            text = spendingGroup.total.toString(),
                            style = CustomTheme.typography.title.h3,
                            color = CustomTheme.colors.text.inverted
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ParticipantView(participant: Participant?){
    Card(
        border = BorderStroke(2.dp, Color.Gray),
        colors = CustomTheme.m3Colors.cardColors.primary
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = participant?.name ?: "нет",
                style = CustomTheme.typography.title.h3
            )
        }
    }
}

@Composable
fun ExpandableContent(
    spendingGroup: SpendingGroup,
    onSpendingChanged: (Spending) -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = CustomTheme.colors.background.card
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            SpendingMarkUp(
                name = { Text(
                    text = "Наименование",
                    style = CustomTheme.typography.title.h4,
                    color = CustomTheme.colors.text.primary
                ) },
                amount = { Text(
                    text = "Кол-во",
                    style = CustomTheme.typography.title.h4,
                    color = CustomTheme.colors.text.primary
                ) },
                price = { Text(
                    text = "Цена",
                    style = CustomTheme.typography.title.h4,
                    color = CustomTheme.colors.text.primary
                ) },
                total = { Text(
                    text = "Сумма",
                    style = CustomTheme.typography.title.h4,
                    color = CustomTheme.colors.text.primary
                ) },
            )

            Box(Modifier.padding(top = 2.dp, bottom = 8.dp)){
                Box(
                    modifier = Modifier
                        .border(3.dp, Color.Gray)
                        .height(1.dp)
                        .fillMaxWidth()
                )
            }

            spendingGroup.spendings.forEach(){
                SpendingView(
                    spending = it,
                    {},
                    {},
                    {}
                )
            }
        }
    }
}

@Composable
fun SpendingMarkUp(
    name: @Composable () -> Unit,
    amount: @Composable () -> Unit,
    price: @Composable () -> Unit,
    total: @Composable () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .weight(4f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            name()
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            amount()
        }
        Row(
            Modifier
                .weight(1.4f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            price()
        }
        Row(
            Modifier
                .weight(1.2f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            total()
        }
    }
}

@Composable
fun SpendingView(
    spending: Spending,
    onNameChanged: (String) -> Unit,
    onAmountChanged: (String) -> Unit,
    onPriceChanged: (String) -> Unit,
){

    val textFieldDecorationBox = @Composable { content: @Composable () -> Unit ->
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

    var nameState by remember { mutableStateOf(spending.name) }
    val name = @Composable {CustomizableTextField(
        placeholderText = "Введите наименование",
        modifier = Modifier.fillMaxWidth(),
        value = nameState,
        onValueChange = {
            nameState = it
            onNameChanged(it) },
        textStyle = CustomTheme.typography.body.regular,
        textColor = CustomTheme.colors.text.primary,
        decorationBox = textFieldDecorationBox
    )}

    var amountState by remember { mutableIntStateOf(spending.amount) }
    val amount = @Composable {CustomizableTextField(
        modifier = Modifier.fillMaxWidth(),
        value = if (amountState != 0) amountState.toString() else "",
        onValueChange = {
            if (it.length < 3) {
                amountState = it.toIntOrNull() ?: 0
            }
            onAmountChanged(it)
        },
        textStyle = CustomTheme.typography.body.regular,
        textColor = CustomTheme.colors.text.primary,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = textFieldDecorationBox
    )}

    var priceState by remember { mutableDoubleStateOf(spending.price) }
    val price = @Composable {CustomizableTextField(
        modifier = Modifier.fillMaxWidth(),
        value = if (priceState > 0) priceState.roundToInt().toString() else "",
        onValueChange = {
            if (it.length < 5) {
                priceState = it.toDoubleOrNull() ?: 0.0
            }
            onPriceChanged(it)
        },
        textStyle = CustomTheme.typography.body.regular,
        textColor = CustomTheme.colors.text.primary,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = textFieldDecorationBox
    )}

    val total = @Composable {Surface(
        modifier = Modifier
            .padding(vertical = 2.dp),

        shape = RoundedCornerShape(12.dp),
        color = CustomTheme.colors.overlay.accent
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            text = spending.total.roundToInt().toString(),
            style = CustomTheme.typography.body.regular,
            color = CustomTheme.colors.text.inverted
        )
    }}

    SpendingMarkUp(
        name = { name() },
        amount = { amount() },
        price = { price() },
        total = { total() },
    )
}

@Composable
@Preview(
    showSystemUi = true,
    backgroundColor = 0xFFF7931E
)
fun SpendingGroupBlockPreview() {
    AppTheme {
        Scaffold(
            topBar = { DefaultTopAppBar(label = "Новое событие") },
            containerColor = CustomTheme.colors.background.screen
        ) {
            Box(modifier = Modifier.padding(it)) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    SpendingGroupBlockUI(FakeSpendingGroupBlock())
                }
            }
        }
    }
}