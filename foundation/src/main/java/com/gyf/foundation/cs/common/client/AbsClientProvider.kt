@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.common.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import com.gyf.foundation.cs.common.CsConst
import com.gyf.foundation.cs.common.CsMessage
import com.gyf.foundation.cs.common.CsMessageQuick
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.face.IClientGet
import com.gyf.foundation.cs.common.client.face.IClientPost
import com.gyf.foundation.cs.common.client.face.IClientProvider
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.ext.coroutine.coroutineScope
import com.gyf.foundation.ext.flow.stateFlow
import com.gyf.foundation.ext.message.MessageExt.toStringExt
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 16:09
 */
abstract class AbsClientProvider<S : Any>(
    val clientTag: String,
    private val intent: Intent,
    val clientCallback: ClientCallback,
) : IClientProvider,
    IMessage by CsMessage(),
    IMessageQuick by CsMessageQuick(),
    IClientPost by ClientPost(),
    IClientGet by ClientGet() {


    private var contextRef: WeakReference<Context>? = null

    /**
     * Bound
     */
    private val connect by stateFlow(State.UNKNOWN)

    /**
     * 是否已连接服务
     */
    override val isConnected get() = connect.value == State.CONNECTED

    /**
     * Aidl客户端接口实现
     */
    protected val client: ClientCallback = object : ClientCallback {

        override fun onCreate(clientTag: String) {
            "onCreate clientTag = $clientTag".log
            clientCallback.onCreate(clientTag)
        }

        override fun onDestroy(clientTag: String) {
            "onDestroy clientTag = $clientTag".log
            clientCallback.onDestroy(clientTag)
        }

        override fun onConnected(clientTag: String) {
            "onConnected clientTag = $clientTag".log
            clientCallback.onConnected(clientTag)
        }

        override fun onDisconnected(clientTag: String) {
            "onDisconnected clientTag = $clientTag ".log
            clientCallback.onDisconnected(clientTag)
            cleanup {
                contextRef?.get()?.unbindService(serviceConnection)?.also {
                    "unbindService".log
                }
            }
            if (isCreated.get().not()) {
                onDestroy(clientTag)
            }
        }

        override fun onResponse(clientTag: String, message: Message) {
            when (message.what) {

                CsConst.MSG_WHAT_CONNECTION -> onConnected(clientTag)

                CsConst.MSG_WHAT_DISCONNECTION -> onDisconnected(clientTag)

                else -> {
                    "onResponse clientTag = $clientTag message = ${message.toStringExt()}".log
                    clientCallback.onResponse(clientTag, message)
                }
            }
        }
    }
    protected var service: S? = null

    /**
     * 服务连接对象
     */
    private val serviceConnection: ServiceConnection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            "${name?.className} onServiceConnected".log
            try {
                this@AbsClientProvider.service = connect(service)
                connect.value = State.CONNECTED
                registerConnection()
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            "${name?.className} onServiceDisconnected".log
            cleanup()
        }
    }

    /**
     * Message queue
     */
    private var messageQueue = Channel<Message>()

    /**
     * Enqueue job
     */
    private var enqueueJob: Job? = null

    /**
     * 客户端Messenger
     */
    abstract val clientMessenger: Messenger?

    /**
     * 是否已销毁
     */
    private val isCreated = AtomicBoolean(false)

    init {
        if (clientTag.isBlank()) {
            throw IllegalArgumentException("clientTag must not be blank")
        }
        init()
        coroutineScope.launch {
            connect.flow.collect {
                when (it) {
                    State.UNKNOWN -> {}

                    State.CONNECTED -> promoteQueue()

                    State.Disconnected -> cancelQueue()
                }
            }
        }
    }

    private fun init() {
        _clientTag = clientTag
        _postClientProvider = this
        _getClientProvider = this
    }

    override fun create(context: Context) {
        isCreated.set(true)
        client.onCreate(clientTag)
    }

    override fun destroy(context: Context) {
        isCreated.set(false)
        if (isConnected) {
            disconnect(context)
        } else {
            client.onDestroy(clientTag)
        }
    }

    override fun connect(context: Context, flags: Int) {
        if (isConnected) {
            return
        }
        "bind".log
        val bindService = context.bindService(intent, serviceConnection, flags)
        if (!bindService) {
            "No permission to bind service".log
        }
    }

    override fun disconnect(context: Context) {
        if (!isConnected) {
            return
        }
        "unbind".log
        contextRef = WeakReference(context.applicationContext)
        unregisterConnection()
    }

    private fun cleanup(block: (() -> Unit)? = null) {
        try {
            disconnect()
            block?.invoke()
            connect.value = State.Disconnected
            service = null
            contextRef?.clear()
            contextRef = null
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    /**
     * 执行消息
     *
     * @param message 消息
     */
    final override fun execute(message: Message): Message? {
        return executeInternal(message)
    }

    /**
     * 入队消息
     *
     * @param message 消息
     */
    final override fun enqueue(message: Message) {
        when (connect.value) {
            State.UNKNOWN -> saveMessage(message)
            State.CONNECTED -> enqueueInternal(message)
            State.Disconnected -> {}
        }
    }

    /**
     * 执行消息
     *
     * @param message 消息
     */
    private fun executeInternal(message: Message, check: Boolean = true): Message? {
        if (!checkConnected()) return null
        checkMessage(message, check)
        return executeMessage(message)
    }

    /**
     * 入队消息
     *
     * @param message 消息
     */
    private fun enqueueInternal(message: Message, check: Boolean = true) {
        if (!checkConnected()) return
        checkMessage(message, check)
        enqueueMessage(message)
    }

    /**
     * 检查消息
     *
     * @param message 消息
     */
    private fun checkMessage(message: Message, check: Boolean) {
        if (check) {
            when (message.what) {
                CsConst.MSG_WHAT_CONNECTION, CsConst.MSG_WHAT_DISCONNECTION -> throw IllegalArgumentException(
                    "Message what must not be ${CsConst.MSG_WHAT_CONNECTION} or ${CsConst.MSG_WHAT_DISCONNECTION},ues other what value."
                )

                else -> {}
            }
        }
        message.putClientTagIf(_clientTag)
        message.putCookieIf()
    }

    /**
     * Save
     *
     * @param message
     */
    private fun saveMessage(message: Message) {
        coroutineScope.launch {
            messageQueue.send(message)
        }
    }

    /**
     * Promote queue
     */
    private fun promoteQueue() {
        if (enqueueJob?.isActive == true) {
            return
        }
        enqueueJob = coroutineScope.launch {
            for (message in messageQueue) {
                enqueueInternal(message)
            }
        }
    }

    /**
     * Cancel queue
     */
    private fun cancelQueue() {
        coroutineScope.launch {
            clearQueue()
            enqueueJob?.cancel()
            enqueueJob = null
        }
    }

    /**
     * Clear queue
     *
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun clearQueue() {
        while (!messageQueue.isEmpty) {
            messageQueue.receive()
        }
    }

    /**
     * 注册连接
     */
    private fun registerConnection() {
        enqueueInternal(obtainMessage(CsConst.MSG_WHAT_CONNECTION).replyTo(clientMessenger), false)
    }

    /**
     * 注销连接
     */
    private fun unregisterConnection() {
        enqueueInternal(
            obtainMessage(CsConst.MSG_WHAT_DISCONNECTION).replyTo(clientMessenger),
            false
        )
    }

    /**
     * 检查是否已绑定
     */
    private fun checkConnected(): Boolean {
        if (!isConnected) {
            "Service is not bound".log
            return false
        }
        return true
    }

    /**
     * Connect
     *
     * @param iBinder
     */
    abstract fun connect(iBinder: IBinder?): S

    /**
     * Disconnect
     *
     */
    abstract fun disconnect()

    /**
     *
     * @param message Message
     * @return Message?
     */
    abstract fun executeMessage(message: Message): Message?

    /**
     *
     * @param message Message
     */
    abstract fun enqueueMessage(message: Message)

    // 定义状态枚举
    private enum class State {
        UNKNOWN,
        CONNECTED,
        Disconnected
    }
}