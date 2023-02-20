package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class EducativeContent(
    @StringRes val title: Int,
    @StringRes val message: Int,
    val greenText: List<String>,
    val boldText: List<String>,
    @DrawableRes val imageHeaderResource: Int,
)
