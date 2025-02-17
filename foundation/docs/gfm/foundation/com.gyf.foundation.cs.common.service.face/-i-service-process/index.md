//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service.face](../index.md)/[IServiceProcess](index.md)

# IServiceProcess

interface [IServiceProcess](index.md)

IAidlRequestService接口

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IService](../-i-service/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onEnqueue](on-enqueue.md) | [androidJvm]<br>abstract fun [onEnqueue](on-enqueue.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))<br>异步方法，用于处理客户端的请求，服务端处理完成后选择是否调用response方法，把消息返回给客户端 |
| [onExecute](on-execute.md) | [androidJvm]<br>abstract fun [onExecute](on-execute.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?<br>用于处理客户端调用execute方法后，服务端收到的请求回调 |