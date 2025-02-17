package com.gyf.foundation.window.delegate

import android.content.Context
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.contextaware.ContextAware
import androidx.activity.contextaware.OnContextAvailableListener
import androidx.core.content.OnConfigurationChangedProvider
import androidx.core.content.OnTrimMemoryProvider
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner
import com.gyf.foundation.window.callback.OnNewWindowIntentProvider

/**
 * IComponent接口，包含了一系列的生命周期方法和窗口相关的方法
 * IComponent interface, includes a series of lifecycle methods and window related methods
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 18:18
 */
interface IComponent :
    ContextAware,
    LifecycleOwner,
    ViewModelStoreOwner,
    HasDefaultViewModelProviderFactory,
    SavedStateRegistryOwner,
    OnBackPressedDispatcherOwner,
    OnConfigurationChangedProvider,
    OnTrimMemoryProvider,
    OnNewWindowIntentProvider,
    IComponentRegistry,
    IViewThreeRegistry {

    /**
     * 获取可用的上下文
     * Get the available context
     *
     * @return Context? 可能返回的上下文
     *                  Possible returned context
     */
    override fun peekAvailableContext(): Context? {
        return null
    }

    /**
     * 添加上下文可用的监听器
     * Add a listener for when the context is available
     *
     * @param listener OnContextAvailableListener 监听器
     *                                          Listener
     */
    override fun addOnContextAvailableListener(listener: OnContextAvailableListener) {

    }

    /**
     * 移除上下文可用的监听器
     * Remove a listener for when the context is available
     *
     * @param listener OnContextAvailableListener 监听器
     *                                          Listener
     */
    override fun removeOnContextAvailableListener(listener: OnContextAvailableListener) {

    }
}