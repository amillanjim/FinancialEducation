package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.Gray400
import com.alexm.financialeducation.presentation.ui.compose.theme.Shapes
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary
import com.alexm.financialeducation.presentation.ui.compose.theme.Typography

@Composable
fun BaseTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = Typography.button,
    contentColor: Color = Stori700Primary,
    disabledContentColor: Color = Gray400,
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.small,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    TextButton(
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
            disabledContentColor = disabledContentColor
        ),
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            textStyle = textStyle,
            contentColor = contentColor,
            enableIcon = enableIcon
        )
    }
}