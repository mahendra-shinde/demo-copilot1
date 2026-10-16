package com.example.expenses.ui

/** Parses user-entered amount text; returns null unless it is a positive number. */
fun parseAmount(text: String): Double? =
    text.trim().toDoubleOrNull()?.takeIf { it > 0 && it.isFinite() }
