@file:Suppress("KDocUnresolvedReference", "PropertyName")

package com.gyf.foundation.cs.common.client.face

import com.gyf.foundation.cs.common.face.IPost

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:51
 */
interface IClientPost : IPost {
    /**
     * 设置ClientProvider
     *
     * @param IClientProvider ClientProvider
     */
    var _postClientProvider: IClientProvider?
}