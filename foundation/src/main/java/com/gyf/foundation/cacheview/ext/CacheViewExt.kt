package com.gyf.foundation.cacheview.ext

import android.app.Application
import com.gyf.foundation.cacheview.CacheView

/**
 * 准备缓存view
 *
 * @receiver Context
 * @param block [@kotlin.ExtensionFunctionType] Function1<CacheViewHelper, Unit>
 * @return CacheViewHelper
 */
inline fun Application.cacheView(block: CacheView.() -> Unit) {
    CacheView.init(this)
    CacheView.instance.also(block)
}

///**
// * 获得缓存view
// *
// * @receiver Context
// * @param layoutId Int
// * @return CacheView?
// */
//fun Context.getCacheView(layoutId: Int) = CacheView.instance.getView(layoutId)
//
///**
// * 获得缓存view
// *
// * @receiver ViewGroup
// * @param layoutId Int
// * @return View
// */
//fun ViewGroup.getCacheView(layoutId: Int): View {
//    val nanoTime = System.nanoTime()
//    val cacheView = context.getCacheView(layoutId)
//    var view: View? = null
//    var lp: ViewGroup.LayoutParams? = null
//    cacheView?.also { cache ->
//        lp = if (this is RecyclerView) {
//            layoutManager?.generateDefaultLayoutParams()
//        } else {
//            layoutParams
//        }
//        lp?.apply {
//            cache.layoutParams?.width?.also {
//                width = it
//            }
//            cache.layoutParams?.height?.also {
//                height = it
//            }
//        }
//        if (lp == null) {
//            lp = cache.layoutParams
//        }
//        lp?.apply {
//            cache.view.layoutParams = this
//            view = cache.view
//            ("cache-${((System.nanoTime() - nanoTime) / 1000000.000f)}ns").log()
//        }
//    }
//    if (view == null || lp == null) {
//        view = LayoutInflater.from(context).inflate(layoutId, this, false)
//        ("normal-${((System.nanoTime() - nanoTime) / 1000000.000f)}ns").log()
//    }
//    return view!!
//}
//
//
//internal fun String.log() {
//    if (CacheView.instance.isDebug) {
//        Log.d("CacheView", this)
//    }
//}