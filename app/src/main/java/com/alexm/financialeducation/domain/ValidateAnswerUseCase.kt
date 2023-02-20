package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ValidateAnswerUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(section: Int, userAnswer: Int): Flow<DataState<Boolean>> = flow {
        emit(DataState.Empty())
        val isCorrectAnswer = financialEducationRepository.validateCorrectAnswer(
            section = section, userAnswer = userAnswer
        )
        emit(DataState.Success(data = isCorrectAnswer))
    }.catch { e ->
        emit(DataState.Error(message = e.toString(), data = false))
    }
}