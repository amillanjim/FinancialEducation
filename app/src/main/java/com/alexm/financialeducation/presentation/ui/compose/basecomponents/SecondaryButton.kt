package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = Typography.button,
    contentColor: Color = Stori700Primary,
    disableContentColor: Color = Gray400,
    border: BorderStroke = BorderStroke(1.dp, Stori700Primary),
    disableBorder: BorderStroke = BorderStroke(1.dp, Gray400),
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = Shapes.medium,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit
){
    val borderStroke = if (enabled) border else disableBorder
    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = White.copy(alpha = 0.0F),
            contentColor = contentColor,
            disabledContentColor = disableContentColor
        ),
        border = borderStroke,
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            textStyle = textStyle,
            enableIcon = enableIcon
        )
    }
}

@Preview
@Composable
fun PreviewSecondaryButton(){
    SecondaryButton(text = "Prueba") {
        
    }
}