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
                "Tu fecha de corte",
                "Tu fecha límite de pago"
            ),
            boldText = listOf(
                "es el día que cerramos todas las compras que hiciste durante los 30 " +
                        "días anteriores.",
                "es el último día para realizar el pago de tu Stori."
            ),
            imageHeaderResource = R.drawable.img_book_walking_cut
        )
    ),
    PAYMENT_METHODS(
        section = 1,
        EducativeContent(
            title = R.string.fe_second_section_educative_question,
            message = R.string.fe_educative_second_section_message,
            greenText = listOf(
                "1. SPEI/transferencia a cuenta CLABE interbancaria:",
                "2. Transferencia bancaria:",
                "3. OXXO Pay:",
                "4. Pago en ventanilla:"
            ),
            boldText = listOf(
                "A través de tarjeta de débito:",
                "¡Te la recomendamos!",
                "El pago puede tardar hasta 72 horas en reflejarse.",
                "Si no tienes tarjeta de débito o prefieres hacerlo de forma presencial no te " +
                        "preocupes, puedes hacer el pago por los siguientes medios:",
                "¡Te la recomendamos!",
                "puede tomar hasta 72 horas"
            ),
            imageHeaderResource = R.drawable.img_book_test_your_knowledge_cut
        )
    ),
    PAY_ON_TIME(
        section = 2,
        EducativeContent(
            title = R.string.fe_third_section_educative_question,
            message = R.string.fe_educative_third_section_message,
            greenText = listOf(
                "Pagar a tiempo tu Stori implica hacer el pago en tu fecha límite de pago o antes."
            ),
            boldText = listOf(
                "Recuerda que los beneficios de pagar tu Stori a tiempo son los siguientes:",
                "mejoras tu historial crediticio",
                "aumentar tu límite",
                "futuras compras",
                "sus beneficios"
            ),
            imageHeaderResource = R.drawable.img_bulb_no_light_one_color
        )
    ),
    PAYMENT_AMOUNTS(
        section = 3,
        EducativeContent(
            title = R.string.fe_fourth_section_educative_question,
            message = R.string.fe_educative_fourth_section_message,
            greenText = listOf(
                "Pago mínimo:",
                "Pago para no generar intereses:",
                "Pago de saldo total:"
            ),
            boldText = listOf(
                "Existen 3 formas de pago disponibles para pagar tu Stori:",
                "valor mínimo que debes pagar para no tener impactos en tu historial crediticio.",
                "incluye el pago de todas las compras realizadas",
                "incluye tu deuda total,"
            ),
            imageHeaderResource = R.drawable.img_book_abc_no_light
        )
    );

    companion object {
        private val educativeMap = values().associateBy(EducativeContentType::section)
        fun getEducativeContentBySection(section: Int): EducativeContent =
            educativeMap[section]?.educativeContent ?: DIFFERENCE_DUE_AND_CUT_DATE.educativeContent
    }
}