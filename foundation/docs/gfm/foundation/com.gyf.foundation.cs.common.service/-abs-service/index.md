//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service](../index.md)/[AbsService](index.md)

# AbsService

abstract class [AbsService](index.md) : [LifecycleService](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleService.html), [ServiceProviderOwner](../../com.gyf.foundation.cs.common.service.face/-service-provider-owner/index.md), [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md), [IServiceResponse](../../com.gyf.foundation.cs.common.service.face/-i-service-response/index.md), [IMessage](../../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IServicePost](../../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md), [IServiceGet](../../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md), [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)

AidlService类，继承自LifecycleService，实现了ICoroutine和IService接口

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AidlService](../../com.gyf.foundation.cs.aidl.service/-aidl-service/index.md) |
| [MessengerService](../../com.gyf.foundation.cs.messenger.service/-messenger-service/index.md) |

## Constructors

| | |
|---|---|
| [AbsService](-abs-service.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [onBind](on-bind.md) | [androidJvm]<br>override fun [onBind](on-bind.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)<br>onBind方法，绑定服务时调用 |
| [onBound](on-bound.md) | [androidJvm]<br>open override fun [onBound](on-bound.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当客户端绑定成功时调用 |
| [onCreate](on-create.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onCreate](on-create.md)()<br>onCreate方法，当创建时调用 |
| [onEnqueue](on-enqueue.md) | [androidJvm]<br>open override fun [onEnqueue](on-enqueue.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>异步方法，用于处理客户端的请求，服务端处理完成后选择是否调用response方法，把消息返回给客户端 |
| [onExecute](on-execute.md) | [androidJvm]<br>open override fun [onExecute](on-execute.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>用于处理客户端调用execute方法后，服务端收到的请求回调 |
| [onUnbound](on-unbound.md) | [androidJvm]<br>open override fun [onUnbound](on-unbound.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当客户端解绑成功时调用 |
| [response](response.md) | [androidJvm]<br>open override fun [response](response.md)(newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>给所有客户端发消息<br>[androidJvm]<br>open override fun [response](response.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>给客户端发消息 |