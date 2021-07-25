package chapter2

fun main() {
    // 除非另有规定，变量不可为 null
    // 这里会报错
    // var str : String = null
    // 加个 ? 表示可空
    var str: String? = null
    // 因为可能为空，所以会报错
    // str.capitalize()
    // 加 ? 表示安全调用 这里不会报错，并输出为 null，
    println(str?.capitalize())

    // 使用 let 可以在指定的作用域内定义一个或多个变量，
    // 在这里通过对输入的内容判空来做为例子
//    val str1 = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "is Null"
//        }
//    }
//    println(str1)

    // !! 是非空断言操作符，但变量值为 null 时，会抛出 NullPointerException
//    var str2: String? = null
//    println(str2!!.capitalize())

    // ?: 是空合并操作符，如果左边的求值结果为 null，就使用右边的值
    var str3: String = str ?: "new Value"
    println(str3)
    // 可以和 let 一起使用
    var str4: String = str?.let { it.capitalize() } ?: "new Value2"
    println(str4)

    // 先决条件函数，kotlin 内置的函数，符合就返回值，否则会抛出异常，也可以自定义异常信息
    checkNotNull(str) { "str is Null" }
//    requireNotNull(str)

    // 数字类型的安全转换函数
    val number: Int? = "8.00".toIntOrNull()

}