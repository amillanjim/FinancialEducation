package com.alexm.financialeducation.data.repository

import com.alexm.financialeducation.data.dto.*
import javax.inject.Inject

class FinancialEducationRepositoryImpl @Inject constructor(): FinancialEducationRepository {
    override suspend fun getCompletedSections(): Int = 0

    override suspend fun saveCompletedSection(completedSections: Int) {
        TODO("save completed section in Preferences Helper")
    }

    override suspend fun getCurrentSection(): Int = -3

    override suspend fun saveCurrentSection(currentSection: Int) {
        TODO("save current section in Preferences Helper")
    }

    override suspend fun getOnboardingBySection(section: Int): Onboarding =
        OnboardingType.getOnboardingBySection(section = section)


    override suspend fun getLobbyByCompletedSections(completedSections: Int): Lobby =
        LobbyType.getLobbyByCompletedSections(completedSections = completedSections)

    override suspend fun getEducativeContentBySection(section: Int): EducativeContent =
        EducativeContentType.getEducativeContentBySection(section = section)

    override suspend fun getQuizBySection(section: Int): Quiz =
        QuizType.getQuizQuestionBySection(section = section)

    override suspend fun validateCorrectAnswer(section: Int, userAnswer: Int): Boolean =
        userAnswer == QuizType.getQuizQuestionBySection(section = section).correctAnswer
}