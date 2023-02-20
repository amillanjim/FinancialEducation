package com.alexm.financialeducation.presentation.ui.compose.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alexm.financialeducation.R

/**
 * Typography
 *
 * A set of Font Family values created for the design system, you must implement the values
 * contained inside this file, these were created base on the design system and are implemented
 * into the theme.
 */

private val Roboto = FontFamily(
    Font(R.font.roboto, FontWeight.Normal)
)

private val PublicSans = FontFamily(
    Font(R.font.public_sans, FontWeight.Normal)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    h3 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp,
        letterSpacing = (0.3).sp
    ),
    subtitle2 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = (0.3).sp
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 23.sp,
        letterSpacing = 0.sp
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = (0.3).sp
    ),
    overline = TextStyle(
        fontFamily = Roboto,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    )
)

fun Typography.subtitle3() = TextStyle(
    fontFamily = PublicSans,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.body3() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.body4() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.tabs() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 23.sp,
    letterSpacing = (0.5).sp
)