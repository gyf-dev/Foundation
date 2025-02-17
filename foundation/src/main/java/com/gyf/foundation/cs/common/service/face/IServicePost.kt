@file:Suppress("PropertyName", "KDocUnresolvedReference")

package com.gyf.foundation.cs.common.service.face

import com.gyf.foundation.cs.common.face.IPost
import com.gyf.foundation.cs.common.face.IPostQuick
import com.gyf.foundation.cs.common.face.IReplyPost
import com.gyf.foundation.cs.common.face.IReplyPostQuick

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:39
 */
interface IServicePost : IPost, IPostQuick, IReplyPost, IReplyPostQuick {
    /**
     * 设置ServiceProvider
     *
     * @param IServiceProvider ServiceProvider
     */
    var _postServiceProvider: IServiceProvider?
}