package com.alexm.financialeducation.presentation.ui.quiz

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.*
import com.alexm.financialeducation.presentation.ui.compose.theme.White
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuizScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onWrongAnswerClick: () -> Unit,
    onCorrectAnswerBtnClick: () -> Unit
) {
    SetSystemBarsColor(
        statusBarColor = White,
        isDarkModeIcons = true
    )

    val coroutineScope = rememberCoroutineScope()
    var hiddenWrongBottomSheet by rememberSaveable { mutableStateOf(0) }

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    ) { it != ModalBottomSheetValue.HalfExpanded }

    if (sheetState.currentValue != ModalBottomSheetValue.Hidden) {
        DisposableEffect(Unit) {
            onDispose {
                if (hiddenWrongBottomSheet == 1) {
                    onWrongAnswerClick()
                    hiddenWrongBottomSheet = 0
                } else {
                    hiddenWrongBottomSheet++
                }
            }
        }
    }

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
            WrongAnswerBottomSheet(isBackToEducative = hiddenWrongBottomSheet >= 1)
            { coroutineScope.launch { sheetState.hide() } }
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
            id = if (isBackToEducative) R.string.fe_quiz_wrong_answer_redirect
            else R.string.fe_quiz_wrong_answer
        ),
        headIcon = if (isBackToEducative) R.drawable.ic_crying_face else R.drawable.ic_flushed_face,
        mainBtnAction = onClick,
        mainBtnText = stringResource(id = R.string.fe_lobby_bs_got_it)
    )
}
