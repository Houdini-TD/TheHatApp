package com.example.core.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.theme.custom.CustomTheme
import com.example.core.theme.values.AppTypography
import com.example.core.theme.values.DarkAppColors
import com.example.core.theme.values.LightAppColors
import com.example.core.theme.values.M3DarkAppColors
import com.example.core.theme.values.M3LightAppColors

@Composable
fun AppTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
){
    val colorScheme = if (darkTheme) DarkAppColors else LightAppColors
    val m3CustomColors = if (darkTheme) M3DarkAppColors else M3LightAppColors
    val typography = AppTypography

    CustomTheme(
        m3Colors = m3CustomColors,
        colors = colorScheme,
        typography = typography
    ){
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = CustomTheme.colors.background.screen
        ) {
            content()
        }
    }
}