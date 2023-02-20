package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.*

fun Modifier.diagonalGradientTint(
    colors: List<Color>
) = drawWithContent {
    drawContent()
    drawRect(
        brush = Brush.linearGradient(colors)
    )
}

fun Modifier.angledGradientBackground(colors: List<Color>, degrees: Float) = this.then(
    drawBehind {
        val (x, y) = size
        val gamma = atan2(y, x)

        if (gamma == 0f || gamma == (PI / 2).toFloat()) {
            return@drawBehind
        }

        val degreesNormalised = (degrees % 360).let { if (it < 0) it + 360 else it }

        val alpha = (degreesNormalised * PI / 180).toFloat()

        val gradientLength = when (alpha) {
            in 0f..gamma, in (2*PI - gamma)..2*PI -> { x / cos(alpha) }
            in gamma..(PI - gamma).toFloat() -> { y / sin(alpha) }
            in (PI - gamma)..(PI + gamma) -> { x / -cos(alpha) }
            in (PI + gamma)..(2*PI - gamma) -> { y / -sin(alpha) }
            else -> hypot(x, y)
        }

        val centerOffsetX = cos(alpha) * gradientLength / 2
        val centerOffsetY = sin(alpha) * gradientLength / 2

        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(center.x - centerOffsetX,center.y - centerOffsetY),
                end = Offset(center.x + centerOffsetX, center.y + centerOffsetY)
            ),
            size = size
        )
    }
)


fun Modifier.offsetGradientBackground(
    colors: List<Color>,
    width: Float,
    offset: Float = 0f
) = background(
    Brush.horizontalGradient(
        colors,
        startX = -offset,
        endX = width - offset,
        tileMode = TileMode.Mirror
    )
)

fun Modifier.diagonalGradientBorder(
    colors: List<Color>,
    borderSize: Dp = 2.dp,
    shape: Shape
) = border(
    width = borderSize,
    brush = Brush.linearGradient(colors),
    shape = shape
)

fun Modifier.fadeInDiagonalGradientBorder(
    showBorder: Boolean,
    colors: List<Color>,
    borderSize: Dp = 2.dp,
    shape: Shape
) = composed {
    val animatedColors = List(colors.size) { i ->
        animateColorAsState(if (showBorder) colors[i] else colors[i].copy(alpha = 0f)).value
    }
    diagonalGradientBorder(
        colors = animatedColors,
        borderSize = borderSize,
        shape = shape
    )
}