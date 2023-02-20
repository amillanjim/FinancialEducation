package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quiz(
    @StringRes val title: Int,
    @StringRes val firstQuestion: Int,
    @StringRes val secondQuestion: Int,
    @StringRes val correctAnswer: Int,
    @DrawableRes val imageHeaderResource: Int
)
