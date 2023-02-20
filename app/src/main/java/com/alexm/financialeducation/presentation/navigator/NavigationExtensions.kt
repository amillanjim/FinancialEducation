package com.alexm.financialeducation.presentation.navigator

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alexm.financialeducation.presentation.navigator.FinancialEducationNavigation
import com.alexm.financialeducation.presentation.navigator.Screen
import com.alexm.financialeducation.presentation.ui.compose.storicomponents.StoriPrimaryButton
import com.alexm.financialeducation.presentation.ui.educationbanner.EducationBannerScreen
import com.alexm.financialeducation.presentation.ui.lobby.LobbyScreen
import com.alexm.financialeducation.presentation.ui.onboarding.OnboardingScreen
import com.alexm.financialeducation.presentation.ui.quiz.EducativeScreen
import com.alexm.financialeducation.presentation.ui.quiz.QuizScreen
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel

fun NavGraphBuilder.financialEducationGraph(
    navController: NavController,
    viewModel: FinancialEducationViewModel,
){
    val financialEducationNavigation = FinancialEducationNavigation(navController)
    val currentSection = viewModel.currentSectionState.value
    composable(route = Screen.EducationBannerScreen.route) { EducationBannerScreen(
        onDismissPress = {
            val activity = navController.context as Activity
            activity.finish() },
        onPrimaryBtnClick = { financialEducationNavigation.navigateToOnboardingScreen() },
        onSecondaryBtnClick = {
            val activity = navController.context as Activity
            activity.finish()
        }
    ) }
    composable(route = Screen.OnboardingScreen.route) { OnboardingScreen(
        viewModel = viewModel,
        onBackPressed = {
            when {
                currentSection == -3 -> {
                    val activity = navController.context as Activity
                    activity.finish()
                }
                currentSection >= 0 -> financialEducationNavigation.navigateBack()
                else -> {
                    viewModel.increaseCurrentSection()
                    financialEducationNavigation.navigateToLobbyScreen()
                }
            } },
        onPrimaryBtnClick = {
            when {
                currentSection < -1 -> {
                    viewModel.increaseCurrentSection()
                    viewModel.collectOnboardingState()
                }
                currentSection == -2 -> {
                    viewModel.collectLobbyState()
                }
                currentSection == -1 -> {
                    viewModel.increaseCurrentSection()
                    financialEducationNavigation.navigateToLobbyScreen()
                }
                else -> {
                    viewModel.increaseCurrentSection()
                    viewModel.collectEducativeContentState()
                    viewModel.collectQuizState()
                    viewModel.updateCompletedSections()
                    viewModel.collectLobbyState()
                    financialEducationNavigation.navigateToEducativeScreen()
                }
            } },
        onSecondaryBtnClick = {
            viewModel.updateCompletedSections()
            viewModel.increaseCurrentSection()
            viewModel.collectLobbyState()
            financialEducationNavigation.navigateToLobbyScreen()
        }
    ) }
    composable(route = Screen.LobbyScreen.route) { LobbyScreen(
        viewModel = viewModel,
        onBackPressed = {
            val activity = navController.context as Activity
            activity.finish()
        },
        onSectionSelected = {
            viewModel.collectQuizState()
            financialEducationNavigation.navigateToEducativeScreen()
        }
    ) }
    composable(route = Screen.EducativeScreen.route) { EducativeScreen(
        viewModel = viewModel,
        onBackPressed = { financialEducationNavigation.navigateBack() } ,
        onBSBtnClick = { financialEducationNavigation.navigateToQuizScreen() }
    ) }
    composable(route = Screen.QuizScreen.route) { QuizScreen(
        viewModel = viewModel,
        onBackPressed = { financialEducationNavigation.navigateBack() },
        onCorrectAnswerBtnClick = {
            viewModel.collectOnboardingState()
            financialEducationNavigation.navigateToOnboardingScreen()
        },
        onWrongAnswerClick = { financialEducationNavigation.navigateBack() }
    ) }
}