package com.gyf.foundation.cs.common.client

import com.gyf.foundation.cs.common.client.face.IClientGetQuick

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:40
 */
class ClientGetQuick : IClientGetQuick {

    override var _getQuickAbsClient: AbsClient? = null

    override fun getQuick(data: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                data
            ).putCookieIf()
        )
    }

    override fun getQuick(data: Any?, data2: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                data,
                data2
            ).putCookieIf()
        )
    }

    override fun getQuick(data: Any?, data2: Any?, data3: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                data,
                data2,
                data3
            ).putCookieIf()
        )
    }

    override fun getQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    data,
                    data2,
                    data3,
                    data4
                ).putCookieIf()
            )
        }

    override fun getQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    data,
                    data2,
                    data3,
                    data4,
                    data5
                ).putCookieIf()
            )
        }

    override fun getQuick(clientTag: String, data: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                data
            ).putCookieIf()
        )
    }

    override fun getQuick(clientTag: String, data: Any?, data2: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                data,
                data2
            ).putCookieIf()
        )
    }

    override fun getQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    clientTag,
                    data,
                    data2,
                    data3
                ).putCookieIf()
            )
        }

    override fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                data,
                data2,
                data3,
                data4
            ).putCookieIf()
        )
    }

    override fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                data,
                data2,
                data3,
                data4,
                data5
            ).putCookieIf()
        )
    }

    override fun getQuick(what: Int, data: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    what,
                    data
                ).putCookieIf()
            )
        }

    override fun getQuick(what: Int, data: Any?, data2: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    what,
                    data,
                    data2
                ).putCookieIf()
            )
        }

    override fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    what,
                    data,
                    data2,
                    data3
                ).putCookieIf()
            )
        }


    override fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    what,
                    data,
                    data2,
                    data3,
                    data4
                ).putCookieIf()
            )
        }

    override fun getQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                what,
                data,
                data2,
                data3,
                data4,
                data5
            ).putCookieIf()
        )
    }

    override fun getQuick(clientTag: String, what: Int, data: Any?) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                what,
                data,
            ).putCookieIf()
        )
    }

    override fun getQuick(clientTag: String, what: Int, data: Any?, data2: Any?) =
        _getQuickAbsClient?.run {
            execute(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data,
                    data2
                ).putCookieIf()
            )
        }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                what,
                data,
                data2,
                data3
            ).putCookieIf()
        )
    }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                what,
                data,
                data2,
                data3,
                data4
            ).putCookieIf()
        )
    }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) = _getQuickAbsClient?.run {
        execute(
            obtainMessageQuick(
                clientTag,
                what,
                data,
                data2,
                data3,
                data4,
                data5
            ).putCookieIf()
        )
    }
}