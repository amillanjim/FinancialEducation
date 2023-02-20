package com.alexm.financialeducation.presentation.ui.compose.storicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseTextButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary

@Composable
fun StoriTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    BaseTextButton(
        modifier = modifier.height(32.dp),
        text = text,
        contentColor = Stori700Primary,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewStoriTextButton(){
    Column {
        StoriTextButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Text Button"
        ) {}

        StoriTextButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Text Button",
            enableIcon = true
        ) {}

        StoriTextButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Text Button",
            enabled = false
        ) {}

        StoriTextButton(
            modifier = Modifier.width(250.dp),
            text = "Stori Text Button",
            enabled = false,
            enableIcon = true
        ) {}
    }
}