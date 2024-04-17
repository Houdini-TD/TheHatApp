package com.example.core.theme.custom

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle


data class CustomTypography(
    val title: TitleTypography,
    val body: BodyTypography,
    val button: ButtonTypography
)

data class TitleTypography(
    val h1: TextStyle,
    val h2: TextStyle,
)

data class BodyTypography(
    val regular: TextStyle
)

data class ButtonTypography(
    val regular: TextStyle
)

val LocalCustomTypography = staticCompositionLocalOf<CustomTypography?> { null }