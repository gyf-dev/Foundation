package com.gyf.foundation.window.delegate

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.contextaware.ContextAwareHelper
import androidx.activity.contextaware.OnContextAvailableListener
import androidx.core.util.Consumer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.enableSavedStateHandles
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.gyf.foundation.window.intent.WindowIntent
import com.gyf.foundation.window.view.DecorView
import java.util.concurrent.CopyOnWriteArrayList

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/26 18:19
 */
class DefaultComponent : IComponent {

    private var decorView: DecorView? = null

    private val contextAwareHelper by lazy { ContextAwareHelper() }

    private val lifecycleRegistry = LifecycleRegistry(this)

    override val lifecycle: Lifecycle by lazy { lifecycleRegistry }

    override val viewModelStore: ViewModelStore by lazy { ViewModelStore() }

    override val defaultViewModelProviderFactory: ViewModelProvider.Factory by lazy {
        SavedStateViewModelFactory(
            null,
            this,
            null
        )
    }

    private val savedStateRegistryController: SavedStateRegistryController by lazy {
        SavedStateRegistryController.create(this)
    }

    override val savedStateRegistry: SavedStateRegistry by lazy {
        savedStateRegistryController.savedStateRegistry
    }
    override val onBackPressedDispatcher: OnBackPressedDispatcher by lazy { OnBackPressedDispatcher() }

    private val onConfigurationChangedListeners = CopyOnWriteArrayList<Consumer<Configuration>>()
    private val onTrimMemoryListeners = CopyOnWriteArrayList<Consumer<Int>>()
    private val onNewIntentListeners = CopyOnWriteArrayList<Consumer<WindowIntent>>()

    init {
        init()
    }

    private fun init() {
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                decorView?.cancelPendingInputEvents()
            }
        })
        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                // Clear out the available context
                contextAwareHelper.clearAvailableContext()
                // And clear the ViewModelStore
                viewModelStore.clear()
            }
        })
        savedStateRegistryController.performAttach()
        enableSavedStateHandles()
    }

    override fun addOnConfigurationChangedListener(listener: Consumer<Configuration>) {
        onConfigurationChangedListeners.add(listener)
    }

    override fun removeOnConfigurationChangedListener(listener: Consumer<Configuration>) {
        onConfigurationChangedListeners.remove(listener)
    }

    override fun addOnTrimMemoryListener(listener: Consumer<Int>) {
        onTrimMemoryListeners.add(listener)
    }

    override fun removeOnTrimMemoryListener(listener: Consumer<Int>) {
        onTrimMemoryListeners.remove(listener)
    }

    override fun addOnNewWindowIntentListener(listener: Consumer<WindowIntent>) {
        onNewIntentListeners.add(listener)
    }

    override fun removeOnNewWindowIntentListener(listener: Consumer<WindowIntent>) {
        onNewIntentListeners.remove(listener)
    }

    override fun create(context: Context, savedInstanceState: Bundle?) {
        savedStateRegistryController.performRestore(savedInstanceState)
        contextAwareHelper.dispatchOnContextAvailable(context)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun start(context: Context) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun resume(context: Context) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun pause(context: Context) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    override fun stop(context: Context) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    override fun destroy(context: Context) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun newIntent(context: Context, intent: WindowIntent) {
        for (listener in onNewIntentListeners) {
            listener.accept(intent)
        }
    }

    override fun configurationChanged(context: Context, newConfig: Configuration) {
        for (listener in onConfigurationChangedListeners) {
            listener.accept(newConfig)
        }
    }

    override fun trimMemory(context: Context, level: Int) {
        for (listener in onTrimMemoryListeners) {
            listener.accept(level)
        }
    }

    override fun saveInstanceState(context: Context, outState: Bundle) {
        val lifecycle = lifecycle
        if (lifecycle is LifecycleRegistry) {
            lifecycle.currentState = Lifecycle.State.CREATED
        }
        savedStateRegistryController.performSave(outState)
    }

    override fun initializeViewTreeOwners(decorView: DecorView) {
        this.decorView = decorView
        decorView.setViewTreeLifecycleOwner(this)
        decorView.setViewTreeViewModelStoreOwner(this)
        decorView.setViewTreeSavedStateRegistryOwner(this)
    }

    override fun peekAvailableContext(): Context? {
        return contextAwareHelper.peekAvailableContext()
    }

    override fun addOnContextAvailableListener(listener: OnContextAvailableListener) {
        contextAwareHelper.addOnContextAvailableListener(listener)
    }

    override fun removeOnContextAvailableListener(listener: OnContextAvailableListener) {
        contextAwareHelper.removeOnContextAvailableListener(listener)
    }
}