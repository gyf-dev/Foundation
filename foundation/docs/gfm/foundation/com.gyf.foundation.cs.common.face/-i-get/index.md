//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IGet](index.md)

# IGet

interface [IGet](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IClientGet](../../com.gyf.foundation.cs.common.client.face/-i-client-get/index.md) |
| [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md) |
| [IServiceGet](../../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>abstract fun [get](get.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [get](get.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [get](get.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其数据<br>[androidJvm]<br>abstract fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段<br>[androidJvm]<br>abstract fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>abstract fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段和数据<br>[androidJvm]<br>abstract fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段和clientTag<br>[androidJvm]<br>abstract fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字段、clientTag和数据<br>[androidJvm]<br>abstract fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>获取服务端的消息，指定其what字��、clientTag和数据 |