package com.gyf.foundation.cs.common.face

import android.os.Message

/**
 * 快速回复获取接口，提供多个重载方法以支持不同的数据类型和数量的快速回复。
 * Quick reply fetch interface, providing multiple overloaded methods to support quick replies with different data types and quantities.
 */
interface IReplyGetQuick {

    /**
     * 快速回复消息，携带单个数据。
     * Quickly reply to a message, carrying a single piece of data.
     *
     * @param data Any? 携带的数据
     * @return Message? 可能返回修改后的Message对象
     */
    fun Message.replyGetQuick(data: Any?): Message?

    /**
     * 快速回复消息，���带两个数据。
     * Quickly reply to a message, carrying two pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @return Message? 可能返回修改后的Message对象
     */
    fun Message.replyGetQuick(data: Any?, data2: Any?): Message?

    /**
     * 快速回复消息，携带三个数据。
     * Quickly reply to a message, carrying three pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     * @return Message? 可能返回修改后的Message对象
     */
    fun Message.replyGetQuick(data: Any?, data2: Any?, data3: Any?): Message?

    /**
     * 快速回复消息，携带四个数据。
     * Quickly reply to a message, carrying four pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     * @param data4 Any? 第四个携带的数据
     * @return Message? 可能返回修改后的Message对象
     */
    fun Message.replyGetQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?): Message?

    /**
     * 快速回复消息，携带五个数据。
     * Quickly reply to a message, carrying five pieces of data.
     *
     * @param data Any? 第一个携带的数据
     * @param data2 Any? 第二个携带的数据
     * @param data3 Any? 第三个携带的数据
     * @param data4 Any? 第四个携带的数据
     * @param data5 Any? 第五个携带的数据
     * @return Message? 可能返回修改后的Message对象
     */
    fun Message.replyGetQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?): Message?
}