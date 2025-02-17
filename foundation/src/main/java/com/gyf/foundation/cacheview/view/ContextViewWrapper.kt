package com.gyf.foundation.cacheview.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import java.lang.ref.WeakReference

/**
 * view的context的包装类
 *
 * @author geyifeng
 * @date 2020/4/15 2:08 PM
 */
class ContextViewWrapper(context: Context) : ContextWrapper(context) {

    private var mContextRef = WeakReference(context)

    fun setCurrentContext(context: Context) {
        mContextRef = WeakReference(context)
    }

    fun getCurrentContext() = mContextRef.get()

    companion object {

        fun getActivity(context: Context): Activity? {
            var activity: Activity? = null
            if (context is Activity) {
                activity = context
            }
            if (context is ContextViewWrapper) {
                context.getCurrentContext()?.apply {
                    if (this is Activity) {
                        activity = this
                    }
                }
            }
            return activity
        }
    }
}