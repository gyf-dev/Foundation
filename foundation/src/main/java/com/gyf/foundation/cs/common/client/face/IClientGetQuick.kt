package com.gyf.foundation.cs.common.client.face

import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.face.IGetQuick

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:29
 */
interface IClientGetQuick : IGetQuick {
    var _getQuickAbsClient: AbsClient?
}