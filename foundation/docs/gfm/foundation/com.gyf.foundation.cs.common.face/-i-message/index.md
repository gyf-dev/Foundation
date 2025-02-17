//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IMessage](index.md)

# IMessage

interface [IMessage](index.md)

IMessage接口，定义了一系列与消息相关的方法

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [CsMessage](../../com.gyf.foundation.cs.common/-cs-message/index.md) |
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |
| [AbsClientProvider](../../com.gyf.foundation.cs.common.client/-abs-client-provider/index.md) |
| [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md) |
| [AbsService](../../com.gyf.foundation.cs.common.service/-abs-service/index.md) |
| [AbsServiceProvider](../../com.gyf.foundation.cs.common.service/-abs-service-provider/index.md) |
| [IServiceProvider](../../com.gyf.foundation.cs.common.service.face/-i-service-provider/index.md) |

## Properties

| Name | Summary |
|---|---|
| [_clientTag](_client-tag.md) | [androidJvm]<br>abstract var [_clientTag](_client-tag.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>消息标签 |

## Functions

| Name | Summary |
|---|---|
| [getClientTag](get-client-tag.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[getClientTag](get-client-tag.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>获取Message的clientTag |
| [getCookie](get-cookie.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[getCookie](get-cookie.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>获取Message的cookies |
| [hasClientTag](has-client-tag.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[hasClientTag](has-client-tag.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否有ClientTag字段 |
| [hasCookie](has-cookie.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[hasCookie](has-cookie.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否有cookies字段 |
| [isSame](is-same.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[isSame](is-same.md)(otherMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否是同一条请求 |
| [obtainMessage](obtain-message.md) | [androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>abstract fun [obtainMessage](obtain-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>abstract fun [obtainMessage](obtain-message.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>abstract fun [obtainMessage](obtain-message.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其数据<br>[androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其what字段<br>[androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>abstract fun [obtainMessage](obtain-message.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其what字段和数据<br>[androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其what字段和clientTag<br>[androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其what字段、clientTag和数据<br>[androidJvm]<br>abstract fun [obtainMessage](obtain-message.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>创建一个新的Message对象，指定其what字��、clientTag和数据 |
| [putClientTagIf](put-client-tag-if.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[putClientTagIf](put-client-tag-if.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>设置Message的clientTag |
| [putCookieIf](put-cookie-if.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[putCookieIf](put-cookie-if.md)(): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>设置Message的cookies |
| [replyTo](reply-to.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(oldMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>将新的Message携带旧的Message部分信息发送给客户端<br>[androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(messenger: [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)<br>设置Message的回复Messenger |