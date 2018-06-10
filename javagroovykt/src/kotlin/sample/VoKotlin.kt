package sample

// Custom getter/setter for properties created by type params - Kotlin Discussions https://discuss.kotlinlang.org/t/custom-getter-setter-for-properties-created-by-type-params/46
class VoKotlin(name: String, age: Int) {
    var name: String = name
      get() = field + "くん"
    var age: Int = age
}
