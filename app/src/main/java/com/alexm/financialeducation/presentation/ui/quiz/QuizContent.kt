package com.alexm.financialeducation.presentation.ui.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.*
import com.alexm.financialeducation.presentation.ui.compose.theme.*
import com.alexm.financialeducation.presentation.ui.quiz.components.ImageHeader
import com.alexm.financialeducation.presentation.ui.quiz.components.QuizTitle
import com.alexm.financialeducation.presentation.ui.quiz.components.QuizTopBar
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel

@Composable
fun QuizContent(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onCorrectAnswerBtnClick: () -> Unit,
    onWrongAnswerBtnClick: () -> Unit
){
    val quizState by viewModel.quizState.collectAsState()

    Scaffold(
        topBar = { QuizTopBar(onBackPressed) },
        backgroundColor = Light
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Light)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            val (imageHeader, quizTitle, quizContent) = createRefs()

            ImageHeader(
                modifier = Modifier.constrainAs(
                    ref = imageHeader,
                    constrainBlock = { top.linkTo(parent.top) }
                ),
                resourceId = quizState.imageHeaderResource
            )

            QuizTitle(
                modifier = Modifier.constrainAs(
                    ref = quizTitle,
                    constrainBlock = { top.linkTo(imageHeader.bottom) }
                ),
                title = stringResource(id = quizState.title)
            )

            QuizQuestions(
                viewModel = viewModel,
                modifier = Modifier.constrainAs(
                    ref = quizContent,
                    constrainBlock = { top.linkTo(quizTitle.bottom) }
                ),
                firstQuestion = quizState.firstQuestion,
                secondQuestion = quizState.secondQuestion,
                onCorrectAnswerBtnClick = onCorrectAnswerBtnClick,
                onWrongAnswerBtnClick = onWrongAnswerBtnClick
            )
        }
    }
}

@Composable
private fun QuizQuestions(
    viewModel: FinancialEducationViewModel,
    modifier: Modifier,
    firstQuestion: Int,
    secondQuestion: Int,
    onCorrectAnswerBtnClick: () -> Unit,
    onWrongAnswerBtnClick: () -> Unit
){
    Column(
        modifier = modifier.padding(top = 56.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AnswerOption(answerOption = firstQuestion) {
            viewModel.validateAnswer(userAnswer = it)
            if (viewModel.isValidAnswer.value)
                onCorrectAnswerBtnClick()
            else
                onWrongAnswerBtnClick()
        }
        AnswerOption(answerOption = secondQuestion) {
            viewModel.validateAnswer(userAnswer = it)
            if (viewModel.isValidAnswer.value)
                onCorrectAnswerBtnClick()
            else
                onWrongAnswerBtnClick()
        }
    }
}

@Composable
private fun AnswerOption(
    answerOption: Int,
    onSelected: (questionId: Int) -> Unit
){
    OutlinedBox(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onSelected(answerOption) },
        elevation = 2.dp,
        borderWidth = 2.dp,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 28.dp, horizontal = 58.dp),
            text = stringResource(id = answerOption),
            textAlign = TextAlign.Center,
            style = Typography.subtitle1
        )
    }
}