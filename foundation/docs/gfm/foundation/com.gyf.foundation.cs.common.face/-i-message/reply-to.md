//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.face](../index.md)/[IMessage](index.md)/[replyTo](reply-to.md)

# replyTo

[androidJvm]\
abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(messenger: [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)

设置Message的回复Messenger

#### Return

Message 设置了回复Messenger的Message对象

#### Parameters

androidJvm

| | |
|---|---|
| messenger | 指定的Messenger |

[androidJvm]\
abstract fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(oldMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)

将新的Message携带旧的Message部分信息发送给客户端

#### Receiver

Message

#### Return

Message

#### Parameters

androidJvm

| | |
|---|---|
| oldMessage | Message |