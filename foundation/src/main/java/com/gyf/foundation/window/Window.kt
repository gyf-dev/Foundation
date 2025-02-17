@file:Suppress("MemberVisibilityCanBePrivate", "HasPlatformType", "DEPRECATION")

package com.gyf.foundation.window

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentCallbacks2
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.Gravity
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.CallSuper
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.gyf.foundation.R
import com.gyf.foundation.ext.configuration.ConfigurationOwner
import com.gyf.foundation.ext.configuration.ConfigurationRegister
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.window.callback.WindowCallback
import com.gyf.foundation.window.ext.WindowStarter
import com.gyf.foundation.window.ext.WindowStarter.remove
import com.gyf.foundation.window.intent.IWindowStarter
import com.gyf.foundation.window.intent.WindowIntent
import com.gyf.foundation.window.view.DecorView
import java.util.Locale

/**
 * The type Window.
 *
 * @author ifan.ge
 */
open class Window : ContextWrapper(null),
    LayoutInflater.Factory2,
    WindowCallback,
    KeyEvent.Callback,
    ComponentCallbacks2,
    IWindowStarter,
    ConfigurationOwner,
    ITag {

    private val mHandler: Handler = WindowHandler(Looper.getMainLooper())

    val windowManager by lazy { getSystemService(WINDOW_SERVICE) as WindowManager }

    val layoutInflater by lazy { LayoutInflater.from(this).cloneInContext(this) }

    var hasDecorView = false
        private set

    val decorView: DecorView by lazy {
        DecorView(baseContext).apply {
            id = R.id.window_decor_view
            setWindowCallback(this@Window)
            visibility = View.GONE
        }
    }

    var isShow: Boolean = false
        private set

    var isFinished: Boolean = false
        private set

    private var isFirstShow = true

    internal var intent: WindowIntent = WindowIntent(Window::class.java)
        set(windowIntent) {
            if (!field.isSame(windowIntent)) {
                attributes = newLayoutParams(windowIntent)
            }
            field = windowIntent
        }

    var attributes: WindowManager.LayoutParams = WindowManager.LayoutParams().apply {
        width = ViewGroup.LayoutParams.MATCH_PARENT
        height = ViewGroup.LayoutParams.MATCH_PARENT
        format = PixelFormat.TRANSLUCENT
        gravity = Gravity.CENTER
        type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        }
    }
        set(attrs) {
            val changed = attributes.copyFrom(attrs)
            if (changed != 0 || attributes === attrs) {
                dispatchWindowAttributesChanged(attrs)
            }
            field = attrs
        }

    private val isMainThread: Boolean get() = Looper.getMainLooper().thread === Thread.currentThread()

    var cancelable = false

    private val configurationRegister by lazy { ConfigurationRegister(this) }

    public override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    @SuppressLint("WrongConstant")
    protected fun newLayoutParams(intent: WindowIntent): WindowManager.LayoutParams {
        val params = attributes
        params.width = intent.width
        params.height = intent.height
        params.format = PixelFormat.RGBA_8888
        if (intent.type != 0) {
            params.type = intent.type
        }
        if (intent.flags != 0) {
            params.flags = intent.flags
        }
        if (intent.gravity != 0) {
            params.gravity = intent.gravity
        }
        return params
    }

    private fun onShow() {
        "onShow".log
        handleShow()
    }

    private fun onHide() {
        "onHide".log
        handleHide()
    }

    private fun onFinish() {
        "onFinish".log
        handleFinish()
    }

    fun isFinishing(): Boolean {
        return isFinished
    }

    @CallSuper
    protected open fun onCreate(savedInstanceState: Bundle?) {
        "onCreate".log
    }

    @CallSuper
    protected open fun onRestart() {
        "onRestart".log
    }

    @CallSuper
    protected open fun onStart() {
        "onStart".log
    }

    @CallSuper
    protected open fun onResume() {
        "onResume".log
    }

    @CallSuper
    protected open fun onPause() {
        "onPause".log
    }

    @CallSuper
    protected open fun onStop() {
        "onStop".log
    }

    @CallSuper
    protected open fun onDestroy() {
        "onDestroy".log
    }

    open fun onNewIntent(intent: WindowIntent) {
        "onNewIntent".log
        this.intent = intent
    }

    @CallSuper
    protected open fun onSaveInstanceState(outState: Bundle) {
        "onSaveInstanceState".log
    }

    @CallSuper
    open fun show() {
        "show".log
        performShow()
    }

    private fun handleShow() {
        if (isShow || isFinished) {
            return
        }
        if (isFirstShow) {
            registerComponentCallbacks(this)
            configurationRegister.register()
            performCreate()
        } else {
            performRestart()
        }
        decorView.visibility = View.VISIBLE
        performStart()
        if (isFirstShow) {
            if (decorView.parent == null) {
                windowManager.addView(decorView, attributes)
                hasDecorView = true
            }
            isFirstShow = false
        }
        performResume()
        isShow = true
    }

    @CallSuper
    open fun hide() {
        "hide".log
        performHide()
    }

    private fun handleHide() {
        if (!isShow || isFinished) {
            return
        }
        performPause()
        decorView.visibility = View.GONE
        performStop()
        isShow = false
    }

    @CallSuper
    open fun finish() {
        "finish".log
        performFinish()
    }

    private fun handleFinish() {
        if (isFinished) {
            return
        }
        hide()
        configurationRegister.unregister()
        unregisterComponentCallbacks(this)
        performDestroy()
        if (decorView.parent != null) {
            windowManager.removeViewImmediate(decorView)
            hasDecorView = false
        }
        isFirstShow = true
        isFinished = true
        remove(this)
    }

    private fun updateViewLayout(attrs: WindowManager.LayoutParams) {
        val decor = decorView
        if (decor.parent != null) {
            windowManager.updateViewLayout(decor, attrs)
        }
    }

    open fun setContentView(@LayoutRes layoutResId: Int) {
        val view = layoutInflater.inflate(layoutResId, null)
        decorView.removeAllViews()
        decorView.addView(view)
    }

    @CallSuper
    open fun setContentView(view: View) {
        decorView.removeAllViews()
        decorView.addView(view)
    }

    @CallSuper
    open fun setContentView(view: View, params: ViewGroup.LayoutParams?) {
        decorView.removeAllViews()
        decorView.addView(view, params)
    }

    @CallSuper
    open fun addContentView(view: View?, params: ViewGroup.LayoutParams?) {
        decorView.addView(view, params)
    }

    @CallSuper
    override fun onConfigurationChanged(newConfig: Configuration) {
        configurationRegister.dispatchConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {

    }

    override fun onTrimMemory(level: Int) {

    }

    private fun performShow() {
        if (isMainThread) {
            handleShow()
        } else {
            mHandler.obtainMessage(SHOW).sendToTarget()
        }
    }

    private fun performHide() {
        if (isMainThread) {
            handleHide()
        } else {
            mHandler.obtainMessage(HIDE).sendToTarget()
        }
    }

    private fun performFinish() {
        if (isMainThread) {
            handleFinish()
        } else {
            mHandler.obtainMessage(FINISH).sendToTarget()
        }
    }

    private fun performCreate() {
        if (isMainThread) {
            onCreate(null)
        } else {
            mHandler.obtainMessage(CREATE).sendToTarget()
        }
    }

    private fun performRestart() {
        if (isMainThread) {
            onRestart()
        } else {
            mHandler.obtainMessage(RESTART).sendToTarget()
        }
    }

    private fun performStart() {
        if (isMainThread) {
            onStart()
        } else {
            mHandler.obtainMessage(START).sendToTarget()
        }
    }

    private fun performResume() {
        if (isMainThread) {
            onResume()
        } else {
            mHandler.obtainMessage(RESUMED).sendToTarget()
        }
    }

    private fun performPause() {
        if (isMainThread) {
            onPause()
        } else {
            mHandler.obtainMessage(PAUSE).sendToTarget()
        }
    }

    private fun performStop() {
        if (isMainThread) {
            onStop()
        } else {
            mHandler.obtainMessage(STOP).sendToTarget()
        }
    }

    private fun performDestroy() {
        if (isMainThread) {
            onDestroy()
        } else {
            mHandler.obtainMessage(DESTROY).sendToTarget()
        }
    }

    override fun startActivity(intent: Intent) {
        if (baseContext !is Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        super.startActivity(intent)
    }

    override fun startActivity(intent: Intent, options: Bundle?) {
        if (baseContext !is Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        super.startActivity(intent, options)
    }

    override fun startActivities(intents: Array<Intent>) {
        if (baseContext !is Activity) {
            for (intent in intents) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }
        super.startActivities(intents)
    }

    override fun startActivities(intents: Array<Intent>, options: Bundle?) {
        if (baseContext !is Activity) {
            for (intent in intents) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }
        super.startActivities(intents, options)
    }

    fun <T : View?> findViewById(@IdRes id: Int): T? {
        return decorView.findViewById(id)
    }

    override fun onCreateView(
        parent: View?, name: String, context: Context,
        attrs: AttributeSet
    ): View? {
        return null
    }

    override fun onCreateView(
        name: String, context: Context,
        attrs: AttributeSet
    ): View? {
        return null
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_ESCAPE) {
            event.startTracking()
            return true
        }
        return false
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent): Boolean {
        return false
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_ESCAPE)
            && event.isTracking
            && !event.isCanceled
        ) {
            onBackPressed()
            return true
        }
        return false
    }

    override fun onKeyMultiple(keyCode: Int, count: Int, event: KeyEvent): Boolean {
        return false
    }

    open fun onBackPressed() {
        if (cancelable) {
            finish()
        }
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        onUserInteraction()
        if (decorView.superDispatchKeyEvent(event)) {
            return true
        }
        return event.dispatch(this, decorView.keyDispatcherState, this)
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
    }

    override fun onAttachedToWindow() {
    }

    override fun onDetachedFromWindow() {
    }

    fun setBackgroundResource(@DrawableRes resId: Int) {
        decorView.setBackgroundResource(resId)
    }

    fun setBackground(background: Drawable?) {
        decorView.background = background
    }

    @Suppress("deprecation")
    fun setBackgroundDrawable(background: Drawable?) {
        decorView.setBackgroundDrawable(background)
    }

    fun setBackgroundColor(@ColorInt color: Int) {
        decorView.setBackgroundColor(color)
    }

    private fun dispatchWindowAttributesChanged(attrs: WindowManager.LayoutParams) {
        updateViewLayout(attrs)
        onWindowAttributesChanged(attrs)
    }

    fun post(runnable: Runnable) {
        if (isFinished) {
            return
        }
        mHandler.post(runnable)
    }

    fun postDelayed(runnable: Runnable, delayMillis: Long) {
        if (isFinished) {
            return
        }
        mHandler.postDelayed(runnable, delayMillis)
    }

    override fun onWindowAttributesChanged(params: WindowManager.LayoutParams) {
        params.log
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            onUserInteraction()
        }
        if (decorView.superDispatchTouchEvent(event)) {
            return true
        }
        return onTouchEvent(event)
    }

    open fun onTouchEvent(event: MotionEvent): Boolean {
        "onTouchEvent $event".log
        if (cancelable && isShow && shouldCloseOnTouch(event)) {
            onCanceledOnTouchOutside()
            hide()
            return true
        }
        return false
    }

    open fun onCanceledOnTouchOutside() {
        "onCanceledOnTouchOutside".log
    }

    private fun shouldCloseOnTouch(event: MotionEvent): Boolean {
        val isOutside = event.action == MotionEvent.ACTION_UP
                && isOutOfBounds(event)
                || event.action == MotionEvent.ACTION_OUTSIDE
        return isOutside
    }

    private fun isOutOfBounds(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        val slop = ViewConfiguration.get(this).scaledWindowTouchSlop
        return ((x < -slop) || (y < -slop)
                || (x > (decorView.width + slop))
                || (y > (decorView.height + slop)))
    }

    open fun onUserInteraction() {

    }

    fun clearFlags(flags: Int) {
        setFlags(0, flags)
    }

    fun addFlags(flags: Int) {
        setFlags(flags, flags)
    }

    fun setFlags(flags: Int, mask: Int) {
        val attrs = attributes
        attrs.flags = (attrs.flags and mask.inv()) or (flags and mask)
        dispatchWindowAttributesChanged(attrs)
    }

    open fun setCanceledOnTouchOutside(cancel: Boolean) {
        if (cancel && !cancelable) {
            cancelable = true
        }
    }

    override fun <T : Window> startWindow(intent: WindowIntent) {
        WindowStarter.startWindow<T>(this, intent)
    }

    override fun <T : Window> startWindowGet(intent: WindowIntent): T {
        return WindowStarter.startWindowGet(this, intent)
    }

    internal inner class WindowHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                SHOW -> onShow()
                HIDE -> onHide()
                FINISH -> onFinish()
                CREATE -> onCreate(null)
                RESTART -> onRestart()
                START -> onStart()
                RESUMED -> onResume()
                PAUSE -> onPause()
                STOP -> onStop()
                DESTROY -> onDestroy()
                else -> {}
            }
        }
    }

    companion object {
        private const val SHOW = -1
        private const val HIDE = -2
        private const val FINISH = -3
        private const val CREATE = 0
        private const val RESTART = 1
        private const val START = 2
        private const val RESUMED = 3
        private const val PAUSE = 4
        private const val STOP = 5
        private const val DESTROY = 6
    }

    override fun onLocaleChanged(locale: Locale) {

    }

    override fun onNightModeChanged(nightMode: Boolean) {

    }
}
