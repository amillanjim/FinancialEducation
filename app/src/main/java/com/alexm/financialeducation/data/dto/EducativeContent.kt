package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class EducativeContent(
    @StringRes val title: Int,
    @StringRes val message: Int,
    val greenText: List<Int>,
    val boldText: List<Int>,
    @DrawableRes val imageHeaderResource: Int,
    val rotateImage: Float? = null
)
