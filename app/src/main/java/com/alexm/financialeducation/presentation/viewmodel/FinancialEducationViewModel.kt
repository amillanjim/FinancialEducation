package com.alexm.financialeducation.presentation.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexm.financialeducation.data.dto.*
import com.alexm.financialeducation.domain.*
import com.alexm.financialeducation.presentation.ui.lobby.LobbyState
import com.alexm.financialeducation.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FinancialEducationViewModel @Inject constructor(
    private val completedSectionsUseCase: CompletedSectionsUseCase,
    private val currentSectionUseCase: CurrentSectionUseCase,
    private val lobbyUseCase: LobbyUseCase,
    private val onboardingUseCase: OnboardingUseCase,
    private val educativeContentUseCase: EducativeContentUseCase,
    private val quizUseCase: QuizUseCase,
    private val validateAnswerUseCase: ValidateAnswerUseCase
): ViewModel() {

    private var _currentSectionState = MutableStateFlow(0)
    val currentSectionState = _currentSectionState.asStateFlow()

    private var _completedSectionsState = MutableStateFlow(0)
    val completedSections = _completedSectionsState.asStateFlow()

    private var _lobbyState = MutableStateFlow(LobbyState(isLoading = true))
    val lobbyState = _lobbyState.asStateFlow()

    private var _onboardingState = MutableStateFlow(OnboardingType.GOOD_START.onboarding)
    val onboardingState = _onboardingState.asStateFlow()

    private var _educativeContentState = MutableStateFlow(
        EducativeContentType.PAYMENT_AMOUNTS.educativeContent
    )
    val educativeContentState = _educativeContentState.asStateFlow()

    private var _quizState = MutableStateFlow(QuizType.WHAT_HAPPEN_IF_PAY_MINIMUM.quiz)
    val quizState = _quizState.asStateFlow()

    private var _isValidAnswer = MutableStateFlow(false)
    val isValidAnswer = _isValidAnswer.asStateFlow()

    init {
        viewModelScope.launch {
            currentSectionUseCase().collectLatest {
                _currentSectionState.value = it.data ?: 0
            }
            completedSectionsUseCase().collectLatest {
                _completedSectionsState.value = it.data ?: 0
                collectStateValues()
            }
        }
    }

    fun collectLobbyState() {
        viewModelScope.launch {
            lobbyUseCase(_completedSectionsState.value).collectLatest {
                _lobbyState.value = LobbyState(
                    isLoading = false,
                    lobby = it.data ?: LobbyType.NO_SECTIONS_COMPLETED.lobby
                )
            }
        }
    }

    fun collectOnboardingState() {
        viewModelScope.launch {
            onboardingUseCase(_currentSectionState.value).collectLatest {
                _onboardingState.value = it.data ?: OnboardingType.GOOD_START.onboarding
            }
        }
    }

    fun collectEducativeContentState() {
        viewModelScope.launch {
            educativeContentUseCase(_currentSectionState.value).collectLatest {
                _educativeContentState.value = it.data
                    ?: EducativeContentType.PAYMENT_AMOUNTS.educativeContent
            }
        }
    }

    fun collectQuizState() {
        viewModelScope.launch {
            quizUseCase(_currentSectionState.value).collectLatest {
                _quizState.value = it.data ?: QuizType.WHAT_HAPPEN_IF_PAY_MINIMUM.quiz
            }
        }
    }

    fun validateAnswer(@StringRes userAnswer: Int) {
        viewModelScope.launch {
            validateAnswerUseCase(
                section = _currentSectionState.value,
                userAnswer = userAnswer
            ).collectLatest {
                _isValidAnswer.value = it.data ?: false
            }
        }
    }

    private fun collectStateValues(){
        viewModelScope.launch {
            collectOnboardingState()
            collectEducativeContentState()
            collectQuizState()
            collectLobbyState()
        }
    }

    fun increaseCurrentSection(){
        _currentSectionState.value++
    }

    fun decreaseCurrentSection(){
        _currentSectionState.value--
    }

    fun updateCompletedSections(){
        _completedSectionsState.value++
        _isValidAnswer.value = false
    }
}