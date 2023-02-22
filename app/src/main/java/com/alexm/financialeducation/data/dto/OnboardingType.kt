package com.alexm.financialeducation.data.dto

import androidx.compose.ui.layout.ContentScale
import com.alexm.financialeducation.R

enum class OnboardingType(
    val section: Int,
    val onboarding: Onboarding
) {
    LEARN_IS_EASY(
        section = -3,
        Onboarding(
            title = R.string.fe_onboarding_first_screen_title,
            message = R.string.fe_onboarding_first_screen_message,
            boldText = listOf(R.string.fe_onboarding_first_section_learn_with_stori),
            primaryBtnText = R.string.fe_next,
            imageHeader = R.drawable.img_book_with_eyes,
            rotateImage = 8.82F,
            contentScale = ContentScale.Inside
        )
    ),
    RIFATE_LEARNING(
        section = -2,
        Onboarding(
            title = R.string.fe_onboarding_second_screen_title,
            message = R.string.fe_onboarding_second_screen_message,
            primaryBtnText = R.string.fe_next,
            imageHeader = R.drawable.img_lamp_light_one_color,
            contentScale = ContentScale.Inside
        )
    ),
    TEST_WHAT_YOU_LEARNED(
        section = -1,
        Onboarding(
            title = R.string.fe_onboarding_third_screen_title,
            message = R.string.fe_onboarding_third_screen_message,
            primaryBtnText = R.string.fe_onboarding_i_want_start,
            imageHeader = R.drawable.img_card_with_check,
            contentScale = ContentScale.None
        )
    ),
    GOOD_START(
        section = 0,
        Onboarding(
            title = R.string.fe_onboarding_fourth_screen_title,
            message = R.string.fe_onboarding_fourth_screen_message,
            boldText = listOf(
                R.string.fe_onboarding_fourth_section_your_first_challenge,
                R.string.fe_onboarding_fourth_section_learn_with_stori
            ),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_walking,
            contentScale = ContentScale.Crop
        )
    ),
    KEEP_MOVING(
        section = 1,
        Onboarding(
            title = R.string.fe_onboarding_fifth_screen_title,
            message = R.string.fe_onboarding_fifth_screen_message,
            boldText = listOf(R.string.fe_onboarding_fifth_section_stori_challenge),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_with_skate,
            contentScale = ContentScale.Crop
        )
    ),
    FINISH_THIRD_CHALLENGE(
        section = 2,
        Onboarding(
            title = R.string.fe_onboarding_sixth_screen_title,
            message = R.string.fe_onboarding_sixth_screen_message,
            boldText = listOf(R.string.fe_onboarding_sixth_section_third_stori_challenge),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_with_skate,
            contentScale = ContentScale.Crop
        )
    ),
    YOU_DID_IT(
        section = 3,
        Onboarding(
            title = R.string.fe_lobby_you_did_it,
            message = R.string.fe_onboarding_seventh_screen_message,
            boldText = listOf(
                R.string.fe_onboarding_seventh_section_you,
                R.string.fe_onboarding_seventh_section_first_learn_with_stori_module
            ),
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_lamp_multi_color,
            contentScale = ContentScale.Inside
        )
    );

    companion object {
        private val onboardingMap = values().associateBy(OnboardingType::section)
        fun getOnboardingBySection(section: Int): Onboarding =
           onboardingMap[section]?.onboarding ?: GOOD_START.onboarding
    }
}