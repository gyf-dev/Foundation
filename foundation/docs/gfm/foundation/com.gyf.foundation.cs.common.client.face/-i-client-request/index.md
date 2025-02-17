//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client.face](../index.md)/[IClientRequest](index.md)

# IClientRequest

interface [IClientRequest](index.md)

IClientRequest接口

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |
| [IClientProvider](../-i-client-provider/index.md) |

## Functions

| Name | Summary |
|---|---|
| [enqueue](enqueue.md) | [androidJvm]<br>abstract fun [enqueue](enqueue.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>入队方法，用于处理客户端的请求，但不返回任何消息给客户端 Enqueue method, used to handle client requests, but does not return any messages to the client |
| [execute](execute.md) | [androidJvm]<br>abstract fun [execute](execute.md)(message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>执行方法，用于处理客户端的请求，并返回处理后的消息���客户端 Execute method, used to handle client requests and return the processed message to the client |