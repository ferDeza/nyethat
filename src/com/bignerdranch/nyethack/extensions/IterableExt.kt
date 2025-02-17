package com.bignerdranch.nyethack.extensions
fun <T> Iterable<T>.random(): T = this.shuffled().first()

fun String.toDragonSpeak():String{
    return this.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }
}

fun String.frame(padding: Int):String{
    val greeting="$this!"
    val formatChar = "*"
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
    .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}