package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrentSectionUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(): Flow<DataState<Int>> = flow {
        emit(DataState.Empty())
        val currentSection = financialEducationRepository.getCurrentSection()
        emit(DataState.Success(currentSection))
    }.catch { e ->
        emit(
            DataState.Error(
            message = e.toString(),
            data = 0
            )
        )
    }
}