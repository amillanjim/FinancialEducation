package com.alexm.financialeducation.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alexm.financialeducation.presentation.navigator.Screen
import com.alexm.financialeducation.presentation.ui.compose.theme.FinancialEducationTheme
import com.alexm.financialeducation.presentation.viewmodel.FinancialEducationViewModel
import com.alexm.financialeducation.presentation.navigator.financialEducationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinancialEducationComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val viewModel: FinancialEducationViewModel = hiltViewModel()
            val navController = rememberNavController()

            val startDestination = if (viewModel.currentSectionState.collectAsState().value < 0)
                Screen.EducationBannerScreen
            else Screen.LobbyScreen

            FinancialEducationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination.route
                    ) {
                        financialEducationGraph(navController, viewModel)
                    }
                }
            }
        }
    }
}