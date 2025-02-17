//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service](../index.md)/[ServicePost](index.md)/[replyPost](reply-post.md)

# replyPost

[androidJvm]\
open override fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Receiver

clientMessage Message 旧的Message对象

#### Parameters

androidJvm

| | |
|---|---|
| bundle | 指定的数据 |

[androidJvm]\
open override fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Receiver

clientMessage Message 旧的Message对象

#### Parameters

androidJvm

| | |
|---|---|
| pair | 指定的数据 |

[androidJvm]\
open override fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Receiver

clientMessage Message 旧的Message对象

#### Parameters

androidJvm

| | |
|---|---|
| message | Message 旧的Message对象 |