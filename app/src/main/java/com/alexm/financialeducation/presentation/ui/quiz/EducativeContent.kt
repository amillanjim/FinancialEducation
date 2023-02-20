package com.alexm.financialeducation.presentation.ui.quiz

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
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexm.financialeducation.R
import com.alexm.financialeducation.data.dto.EducativeContent
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.PrimaryButton
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.Toolbar
import com.alexm.financialeducation.presentation.ui.compose.theme.Light
import com.alexm.financialeducation.presentation.ui.compose.theme.Stori700Primary
import com.alexm.financialeducation.presentation.ui.quiz.components.ImageHeader
import com.alexm.financialeducation.presentation.ui.quiz.components.QuizTitle
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.FinancialEducationUtils

@Composable
fun EducativeContent(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onEducativeBtnClick: () -> Unit,
) {
    val educativeState by viewModel.educativeContentState.collectAsState()

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            Toolbar(
                text = stringResource(id = R.string.fe_toolbar_header),
                leftIconResource = R.drawable.ic_chevron_left_24px,
                onLeftClick = onBackPressed
            )
        }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Light)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            val (imageHeader, quizTitle, educativeContent) = createRefs()

            ImageHeader(
                modifier = Modifier.constrainAs(
                    ref = imageHeader,
                    constrainBlock = { top.linkTo(parent.top) }
                ),
                resourceId = educativeState.imageHeaderResource
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
                educativeContent = educativeState,
                buttonText = stringResource(id = R.string.fe_lobby_bs_got_it),
                onClick = onEducativeBtnClick
            )
        }
    }
}

@Composable
private fun EducativeContent(
    modifier: Modifier,
    educativeContent: EducativeContent,
    buttonText: String,
    onClick: () -> Unit
){
    Column(
        modifier = modifier.padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(56.dp)
    ) {
        val styledText = FinancialEducationUtils.styledText(
            text = stringResource(id = educativeContent.message),
            color = Stori700Primary,
            colorText = educativeContent.greenText,
            secondaryColorText = educativeContent.boldText
        )

        Text(text = styledText)

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .padding(horizontal = 40.dp),
            text = buttonText,
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),
            onClick = onClick
        )
    }
}