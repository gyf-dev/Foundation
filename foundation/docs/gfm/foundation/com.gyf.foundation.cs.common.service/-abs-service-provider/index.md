//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service](../index.md)/[AbsServiceProvider](index.md)

# AbsServiceProvider

abstract class [AbsServiceProvider](index.md)(serviceCallback: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) : [IServiceProvider](../../com.gyf.foundation.cs.common.service.face/-i-service-provider/index.md), [IMessage](../../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IServicePost](../../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md), [IServiceGet](../../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AbsAidlServiceProvider](../../com.gyf.foundation.cs.aidl.service/-abs-aidl-service-provider/index.md) |
| [MessengerServiceProvider](../../com.gyf.foundation.cs.messenger.service/-messenger-service-provider/index.md) |

## Constructors

| | |
|---|---|
| [AbsServiceProvider](-abs-service-provider.md) | [androidJvm]<br>constructor(serviceCallback: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [response](response.md) | [androidJvm]<br>override fun [response](response.md)(newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>给所有客户端发消息<br>[androidJvm]<br>override fun [response](response.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>响应，回调给客户端的消息请调用 |
| [responseMessage](response-message.md) | [androidJvm]<br>abstract fun [responseMessage](response-message.md)(newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |