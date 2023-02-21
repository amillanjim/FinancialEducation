package com.alexm.financialeducation.data.dto

import com.alexm.financialeducation.R

enum class OnboardingType(
    val section: Int,
    val onboarding: Onboarding
) {
    LEARN_IS_EASY(
        section = -3,
        Onboarding(
            title = R.string.fe_onboarding_learn_is_easy,
            message = R.string.fe_onboarding_learn_with_stori,
            boldText = listOf("Aprende con Stori"),
            primaryBtnText = R.string.fe_next,
            imageHeader = R.drawable.img_book_with_eyes
        )
    ),
    RIFATE_LEARNING(
        section = -2,
        Onboarding(
            title = R.string.fe_onboarding_rifate_learning,
            message = R.string.fe_onboarding_with_capsules,
            primaryBtnText = R.string.fe_next,
            imageHeader = R.drawable.img_lamp_light_one_color
        )
    ),
    TEST_WHAT_YOU_LEARNED(
        section = -1,
        Onboarding(
            title = R.string.fe_onboarding_test_your_knowledge,
            message = R.string.fe_onboarding_fast_surveys,
            primaryBtnText = R.string.fe_onboarding_i_want_start,
            imageHeader = R.drawable.img_card_with_check
        )
    ),
    GOOD_START(
        section = 0,
        Onboarding(
            title = R.string.fe_onboarding_good_start,
            message = R.string.fe_onboarding_finished_first_challenge,
            boldText = listOf("tu primer reto Aprende con Stori!"),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_walking
        )
    ),
    KEEP_MOVING(
        section = 1,
        Onboarding(
            title = R.string.fe_onboarding_keep_moving,
            message = R.string.fe_onboarding_finished_other_challenge,
            boldText = listOf("Stori reto"),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_with_skate
        )
    ),
    FINISH_THIRD_CHALLENGE(
        section = 2,
        Onboarding(
            title = R.string.fe_onboarding_keep_moving,
            message = R.string.fe_onboarding_finished_third_challenge,
            boldText = listOf("tu tercer Stori reto"),
            primaryBtnText = R.string.fe_onboarding_primary_btn_keep_learning,
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_card_with_skate
        )
    ),
    YOU_DID_IT(
        section = 3,
        Onboarding(
            title = R.string.fe_lobby_you_did_it,
            message = R.string.fe_onboarding_you_finished_all_challenges,
            boldText = listOf("tu primer módulo de Aprende con Stori"),
            secondaryBtnText = R.string.fe_onboarding_secondary_btn_first_challenge,
            imageHeader = R.drawable.img_lamp_multi_color
        )
    );

    companion object {
        private val onboardingMap = values().associateBy(OnboardingType::section)
        fun getOnboardingBySection(section: Int): Onboarding =
           onboardingMap[section]?.onboarding ?: GOOD_START.onboarding
    }
}