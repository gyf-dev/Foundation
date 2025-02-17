//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client](../index.md)/[AbsClient](index.md)

# AbsClient

abstract class [AbsClient](index.md) : [ContextWrapper](https://developer.android.com/reference/kotlin/android/content/ContextWrapper.html), [ClientProviderOwner](../../com.gyf.foundation.cs.common.client.face/-client-provider-owner/index.md), [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md), [IClientRequest](../../com.gyf.foundation.cs.common.client.face/-i-client-request/index.md), [IClient](../../com.gyf.foundation.cs.common.client.face/-i-client/index.md), [IMessage](../../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IClientPost](../../com.gyf.foundation.cs.common.client.face/-i-client-post/index.md), [IClientGet](../../com.gyf.foundation.cs.common.client.face/-i-client-get/index.md), [IClientPostQuick](../../com.gyf.foundation.cs.common.client.face/-i-client-post-quick/index.md), [IClientGetQuick](../../com.gyf.foundation.cs.common.client.face/-i-client-get-quick/index.md), [IClientPost2](../../com.gyf.foundation.cs.common.client.face/-i-client-post2/index.md), [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)

Messenger绑定客户端类。 提供了一系列与Messenger通信的方法。

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AidlClient](../../com.gyf.foundation.cs.aidl.client/-aidl-client/index.md) |
| [MessengerClient](../../com.gyf.foundation.cs.messenger.client/-messenger-client/index.md) |

## Constructors

| | |
|---|---|
| [AbsClient](-abs-client.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [clientTag](client-tag.md) | [androidJvm]<br>var [clientTag](client-tag.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Client tag |
| [extra](extra.md) | [androidJvm]<br>var [extra](extra.md): [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?<br>额外数据 Extra |
| [isConnected](is-connected.md) | [androidJvm]<br>open override val [isConnected](is-connected.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否已连接服务 |
| [provider](provider.md) | [androidJvm]<br>open lateinit override var [provider](provider.md): [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md)<br>提供者 |

## Functions

| Name | Summary |
|---|---|
| [addClientCallback](add-client-callback.md) | [androidJvm]<br>fun [addClientCallback](add-client-callback.md)(callback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)): [AbsClient](index.md)<br>fun [addClientCallback](add-client-callback.md)(callback: [ClientCallback2](../../com.gyf.foundation.cs.common.client.callback/-client-callback2/index.md)): [AbsClient](index.md)<br>添加客户端回调 |
| [attachBaseContext](attach-base-context.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [attachBaseContext](attach-base-context.md)(base: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [connect](connect.md) | [androidJvm]<br>override fun [connect](connect.md)(flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>绑定服务 |
| [create](create.md) | [androidJvm]<br>override fun [create](create.md)()<br>创建 |
| [destroy](destroy.md) | [androidJvm]<br>override fun [destroy](destroy.md)()<br>销毁 |
| [disconnect](disconnect.md) | [androidJvm]<br>override fun [disconnect](disconnect.md)()<br>解绑服务 |
| [enqueue](enqueue.md) | [androidJvm]<br>open override fun [enqueue](enqueue.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>入队方法，用于处理客户端的请求，但不返回任何消息给客户端 Enqueue method, used to handle client requests, but does not return any messages to the client |
| [execute](execute.md) | [androidJvm]<br>open override fun [execute](execute.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>执行方法，用于处理客户端的请求，并返回处理后的消息���客户端 Execute method, used to handle client requests and return the processed message to the client |
| [init](init.md) | [androidJvm]<br>fun [init](init.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.name): [AbsClient](index.md)<br>初始化 |
| [onConnected](on-connected.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onConnected](on-connected.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当连接成功时调用 |
| [onCreate](on-create.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onCreate](on-create.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当创建时调用 |
| [onDestroy](on-destroy.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onDestroy](on-destroy.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当销毁时调用 |
| [onDisconnected](on-disconnected.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onDisconnected](on-disconnected.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当连接断开时调用 |
| [onResponse](on-response.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onResponse](on-response.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>当接收到消息时调用 |
| [onStateChanged](on-state-changed.md) | [androidJvm]<br>open override fun [onStateChanged](on-state-changed.md)(source: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html), event: [Lifecycle.Event](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.Event.html))<br>声明周期 |
| [polymerization](polymerization.md) | [androidJvm]<br>@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [polymerization](polymerization.md)(base: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.name, flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, block: [AbsClient](index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [AbsClient](index.md)<br>聚合 |
| [removeClientCallback](remove-client-callback.md) | [androidJvm]<br>fun [removeClientCallback](remove-client-callback.md)(callback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)): [AbsClient](index.md)<br>fun [removeClientCallback](remove-client-callback.md)(callback: [ClientCallback2](../../com.gyf.foundation.cs.common.client.callback/-client-callback2/index.md)): [AbsClient](index.md)<br>移除客户端回调 |