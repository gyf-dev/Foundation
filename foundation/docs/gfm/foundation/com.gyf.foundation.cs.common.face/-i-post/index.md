//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IPost](index.md)

# IPost

interface [IPost](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IClientPost](../../com.gyf.foundation.cs.common.client.face/-i-client-post/index.md) |
| [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md) |
| [IServicePost](../../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md) |
| [IServiceProvider](../../com.gyf.foundation.cs.common.service.face/-i-service-provider/index.md) |

## Functions

| Name | Summary |
|---|---|
| [post](post.md) | [androidJvm]<br>abstract fun [post](post.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))<br>abstract fun [post](post.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>abstract fun [post](post.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)<br>abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据<br>[androidJvm]<br>abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段<br>[androidJvm]<br>abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))<br>abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段和数据<br>[androidJvm]<br>abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段和clientTag<br>[androidJvm]<br>abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段、clientTag和数据<br>[androidJvm]<br>abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)<br>对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字��、clientTag和数据 |