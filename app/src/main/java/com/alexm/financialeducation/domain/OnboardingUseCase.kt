package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.dto.Onboarding
import com.alexm.financialeducation.data.dto.OnboardingType
import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OnboardingUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(currentSection: Int): Flow<DataState<Onboarding>> = flow {
        emit(DataState.Empty())
        val onboarding = financialEducationRepository.getOnboardingBySection(
            section = currentSection
        )
        emit(DataState.Success(data = onboarding))
    }.catch { e ->
        emit(DataState.Error(message = e.toString(), data = OnboardingType.GOOD_START.onboarding))
    }
}