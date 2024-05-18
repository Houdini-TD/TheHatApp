package com.example.feature_calculator.presentation.DraftScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.utils.compose.DefaultTopAppBar
import com.example.feature_calculator.presentation.DraftScreen.SpendingGroupBlock.SpendingGroupBlockUI

@Composable
fun DraftScreenUI(component: IDraftScreen) {
    val event by component.event.collectAsState()
    val groupBlocks by component.spendingGroupBlocks.collectAsState()

    Scaffold(
        topBar = { DefaultTopAppBar(label = event.name) },
        containerColor = Color.Transparent
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                groupBlocks.forEach(){
                    SpendingGroupBlockUI(component = it)
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
@Preview
fun DraftScreenPreview() {
    AppTheme {
        DraftScreenUI(FakeDraftScreen())
    }
}
