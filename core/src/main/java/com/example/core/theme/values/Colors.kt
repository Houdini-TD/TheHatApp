package com.example.core.theme.values


import androidx.compose.ui.graphics.Color
import com.example.core.theme.custom.BackgroundColors
import com.example.core.theme.custom.ButtonColors
import com.example.core.theme.custom.CustomColors
import com.example.core.theme.custom.IconColors
import com.example.core.theme.custom.OverlayColors
import com.example.core.theme.custom.TextColors

val DarkAppColors = CustomColors(
    background = BackgroundColors(
        screen = Color(0xFF121212),
        card = Color(0xFF252525)
    ),
    text = TextColors(
        primary = Color(0xFFF0F0F0),
        secondary = Color(0xFFF7931E)
    ),
    icon = IconColors(
        primary = Color(0xFFF0F0F0)
    ),
    button = ButtonColors(
        primary = Color(0xFFFFB82B)
    ),
    overlay = OverlayColors(
        primary = Color(0xFFFFB82B)
    )
)

val LightAppColors = DarkAppColors