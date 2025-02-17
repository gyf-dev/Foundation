//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client.callback](../index.md)/[ClientCallback](index.md)

# ClientCallback

interface [ClientCallback](index.md)

IAidlClient接口

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onConnected](on-connected.md) | [androidJvm]<br>open fun [onConnected](on-connected.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当连接成功时调用 |
| [onCreate](on-create.md) | [androidJvm]<br>open fun [onCreate](on-create.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当创建时调用 |
| [onDestroy](on-destroy.md) | [androidJvm]<br>open fun [onDestroy](on-destroy.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当销毁时调用 |
| [onDisconnected](on-disconnected.md) | [androidJvm]<br>open fun [onDisconnected](on-disconnected.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>当连接断开时调用 |
| [onResponse](on-response.md) | [androidJvm]<br>open fun [onResponse](on-response.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>当接收到消息时调用 |