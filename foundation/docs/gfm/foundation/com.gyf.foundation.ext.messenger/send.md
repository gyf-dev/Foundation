//[foundation](../../index.md)/[com.gyf.foundation.ext.messenger](index.md)/[send](send.md)

# send

[androidJvm]\
fun [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?.[send](send.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;)

向Messenger发送包含特定操作和数据对的消息。 Send a message to Messenger containing a specific action and data pair.

#### Parameters

androidJvm

| | |
|---|---|
| what | 消息的操作码。     The operation code of the message. |
| pair | 包含键值对的数据。     The data containing a key-value pair. |

[androidJvm]\
fun [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?.[send](send.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)? = null)

向Messenger发送包含特定操作和可选Bundle数据的消息。 Send a message to Messenger containing a specific action and an optional Bundle of data.

#### Parameters

androidJvm

| | |
|---|---|
| what | 消息的操作码。     The operation code of the message. |
| bundle | 包含数据的Bundle，可为空。     The Bundle containing data, can be null. |