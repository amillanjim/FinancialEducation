package com.alexm.financialeducation.presentation.ui.lobby

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.alexm.financialeducation.R
import com.alexm.financialeducation.presentation.ui.compose.basecomponents.*
import com.alexm.financialeducation.presentation.ui.compose.theme.White
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.utils.extensions.SetStatusBarColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LobbyScreen(
    viewModel: FinancialEducationViewModel,
    onBackPressed: () -> Unit,
    onSectionSelected: () -> Unit
){
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
        screenContent = { LobbyContent(
            viewModel = viewModel,
            onBackPressed = onBackPressed,
            onSectionSelected = onSectionSelected,
            onNextChallengeClick = { coroutineScope.launch { sheetState.show() } }
        ) },
        sheetContent = { LobbyBottomSheet(
            onClick = { coroutineScope.launch { sheetState.hide() } }
        ) }
    )
}

@Composable
private fun LobbyBottomSheet(
    onClick: () -> Unit
){
    BaseBottomSheetContent(
        title = stringResource(id = R.string.fe_lobby_bs_oops),
        message = stringResource(id = R.string.fe_lobby_bs_creating_more_challenges_fd),
        headIcon = R.drawable.ic_light_bulb,
        mainBtnAction = onClick,
        mainBtnText = stringResource(id = R.string.fe_lobby_bs_got_it)
    )
}