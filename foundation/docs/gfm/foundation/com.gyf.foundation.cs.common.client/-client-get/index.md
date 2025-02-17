//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client](../index.md)/[ClientGet](index.md)

# ClientGet

[androidJvm]\
class [ClientGet](index.md) : [IClientGet](../../com.gyf.foundation.cs.common.client.face/-i-client-get/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [ClientGet](-client-get.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [_getClientProvider](_get-client-provider.md) | [androidJvm]<br>open override var [_getClientProvider](_get-client-provider.md): [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md)?<br>设置ClientProvider |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>open override fun [get](get.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>open override fun [get](get.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>open override fun [get](get.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其数据<br>[androidJvm]<br>open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段<br>[androidJvm]<br>open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段和数据<br>[androidJvm]<br>open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段和clientTag<br>[androidJvm]<br>open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段、clientTag和数据<br>[androidJvm]<br>open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字��、clientTag和数据 |