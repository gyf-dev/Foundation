@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.common.service

import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.annotation.CallSuper
import com.gyf.foundation.cs.common.CsConst
import com.gyf.foundation.cs.common.CsMessage
import com.gyf.foundation.cs.common.CsMessageQuick
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.cs.common.service.face.IService
import com.gyf.foundation.cs.common.service.face.IServiceGet
import com.gyf.foundation.cs.common.service.face.IServicePost
import com.gyf.foundation.cs.common.service.face.IServiceProcess
import com.gyf.foundation.cs.common.service.face.IServiceProvider
import com.gyf.foundation.ext.coroutine.coroutineScope
import com.gyf.foundation.ext.message.MessageExt.toStringExt
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.set

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 18:22
 */
abstract class AbsServiceProvider(private val serviceCallback: IService) : IServiceProvider,
    IMessage by CsMessage(),
    IMessageQuick by CsMessageQuick(),
    IServicePost by ServicePost(),
    IServiceGet by ServiceGet() {

    /**
     * 标签绑定集合
     *
     */
    private val clientTags = Collections.synchronizedSet(HashSet<String>())

    /**
     * 客户端请求服务
     */
    protected val serviceProcess: IServiceProcess by lazy {
        object : IServiceProcess {

            override fun onExecute(clientTag: String, message: Message): Message? {
                return onExecuteInternal(clientTag, message)
            }

            override fun onEnqueue(clientTag: String, message: Message) {
                onEnqueueInternal(clientTag, message)
            }
        }
    }

    /**
     * 服务
     */
    protected val internalService: IService = object : IService {

        override fun onBound(clientTag: String) {
            "onBound clientTag = $clientTag".log
            handleQueue(clientTag)
            handleQueue("")
            serviceCallback.onBound(clientTag)
        }

        override fun onUnbound(clientTag: String) {
            "onUnbound clientTag = $clientTag".log
            cancelQueue(clientTag)
            if (!hasBound) {
                cancelQueue("")
            }
            serviceCallback.onUnbound(clientTag)
        }

        override fun onExecute(clientTag: String, message: Message): Message? {
            "onExecute clientTag = $clientTag message = ${message.toStringExt()}".log
            return this@AbsServiceProvider.onExecute(clientTag, message)
        }

        override fun onEnqueue(clientTag: String, message: Message) {
            "onEnqueue clientTag = $clientTag message = ${message.toStringExt()}".log
            this@AbsServiceProvider.onEnqueue(clientTag, message)
        }
    }
    private val queueMaps = ConcurrentHashMap<String, Channel<Message>>()
    private val queueJobs = ConcurrentHashMap<String, Job>()
    private val queueAll = Channel<Message>()
    private var queueAllJob: Job? = null
    private val mutex = Mutex()
    protected val hasBound get() = clientTags.isNotEmpty()
    private val sendHandler by lazy { Handler(Looper.getMainLooper()) }

    init {
        init()
    }

    private fun init() {
        _postServiceProvider = this
        _getServiceProvider = this
    }

    /**
     * save message
     *
     * @param clientTag String
     * @param message Message
     */
    protected fun saveMessage(clientTag: String, message: Message) {
        coroutineScope.launch {
            if (clientTag.isBlank()) {
                queueAll.send(message)
            } else {
                queueMaps.getOrPut(clientTag) { Channel() }.send(message)
            }
        }
    }

    /**
     * Handle queue
     * @param clientTag String
     */
    protected fun handleQueue(clientTag: String) {
        if (clientTag.isBlank()) {
            if (queueAllJob?.isActive == true) {
                return
            }
            queueAllJob = coroutineScope.launch {
                for (message in queueAll) {
                    responseMessageInternal(message)
                }
            }
        } else {
            val channel = queueMaps[clientTag] ?: return
            if (queueJobs[clientTag]?.isActive == true) {
                return
            }
            queueJobs[clientTag] = coroutineScope.launch {
                for (message in channel) {
                    responseMessageInternal(clientTag, message)
                }
            }
        }
    }

    /**
     * Cancel queue
     */
    protected fun cancelQueue(clientTag: String) {
        coroutineScope.launch {
            clearQueue(clientTag)
            if (clientTag.isBlank()) {
                queueAllJob?.cancel()
                queueAllJob = null
            } else {
                queueJobs[clientTag]?.cancel()
                queueJobs.remove(clientTag)
            }
        }
    }

    /**
     * Clear queue
     */
    protected fun clearQueue(clientTag: String) {
        coroutineScope.launch {
            if (clientTag.isBlank()) {
                clear(queueAll)
            } else {
                val channel = queueMaps[clientTag] ?: return@launch
                clear(channel)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun clear(channel: Channel<Message>) {
        while (!channel.isEmpty) {
            channel.receive()
        }
    }

    /**
     * 响应，回调给客户端的消息请调用
     */
    final override fun response(clientTag: String, newMessage: Message) {
        if (isBound(clientTag)) {
            responseMessageInternal(clientTag, newMessage)
        } else {
            saveMessage(clientTag, newMessage)
        }
    }

    final override fun response(newMessage: Message) {
        if (clientTags.isNotEmpty()) {
            responseMessageInternal(newMessage)
        } else {
            saveMessage("", newMessage)
        }
    }

    @CallSuper
    protected open fun onExecute(clientTag: String, message: Message): Message? {
        return serviceCallback.onExecute(clientTag, message)
    }

    @CallSuper
    protected open fun onEnqueue(clientTag: String, message: Message) {
        serviceCallback.onEnqueue(clientTag, message)
    }

    private fun onExecuteInternal(clientTag: String, message: Message): Message? {
        return when (message.what) {

            CsConst.MSG_WHAT_CONNECTION -> onBound(clientTag, message) {}

            CsConst.MSG_WHAT_DISCONNECTION -> onUnbound(clientTag, message) {}

            else -> internalService.onExecute(clientTag, message)?.let {
                if (!it.hasClientTag() || it.getClientTag() != clientTag) {
                    obtainMessage(clientTag, it)
                }
                it
            }
        }
    }

    /**
     * 接收来自客户端的消息
     *
     * @param clientTag String 客户端标签
     * @param message Message 客户端发送的消息
     */
    private fun onEnqueueInternal(clientTag: String, message: Message) {

        when (message.what) {

            CsConst.MSG_WHAT_CONNECTION ->
                onBound(clientTag, message) { responseMessageInternal(clientTag, it, false) }

            CsConst.MSG_WHAT_DISCONNECTION ->
                onUnbound(clientTag, message) { responseMessageInternal(clientTag, it, false) }

            else -> internalService.onEnqueue(clientTag, message)
        }
    }

    /**
     * 检查客户端是否已经绑定
     */
    protected fun isBound(clientTag: String): Boolean {
        return clientTags.contains(clientTag)
    }

    protected open fun onBound(clientTag: String, message: Message, block: (Message) -> Unit) =
        if (!clientTags.contains(clientTag)) {
            clientTags += clientTag
            internalService.onBound(clientTag)
            val msg = obtainMessage(clientTag, CsConst.MSG_WHAT_CONNECTION)
            block(msg)
            msg
        } else null

    protected open fun onUnbound(clientTag: String, message: Message, block: (Message) -> Unit) =
        if (clientTags.contains(clientTag)) {
            val msg = obtainMessage(clientTag, CsConst.MSG_WHAT_DISCONNECTION)
            block(msg)
            clientTags -= clientTag
            internalService.onUnbound(clientTag)
            msg
        } else null

    private fun responseMessageInternal(
        clientTag: String,
        newMessage: Message,
        check: Boolean = true
    ) {
        checkMessage(newMessage, check)
        if (newMessage.getClientTag() != clientTag) {
            obtainMessage(clientTag, newMessage)
        }
        responseMessageOnMain(clientTag, newMessage)
    }

    private fun responseMessageInternal(newMessage: Message, check: Boolean = true) {
        checkMessage(newMessage, check)
        responseMessageOnMain(newMessage)
    }

    private fun checkMessage(message: Message, check: Boolean) {
        if (check) {
            when (message.what) {
                CsConst.MSG_WHAT_CONNECTION, CsConst.MSG_WHAT_DISCONNECTION -> throw IllegalArgumentException(
                    "Message what must not be ${CsConst.MSG_WHAT_CONNECTION} or ${CsConst.MSG_WHAT_DISCONNECTION},ues other what value."
                )

                else -> {}
            }
        }
        if (!message.hasClientTag()) {
            obtainMessage(message)
        }
    }

    private fun responseMessageOnMain(clientTag: String, newMessage: Message) {
        sendHandler.post { responseMessage(clientTag, newMessage) }
    }

    private fun responseMessageOnMain(newMessage: Message) {
        sendHandler.post { responseMessage(newMessage) }
    }

    protected abstract fun responseMessage(clientTag: String, newMessage: Message)

    abstract fun responseMessage(newMessage: Message)
}