package com.example.feature_home.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.utils.compose.DefaultTopAppBar
import com.example.feature_home.main_screen.AboutUsBlock.AboutUsBlockUI
import com.example.feature_home.main_screen.pictures.CardBlockUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenUI(component: IMainScreen) {

    val a = component.aboutUsBlock.content.collectAsState()
    Scaffold(
        containerColor = Color.Transparent,
        topBar = { DefaultTopAppBar(label = "Главная") }
    ) {
        Box(
            Modifier.padding(it)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                color = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    CardBlockUi(component = component.cardBlock)

                    AboutUsBlockUI(component = component.aboutUsBlock)
                }
            }
        }
    }
}


@Composable
@Preview(
    showSystemUi = true,
    backgroundColor = 0xFFF7931E
)
fun MainScreenPreview() {
    AppTheme {
        MainScreenUI(component = FakeMainScreen())
    }
}