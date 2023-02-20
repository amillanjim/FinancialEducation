package com.alexm.financialeducation.presentation.ui.compose.storicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary

@Composable
fun StoriPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    PrimaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        enabled = enabled,
        enableIcon = enableIcon,
        backgroundColor = Stori700Primary,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewStoriPrimaryButton(){
    Column {
        StoriPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Primary"
        ) {}

        StoriPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Primary",
            enableIcon = true,
            onClick = {}
        )

        StoriPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Primary",
            enabled = false
        ) {}

        StoriPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Primary",
            enabled = false,
            enableIcon = true
        ) {}
    }
}