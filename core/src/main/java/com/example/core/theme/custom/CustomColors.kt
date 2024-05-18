package com.example.core.theme.custom

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors (
    val background: BackgroundColors,
    val text: TextColors,
    val icon: IconColors,
    val button: CoreButtonColors,
    val overlay: OverlayColors
)

data class BackgroundColors(
    val screen: Color,
    val card: Color,
    val textField: Color
)

data class TextColors(
    val primary: Color,
    val secondary: Color,
    val inverted: Color
)

data class IconColors(
    val primary: Color
)

data class CoreButtonColors(
    val primary: Color
)

data class OverlayColors(
    val primary: Color,
    val accent: Color
)

val LocalCustomColors = staticCompositionLocalOf<CustomColors?> { null }