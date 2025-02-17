package com.gyf.foundation.cacheview.callback

import com.gyf.foundation.cacheview.view.ViewCache

interface OnViewCacheFinishListener<R> {
    fun onViewCacheFinish(viewCache: ViewCache<R>)
}