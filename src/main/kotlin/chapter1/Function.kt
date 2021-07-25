package chapter1

/**
 * kotlin 中没有返回值的函数叫 Unit 函数
 */
fun main() {
    println(doSomething())
    println(doSomething(1))

    val count = "MissMiss".count { letter -> letter == 's' }
    println(count)

    // 变量的类型是一个匿名函数，返回值是 String
    // 匿名函数不需要 return 关键字来返回数据，会隐式或自动返回函数体最后一行语句的结果
    val myFunction: () -> String = {
        "China"
    }
    // 由于类型推断，也可以把返回类型省略掉
    val myFunction1 = {
        "China"
    }
    println(myFunction())
    println(myFunction1())

    // 定义一个参数的匿名函数，此时 it 关键字可以起作用，如果多个参数的话则不能用
    val myFunction2: (String) -> String = {
        it
    }
    // 多个参数的匿名函数
    val myFunction3: (String, Int) -> String = { name, number ->
        name + number
    }

    // 也可以在匿名函数里写参数名和类型
    val myFunction4 = { name: String, number: Int ->
        name + number
    }

    // 把函数作为参数传入
    funParamsWithFun(myFunction4)

    // 由于这个函数的唯一参数是匿名函数，或是这个函数的最后一个参数是匿名函数，那就可以有更省略的写法
    funParamsWithFun { name: String, number: Int ->
        name + number
    }

    // 函数引用 除了使用 Lambda，也可以使用 :: 符号来引用一个函数
    funParamsWithFun(::funReference)

    // 调用返回值是函数的函数
    val returnFun = funReturnFun()
    println(returnFun("Hello", 20))


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

/**
 *  定义参数是函数的函数
 */
fun funParamsWithFun(paramFun: (String, Int) -> String) {
    // 处理匿名函数参数
    println(paramFun("Hello", 10))
}

fun funReference(name: String, number: Int): String {
    return name + number + "Reference"
}

/**
 * 创建内联函数
 *
 * JVM 会为所有同 Lambda 打交道的变量分配内存，就产生了内存开销
 * 使用内联的话，JVM 会把使用 Lambda 的地方将函数体直接复制粘贴到那里
 * 可以通过对 kotlin Decompile 来看区别
 *
 * 使用 Lambda 的递归函数无法内联，会导致复制粘贴无限循环，编译发出警告
 */
inline fun funParamsWithFun1(paramFun: (String, Int) -> String) {

}

/**
 * 返回值是函数的参数
 *
 * 这里面也有涉及到闭包函数的概念
 * 匿名函数能修改并引用定义在自己的作用域之外的变量
 * 匿名函数引用着定义自身的函数的变量
 *
 * kotlin 可以作为脚本语言，就没有严格的作用域的概念，因此需要闭包这种东西，避免重名的问题
 */
fun funReturnFun(): (String, Int) -> String {
    val returnFun = "returnFun"
    return { name: String, number: Int ->
        name + number + returnFun
    }
}