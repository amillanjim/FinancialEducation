package com.alexm.financialeducation.presentation.navigator

sealed class Screen(val route: String) {
    object EducationBannerScreen: Screen("educationbanner")
    object OnboardingScreen: Screen("onboarding")
    object LobbyScreen: Screen("lobby")
    object EducativeScreen: Screen("educative")
    object QuizScreen: Screen("quiz")
}
