package com.alexm.financialeducation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.theme.Gray700
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary

object FinancialEducationUtils {
    fun convertQuartersToPercentage(completedSections: Int) =
        when {
            completedSections < 0 -> 0f
            completedSections == 0 -> 0f
            completedSections == 1 -> 25f
            completedSections == 2 -> 50f
            completedSections == 3 -> 75f
            else -> 100f
        }

    private fun styleColorText(
        fontSize: TextUnit = 14.sp,
        fontFamily: FontFamily = FontFamily(Font(R.font.roboto)),
        color: Color
    ) = SpanStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = FontWeight.SemiBold,
        color = color
    )

    private fun styleNormalText(
        fontSize: TextUnit = 14.sp,
        fontFamily: FontFamily = FontFamily(Font(R.font.roboto)),
        color: Color
    ) = SpanStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = FontWeight.Normal,
        color = color
    )

    fun styledText(text: String,
                   fontSize: TextUnit = 14.sp,
                   fontFamily: FontFamily = FontFamily(Font(R.font.roboto)),
                   color: Color = Stori700Primary,
                   secondaryColor: Color = Gray700,
                   normalColor: Color = Gray700,
                   colorText: List<String>? = null,
                   secondaryColorText: List<String>? = null
    ): AnnotatedString {
        val styledString = AnnotatedString.Builder()
        styledString.append(text)

        styledString.addStyle(
            style = styleNormalText(
                fontSize = fontSize,
                fontFamily = fontFamily,
                color = normalColor
            ),
            start = 0,
            end = text.length)

        colorText?.let {
            for (textValue in it){
                if (text.contains(textValue)) {
                    val colorStartIndex = text.indexOf(textValue)
                    val colorEndIndex = colorStartIndex + textValue.length
                    styledString.addStyle(
                        styleColorText(
                            fontSize = fontSize,
                            fontFamily = fontFamily,
                            color = color
                        ),
                        start = colorStartIndex,
                        end = colorEndIndex)
                }
            }
        }

        secondaryColorText?.let {
            for (boldText in it){
                if (text.contains(boldText)) {
                    val boldStartIndex = text.indexOf(boldText)
                    val boldEndIndex = boldStartIndex + boldText.length
                    styledString.addStyle(
                        styleColorText(
                            fontSize = fontSize,
                            fontFamily = fontFamily,
                            color = secondaryColor
                        ), boldStartIndex, boldEndIndex)
                }
            }
        }

        return styledString.toAnnotatedString()
    }
}