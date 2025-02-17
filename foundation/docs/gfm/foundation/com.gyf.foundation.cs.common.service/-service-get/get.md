//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service](../index.md)/[ServiceGet](index.md)/[get](get.md)

# get

[androidJvm]\
open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字段

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |

[androidJvm]\
open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字段和clientTag

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |

[androidJvm]\
open override fun [get](get.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| bundle | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字段和数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |
| bundle | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字段、clientTag和数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |
| bundle | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| pair | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字段和数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |
| pair | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其what字��、clientTag和数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |
| pair | 指定的数据 |

[androidJvm]\
open override fun [get](get.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| message | Message 旧的Message对象 |

[androidJvm]\
open override fun [get](get.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

获取服务端的消息，指定其数据

#### Return

Message 服务端的消息

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | String 客户端标签 |
| message | Message 旧的Message对象 |