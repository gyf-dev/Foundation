package com.gyf.foundation.ext.message

import android.os.Message

/**
 * 消息扩展类
 * Message Extension Class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/24 14:51
 */
object MessageExt {

    /**
     * 将消息转换为字符串
     * Converts the message to a string
     *
     * @receiver Message? 可能为空的消息
     *                The message that may be null
     * @return String 返回转换后的字符串
     *                Returns the converted string
     */
    fun Message?.toStringExt(): String {
        if (this == null) {
            return "null"
        }
        val b = StringBuilder()
        b.append("{ ")
        b.append(" what=")
        b.append(what)
        if (arg1 != 0) {
            b.append(" arg1=")
            b.append(arg1)
        }

        if (arg2 != 0) {
            b.append(" arg2=")
            b.append(arg2)
        }
        if (obj != null) {
            b.append(" obj=")
            b.append(obj)
        }
        if (data != null) {
            b.append(" data=")
            b.append(data)
        }
        b.append(" }")
        return b.toString()
    }
}