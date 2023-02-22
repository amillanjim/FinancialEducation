package com.alexm.financialeducation.presentation.ui.quiz

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexm.financialeducation.R
import com.alexm.financialeducation.data.dto.EducativeContent
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.theme.Light
import com.alexm.financialeducation.presentation.ui.quiz.components.ImageHeader
import com.alexm.financialeducation.presentation.ui.quiz.components.QuizTitle
import com.alexm.financialeducation.presentation.ui.quiz.components.QuizTopBar
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.extensions.styledText

@Composable
fun EducativeContent(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onEducativeBtnClick: () -> Unit,
) {
    val educativeState by viewModel.educativeContentState.collectAsState()

    Scaffold(
        topBar = { QuizTopBar(onBackPressed) },
        backgroundColor = Light
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Light)
                .padding(horizontal = 17.dp, vertical = 24.dp)
        ) {
            val (imageHeader, quizTitle, educativeContent, button) = createRefs()

            ImageHeader(
                modifier = Modifier.constrainAs(
                    ref = imageHeader,
                    constrainBlock = { top.linkTo(parent.top) }
                ),
                resourceId = educativeState.imageHeaderResource,
                rotateImage = educativeState.rotateImage
            )

            QuizTitle(
                modifier = Modifier.constrainAs(
                    ref = quizTitle,
                    constrainBlock = { top.linkTo(imageHeader.bottom) }
                ),
                title = stringResource(
                    id = educativeState.title
                )
            )

            EducativeContent(
                modifier = Modifier.constrainAs(
                    ref = educativeContent,
                    constrainBlock = { top.linkTo(quizTitle.bottom) }
                ),
                educativeContent = educativeState
            )

            EducativeButton(
                modifier = Modifier.constrainAs(
                    ref = button,
                    constrainBlock = { top.linkTo(educativeContent.bottom) }
                ),
                onClick = onEducativeBtnClick,
                buttonText = R.string.fe_lobby_bs_got_it
            )
        }
    }
}

@Composable
private fun EducativeContent(
    modifier: Modifier,
    educativeContent: EducativeContent
){
    val styledText = stringResource(id = educativeContent.message)
        .styledText(
            primaryColorText = educativeContent.greenText,
            secondaryColorText = educativeContent.boldText
        )

    Text(
        modifier = modifier.padding(top = 32.dp),
        text = styledText,
        lineHeight = 23.sp
    )
}

@Composable
private fun EducativeButton(
    modifier: Modifier,
    onClick: () -> Unit,
    @StringRes buttonText: Int
) {
    PrimaryButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp, top = 50.dp)
            .height(42.dp),
        text = stringResource(id = buttonText),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        onClick = onClick
    )
}