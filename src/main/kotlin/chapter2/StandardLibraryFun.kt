package chapter2

import java.io.File

fun main() {

    // apply 函数可看做一个配置函数，传入一个接收者，然后调用一系列函数来配置它以便使用
    val file = File("e.txt").apply {
        setExecutable(false)
        setWritable(true)
        setReadable(true)
    }

    // let 函数能使某个变量作用于其 lambda 表达式里，让 it 关键字能引用它。
    // 与 apply 相比，let 会把接收者传给 lambda，apply 什么都不传
    // 匿名函数执行完，apply 会返回当前接收者，let 会返回 lambda 的最后一行

    val result = listOf(3, 2, 1).first().let {
        it * it
    }
    println(result)
    // 不用 let 函数的话，就是传统的写法
    val first = listOf(1, 2, 3).first()
    val result1 = first * first

    // 与 apply 相比，run 函数不返回接收者，run 返回的是 lambda 结果
    val isContained = File("test.txt").run {
        readText().contains('a')
    }
    println(isContained)
    // run 也能用来执行函数引用，尤其是在链式调用下，上一次的输出是下一个的输入
    val hello = "hello hello hello"
    hello.run(::isLong).run(::showMessage).run(::print)

    // with 函数是 run 的变体，它们的功能行为是一样的，但调用 with 时需要值参作为其第一个参数传入
    val result2 = hello.run {
        length >= 10
    }
    val result3 = with(hello) {
        length >= 10
    }

    // also 与 let 类似，也是把接收者作为值参传给 lambda，
    // 但 also 返回接收者对象，let 返回 lambda 结果
    // 因此 also 适合针对同一原始对象，利用副作用做事
    // 可以基于原始接收者对象执行额外的链式调用
    var fileContents: List<String>
    File("test.txt")
        .also { println(it.name) }
        .also { fileContents = it.readLines() }
    println(fileContents)

    // takeIf 需要判断 lambda 中提供的条件表达式，给出 true 或 false 结果，
    // 如果结果为 true，返回接收者对象
    // 如果为 false，返回 null
    val content = File("test.txt").takeIf {
        it.exists() && it.canRead()
    }?.readText()
    println(content)

    // takeIf 辅助函数 takeUnless，只有判定给定的条件为 false，takeUnless 才会返回原始接收者对象
    // 与 takeIf 相反，用的会比较少
    val content1 = File("test.txt").takeUnless {
        it.isHidden
    }?.readText()
    println(content1)

}

fun isLong(name: String) = name.length > 5
fun showMessage(isLong: Boolean): String {
    return if (isLong) {
        "too long"
    } else {
        "rename it"
    }
}