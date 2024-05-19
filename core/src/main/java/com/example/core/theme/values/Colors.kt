package com.example.core.theme.values


import androidx.compose.ui.graphics.Color
import com.example.core.theme.custom.BackgroundColors
import com.example.core.theme.custom.CoreButtonColors
import com.example.core.theme.custom.CustomColors
import com.example.core.theme.custom.IconColors
import com.example.core.theme.custom.OverlayColors
import com.example.core.theme.custom.TextColors

val DarkAppColors = CustomColors(
    background = BackgroundColors(
        screen = Color(0xFF121212),
        card = Color(0xFF252525),
        textField = Color(0xFF666666)
    ),
    text = TextColors(
        primary = Color(0xFFF0F0F0),
        secondary = Color(0xFFF7931E),
        inverted = Color(0xFF131313),
        noAccent = Color(0xFF8B8B8B)
    ),
    icon = IconColors(
        primary = Color(0xFF131313)
    ),
    button = CoreButtonColors(
        primary = Color(0xFFFFB82B)
    ),
    overlay = OverlayColors(
        primary = Color(0xFFFFB82B),
        accent = Color(0xFFF7941D)
    )
)

val LightAppColors = DarkAppColors