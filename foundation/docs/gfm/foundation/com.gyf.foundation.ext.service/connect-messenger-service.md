//[foundation](../../index.md)/[com.gyf.foundation.ext.service](index.md)/[connectMessengerService](connect-messenger-service.md)

# connectMessengerService

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectMessengerService](connect-messenger-service.md)(action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onMessenger: ([Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onReceived: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

连接到Messenger服务。 Connect to a Messenger service.

#### Parameters

androidJvm

| | |
|---|---|
| action | 服务的动作字符串。     The action string of the service. |
| onMessenger | 当服务连接时的回调，提供Messenger实例。     Callback when the service is connected, providing a Messenger instance. |
| onReceived | 当收到消息时的回调。     Callback when a message is received. |

[androidJvm]\
suspend fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectMessengerService](connect-messenger-service.md)(action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onReceived: ([Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)

协程方式连接到Messenger服务。 Connect to a Messenger service in a coroutine way.

#### Return

返回Messenger实例的挂起函数。     A suspending function returning a Messenger instance.

#### Parameters

androidJvm

| | |
|---|---|
| action | 服务的动作字符串。     The action string of the service. |
| onReceived | 当收到消息时的回调。     Callback when a message is received. |