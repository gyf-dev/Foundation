package com.gyf.foundation.queue

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import java.util.concurrent.CopyOnWriteArrayList

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/17 15:44
 */
class MessageQueueHandler(
    private val name: String,
    private val condition: () -> Boolean,
    private val doQueue: (what: Int, obj: Any?) -> Unit
) {

    private var handlerThread: HandlerThread? = null
    private var handler: Handler? = null
    private val messageQueue = CopyOnWriteArrayList<Message>()
    private val messageQueueFailed = CopyOnWriteArrayList<Message>()

    /**
     * 将消息加入队列
     * @param what 消息类型
     * @param obj 消息内容
     */
    fun queue(what: Int, obj: Any?) {
        if (condition()) {
            doQueue(what, obj)
        } else {
            val message = Message.obtain().apply {
                this.what = what
                this.obj = obj
            }
            val thread = handlerThread
            if (thread == null || !thread.isAlive || handler == null) {
                messageQueue.add(message)
            } else {
                handler?.sendMessage(message)
            }
        }
    }

    /**
     * 启动HandlerThread
     */
    fun start() {
        stop() // 确保之前的线程已经停止
        handlerThread = HandlerThread(name).apply { start() }
        handler = Handler(handlerThread!!.looper) { message ->
            if (condition()) {
                doQueue(message.what, message.obj)
            } else {
                messageQueueFailed.add(Message.obtain().apply {
                    this.what = message.what
                    this.obj = message.obj
                })
            }
            true
        }

        // 处理之前加入的消息
        messageQueue.addAll(messageQueueFailed)
        messageQueueFailed.clear()
        messageQueue.forEach { handler?.sendMessage(it) }
        messageQueue.clear()
    }

    /**
     * 停止处理队列
     */
    fun stop() {
        handlerThread?.quit()
        handlerThread = null
        handler = null
    }

    /**
     * 清空消息队列
     */
    fun clear() {
        messageQueueFailed.clear()
        messageQueue.clear()
    }
}
