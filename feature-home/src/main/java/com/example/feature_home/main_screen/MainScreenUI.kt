package com.example.feature_home.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.feature_home.main_screen.AboutUsBlock.AboutUsBlockUI
import com.example.feature_home.main_screen.pictures.CardBlockUi

@Composable
fun MainScreenUI(component: IMainScreen){

//    Scaffold(
//        bottomBar = { BottomBar()},
//        containerColor = Color.Transparent
//    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            color = Color.Transparent
        ) {
            Column {
                CardBlockUi(component = component.cardBlock)

                AboutUsBlockUI(component = component.aboutUsBlock)
            }
        }
//    }
}

@Composable
fun BottomBar(){
    BottomAppBar(
        containerColor = CustomTheme.colors.overlay.primary,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icons.Default.Home },
                label = {
                    Text(
                        text = "ГЛАВНАЯ",
                        style = CustomTheme.typography.title.h3,
                        color = CustomTheme.colors.text.inverted
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icons.Default.Home },
                label = {
                    Text(
                        text = "НОВОСТИ",
                        style = CustomTheme.typography.title.h3,
                        color = CustomTheme.colors.text.inverted
                    )
                }
            )
        }
    }
}


@Composable
@Preview(
    showSystemUi = true,
    backgroundColor = 0xFFF7931E
)
fun MainScreenPreview(){
    AppTheme{
        MainScreenUI(component = FakeMainScreen())
    }
}