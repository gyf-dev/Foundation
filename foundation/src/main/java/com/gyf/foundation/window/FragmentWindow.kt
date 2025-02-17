@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.window

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentManager
import com.gyf.foundation.window.delegate.FragmentHostCallbacks

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/26 19:56
 */
open class FragmentWindow : ComponentWindow() {

    private val fragments: FragmentController by lazy {
        FragmentController.createController(HostCallbacks())
    }

    val supportFragmentManager: FragmentManager get() = fragments.supportFragmentManager

    var isCreated: Boolean = false
        private set
    var isResumed: Boolean = false
        private set
    var isStopped: Boolean = true
        private set

    init {
        init()
    }

    private fun init() {

        addOnContextAvailableListener { fragments.attachHost(null) }

        // Ensure that the first OnConfigurationChangedListener
        // marks the FragmentManager's state as not saved
        addOnConfigurationChangedListener { fragments.noteStateNotSaved() }

        // Ensure that the first OnNewIntentListener
        // marks the FragmentManager's state as not saved
        addOnNewWindowIntentListener { fragments.noteStateNotSaved() }

    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCreated = true
        fragments.dispatchCreate()
    }

    @CallSuper
    override fun onStart() {
        fragments.noteStateNotSaved()
        super.onStart()
        fragments.execPendingActions()
        isStopped = false
        fragments.dispatchStart()
    }

    @CallSuper
    override fun onResume() {
        fragments.noteStateNotSaved()
        super.onResume()
        fragments.execPendingActions()
        isResumed = true
        fragments.dispatchResume()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        isResumed = false
        fragments.dispatchPause()
    }

    override fun onStop() {
        super.onStop()
        isStopped = true
        fragments.dispatchStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        isCreated = false
        fragments.dispatchDestroy()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return dispatchFragmentsOnCreateView(null, name, context, attrs)
            ?: super.onCreateView(name, context, attrs)
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return dispatchFragmentsOnCreateView(parent, name, context, attrs)
            ?: super.onCreateView(name, context, attrs)
    }

    /**
     * Dispatch fragments on create view view.
     *
     * @param parent  the parent
     * @param name    the name
     * @param context the context
     * @param attrs   the attrs
     * @return the view
     */
    private fun dispatchFragmentsOnCreateView(
        parent: View?, name: String,
        context: Context, attrs: AttributeSet
    ): View? {
        return fragments.onCreateView(parent, name, context, attrs)
    }

    internal inner class HostCallbacks : FragmentHostCallbacks<FragmentWindow>(this) {

        override fun onShouldSaveFragmentState(fragment: Fragment): Boolean {
            return !isFinishing()
        }

        override fun onGetLayoutInflater(): LayoutInflater {
            return layoutInflater.cloneInContext(this@FragmentWindow)
        }

        override fun onGetWindowAnimations(): Int {
            return attributes.windowAnimations
        }

        override fun onFindViewById(id: Int): View? {
            return findViewById<View>(id)
        }

        override fun onHasView(): Boolean {
            return hasDecorView
        }
    }
}