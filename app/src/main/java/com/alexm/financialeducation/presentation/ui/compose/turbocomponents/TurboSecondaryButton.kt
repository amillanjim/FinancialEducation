package com.alexm.financialeducation.presentation.ui.compose.turbocomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.SecondaryButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Turbo400Primary

@Composable
fun TurboSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    SecondaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        contentColor = Turbo400Primary,
        border = BorderStroke(1.dp, Turbo400Primary),
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewTurboSecondaryButton(){
    Column {
        TurboSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Secondary"
        ) {}

        TurboSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Secondary",
            enableIcon = true
        ) {}

        TurboSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Secondary",
            enabled = false
        ) {}

        TurboSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Secondary",
            enabled = false,
            enableIcon = true
        ) {}
    }
}