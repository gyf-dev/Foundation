//[foundation](../../../index.md)/[com.gyf.foundation.cs.messenger.client](../index.md)/[MessengerClientProvider](index.md)

# MessengerClientProvider

[androidJvm]\
open class [MessengerClientProvider](index.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) : [AbsClientProvider](../../com.gyf.foundation.cs.common.client/-abs-client-provider/index.md)&lt;[Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)&gt; 

Messenger客户端提供者类。

提供了一系列与Messenger通信的方法。

## Constructors

| | |
|---|---|
| [MessengerClientProvider](-messenger-client-provider.md) | [androidJvm]<br>constructor(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [clientMessenger](client-messenger.md) | [androidJvm]<br>open override val [clientMessenger](client-messenger.md): [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)<br>客户端Messenger |

## Functions

| Name | Summary |
|---|---|
| [connect](connect.md) | [androidJvm]<br>open override fun [connect](connect.md)(iBinder: [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)?): [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)<br>Connect |
| [disconnect](disconnect.md) | [androidJvm]<br>open override fun [disconnect](disconnect.md)()<br>Disconnect |
| [enqueueMessage](enqueue-message.md) | [androidJvm]<br>open override fun [enqueueMessage](enqueue-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |
| [executeMessage](execute-message.md) | [androidJvm]<br>open override fun [executeMessage](execute-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)? |