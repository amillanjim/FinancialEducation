package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.dto.Quiz
import com.alexm.financialeducation.data.dto.QuizType
import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuizUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(currentSection: Int): Flow<DataState<Quiz>> = flow {
        emit(DataState.Empty())
        val quiz = financialEducationRepository.getQuizBySection(section = currentSection)
        emit(DataState.Success(data = quiz))
    }.catch {
        emit(DataState.Error(
            data = QuizType.WHAT_HAPPEN_IF_PAY_MINIMUM.quiz,
            message = "No se pudo cargar la sección")
        )
    }
}