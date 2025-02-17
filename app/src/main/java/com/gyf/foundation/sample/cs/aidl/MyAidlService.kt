package com.gyf.foundation.sample.cs.aidl

import android.os.Message
import com.gyf.foundation.cs.aidl.service.AidlService

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/24 14:16
 */
class MyAidlService : AidlService() {

    override fun onCreate() {
        super.onCreate()
        post(1, tagName to tagName)
    }

    override fun onExecute(clientTag: String, message: Message): Message? {
        return when (message.what) {
            100 -> message.replyGetQuick("你好Aidl客户端，我是服务端，同步100")

            else -> null
        }
    }

    override fun onEnqueue(clientTag: String, message: Message) {
        when (message.what) {
            200 -> message.replyPostQuick("你好Aidl客户端，我是服务端，异步200")

            400 -> message.replyPostQuick("你好Aidl客户端，我是服务端，异步400")
        }
    }
}