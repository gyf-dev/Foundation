package com.gyf.foundation.ext.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import com.gyf.foundation.ext.intent.createExplicitIntent
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * 提供与Messenger服务连接的扩展功能。
 * Provides extension functions for connecting to Messenger services.
 *
 * @Author  Ifan.Ge
 * @Date    2024/7/3 16:45
 */

/**
 * 连接到Messenger服务。
 * Connect to a Messenger service.
 *
 * @param action 服务的动作字符串。
 *               The action string of the service.
 * @param onMessenger 当服务连接时的回调，提供Messenger实例。
 *                    Callback when the service is connected, providing a Messenger instance.
 * @param onReceived 当收到消息时的回调。
 *                   Callback when a message is received.
 */
@JvmOverloads
fun Context.connectMessengerService(
    action: String,
    onMessenger: ((Messenger?) -> Unit)? = null,
    onReceived: (Message) -> Unit
) {
    val intent = Intent(action).createExplicitIntent(this) ?: return

    var messengerS: Messenger?
    val messengerC = Messenger(object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            onReceived(msg)
        }
    })
    bindService(intent, object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            try {
                messengerS = Messenger(service)
                val msg = Message.obtain(null, 0)
                msg.replyTo = messengerC
                messengerS?.send(msg)
                onMessenger?.invoke(messengerS)
            } catch (_: Exception) {

            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            messengerS = null
            onMessenger?.invoke(null)
        }
    }, Context.BIND_AUTO_CREATE)
}

/**
 * 协程方式连接到Messenger服务。
 * Connect to a Messenger service in a coroutine way.
 *
 * @param action 服务的动作字符串。
 *               The action string of the service.
 * @param onReceived 当收到消息时的回调。
 *                   Callback when a message is received.
 * @return 返回Messenger实例的挂起函数。
 *         A suspending function returning a Messenger instance.
 */
suspend fun Context.connectMessengerService(action: String, onReceived: (Message) -> Unit) =
    suspendCancellableCoroutine { continuation ->
        connectMessengerService(action, {
            if (it == null) {
                continuation.resumeWithException(NullPointerException("The connection has been dropped"))
            } else {
                continuation.resume(it)
            }
        }, onReceived)
    }