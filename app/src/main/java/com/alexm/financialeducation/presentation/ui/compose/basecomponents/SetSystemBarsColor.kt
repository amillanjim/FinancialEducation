package com.alexm.financialeducation.presentation.ui.compose.basecomponents

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SetSystemBarsColor(
    statusBarColor: Color = Color.Transparent,
    navigationBarColor: Color = Color.Transparent,
    isDarkModeIcons: Boolean = false
){
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = statusBarColor.toArgb()
            window.navigationBarColor = navigationBarColor.toArgb()

            WindowCompat.getInsetsController(window, view)
                ?.isAppearanceLightStatusBars = isDarkModeIcons
            WindowCompat.getInsetsController(window, view)
                ?.isAppearanceLightNavigationBars = isDarkModeIcons
        }
    }
}