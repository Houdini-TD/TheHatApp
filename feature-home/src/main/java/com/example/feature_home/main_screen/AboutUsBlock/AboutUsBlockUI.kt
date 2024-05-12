package com.example.feature_home.main_screen.AboutUsBlock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme

@Composable
fun AboutUsBlockUI(component: IAboutUsBlock) {
    val header by component.header.collectAsState()

    val content by component.content.collectAsState()

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent
    ){
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CustomTheme.m3Colors.cardColors.primary
        ) {
            Column(
                Modifier.padding(8.dp)
            ) {
                Text(
                    text = header,
                    style = CustomTheme.typography.title.h3,
                    color = CustomTheme.colors.text.secondary
                )
                Text(
                    text = content,
                    style = CustomTheme.typography.body.regular,
                    color = CustomTheme.colors.text.primary
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000)
fun AboutUsBlockPreview(){
    AppTheme {
        AboutUsBlockUI(component = FakeAboutUsBlock())
    }
}