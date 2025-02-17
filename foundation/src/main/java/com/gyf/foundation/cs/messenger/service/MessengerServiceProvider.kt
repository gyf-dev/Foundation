@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.messenger.service

import android.annotation.SuppressLint
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import androidx.collection.ArraySet
import com.gyf.foundation.cs.common.service.AbsServiceProvider
import com.gyf.foundation.cs.common.service.face.IService
import java.util.concurrent.ConcurrentHashMap

/**
 * Messenger服务提供者类。
 *
 * 提供了一系列与Messenger通信的方法。
 */
class MessengerServiceProvider(iService: IService) : AbsServiceProvider(iService) {

    /**
     * 服务端Messenger对象。
     */
    private val messengerS = Messenger(ProviderHandler())

    /**
     * 服务端Messenger的绑定对象。
     */
    override val binder: IBinder get() = messengerS.binder

    /**
     * 客户端Messenger映射表，键为绑定标签，值为Messenger对象。
     */
    private val callbackMap = ConcurrentHashMap<String, ArraySet<Messenger>>()


    override fun onBound(clientTag: String, message: Message, block: (Message) -> Unit): Message? {
        return super.onBound(clientTag, message) {
            addMessenger(clientTag, message)
            block(it)
        }
    }

    override fun onUnbound(
        clientTag: String,
        message: Message,
        block: (Message) -> Unit
    ): Message? {
        return super.onUnbound(clientTag, message, block).apply {
            removeMessenger(clientTag)
        }
    }

    override fun responseMessage(clientTag: String, newMessage: Message) {
        callbackMap[clientTag]?.forEach {
            it.sendTry(newMessage.putClientTagIf(clientTag))
        }
    }

    override fun responseMessage(newMessage: Message) {
        callbackMap.asSequence().forEach { (t, u) -> responseMessage(t, newMessage) }
    }

    /**
     * 尝试发送消息。
     *
     * @receiver Messenger? 客户端Messenger对象。
     * @param msg Message 要发送的消息。
     */
    private fun Messenger?.sendTry(msg: Message) {
        try {
            this?.send(msg)
        } catch (e: Exception) {
            "sendTry ${e.message}".log
        }
    }

    override fun onExecute(clientTag: String, message: Message): Message? {
        return super.onExecute(clientTag, message).apply {
            addMessenger(clientTag, message)
        }
    }

    override fun onEnqueue(clientTag: String, message: Message) {
        super.onEnqueue(clientTag, message).apply {
            addMessenger(clientTag, message)
        }
    }

    private fun addMessenger(clientTag: String, message: Message) {
        if (!isBound(clientTag)) {
            return
        }
        if (message.replyTo != null) {
            callbackMap.getOrPut(clientTag) { ArraySet() }.add(message.replyTo)
        }
    }

    private fun removeMessenger(clientTag: String) {
        callbackMap.remove(clientTag)
    }


    @SuppressLint("HandlerLeak")
    inner class ProviderHandler : Handler(Looper.getMainLooper()) {
        /**
         * 处理接收到的消息。
         *
         * @param msg Message 接收到的消息。
         */
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val clientTag = msg.getClientTag()
            if (clientTag.isBlank()) return
            serviceProcess.onEnqueue(clientTag, msg)
        }
    }
}