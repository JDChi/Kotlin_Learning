package chapter1

fun main() {
    val c0 = intArrayOf(1, 2, 3)
    // 创建指定长度的数组
    val c1 = IntArray(5) { it + 1 }

    println(c0.contentToString())
    println(c1.contentToString())
}