package com.example.core.utils.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.core.theme.custom.CustomTheme

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    onTextChanged: (String) -> Unit,
    placeholderText: String
) {
    OutlinedTextField(
        modifier  = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .then(modifier),
        value = value,
        onValueChange = { onTextChanged(it) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = CustomTheme.colors.background.textField,
            focusedContainerColor = CustomTheme.colors.background.textField,
            unfocusedTextColor = CustomTheme.colors.text.primary,
            focusedTextColor = CustomTheme.colors.text.primary,
            focusedBorderColor = CustomTheme.colors.text.secondary
        ),
        textStyle = CustomTheme.typography.body.regular,
        singleLine = true,
        placeholder = { Text(placeholderText) }
    )
}