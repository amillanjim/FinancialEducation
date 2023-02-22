package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun OutlinedGradientImageBox(
    modifier: Modifier = Modifier,
    resourceId: Int,
    gradientColors: List<Color> = listOf(GreenGradient1, GreenGradient2),
    backgroundColor: Color = Color.White,
    shape: Shape = Shapes.medium,
    elevation: Dp = 4.dp,
    onClick: (() -> Unit)? = null,
    rotateImage: Float? = null
){
    Card(
        modifier = Modifier.diagonalGradientBorder(
          colors = gradientColors,
          borderSize = 4.dp,
          shape = shape
        ),
        shape = shape,
        backgroundColor = backgroundColor,
        elevation = elevation
    ){
        if (onClick != null)
            modifier.clip(shape).clickable(onClick = onClick)
        else
            modifier.clip(shape)

        Box(modifier = modifier) {
            val imageModifier = if (rotateImage != null) Modifier.fillMaxSize().rotate(rotateImage)
            else Modifier.fillMaxSize()

            Image(
                modifier = imageModifier,
                painter = painterResource(resourceId),
                contentDescription = null
            )
        }
    }
}