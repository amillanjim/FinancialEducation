package com.alexm.financialeducation.presentation.navigator

import androidx.navigation.NavController

class FinancialEducationNavigation(
    private val navController: NavController
) {
    fun navigateToOnboardingScreen() {
        navController.navigate(Screen.OnboardingScreen.route) {
            launchSingleTop = true
        }
    }

    fun navigateToLobbyScreen() =
        navController.navigate(Screen.LobbyScreen.route) {
            popUpTo(Screen.LobbyScreen.route)
            launchSingleTop = true
        }

    fun navigateToEducativeScreen() =
        navController.navigate(Screen.EducativeScreen.route) {
            popUpTo(Screen.LobbyScreen.route)
            launchSingleTop = true
        }

    fun navigateToQuizScreen() =
        navController.navigate(Screen.QuizScreen.route){
            launchSingleTop = true
        }

    fun navigateBack() = navController.popBackStack()
}