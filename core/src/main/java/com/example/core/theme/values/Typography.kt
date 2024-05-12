package com.example.core.theme.values

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.theme.custom.BodyTypography
import com.example.core.theme.custom.ButtonTypography
import com.example.core.theme.custom.CustomTypography
import com.example.core.theme.custom.TitleTypography


val OswaldFontFamily = FontFamily(
    Font(R.font.oswald_extra_light, FontWeight.Light),
    Font(R.font.oswald_regular, FontWeight.Normal),
    Font(R.font.oswald_demi_bold, FontWeight.Bold)
)

val AppTypography = CustomTypography(
    title = TitleTypography(
        h1 = TextStyle(
            fontFamily = OswaldFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp
        ),
        h2 = TextStyle(
            fontFamily = OswaldFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp
        ),
        h3 = TextStyle(
            fontFamily = OswaldFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp
        )
    ),
    body = BodyTypography(
        regular = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 18.sp
        )
    ),
    button = ButtonTypography(
        regular = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 18.sp
        )
    )
)