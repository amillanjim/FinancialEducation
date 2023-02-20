package com.alexm.financialeducation.presentation.ui.quiz.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.presentation.ui.compose.theme.GrayBlack
import com.alexm.financialeducation.presentation.ui.compose.theme.Typography

@Composable
fun QuizTitle(
    modifier: Modifier,
    title: String
){
    Text(
        modifier = modifier.padding(top = 42.dp),
        text = title,
        color = GrayBlack,
        style = Typography.h3
    )
}