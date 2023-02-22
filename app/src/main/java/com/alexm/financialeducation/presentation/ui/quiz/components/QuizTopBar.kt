package com.alexm.financialeducation.presentation.ui.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.Toolbar
import com.alexm.financialeducation.presentation.ui.compose.theme.White

@Composable
fun QuizTopBar(
    onBackPressed: () -> Unit
) {
    Card(
        elevation = 2.dp,
        shape = CutCornerShape(0.dp)
    ) {
        Column {
            Spacer(
                modifier = Modifier
                    .height(
                        WindowInsets.systemBars
                            .asPaddingValues()
                            .calculateTopPadding()
                    )
                    .fillMaxWidth()
                    .background(White)
            )
            Toolbar(
                text = stringResource(id = R.string.fe_toolbar_header),
                leftIconResource = R.drawable.ic_chevron_left_24px,
                onLeftClick = onBackPressed,
                elevation = 0.dp
            )
        }
    }
}