package com.alexm.financialeducation.utils.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.alexm.financialeducation.presentation.ui.compose.theme.*

@Composable
fun String.styledText(
    normalSpanStyle: SpanStyle = SpanStyle().setStyle(
        color = Gray700, textStyle = Typography.body4()
    ),
    primarySpanStyle: SpanStyle = SpanStyle().setStyle(
        color = Stori700Primary, textStyle = Typography.body3()
    ),
    secondarySpanStyle: SpanStyle = SpanStyle().setStyle(
        color = Gray700, textStyle = Typography.body3()
    ),
    primaryColorText: List<Int>? = null,
    secondaryColorText: List<Int>? = null
): AnnotatedString {
    val styledString = AnnotatedString.Builder()
    styledString.append(this)

    styledString.addStyle(
        style = normalSpanStyle,
        start = 0,
        end = this.length)

    primaryColorText?.forEach { primaryText ->
        val stringValue = stringResource(id = primaryText)
        if (this.contains(stringValue)) {
            val colorStartIndex = this.indexOf(stringValue)
            val colorEndIndex = colorStartIndex + stringValue.length
            styledString.addStyle(
                style = primarySpanStyle,
                start = colorStartIndex,
                end = colorEndIndex)
        }
    }

    secondaryColorText?.forEach { secondaryText ->
        val stringValue = stringResource(id = secondaryText)
        if (this.contains(stringValue)) {
            val boldStartIndex = this.indexOf(stringValue)
            val boldEndIndex = boldStartIndex + stringValue.length
            styledString.addStyle(
                style = secondarySpanStyle,
                start = boldStartIndex,
                end = boldEndIndex
            )
        }
    }

    return styledString.toAnnotatedString()
}