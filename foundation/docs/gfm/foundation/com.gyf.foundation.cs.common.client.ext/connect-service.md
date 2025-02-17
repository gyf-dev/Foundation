//[foundation](../../index.md)/[com.gyf.foundation.cs.common.client.ext](index.md)/[connectService](connect-service.md)

# connectService

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[C](connect-service.md) : [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectService](connect-service.md)(action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)

绑定服务 Bind service

#### Return

C 返回绑定的服务     Return the bound service

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签     Client tag |
| action | 动作     Action |
| block | AbsClient.() -> Unit 代码块     Code block |

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[C](connect-service.md) : [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectService](connect-service.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)

绑定服务 Bind service

#### Return

C 返回绑定的服务     Return the bound service

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签     Client tag |
| intent | 意图     Intent |
| block | AbsClient.() -> Unit 代码块     Code block |