package com.alexm.financialeducation.presentation.ui.quiz.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.OutlinedGradientImageBox
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.angledGradientBackground
import com.alexm.financialeducation.presentation.ui.compose.theme.GreenGradient3
import com.alexm.financialeducation.presentation.ui.compose.theme.GreenGradient4
import com.alexm.financialeducation.presentation.ui.compose.theme.GreenGradient5

@Composable
fun ImageHeader(
    modifier: Modifier,
    @DrawableRes resourceId: Int,
    rotateImage: Float? = null
){
    Box(
        modifier = modifier
    ) {
        OutlinedGradientImageBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .angledGradientBackground(
                    colors = listOf(
                        GreenGradient3,
                        GreenGradient4,
                        GreenGradient5
                    ),
                    degrees = 45F
                ),
            elevation = 4.dp,
            resourceId = resourceId,
            rotateImage = rotateImage
        )
    }
}