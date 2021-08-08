package chapter3

fun main() {
    // 不可变 set
    val set = setOf("Jackson", "Jack", "Tom", "Jack")
    println(set)
    val mutableSet = mutableSetOf("Jackson", "Jack", "Tom", "Jack")
    mutableSet += "Jane"
    println(mutableSet)

    val list = listOf("Jackson", "Jack", "Tom", "Jack")
    // list 转 set
    val listToSet = list.toSet()
    println(listToSet)
    // 去重 list 的快捷函数
    val distinctList = list.distinct()
    println(distinctList)

}