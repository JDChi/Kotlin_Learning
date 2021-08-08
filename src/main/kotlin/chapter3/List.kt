package chapter3

fun main() {
    // 不可变列表，不支持 add remove 等操作
    val list = listOf("Jackson", "Jack", "Jacky")
    // 抛出异常
//    println(list[3])
    println(list.getOrElse(3) { "Unknown" })
    println(list.getOrNull(3) ?: "Unknown")

    // 支持内容修改的列表叫可变列表
    val mutableList = mutableListOf("Jackson", "Jack", "Jacky")
    mutableList.add("Jimmy")
    mutableList.remove("Jack")
    // 不可变转成可变，返回新的列表
    val newMutableList = list.toMutableList()
    // 可变转成不可变，返回新的列表
    val newList = mutableList.toList()

    // 能修改可变列表的函数有一个统一的名字：mutator 函数
    // 添加元素运算符与删除元素运算符
    // 基于 lambda 表达式指定的条件删除元素

    // 跟 add 的效果一样
    mutableList += "Jane"
    mutableList -= "Jackson"
    println(mutableList)

    mutableList.removeIf { it.contains("i") }
    println(mutableList)

    mutableList.forEach { println(it) }
    mutableList.forEachIndexed { index, s ->
        if (index % 2 == 0) {
            println(s)
        }

    }

    // 解构，通过 _ 符号过滤不想要的元素
    // 从 decompile 字节码上来看，这里只会获取 list 的第一个元素给 first 变量，而 _ 没有相关代码。
    //   boolean var27 = false;
    //   String first = (String)list.get(0);
    //   $i$f$forEachIndexed = false;
    //   System.out.println(first);
    val (first, _) = list
    println(first)

}