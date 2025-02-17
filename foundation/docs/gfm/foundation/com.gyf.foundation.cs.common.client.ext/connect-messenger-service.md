//[foundation](../../index.md)/[com.gyf.foundation.cs.common.client.ext](index.md)/[connectMessengerService](connect-messenger-service.md)

# connectMessengerService

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[S](connect-messenger-service.md) : [MessengerService](../com.gyf.foundation.cs.messenger.service/-messenger-service/index.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectMessengerService](connect-messenger-service.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [MessengerClient](../com.gyf.foundation.cs.messenger.client/-messenger-client/index.md)

绑定Messenger服务 Bind Messenger service

#### Return

MessengerClient 返回绑定的Messenger服务     Return the bound Messenger service

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签     Client tag |
| block | AbsClient.() -> Unit 代码块     Code block |