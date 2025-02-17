//[foundation](../../index.md)/[com.gyf.foundation.cs.common.client.ext](index.md)/[connectServiceByClass](connect-service-by-class.md)

# connectServiceByClass

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[C](connect-service-by-class.md) : [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md), [S](connect-service-by-class.md) : [AbsService](../com.gyf.foundation.cs.common.service/-abs-service/index.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectServiceByClass](connect-service-by-class.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service-by-class.md)

绑定服务 Bind service

#### Return

C 返回绑定的服务     Return the bound service

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签     Client tag |
| block | AbsClient.() -> Unit 代码块     Code block |