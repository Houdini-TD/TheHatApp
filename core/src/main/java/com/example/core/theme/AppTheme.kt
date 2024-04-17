package com.example.core.theme

import androidx.compose.runtime.Composable
import com.example.core.theme.custom.CustomTheme
import com.example.core.theme.values.AppTypography
import com.example.core.theme.values.DarkAppColors
import com.example.core.theme.values.LightAppColors

@Composable
fun AppTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
){
    val colorScheme = if (darkTheme) DarkAppColors else LightAppColors
    val typography = AppTypography

    CustomTheme(
        colors = colorScheme,
        typography = typography
    ){
        content()
    }
}