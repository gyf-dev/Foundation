package com.gyf.foundation.cs.common

import android.os.Message
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.ext.bundle.Bundle

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 18:15
 */
class CsMessageQuick : IMessageQuick {
    override fun obtainMessageQuick(data: Any?): Message {
        val msg = Message()
        msg.data = Bundle(CsConst.MSG_EXTRA_DATA to data)
        return msg
    }

    override fun obtainMessageQuick(data: Any?, data2: Any?): Message {
        val msg = Message()
        msg.data = Bundle(CsConst.MSG_EXTRA_DATA to data, CsConst.MSG_EXTRA_DATA2 to data2)
        return msg
    }

    override fun obtainMessageQuick(data: Any?, data2: Any?, data3: Any?): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3
        )
        return msg
    }

    override fun obtainMessageQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4
        )
        return msg
    }

    override fun obtainMessageQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4,
            CsConst.MSG_EXTRA_DATA5 to data5
        )
        return msg
    }

    override fun obtainMessageQuick(what: Int, data: Any?): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(CsConst.MSG_EXTRA_DATA to data)
        return msg
    }

    override fun obtainMessageQuick(what: Int, data: Any?, data2: Any?): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(CsConst.MSG_EXTRA_DATA to data, CsConst.MSG_EXTRA_DATA2 to data2)
        return msg
    }

    override fun obtainMessageQuick(what: Int, data: Any?, data2: Any?, data3: Any?): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3
        )
        return msg
    }

    override fun obtainMessageQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4
        )
        return msg
    }

    override fun obtainMessageQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4,
            CsConst.MSG_EXTRA_DATA5 to data5
        )
        return msg
    }

    override fun obtainMessageQuick(clientTag: String, data: Any?): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data
        )
        return msg
    }

    override fun obtainMessageQuick(clientTag: String, data: Any?, data2: Any?): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?
    ): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message {
        val msg = Message()
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4,
            CsConst.MSG_EXTRA_DATA5 to data5
        )
        return msg
    }

    override fun obtainMessageQuick(clientTag: String, what: Int, data: Any?): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4
        )
        return msg
    }

    override fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle(
            CsConst.MSG_EXTRA_CLIENT_TAG to clientTag,
            CsConst.MSG_EXTRA_DATA to data,
            CsConst.MSG_EXTRA_DATA2 to data2,
            CsConst.MSG_EXTRA_DATA3 to data3,
            CsConst.MSG_EXTRA_DATA4 to data4,
            CsConst.MSG_EXTRA_DATA5 to data5
        )
        return msg
    }
}