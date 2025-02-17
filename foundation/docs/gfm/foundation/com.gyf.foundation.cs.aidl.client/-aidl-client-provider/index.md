//[foundation](../../../index.md)/[com.gyf.foundation.cs.aidl.client](../index.md)/[AidlClientProvider](index.md)

# AidlClientProvider

[androidJvm]\
class [AidlClientProvider](index.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) : [AbsClientProvider](../../com.gyf.foundation.cs.common.client/-abs-client-provider/index.md)&lt;&lt;Error class: unknown class&gt;&gt; 

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [AidlClientProvider](-aidl-client-provider.md) | [androidJvm]<br>constructor(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), clientCallback: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [clientMessenger](client-messenger.md) | [androidJvm]<br>open override val [clientMessenger](client-messenger.md): [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)? = null<br>客户端Messenger |

## Functions

| Name | Summary |
|---|---|
| [connect](connect.md) | [androidJvm]<br>open override fun [connect](connect.md)(iBinder: [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)?): &lt;Error class: unknown class&gt;<br>Connect |
| [disconnect](disconnect.md) | [androidJvm]<br>open override fun [disconnect](disconnect.md)()<br>Disconnect |
| [enqueueMessage](enqueue-message.md) | [androidJvm]<br>open override fun [enqueueMessage](enqueue-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |
| [executeMessage](execute-message.md) | [androidJvm]<br>open override fun [executeMessage](execute-message.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)? |