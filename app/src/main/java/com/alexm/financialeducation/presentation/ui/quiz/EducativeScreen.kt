package com.alexm.financialeducation.presentation.ui.quiz

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseBottomSheetContent
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.BaseModalBottomSheet
import com.alexm.financialeducation.presentation.ui.compose.theme.White
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.extensions.SetStatusBarColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EducativeScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onBSBtnClick: () -> Unit
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

    BaseModalBottomSheet(
        sheetState = sheetState,
        coroutineScope = coroutineScope,
        screenContent = { EducativeContent(
            viewModel = viewModel,
            onBackPressed = { onBackPressed.invoke() },
            onEducativeBtnClick = { coroutineScope.launch { sheetState.show() } }
        ) },
        sheetContent = {
            EducativeBottomSheet(
                onClick = {
                    onBSBtnClick.invoke()
                    coroutineScope.launch { sheetState.hide() }
                }
            )
        }
    )
}

@Composable
private fun EducativeBottomSheet(
    onClick: () -> Unit
){
    BaseBottomSheetContent(
        title = stringResource(id = R.string.fe_educative_bs_keep_with_test),
        message = stringResource(id = R.string.fe_educative_bs_now_that_you_learn),
        headIcon = R.drawable.ic_memo,
        mainBtnAction = onClick,
        mainBtnText = stringResource(id = R.string.fe_educative_bs_im_ready)
    )
}