//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IReplyPost](index.md)

# IReplyPost

interface [IReplyPost](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IServicePost](../../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md) |

## Functions

| Name | Summary |
|---|---|
| [replyPost](reply-post.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyPost](reply-post.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据 |