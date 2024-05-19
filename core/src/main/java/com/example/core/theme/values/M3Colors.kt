package com.example.core.theme.values

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.core.theme.custom.CustomButtonColors
import com.example.core.theme.custom.CustomCardColors
import com.example.core.theme.custom.CustomTextFieldColors
import com.example.core.theme.custom.CustomTheme
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
            containerColor = DarkAppColors.button.primary,
            contentColor = DarkAppColors.text.primary,
            disabledContainerColor = DarkAppColors.button.primary,
            disabledContentColor = DarkAppColors.text.primary
        ),
        secondary = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = DarkAppColors.background.card,
            disabledContainerColor = DarkAppColors.button.primary,
            disabledContentColor = DarkAppColors.text.primary
        ),
    ),
    textFieldColors = CustomTextFieldColors(
        primary = @Composable {
            TextFieldDefaults.colors().copy(
                unfocusedContainerColor = CustomTheme.colors.background.textField,
                focusedContainerColor = CustomTheme.colors.background.textField,
                unfocusedTextColor = CustomTheme.colors.text.primary,
                focusedTextColor = CustomTheme.colors.text.primary,
            )
        }
    )
)

val M3LightAppColors = M3DarkAppColors