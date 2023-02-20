package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun OutlinedBox(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.medium,
    elevation: Dp = 1.dp,
    contentColor: Color = Black,
    backgroundColor: Color = Stori50,
    borderColor: Color = Stori700Primary,
    borderWidth: Dp = 1.dp,
    onClick: (() -> Unit)? = null,
    content: @Composable ()-> Unit
){
    Card(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = BorderStroke(borderWidth, borderColor),
    ) {
        val internalModifier =
            if (onClick != null)
                Modifier.fillMaxWidth()
                    .clip(shape)
                    .clickable(onClick = onClick)
            else Modifier.fillMaxWidth().clip(shape)

        Box(
            modifier = internalModifier,
            content = { content.invoke() }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOutlinedBox(){
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        OutlinedBox(
            modifier = Modifier.fillMaxWidth(),
            elevation = 0.dp,
            content = {
                IconText(
                    modifier = Modifier.padding(all = 20.dp),
                    text = "¡Es tu turno de responder!",
                    resource = R.drawable.ic_chevron_right_24px
                )
            }
        )

        OutlinedBox(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            elevation = 2.dp,
            borderWidth = 2.dp,
            content = {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 28.dp, horizontal = 16.dp),
                    text = "SPEI (Transferencia Clabe \nInterbancaria)",
                    textAlign = TextAlign.Center,
                    style = Typography.subtitle1
                )
            }
        )
    }
}