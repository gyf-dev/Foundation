//[foundation](../../../index.md)/[com.gyf.foundation.cs.common](../index.md)/[CsMessage](index.md)/[replyTo](reply-to.md)

# replyTo

[androidJvm]\
open override fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(messenger: [Messenger](https://developer.android.com/reference/kotlin/android/os/Messenger.html)?): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)

获取消息的客户端标签

[androidJvm]\
open override fun [Message](https://developer.android.com/reference/kotlin/android/os/Message.html).[replyTo](reply-to.md)(oldMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)): [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)

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