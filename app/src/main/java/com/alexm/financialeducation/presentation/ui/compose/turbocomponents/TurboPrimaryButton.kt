package com.alexm.financialeducation.presentation.ui.compose.turbocomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Turbo400Primary

@Composable
fun TurboPrimaryButton(
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
        backgroundColor = Turbo400Primary,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewTurboPrimaryButton(){
    Column {
        TurboPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Primary"
        ) {}

        TurboPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Primary",
            enableIcon = true
        ) {}

        TurboPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Primary",
            enabled = false
        ) {}

        TurboPrimaryButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Primary",
            enabled = false,
            enableIcon = true
        ) {}
    }
}