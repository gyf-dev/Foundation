//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IPost2](index.md)/[post](post.md)

# post

[androidJvm]\
abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |

[androidJvm]\
abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段和clientTag

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |

[androidJvm]\
abstract fun [post](post.md)(bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Parameters

androidJvm

| | |
|---|---|
| bundle | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段和数据

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |
| bundle | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段、clientTag和数据

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |
| bundle | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;, result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Parameters

androidJvm

| | |
|---|---|
| pair | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;, result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字段和数据

#### Parameters

androidJvm

| | |
|---|---|
| what | 指定的what字段 |
| pair | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;, result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其what字��、clientTag和数据

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| what | 指定的what字段 |
| pair | 指定的数据 |

[androidJvm]\
abstract fun [post](post.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Parameters

androidJvm

| | |
|---|---|
| message | Message 旧的Message对象 |

[androidJvm]\
abstract fun [post](post.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html), result: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

对于客户端异步获取服务端消息，消息将通过onResponse接口返回 对于服务端，消息通过response发送给客户端，指定其数据

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | String 客户端标签 |
| message | Message 旧的Message对象 |