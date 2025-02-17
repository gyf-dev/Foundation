@file:Suppress("unused")

package com.gyf.foundation.base.activity

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
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
 * 这是一个基础活动类，它扩���了AppCompatActivity并实现了ITag接口。
 * This is a base activity class that extends AppCompatActivity and implements the ITag interface.
 *
 * @Author  Ifan.Ge
 * @Date    2024/7/1 13:49
 */
open class BaseActivity() : AppCompatActivity(), ConfigurationOwner, ITag {

    private val configurationRegister by lazy {
        ConfigurationRegister(this)
            .setAppCompatSameComponentEnabled(false)
    }

    /**
     * 这是内容布局的ID，它是一个整数。
     * This is the ID of the content layout, it is an integer.
     */
    private var contentLayoutId: Int = 0

    /**
     * 这是一个懒加载的_rootView，它是一个可空的View类型。
     * This is a lazily initialized _rootView, it is of nullable View type.
     */
    private val _rootView by lazy { injectContentView() }

    /**
     * 这是一个受保护的懒加载的rootView，如果_rootView为空，它会抛出一个空指针异常。
     * This is a protected lazily initialized rootView, it throws a NullPointerException if _rootView is null.
     */
    protected open val rootView by lazy {
        _rootView ?: throw NullPointerException("rootView is null")
    }

    /**
     * 这是一个带有一个参数的构造函数，该参数是内容布局的ID。
     * This is a constructor with one parameter, which is the ID of the content layout.
     *
     * @param contentLayoutId 内容布局的ID，它是一个整数。
     *                        The ID of the content layout, it is an integer.
     */
    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : this() {
        this.contentLayoutId = contentLayoutId
    }

    init {
        configurationRegister.register()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (_rootView != null && _rootView?.parent == null && _rootView != window.decorView) {
            setContentView(_rootView)
        }
    }

    /**
     * 这是一个受保护的方法，它返回一个可空的View类型的值。
     * This is a protected method, it returns a nullable value of type View.
     *
     * @return 返回一个可空的View类型的值，它是内容视图。
     *         Returns a nullable value of type View, it is the content view.
     */
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