package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.R

@Composable
fun ButtonContent(
    text: String,
    textStyle: TextStyle,
    contentColor: Color,
    enableIcon: Boolean
){
    Text(
        text = text,
        color = contentColor,
        style = textStyle,
    )
    if (enableIcon) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right_24px),
                contentDescription = null,
                modifier = Modifier.width(17.dp),
                tint = contentColor
            )
        }
    }
}