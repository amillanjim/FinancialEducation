package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.dto.EducativeContent
import com.alexm.financialeducation.data.dto.EducativeContentType
import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EducativeContentUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(currentSection: Int): Flow<DataState<EducativeContent>> = flow {
        emit(DataState.Empty())
        val educativeContent = financialEducationRepository.getEducativeContentBySection(currentSection)
        emit(DataState.Success(educativeContent))
    }.catch { e ->
        emit(DataState.Error(
            message = e.toString(),
            data = EducativeContentType.PAYMENT_AMOUNTS.educativeContent)
        )
    }
}