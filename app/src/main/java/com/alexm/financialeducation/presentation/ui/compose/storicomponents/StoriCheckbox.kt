package com.alexm.financialeducation.presentation.ui.compose.storicomponents

import androidx.compose.runtime.Composable
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseCheckbox
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori100
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary

@Composable
fun StoriCheckbox(
    enabled: Boolean = false
){
    BaseCheckbox(
        checkedColor = Stori700Primary,
        disabledColor = Stori100.copy(alpha = 0.9f),
        enabled = enabled
    )
}