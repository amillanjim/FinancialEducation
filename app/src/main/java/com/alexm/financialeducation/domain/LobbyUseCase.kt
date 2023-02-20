package com.alexm.financialeducation.domain

import com.alexm.financialeducation.data.dto.Lobby
import com.alexm.financialeducation.data.dto.LobbyType
import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LobbyUseCase @Inject constructor(
    private val financialEducationRepository: FinancialEducationRepository
) {
    operator fun invoke(currentSection: Int): Flow<DataState<Lobby>> = flow {
        emit(DataState.Empty())
        val lobby = financialEducationRepository.getLobbyByCompletedSections(
            completedSections = currentSection
        )
        emit(DataState.Success(data = lobby))
    }.catch { e ->
        emit(DataState.Error(message = e.toString(), data = LobbyType.NO_SECTIONS_COMPLETED.lobby))
    }
}