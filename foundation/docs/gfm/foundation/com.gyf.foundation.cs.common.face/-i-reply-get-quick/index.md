//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IReplyGetQuick](index.md)

# IReplyGetQuick

interface [IReplyGetQuick](index.md)

快速回复获取接口，提供多个重载方法以支持不同的数据类型和数量的快速回复。 Quick reply fetch interface, providing multiple overloaded methods to support quick replies with different data types and quantities.

#### Inheritors

| |
|---|
| [IServiceGet](../../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md) |

## Functions

| Name | Summary |
|---|---|
| [replyGetQuick](reply-get-quick.md) | [androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGetQuick](reply-get-quick.md)(data: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>快速回复消息，携带单个数据。 Quickly reply to a message, carrying a single piece of data.<br>[androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGetQuick](reply-get-quick.md)(data: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data2: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>快速回复消息，���带两个数据。 Quickly reply to a message, carrying two pieces of data.<br>[androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGetQuick](reply-get-quick.md)(data: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data2: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data3: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>快速回复消息，携带三个数据。 Quickly reply to a message, carrying three pieces of data.<br>[androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGetQuick](reply-get-quick.md)(data: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data2: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data3: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data4: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>快速回复消息，携带四个数据。 Quickly reply to a message, carrying four pieces of data.<br>[androidJvm]<br>abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyGetQuick](reply-get-quick.md)(data: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data2: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data3: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data4: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, data5: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>快速回复消息，携带五个数据。 Quickly reply to a message, carrying five pieces of data. |