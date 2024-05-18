package com.example.core.utils.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.core.theme.custom.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(label: String) {
    TopAppBar(
        title = {
            Text(text = label, style = CustomTheme.typography.title.h1)
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = CustomTheme.colors.overlay.primary),
    )
}