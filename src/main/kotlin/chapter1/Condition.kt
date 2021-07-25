package chapter1

fun main() {
    val age = 4;
    if (age in 0..3) {
        println("right")
    } else {
        println("wrong")
    }

    if (age !in 0..3) {
        println("wrong again")
    }

    val result = when (age) {
        0 -> "right"
        in 1..2 -> "right"
        else -> "wrong"
    }
    println(result)
}