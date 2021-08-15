package chapter4

class Player7 {
    // blood 应该写在 init 的上面，这样才能正常使用，反编译的时候可以看出顺序
    val blood = 100

    init {
        val bloodBonus = blood.times(4)
    }

//    val blood = 100
}

class Player8 {
    val name: String

    // 由于编译器看到 name 属性在 init 里有赋值，所以没报错，但运行的话会抛出空指针，因为提前调用
    init {
        println(firstLetter())
        name = "Jack"
    }

    private fun firstLetter(): Char {
        return name[0]
    }
}

class Player9(_name: String) {
    // 这种也因未初始化而返回空，因此因把下面两局调换位置，在 kotlin 里有顺序讲究
    val playname: String = initPlayerName()
    val name: String = _name
    private fun initPlayerName(): String {
        return name
    }
}