package com.alexm.financialeducation.presentation.ui.lobby.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.Gray100
import com.alexm.financialeducation.presentation.ui.compose.theme.Typography
import com.alexm.financialeducation.utils.FinancialEducationUtils

@Composable
fun GradientCircularProgressBar(
    completedSections: Int,
    indicatorThickness: Dp = 12.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    backgroundIndicatorColor: Color = Gray100,
    gradientColors: List<Color> = listOf(
        Color(0xFF016598),
        Color(0xFF00A19C),
        Color(0xFF00A19C),
        Color(0xFF016598),
    )
) {
    val number = FinancialEducationUtils.convertQuartersToPercentage(completedSections)

    val animateNumber = animateFloatAsState(
        targetValue = number,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(size = 65.dp)
    ) {
        Canvas(
            modifier = Modifier.size(size = 55.dp)
        ) {
            drawCircle(
                color = backgroundIndicatorColor,
                radius = 55.dp.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Square)
            )

            val sweepAngle = (animateNumber.value / 100) * 360

            drawArc(
                brush = Brush.sweepGradient(gradientColors),
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Square)
            )
        }

        Text(
            text = "$completedSections/4",
            style = Typography.body2
        )
    }

    Spacer(modifier = Modifier.height(32.dp))
}