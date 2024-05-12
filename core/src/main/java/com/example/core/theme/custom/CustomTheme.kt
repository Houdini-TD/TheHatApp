package com.example.core.theme.custom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun CustomTheme(
    m3Colors: M3CustomColors,
    colors: CustomColors,
    typography: CustomTypography,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalCustomColors provides colors,
        LocalCustomTypography provides typography,
        LocalM3CustomColors provides m3Colors
    ) {
        content()
    }
}

object CustomTheme{
    val m3Colors: M3CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalM3CustomColors.current
            ?: throw Exception("M3CustomColors is not provided. Did you forget to apply CustomTheme?")
    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current
            ?: throw Exception("CustomColors is not provided. Did you forget to apply CustomTheme?")

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current
            ?: throw Exception("CustomTypography is not provided. Did you forget to apply CustomTheme?")
}