@file:Suppress("unused")

package com.gyf.foundation.window

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import com.gyf.foundation.window.delegate.DefaultComponent
import com.gyf.foundation.window.delegate.IComponent
import com.gyf.foundation.window.intent.WindowIntent

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/26 17:35
 */
open class ComponentWindow() : Window(), IComponent by DefaultComponent() {

    @LayoutRes
    private var contentLayoutId = 0

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : this() {
        this.contentLayoutId = contentLayoutId
    }

    init {
        init()
    }

    private fun init() {
        addOnContextAvailableListener {
            onBackPressedDispatcher.addCallback { super.onBackPressed() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        create(this, savedInstanceState)
        if (contentLayoutId != 0) {
            setContentView(contentLayoutId)
        }
    }

    override fun onStart() {
        super.onStart()
        start(this)
    }

    override fun onResume() {
        super.onResume()
        resume(this)
    }

    override fun onPause() {
        super.onPause()
        pause(this)
    }

    override fun onStop() {
        super.onStop()
        stop(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        destroy(this)
    }

    override fun onNewIntent(intent: WindowIntent) {
        super.onNewIntent(intent)
        newIntent(this, intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(this, outState)
    }

    @CallSuper
    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configurationChanged(this, newConfig)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        trimMemory(this, level)
    }

    @CallSuper
    override fun setContentView(layoutResId: Int) {
        initializeViewTreeOwners(decorView)
        super.setContentView(layoutResId)
    }

    @CallSuper
    override fun setContentView(view: View) {
        initializeViewTreeOwners(decorView)
        super.setContentView(view)
    }

    @CallSuper
    override fun setContentView(view: View, params: ViewGroup.LayoutParams?) {
        initializeViewTreeOwners(decorView)
        super.setContentView(view, params)
    }

    @CallSuper
    override fun addContentView(view: View?, params: ViewGroup.LayoutParams?) {
        initializeViewTreeOwners(decorView)
        super.addContentView(view, params)
    }
}