package com.alexm.financialeducation.presentation.ui.compose.turbocomponents

import androidx.compose.runtime.Composable
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseCheckbox
import com.alexm.financialeducation.presentation.ui.compose.theme.SuperApp100
import com.alexm.financialeducation.presentation.ui.compose.theme.SuperApp700

@Composable
fun TurboCheckbox(
    enabled: Boolean
){
    BaseCheckbox(
        checkedColor = SuperApp700,
        disabledColor = SuperApp100.copy(alpha = 0.9f),
        enabled = enabled
    )
}