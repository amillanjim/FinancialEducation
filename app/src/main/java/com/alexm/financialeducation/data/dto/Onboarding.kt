package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Onboarding(
    @StringRes val title: Int,
    @StringRes val message: Int,
    val boldText: List<String>? = null,
    @StringRes val primaryBtnText: Int? = null,
    @StringRes val secondaryBtnText: Int? = null,
    @DrawableRes val imageHeader: Int
)