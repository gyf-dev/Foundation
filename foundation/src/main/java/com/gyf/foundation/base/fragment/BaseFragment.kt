@file:Suppress("unused")

package com.gyf.foundation.base.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.gyf.foundation.cacheview.CacheView
import com.gyf.foundation.ext.configuration.ConfigurationOwner
import com.gyf.foundation.ext.configuration.ConfigurationRegister
import com.gyf.foundation.ext.log.ITag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import java.util.Locale

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 15:40
 */
open class BaseFragment() : Fragment(), ConfigurationOwner, ITag {

    private val configurationRegister by lazy {
        ConfigurationRegister(this)
            .setAppCompatSameComponentEnabled(false)
    }

    private var contentLayoutId: Int = 0
    private val _rootView by lazy { injectContentView() }
    protected open val rootView by lazy {
        _rootView ?: throw NullPointerException("rootView is null")
    }
    private val realScope
        get() = if (view == null) lifecycleScope else viewLifecycleOwner.lifecycleScope

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : this() {
        this.contentLayoutId = contentLayoutId
    }

    init {
        configurationRegister.register()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return _rootView
    }

    protected open fun injectContentView(): View? {
        val viewCache =
            CacheView.instance.getViewCache<Int, View>(requireContext(), contentLayoutId)
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
        scope: CoroutineScope = realScope,
        collector: FlowCollector<T>
    ) = scope.launch { collect(collector) }

    fun <T> Flow<T>.collectQuick2(
        scope: CoroutineScope = realScope,
        block: (scope: CoroutineScope, value: T) -> Unit
    ) = scope.launch { collect { block(this, it) } }

    fun <T> Flow<T>.collectOnLifecycle(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        scope: CoroutineScope = realScope,
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
        scope: CoroutineScope = realScope,
        block: (scope: CoroutineScope, value: T) -> Unit
    ) {
        scope.launch {
            repeatOnLifecycle(state) {
                collect { block(this, it) }
            }
        }
    }

    @CallSuper
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configurationRegister.dispatchConfigurationChanged(newConfig)
    }

    override fun onLocaleChanged(locale: Locale) {

    }

    override fun onNightModeChanged(nightMode: Boolean) {

    }
}