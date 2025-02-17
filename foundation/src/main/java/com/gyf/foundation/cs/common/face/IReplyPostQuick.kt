package com.gyf.foundation.cs.common.face

import android.os.Message

/**
 * 快速回复接口，提供多个重载方法以支持不同的数据类型和数量。
 * Quick reply interface, providing multiple overloaded methods to support different data types and quantities.
 */
interface IReplyPostQuick {
    /**
     * 快速回复消息，携带单个数据。
     * Quickly reply to a message, carrying a single piece of data.
     *
     * @param data Any? 携带的数据
     */
    fun Message.replyPostQuick(data: Any?)

    /**
     * 快速回复消息，携带两个数据。
     * Quickly reply to a message, carrying two pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     */
    fun Message.replyPostQuick(data: Any?, data2: Any?)

    /**
     * 快速回复消息，携带三个数据。
     * Quickly reply to a message, carrying three pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     */
    fun Message.replyPostQuick(data: Any?, data2: Any?, data3: Any?)

    /**
     * 快速回复消息，携带四个数据。
     * Quickly reply to a message, carrying four pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     * @param data4 Any? 第四个携带的数据
     */
    fun Message.replyPostQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?)

    /**
     * 快速回复消息，携带五个数据。
     * Quickly reply to a message, carrying five pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     * @param data4 Any? 第四个携带的数据
     * @param data5 Any? 第五个携带的数据
     */
    fun Message.replyPostQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?)
}