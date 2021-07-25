package chapter1

/**
 * kotlin 只提供引用类型这一种数据类型，出于更高性能的需要，Kotlin 编译器会在 Java 字节码中改用基本数据类型
 */
fun main(args: Array<String>) {
    var a: Int = 2
    var a1 = 2
    val b: String = "Hello World"
    val b1 = "Hello World1"
    val b2 = b
    val b3 = b

    // 比较值
    println(b == b1)
    // 比较引用 这里 b2 和 b3 都是同一个引用 b，即是否为同一个对象
    println(b3 === b2)

    // 易混淆的 Long 类型标记
    // val d = 1234l 会报错
    val d = 1234L

    // 数值类型转换
    // val f : Long = e 会报错
    val e: Int = 10
    val f: Long = e.toLong()

    println("e is $e")
}