package com.alexm.financialeducation.presentation.ui.compose.storicomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.SecondaryButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary

@Composable
fun StoriSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    SecondaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        contentColor = Stori700Primary,
        border = BorderStroke(1.dp, Stori700Primary),
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewStoriSecondaryButton(){
    Column {
        StoriSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Secondary"
        ) {}

        StoriSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Secondary",
            enableIcon = true
        ) {}

        StoriSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Secondary",
            enabled = false
        ) {}

        StoriSecondaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Secondary",
            enabled = false,
            enableIcon = true
        ) {}
    }
}