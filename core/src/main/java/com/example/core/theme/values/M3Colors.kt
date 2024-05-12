package com.example.core.theme.values

import androidx.compose.material3.CardColors
import com.example.core.theme.custom.ButtonColors
import com.example.core.theme.custom.CustomButtonColors
import com.example.core.theme.custom.CustomCardColors
import com.example.core.theme.custom.M3CustomColors

val M3DarkAppColors = M3CustomColors(
    cardColors = CustomCardColors(
        primary = CardColors(
            containerColor = DarkAppColors.background.card,
            contentColor = DarkAppColors.text.primary,
            disabledContainerColor = DarkAppColors.background.card,
            disabledContentColor = DarkAppColors.text.primary
        ),
        secondary = CardColors(
            containerColor = DarkAppColors.background.card,
            contentColor = DarkAppColors.text.primary,
            disabledContainerColor = DarkAppColors.background.card,
            disabledContentColor = DarkAppColors.text.primary
        ),
    ),
    buttonColors = CustomButtonColors(
        primary = ButtonColors(
            primary = DarkAppColors.button.primary
        ),
        secondary = ButtonColors(
            primary = DarkAppColors.button.primary
        )
    )
)

val M3LightAppColors = M3DarkAppColors