package com.alexm.financialeducation.data.dto

import com.alexm.financialeducation.R

enum class LobbyType(
    val section: Int,
    val lobby: Lobby
) {
    NO_SECTIONS_COMPLETED(
        section = 0,
        Lobby(
            title = R.string.fe_lobby_start_learning,
            subtitle = R.string.fe_lobby_select_your_first_challenge,
            emojiResource = R.drawable.ic_grinning_face
        )
    ),
    FIRST_SECTION_COMPLETED(
        section = 1,
        Lobby(
            title = R.string.fe_lobby_good_start,
            subtitle = R.string.fe_lobby_keep_moving_with_challenges,
            emojiResource = R.drawable.ic_hundred_points
        )
    ),
    SECOND_SECTION_COMPLETED(
        section = 2,
        Lobby(
            title = R.string.fe_lobby_you_almost_there,
            subtitle = R.string.fe_lobby_you_have_walk_half_of_the_path,
            emojiResource = R.drawable.ic_sparkles
        )
    ),
    THIRD_SECTION_COMPLETED(
        section = 3,
        Lobby(
            title = R.string.fe_lobby_just_one_left,
            subtitle = R.string.fe_lobby_not_give_up_finish_challenge,
            emojiResource = R.drawable.ic_high_voltage
        )
    ),
    ALL_SECTIONS_COMPLETED(
        section = 4,
        Lobby(
            title = R.string.fe_lobby_you_did_it,
            subtitle = R.string.fe_lobby_you_finished_the_challenges,
            emojiResource = R.drawable.ic_trophy
        )
    );

    companion object {
        private val lobbyMap = values().associateBy(LobbyType::section)
        fun getLobbyByCompletedSections(completedSections: Int): Lobby {
            return lobbyMap[completedSections]?.lobby ?: NO_SECTIONS_COMPLETED.lobby
        }
    }
}