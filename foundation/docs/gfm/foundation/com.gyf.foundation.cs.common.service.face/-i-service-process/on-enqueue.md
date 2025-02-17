//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service.face](../index.md)/[IServiceProcess](index.md)/[onEnqueue](on-enqueue.md)

# onEnqueue

[androidJvm]\
abstract fun [onEnqueue](on-enqueue.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html))

异步方法，用于处理客户端的请求，服务端处理完成后选择是否调用response方法，把消息返回给客户端

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| message | 客户端发来的消息 |