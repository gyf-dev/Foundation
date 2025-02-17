package com.gyf.foundation.sample.cs.messenger

import android.os.Message
import com.gyf.foundation.cs.messenger.service.MessengerService

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/24 14:16
 */
class MyMessengerService : MessengerService() {

    override fun onCreate() {
        super.onCreate()
        post(2, tagName to tagName)
    }

    override fun onEnqueue(clientTag: String, message: Message) {
        when (message.what) {
            300 -> message.replyPostQuick("你好Messenger客户端，我是服务端，异步300")
        }
    }
}