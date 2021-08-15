package chapter4

fun main() {
    // field
    // 针对定义的每一个属性，Kotlin 都会产生一个 field，一个 getter，一个 setter
    val player = Player()
    player.name = "Hello"
    println(player.name)
    println(player.randomValue)

    // 会输出错误
    var player4 = Player4(name = "Jane", age = -1)


}

class Player {
    // 只要定义该属性，就会默认生成 get set 方法，通过反编译可以看到
//    @NotNull
//    private String name = "Jack";
//
//    @NotNull
//    public final String getName() {
//        return this.name;
//    }
//
//    public final void setName(@NotNull String var1) {
//        Intrinsics.checkNotNullParameter(var1, "<set-?>");
//        this.name = var1;
//    }
    var name = "Jack"
        // 想自定义 get set 的话，就可以通过 field 来操作F
        get() = field.substring(3)
        set(value) {
            field = value.toUpperCase()
        }

    // 也可以定义与 field 无关的操作
    val randomValue
        get() = (1..6).shuffled().first()
}

/**
 * 定义一个主构造函数，使用临时变量为 Player1 的各个属性提供初始值，一般以下划线开头的名字命名
 */
class Player1(
    _name: String,
    _age: Int = 20 // 可以提供默认值
) {
    var name = _name
    var age = _age
}

/**
 * 主构造函数里直接定义属性
 */
class Player2(
    var name: String,
    var age: Int
)

/**
 * 次构造函数，依然会调用主构造函数
 */
class Player3(
    var name: String,
    var age: Int
) {
    constructor(name: String) : this(name, age = 10) {
        // 也可以写构造逻辑
    }
}

class Player4(
    var name: String,
    var age: Int
) {
    // 初始化块可以设置变量或值，以及执行有效性检查，会在构造类实例时运行
    init {
        require(age > 0) {
            "age must be positive"
        }
    }
}

/**
 * 反编译可以看到初始化的顺序
 *
 * public Student(@NotNull String _name, int age) {
 * Intrinsics.checkNotNullParameter(_name, "_name");
 * super();
 * this.name = _name;
 * this.score = 100;
 * String var3 = "initializing ...";
 * boolean var4 = false;
 * System.out.println(var3);
 * this.subject = "math";
 * }

 * public Student(@NotNull String _name) {
 * Intrinsics.checkNotNullParameter(_name, "_name");
 * this(_name, 10);
 * this.score = 20;
 * }
 *
 * 初始化顺序
 * 1. 主构造函数里声明的属性
 * 2. 类级别的属性赋值
 * 3. init 初始化块里的属性赋值和函数调用
 * 4. 次构造函数里的属性赋值和函数调用
 */

class Student(_name: String, age: Int) {
    var name = _name
    var score = 100
    val subject: String

    init {
        println("initializing ...")
        subject = "math"
    }

    constructor(_name: String) : this(_name, 10) {
        score = 20
    }
}

class Player5 {
    // 延迟初始化
    lateinit var equipment: String
    fun ready() {
        equipment = "knife"
    }

    fun battle() {
        // 因为引用函数，所以用 ::
        if (::equipment.isInitialized) println(equipment)
    }
}

/**
 * lazy 是惰性初始化，表示直到首次调用的时候才去初始化
 * 相比于上面的 lateinit，lazy 是先写好初始化的内容
 */
class Player6(_name: String) {
    var name = _name
    val config by lazy { loadConfig() }

    private fun loadConfig(): String {
        println("loading")
        return "config loaded"
    }
}
