package com.example.core.theme.custom

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

fun TextStyle.toSpanStyle(){

}

data class CustomTypography(
    val title: TitleTypography,
    val body: BodyTypography,
    val button: ButtonTypography
)

data class TitleTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle
)

data class BodyTypography(
    val regular: TextStyle,
    val bold: TextStyle
)

data class ButtonTypography(
    val regular: TextStyle
)

val LocalCustomTypography = staticCompositionLocalOf<CustomTypography?> { null }