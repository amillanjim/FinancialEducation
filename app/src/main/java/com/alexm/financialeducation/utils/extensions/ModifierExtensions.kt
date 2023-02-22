package com.alexm.financialeducation.utils.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import com.alexm.financialeducation.presentation.ui.compose.theme.GreenGradient6
import com.alexm.financialeducation.presentation.ui.compose.theme.GreenGradient7

fun Modifier.educationBannerContainer() =
    composed { this.then(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        GreenGradient6,
                        GreenGradient7
                    )
                )
            )
            .systemBarsPadding()
            .verticalScroll(
                rememberScrollState()
            )
    ) }

fun Modifier.onboardingContainer() =
    composed {
        this.then(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            GreenGradient6,
                            GreenGradient7
                        )
                    )
                )
                .statusBarsPadding()
                .navigationBarsPadding()
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
        )
    }