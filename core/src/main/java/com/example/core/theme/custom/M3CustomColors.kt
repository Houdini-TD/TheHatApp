package com.example.core.theme.custom

import androidx.compose.material3.CardColors
import androidx.compose.runtime.staticCompositionLocalOf


data class M3CustomColors(
    val cardColors: CustomCardColors,
    val buttonColors: CustomButtonColors
)

data class CustomCardColors(
    val primary: CardColors,
    val secondary: CardColors
)

data class CustomButtonColors(
    val primary: ButtonColors,
    val secondary: ButtonColors
)

val LocalM3CustomColors = staticCompositionLocalOf<M3CustomColors?> { null }