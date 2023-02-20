package com.alexm.financialeducation.data.dto

import com.alexm.financialeducation.R

enum class QuizType(
    val section: Int,
    val quiz: Quiz
){
    LAST_DAY_TO_PAY_MINIMUM(
        section = 0,
        Quiz(
            title = R.string.fe_quiz_first_section_title,
            firstQuestion = R.string.fe_quiz_first_section_first_response,
            secondQuestion = R.string.fe_quiz_first_section_second_response,
            correctAnswer = R.string.fe_quiz_first_section_second_response,
            imageHeaderResource = R.drawable.img_book_smilling_scissors
        )
    ),
    WHICH_PAYMENT_REFLECTS_IN_MINUTES(
        section = 1,
        Quiz(
            title = R.string.fe_quiz_second_section_title,
            firstQuestion = R.string.fe_quiz_second_section_first_response,
            secondQuestion = R.string.fe_quiz_second_section_second_response,
            correctAnswer = R.string.fe_quiz_second_section_first_response,
            imageHeaderResource = R.drawable.img_book_two_faces
        )
    ),
    WHAT_HAPPEN_IF_NO_POT(
        section = 2,
        Quiz(
            title = R.string.fe_quiz_third_section_title,
            firstQuestion = R.string.fe_quiz_third_section_first_response,
            secondQuestion = R.string.fe_quiz_third_section_second_response,
            correctAnswer = R.string.fe_quiz_third_section_second_response,
            imageHeaderResource = R.drawable.img_two_books
        )
    ),
    WHAT_HAPPEN_IF_PAY_MINIMUM(
        section = 3,
        Quiz(
            title = R.string.fe_quiz_fourth_section_title,
            firstQuestion = R.string.fe_quiz_fourth_section_first_response,
            secondQuestion = R.string.fe_quiz_fourth_section_second_response,
            correctAnswer = R.string.fe_quiz_fourth_section_first_response,
            imageHeaderResource = R.drawable.img_total_min_payment
        )
    );

    companion object {
        private val quizQuestionMap = values().associateBy(QuizType::section)
        fun getQuizQuestionBySection(section: Int): Quiz =
            quizQuestionMap[section]?.quiz ?: LAST_DAY_TO_PAY_MINIMUM.quiz
    }
}