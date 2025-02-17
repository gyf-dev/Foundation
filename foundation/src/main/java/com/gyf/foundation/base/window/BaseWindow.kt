@file:Suppress("unused")

package com.gyf.foundation.base.window

import android.os.Bundle
import android.view.View
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.gyf.foundation.cacheview.CacheView
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.window.FragmentWindow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch


/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 13:49
 */
open class BaseWindow() : FragmentWindow(), ITag {

    private var contentLayoutId: Int = 0

    private val _rootView by lazy { injectContentView() }

    protected open val rootView by lazy {
        _rootView ?: throw NullPointerException("rootView is null")
    }

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : this() {
        this.contentLayoutId = contentLayoutId
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = _rootView
        if (view != null && view.parent == null && view != decorView) {
            setContentView(view)
        }
    }

    protected open fun injectContentView(): View? {
        val viewCache =
            CacheView.instance.getViewCache<Int, View>(this, contentLayoutId)
        return if (viewCache?.view != null) {
            viewCache.view
        } else {
            if (contentLayoutId != 0) {
                layoutInflater.inflate(contentLayoutId, null)
            } else {
                null
            }
        }
    }

    fun <T> Flow<T>.collectQuick(
        scope: CoroutineScope = lifecycleScope,
        collector: FlowCollector<T>
    ) = scope.launch { collect(collector) }


    fun <T> Flow<T>.collectQuick2(
        scope: CoroutineScope = lifecycleScope,
        block: (scope: CoroutineScope, value: T) -> Unit
    ) = scope.launch { collect { block(this, it) } }

    fun <T> Flow<T>.collectOnLifecycle(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        scope: CoroutineScope = lifecycleScope,
        collector: FlowCollector<T>
    ) {
        scope.launch {
            repeatOnLifecycle(state) {
                collect { collect(collector) }
            }
        }
    }

    fun <T> Flow<T>.collectOnLifecycle2(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        scope: CoroutineScope = lifecycleScope,
        block: (scope: CoroutineScope, value: T) -> Unit
    ) {
        scope.launch {
            repeatOnLifecycle(state) {
                collect { block(this, it) }
            }
        }
    }
}