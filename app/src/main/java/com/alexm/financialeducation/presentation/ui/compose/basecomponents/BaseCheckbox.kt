package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun BaseCheckbox(
    checkedColor: Color = Stori700Primary,
    uncheckedColor: Color = GrayBlack,
    checkmarkColor: Color = White,
    disabledColor: Color = Stori100.copy(alpha = 0.9f),
    enabled: Boolean = true
){
    var checkedState by remember { mutableStateOf(true) }
    Checkbox(
        colors = CheckboxDefaults.colors(
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor,
            checkmarkColor = checkmarkColor,
            disabledColor = disabledColor
        ),
        enabled = enabled,
        checked = checkedState,
        onCheckedChange = { checkedState = it }
    )
}