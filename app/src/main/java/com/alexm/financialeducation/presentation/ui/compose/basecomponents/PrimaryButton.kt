package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = Typography.button,
    enableIcon: Boolean = false,
    contentColor: Color = White,
    disableContentColor: Color = Gray400,
    backgroundColor: Color = Stori700Primary,
    disableBackgroundColor: Color = Gray200,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = Shapes.medium,
    borderStroke: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit
){
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledBackgroundColor = disableBackgroundColor,
            disabledContentColor = disableContentColor
        ),
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        border = borderStroke,
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