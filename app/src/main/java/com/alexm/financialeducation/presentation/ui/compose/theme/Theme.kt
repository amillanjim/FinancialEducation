package com.alexm.financialeducation.presentation.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Stori700Primary,
    primaryVariant = Stori600,
    secondary = Stori300Secondary,
    secondaryVariant = Stori100,
    background = Light,
    surface = White,
    onPrimary = White,
    onSecondary = GrayBlack,
    onBackground = GrayBlack,
    onSurface = GrayBlack,
)

@Composable
fun FinancialEducationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors =  LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}