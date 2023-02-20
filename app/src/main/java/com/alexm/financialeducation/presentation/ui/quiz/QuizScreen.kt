package com.alexm.financialeducation.presentation.ui.quiz

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.*
import com.alexm.financialeducation.presentation.ui.compose.theme.White
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.extensions.SetStatusBarColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuizScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onWrongAnswerClick: () -> Unit,
    onCorrectAnswerBtnClick: () -> Unit
) {
    SetStatusBarColor(
        statusBarColor = White,
        isDarkModeIcons = true
    )

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()
    var hiddenWrongBottomSheet by rememberSaveable { mutableStateOf(0) }

    BaseModalBottomSheet(
        sheetState = sheetState,
        coroutineScope = coroutineScope,
        screenContent = { QuizContent(
            viewModel = viewModel,
            onBackPressed = onBackPressed,
            onCorrectAnswerBtnClick = onCorrectAnswerBtnClick,
            onWrongAnswerBtnClick = { coroutineScope.launch { sheetState.show() } }
        ) },
        sheetContent = {
            WrongAnswerBottomSheet(
                isBackToEducative = hiddenWrongBottomSheet != 1
            ){
                coroutineScope.launch {
                    sheetState.hide()
                    if (hiddenWrongBottomSheet == 1) {
                        hiddenWrongBottomSheet = 0
                        onWrongAnswerClick.invoke()
                    } else {
                        hiddenWrongBottomSheet++
                    }
                }
            }
        }
    )
}

@Composable
private fun WrongAnswerBottomSheet(
    isBackToEducative: Boolean,
    onClick: () -> Unit
){
    BaseBottomSheetContent(
        title = stringResource(
            id = if (isBackToEducative) R.string.fe_quiz_bs_oh_no
            else R.string.fe_lobby_bs_oops
        ),
        message = stringResource(
            id = if (isBackToEducative) R.string.fe_quiz_wrong_answer
            else R.string.fe_quiz_wrong_answer_redirect
        ),
        headIcon = if (isBackToEducative) R.drawable.ic_flushed_face else R.drawable.ic_crying_face,
        mainBtnAction = onClick,
        mainBtnText = stringResource(id = R.string.fe_lobby_bs_got_it)
    )
}
