@file:Suppress("PropertyName", "KDocUnresolvedReference")

package com.gyf.foundation.cs.common.service.face

import com.gyf.foundation.cs.common.face.IGet
import com.gyf.foundation.cs.common.face.IGetQuick
import com.gyf.foundation.cs.common.face.IReplyGet
import com.gyf.foundation.cs.common.face.IReplyGetQuick

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:39
 */
interface IServiceGet : IGet, IGetQuick, IReplyGet, IReplyGetQuick {
    /**
     * 设置ServiceProvider
     *
     * @param IServiceProvider ServiceProvider
     */
    var _getServiceProvider: IServiceProvider?
}