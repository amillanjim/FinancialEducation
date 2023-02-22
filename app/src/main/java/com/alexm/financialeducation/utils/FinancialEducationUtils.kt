package com.alexm.financialeducation.utils

fun convertQuartersToPercentage(completedSections: Int) =
    when {
        completedSections < 0 -> 0f
        completedSections == 0 -> 0f
        completedSections == 1 -> 25f
        completedSections == 2 -> 50f
        completedSections == 3 -> 75f
        else -> 100f
    }