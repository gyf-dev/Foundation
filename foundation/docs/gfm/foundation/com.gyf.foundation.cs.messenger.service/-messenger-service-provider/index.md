//[foundation](../../../index.md)/[com.gyf.foundation.cs.messenger.service](../index.md)/[MessengerServiceProvider](index.md)

# MessengerServiceProvider

[androidJvm]\
class [MessengerServiceProvider](index.md)(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) : [AbsServiceProvider](../../com.gyf.foundation.cs.common.service/-abs-service-provider/index.md)

Messenger服务提供者类。

提供了一系列与Messenger通信的方法。

## Constructors

| | |
|---|---|
| [MessengerServiceProvider](-messenger-service-provider.md) | [androidJvm]<br>constructor(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) |

## Types

| Name | Summary |
|---|---|
| [ProviderHandler](-provider-handler/index.md) | [androidJvm]<br>inner class [ProviderHandler](-provider-handler/index.md) : [Handler](https://developer.android.com/reference/kotlin/android/os/Handler.html) |

## Properties

| Name | Summary |
|---|---|
| [binder](binder.md) | [androidJvm]<br>open override val [binder](binder.md): [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)<br>服务端Messenger的绑定对象。 |

## Functions

| Name | Summary |
|---|---|
| [responseMessage](response-message.md) | [androidJvm]<br>open override fun [responseMessage](response-message.md)(newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |