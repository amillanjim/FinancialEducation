package com.alexm.financialeducation.data.repository

import com.alexm.financialeducation.data.dto.EducativeContent
import com.alexm.financialeducation.data.dto.Lobby
import com.alexm.financialeducation.data.dto.Onboarding
import com.alexm.financialeducation.data.dto.Quiz

interface FinancialEducationRepository {

    suspend fun getCompletedSections(): Int

    suspend fun saveCompletedSection(completedSections: Int)

    suspend fun getCurrentSection(): Int

    suspend fun saveCurrentSection(currentSection: Int)

    suspend fun getOnboardingBySection(section: Int): Onboarding

    suspend fun getLobbyByCompletedSections(completedSections: Int): Lobby

    suspend fun getEducativeContentBySection(section: Int): EducativeContent

    suspend fun getQuizBySection(section: Int): Quiz

    suspend fun validateCorrectAnswer(section: Int, userAnswer: Int): Boolean
}