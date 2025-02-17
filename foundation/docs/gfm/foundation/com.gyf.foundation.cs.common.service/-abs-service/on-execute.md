//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.service](../index.md)/[AbsService](index.md)/[onExecute](on-execute.md)

# onExecute

[androidJvm]\
open override fun [onExecute](on-execute.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)?

用于处理客户端调用execute方法后，服务端收到的请求回调

#### Return

返回处理后的消息给到客户端

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签 |
| message | 客户端发来的消息 |