package com.example.buslive.util

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


val c = Calendar.getInstance()
val getDay = c.get(Calendar.DAY_OF_MONTH)
val getMonth = c.get(Calendar.MONTH)
val getYear = c.get(Calendar.YEAR)

fun String.toTime(): String {
    val date = SimpleDateFormat("yyyy-MM-dd h:mma", Locale.ENGLISH).parse(this)
    return SimpleDateFormat("h:mma", Locale.ENGLISH).format(date.time)
}

fun String.toDate(): String {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(this)
    return SimpleDateFormat("EEE, dd MMMM", Locale.ENGLISH).format(date.time)
}

fun Double.toCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "GH"))
    return format.format(this)
}
