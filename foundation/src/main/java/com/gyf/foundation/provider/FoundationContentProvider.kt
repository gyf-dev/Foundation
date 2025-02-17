package com.gyf.foundation.provider

import com.gyf.foundation.Foundation
import com.gyf.foundation.cacheview.CacheView

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/28 14:23
 */
class FoundationContentProvider : DefaultContentProvider() {

    override fun onCreate(): Boolean {
        Foundation.init(context!!)
        CacheView.init(context!!.applicationContext)
        return super.onCreate()
    }
}