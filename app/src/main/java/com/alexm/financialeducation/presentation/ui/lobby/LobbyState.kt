package com.alexm.financialeducation.presentation.ui.lobby

import com.alexm.financialeducation.data.dto.Lobby
import com.alexm.financialeducation.data.dto.LobbyType

data class LobbyState(
    val isLoading: Boolean,
    val lobby: Lobby = LobbyType.NO_SECTIONS_COMPLETED.lobby
)