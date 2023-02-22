package com.alexm.financialeducation.data.dto

import com.alexm.financialeducation.R

enum class EducativeContentType(
    val section: Int,
    val educativeContent: EducativeContent
){
    DIFFERENCE_DUE_AND_CUT_DATE(
        section = 0,
        EducativeContent(
            title = R.string.fe_first_section_educative_question,
            message = R.string.fe_educative_first_section_message,
            greenText = listOf(
                R.string.fe_educative_first_section_cut_day,
                R.string.fe_educative_first_section_due_day
            ),
            boldText = listOf(
                R.string.fe_educative_first_section_day_we_close_payments,
                R.string.fe_educative_first_section_last_day_to_pay
            ),
            imageHeaderResource = R.drawable.img_card_walking_cut
        )
    ),
    PAYMENT_METHODS(
        section = 1,
        EducativeContent(
            title = R.string.fe_second_section_educative_question,
            message = R.string.fe_educative_second_section_message,
            greenText = listOf(
                R.string.fe_educative_second_section_spei,
                R.string.fe_educative_second_section_transfer,
                R.string.fe_educative_second_section_oxxo,
                R.string.fe_educative_second_section_window_paymen
            ),
            boldText = listOf(
                R.string.fe_educative_second_section_via_debit_card,
                R.string.fe_educative_second_section_recommended,
                R.string.fe_educative_second_section_take_72_hrs,
                R.string.fe_educative_second_section_no_have_debit_card,
                R.string.fe_educative_second_section_recommended,
                R.string.fe_educative_second_section_can_take_72
            ),
            imageHeaderResource = R.drawable.img_card_with_check_cut
        )
    ),
    PAY_ON_TIME(
        section = 2,
        EducativeContent(
            title = R.string.fe_third_section_educative_question,
            message = R.string.fe_educative_third_section_message,
            greenText = listOf(R.string.fe_educative_third_section_pay_on_time),
            boldText = listOf(
                R.string.fe_educative_third_section_benefits,
                R.string.fe_educative_third_section_improve_you_credit,
                R.string.fe_educative_third_section_increase_your_credit,
                R.string.fe_educative_third_section_future_buys,
                R.string.fe_educative_third_section_its_benefits
            ),
            imageHeaderResource = R.drawable.img_lamp_no_light_one_color
        )
    ),
    PAYMENT_AMOUNTS(
        section = 3,
        EducativeContent(
            title = R.string.fe_fourth_section_educative_question,
            message = R.string.fe_educative_fourth_section_message,
            greenText = listOf(
                R.string.fe_educative_fourth_section_minimum_payment,
                R.string.fe_educative_fourth_section_no_interest_payment,
                R.string.fe_educative_fourth_section_total_debt
            ),
            boldText = listOf(
                R.string.fe_educative_fourth_section_3_ways_to_pay_your_card,
                R.string.fe_educative_fourth_section_minimum_value_to_pay,
                R.string.fe_educative_fourth_section_pay_complete_debt,
                R.string.fe_educative_fourth_section_total_debt_included
            ),
            imageHeaderResource = R.drawable.img_book_with_eyes_cut,
            rotateImage = 10F
        )
    );

    companion object {
        private val educativeMap = values().associateBy(EducativeContentType::section)
        fun getEducativeContentBySection(section: Int): EducativeContent =
            educativeMap[section]?.educativeContent ?: DIFFERENCE_DUE_AND_CUT_DATE.educativeContent
    }
}