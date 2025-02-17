//[foundation](../../../index.md)/[com.gyf.foundation.cs.aidl.service](../index.md)/[AbsAidlServiceProvider](index.md)

# AbsAidlServiceProvider

abstract class [AbsAidlServiceProvider](index.md)&lt;[C](index.md) : [IInterface](https://developer.android.com/reference/kotlin/android/os/IInterface.html)&gt;(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) : [AbsServiceProvider](../../com.gyf.foundation.cs.common.service/-abs-service-provider/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AidlServiceProvider](../-aidl-service-provider/index.md) |

## Constructors

| | |
|---|---|
| [AbsAidlServiceProvider](-abs-aidl-service-provider.md) | [androidJvm]<br>constructor(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [responseMessage](response-message.md) | [androidJvm]<br>open override fun [responseMessage](response-message.md)(newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |
| [responseOn](response-on.md) | [androidJvm]<br>abstract fun [responseOn](response-on.md)(item: [C](index.md), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |