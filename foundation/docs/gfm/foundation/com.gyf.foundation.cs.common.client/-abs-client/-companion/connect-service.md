//[foundation](../../../../index.md)/[com.gyf.foundation.cs.common.client](../../index.md)/[AbsClient](../index.md)/[Companion](index.md)/[connectService](connect-service.md)

# connectService

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[C](connect-service.md) : [AbsClient](../index.md)&gt; [connectService](connect-service.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)

绑定服务

#### Parameters

androidJvm

| | |
|---|---|
| context | 上下文 |
| clientTag | 客户端标签 |
| action | 动作 |
| block | AbsClient.() -> Unit 代码块 |

[androidJvm]\
inline fun &lt;[C](connect-service.md) : [AbsClient](../index.md)&gt; [connectService](connect-service.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)

绑定服务

#### Parameters

androidJvm

| | |
|---|---|
| context | 上下文 |
| intent | Intent对象 |
| clientTag | 客户端标签 |
| block | AbsClient.() -> Unit 代码块 |