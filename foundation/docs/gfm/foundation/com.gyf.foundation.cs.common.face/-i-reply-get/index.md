//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IReplyGet](index.md)

# IReplyGet

interface [IReplyGet](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IServiceGet](../../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md) |

## Functions

| Name | Summary |
|---|---|
| [replyGet](reply-get.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGet](reply-get.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGet](reply-get.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGet](reply-get.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据 |