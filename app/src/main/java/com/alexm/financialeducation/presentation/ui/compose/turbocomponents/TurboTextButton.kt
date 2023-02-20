package com.alexm.financialeducation.presentation.ui.compose.turbocomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.Turbo400Primary
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseTextButton

@Composable
fun TurboTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    BaseTextButton(
        modifier = modifier.height(32.dp),
        text = text,
        contentColor = Turbo400Primary,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewTurboTextButton(){
    Column {
        TurboTextButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Text Button"
        ) {}

        TurboTextButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Text Button",
            enableIcon = true
        ) {}

        TurboTextButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Text Button",
            enabled = false
        ) {}

        TurboTextButton(
            modifier = Modifier.width(250.dp),
            text = "Turbo Text Button",
            enabled = false,
            enableIcon = true
        ) {}
    }
}