//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client](../index.md)/[AbsClientProvider](index.md)

# AbsClientProvider

abstract class [AbsClientProvider](index.md)&lt;[S](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(val clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), val clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) : [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md), [IMessage](../../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IClientPost](../../com.gyf.foundation.cs.common.client.face/-i-client-post/index.md), [IClientGet](../../com.gyf.foundation.cs.common.client.face/-i-client-get/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AidlClientProvider](../../com.gyf.foundation.cs.aidl.client/-aidl-client-provider/index.md) |
| [MessengerClientProvider](../../com.gyf.foundation.cs.messenger.client/-messenger-client-provider/index.md) |

## Constructors

| | |
|---|---|
| [AbsClientProvider](-abs-client-provider.md) | [androidJvm]<br>constructor(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [clientCallback](client-callback.md) | [androidJvm]<br>val [clientCallback](client-callback.md): [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md) |
| [clientMessenger](client-messenger.md) | [androidJvm]<br>abstract val [clientMessenger](client-messenger.md): [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?<br>客户端Messenger |
| [clientTag](client-tag.md) | [androidJvm]<br>val [clientTag](client-tag.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [isConnected](is-connected.md) | [androidJvm]<br>open override val [isConnected](is-connected.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否已连接服务 |

## Functions

| Name | Summary |
|---|---|
| [connect](connect.md) | [androidJvm]<br>abstract fun [connect](connect.md)(iBinder: [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)?): [S](index.md)<br>Connect<br>[androidJvm]<br>open override fun [connect](connect.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>绑定客户端 |
| [create](create.md) | [androidJvm]<br>open override fun [create](create.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>创建客户端 |
| [destroy](destroy.md) | [androidJvm]<br>open override fun [destroy](destroy.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>销毁客户端 |
| [disconnect](disconnect.md) | [androidJvm]<br>abstract fun [disconnect](disconnect.md)()<br>Disconnect<br>[androidJvm]<br>open override fun [disconnect](disconnect.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>解绑客户端 |
| [enqueue](enqueue.md) | [androidJvm]<br>override fun [enqueue](enqueue.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>入队消息 |
| [enqueueMessage](enqueue-message.md) | [androidJvm]<br>abstract fun [enqueueMessage](enqueue-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |
| [execute](execute.md) | [androidJvm]<br>override fun [execute](execute.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>执行消息 |
| [executeMessage](execute-message.md) | [androidJvm]<br>abstract fun [executeMessage](execute-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)? |