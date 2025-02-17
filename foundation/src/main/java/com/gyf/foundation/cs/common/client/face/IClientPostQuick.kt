package com.gyf.foundation.cs.common.client.face

import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.face.IPostQuick
import com.gyf.foundation.cs.common.face.IPostQuick2

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:29
 */
interface IClientPostQuick : IPostQuick, IPostQuick2 {

    var _postQuickAbsClient: AbsClient?
}