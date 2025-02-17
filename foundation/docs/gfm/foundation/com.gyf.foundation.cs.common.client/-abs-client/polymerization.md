//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client](../index.md)/[AbsClient](index.md)/[polymerization](polymerization.md)

# polymerization

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [polymerization](polymerization.md)(base: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, block: [AbsClient](index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [AbsClient](index.md)

聚合

#### Parameters

androidJvm

| | |
|---|---|
| base | Context 基础上下文 |
| flags | Int 绑定标志 |
| clientTag | String 客户端标签 |
| intent | Intent 意图 |
| block | AbsClient.() -> Unit 代码块 |