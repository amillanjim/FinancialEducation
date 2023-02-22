package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.layout.ContentScale

data class Onboarding(
    @StringRes val title: Int,
    @StringRes val message: Int,
    val boldText: List<Int>? = null,
    @StringRes val primaryBtnText: Int? = null,
    @StringRes val secondaryBtnText: Int? = null,
    @DrawableRes val imageHeader: Int,
    val rotateImage: Float? = null,
    val contentScale: ContentScale = ContentScale.None
)