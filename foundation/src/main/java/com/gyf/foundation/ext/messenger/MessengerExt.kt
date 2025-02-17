package com.gyf.foundation.ext.messenger

import android.os.Bundle
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import com.gyf.foundation.ext.bundle.Bundle

/**
 * 提供Messenger通信的扩展功能。
 * Provides extension functions for Messenger communication.
 *
 * @Author  Ifan.Ge
 * @Date    2024/7/3 17:01
 */


/**
 * 向Messenger发送包含特定操作和数据对的消息。
 * Send a message to Messenger containing a specific action and data pair.
 *
 * @param what 消息的操作码。
 *             The operation code of the message.
 * @param pair 包含键值对的数据。
 *             The data containing a key-value pair.
 */
fun Messenger?.send(
    what: Int,
    pair: Pair<String, Any>,
) {
    sendTry(Message.obtain(null, what, Bundle(pair)))
}

/**
 * 向Messenger发送包含特定操作和可选Bundle数据的消息。
 * Send a message to Messenger containing a specific action and an optional Bundle of data.
 *
 * @param what 消息的操作码。
 *             The operation code of the message.
 * @param bundle 包含数据的Bundle，可为空。
 *               The Bundle containing data, can be null.
 */
fun Messenger?.send(
    what: Int,
    bundle: Bundle? = null,
) {
    sendTry(Message.obtain(null, what, bundle))
}

/**
 * 尝试发送消息至Messenger，捕获并忽略远程异常。
 * Attempts to send a message to Messenger, catching and ignoring RemoteException.
 *
 * @param msg 要发送的消息。
 *            The message to be sent.
 */
private fun Messenger?.sendTry(msg: Message) {
    try {
        this?.send(msg)
    } catch (_: RemoteException) {
        // 远程异常被捕获但不处理，确保程序不因异常而中断。
        // RemoteException is caught but not handled, ensuring the program does not crash due to the exception.
    }
}