package com.example.core.theme.custom

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors (
    val background: BackgroundColors,
    val text: TextColors,
    val icon: IconColors,
    val button: ButtonColors,
    val overlay: OverlayColors
)

data class BackgroundColors(
    val screen: Color,
    val card: Color
)

data class TextColors(
    val primary: Color,
    val secondary: Color,
    val inverted: Color
)

data class IconColors(
    val primary: Color
)

data class ButtonColors(
    val primary: Color
)

data class OverlayColors(
    val primary: Color
)

val LocalCustomColors = staticCompositionLocalOf<CustomColors?> { null }