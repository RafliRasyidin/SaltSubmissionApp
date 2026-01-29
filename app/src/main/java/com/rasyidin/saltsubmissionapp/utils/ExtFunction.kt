package com.rasyidin.saltsubmissionapp.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Double.toRupiah(): String {
    val symbols = DecimalFormatSymbols(Locale("in", "ID")).apply {
        groupingSeparator = '.'
    }
    val formatter = DecimalFormat("#,###", symbols)
    return formatter.format(this)
}