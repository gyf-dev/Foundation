package com.gyf.foundation.cs.common.client.face

import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.face.IPost2

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/16 18:35
 */
interface IClientPost2 : IPost2 {
    var _postAbsClient: AbsClient?
}