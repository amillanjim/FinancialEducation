package com.alexm.financialeducation.data.dto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lobby(
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    @DrawableRes val emojiResource: Int
)