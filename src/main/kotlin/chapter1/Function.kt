package chapter1

/**
 * kotlin 中没有返回值的函数叫 Unit 函数
 */
fun main() {
    println(doSomething())
    println(doSomething(1))

    val count = "MissMiss".count { letter -> letter == 's' }
    println(count)

    // 变量的类型是一个匿名函数
    // 匿名函数不需要 return 关键字来返回数据，会隐式或自动返回函数体最后一行语句的结果
    val myFunction: () -> String = {
        "China"
    }
    println(myFunction())



}

private fun doSomething(age: Int = 4): String {
    return "$age"
}

/**
 * 可以使用反引号来创建一个特殊命名的函数
 *
 * 另外在 kotlin 和 Java 互操作的时候，Java 里的方法名在 kotlin 是特殊命名，此时就可以用反引号来避免冲突
 * MyJava.`is`();
 */
fun `**hello**`() {

}