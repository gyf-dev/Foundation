//[foundation](../../../../index.md)/[com.gyf.foundation.cs.common.client](../../index.md)/[AbsClient](../index.md)/[Companion](index.md)

# Companion

[androidJvm]\
object [Companion](index.md)

## Properties

| Name | Summary |
|---|---|
| [clients](clients.md) | [androidJvm]<br>val [clients](clients.md): [ConcurrentHashMap](https://developer.android.com/reference/kotlin/java/util/concurrent/ConcurrentHashMap.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [AbsClient](../index.md)&gt; |
| [connectedClients](connected-clients.md) | [androidJvm]<br>val [connectedClients](connected-clients.md): [ConcurrentHashMap](https://developer.android.com/reference/kotlin/java/util/concurrent/ConcurrentHashMap.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [AbsClient](../index.md)&gt;<br>已经绑定的所有集合 |

## Functions

| Name | Summary |
|---|---|
| [connectService](connect-service.md) | [androidJvm]<br>inline fun &lt;[C](connect-service.md) : [AbsClient](../index.md)&gt; [connectService](connect-service.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)<br>@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>inline fun &lt;[C](connect-service.md) : [AbsClient](../index.md)&gt; [connectService](connect-service.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = C::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [C](connect-service.md)<br>绑定服务 |