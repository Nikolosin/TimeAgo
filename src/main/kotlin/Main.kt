package ru.netology

fun main() {
    val second = 10000
    println(agoToText(second))
}

fun agoToText(second: Int): String {
    val minutes = 60
    val hour = 60 * minutes
    val day = 24 * hour
    val result = when (second) {
        in 0..60 -> "был(а) только что"
        in 61..hour -> "был(а) ${minutesOrHour(second)} назад"
        in hour + 1..day -> "был(а) ${minutesOrHour(second)} назад"
        in day + 1..day * 2 -> "был(а) вчера"
        in day * 2..day * 3 -> "был(а) позовчера"
        else -> "был(а) давно"
    }
    return result
}

fun minutesOrHour(second: Int): String {
    val minute = second / 60
    val hour = second / 3600
    var result = "минуту"
    if (minute < 60) {
        when {
            minute % 10 in 2..4 -> result = ("$minute минуты")
            minute in 11..14 || minute % 10 in 5..9 || minute % 10 == 0 -> result = ("$minute минут")
        }
    } else when (hour) {
        1, 21 -> result = ("$hour час")
        2, 3, 4, 22, 23, 24 -> result = ("$hour часа")
        in 5..20 -> result = ("$hour часов")
    }
    return result
}