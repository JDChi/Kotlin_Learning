package chapter3

fun main() {
    // to 函数将它左边和右边的值转换成一对 Pair
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    val map = mapOf("Jack" to 20, "Jackson" to 30, "Jacky" to 40)
    println(map)

    val map1 = mapOf(Pair("Jack", 20), Pair("Jackson", 30))
    println(map1)

    println(map["Jack"])
    println(map.getValue("Jack"))
    println(map.getOrElse("Jimmy") { "Unknown" })
    println(map.getOrDefault("Jimmy", 1))

    map.forEach { (t, u) -> println("key = $t value = $u") }
    map.forEach { println("key = ${it.key} value = ${it.value}") }

    val mutableMap = mutableMapOf("Jack" to 20, "Jackson" to 30, "Jacky" to 40)
    mutableMap.remove("Jack")
    mutableMap += "Jane" to 20
    // 获取不到，就加进去
    mutableMap.getOrPut("Tim") { 50 }
    println(mutableMap)


}