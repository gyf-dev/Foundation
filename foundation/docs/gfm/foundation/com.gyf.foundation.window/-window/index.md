//[foundation](../../../index.md)/[com.gyf.foundation.window](../index.md)/[Window](index.md)

# Window

open class [Window](index.md) : [ContextWrapper](https://developer.android.com/reference/kotlin/android/content/ContextWrapper.html), [LayoutInflater.Factory2](https://developer.android.com/reference/kotlin/android/view/LayoutInflater.Factory2.html), [WindowCallback](../../com.gyf.foundation.window.callback/-window-callback/index.md), [KeyEvent.Callback](https://developer.android.com/reference/kotlin/android/view/KeyEvent.Callback.html), [ComponentCallbacks2](https://developer.android.com/reference/kotlin/android/content/ComponentCallbacks2.html), [IWindowStarter](../../com.gyf.foundation.window.intent/-i-window-starter/index.md), [ConfigurationOwner](../../com.gyf.foundation.ext.configuration/-configuration-owner/index.md), [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

The type Window.

#### Author

ifan.ge

#### Inheritors

| |
|---|
| [ComponentWindow](../-component-window/index.md) |

## Constructors

| | |
|---|---|
| [Window](-window.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [attributes](attributes.md) | [androidJvm]<br>var [attributes](attributes.md): [WindowManager.LayoutParams](https://developer.android.com/reference/kotlin/android/view/WindowManager.LayoutParams.html) |
| [cancelable](cancelable.md) | [androidJvm]<br>var [cancelable](cancelable.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [decorView](decor-view.md) | [androidJvm]<br>val [decorView](decor-view.md): [DecorView](../../com.gyf.foundation.window.view/-decor-view/index.md) |
| [hasDecorView](has-decor-view.md) | [androidJvm]<br>var [hasDecorView](has-decor-view.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isFinished](is-finished.md) | [androidJvm]<br>var [isFinished](is-finished.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isShow](is-show.md) | [androidJvm]<br>var [isShow](is-show.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [layoutInflater](layout-inflater.md) | [androidJvm]<br>val [layoutInflater](layout-inflater.md): [LayoutInflater](https://developer.android.com/reference/kotlin/android/view/LayoutInflater.html) |
| [windowManager](window-manager.md) | [androidJvm]<br>val [windowManager](window-manager.md): [WindowManager](https://developer.android.com/reference/kotlin/android/view/WindowManager.html) |

## Functions

| Name | Summary |
|---|---|
| [addContentView](add-content-view.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [addContentView](add-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, params: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?) |
| [addFlags](add-flags.md) | [androidJvm]<br>fun [addFlags](add-flags.md)(flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [attachBaseContext](attach-base-context.md) | [androidJvm]<br>open override fun [attachBaseContext](attach-base-context.md)(base: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [clearFlags](clear-flags.md) | [androidJvm]<br>fun [clearFlags](clear-flags.md)(flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [dispatchKeyEvent](dispatch-key-event.md) | [androidJvm]<br>open override fun [dispatchKeyEvent](dispatch-key-event.md)(event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>分发键盘事件的方法 Method for dispatching keyboard events |
| [dispatchTouchEvent](dispatch-touch-event.md) | [androidJvm]<br>open override fun [dispatchTouchEvent](dispatch-touch-event.md)(event: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>分发触摸事件的方法 Method for dispatching touch events |
| [findViewById](find-view-by-id.md) | [androidJvm]<br>fun &lt;[T](find-view-by-id.md) : [View](https://developer.android.com/reference/kotlin/android/view/View.html)?&gt; [findViewById](find-view-by-id.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)id: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [T](find-view-by-id.md)? |
| [finish](finish.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [finish](finish.md)() |
| [hide](hide.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [hide](hide.md)() |
| [isFinishing](is-finishing.md) | [androidJvm]<br>fun [isFinishing](is-finishing.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onAttachedToWindow](on-attached-to-window.md) | [androidJvm]<br>open override fun [onAttachedToWindow](on-attached-to-window.md)()<br>当窗口附加到窗口时的回调方法 Callback method when the window is attached to the window |
| [onBackPressed](on-back-pressed.md) | [androidJvm]<br>open fun [onBackPressed](on-back-pressed.md)() |
| [onCanceledOnTouchOutside](on-canceled-on-touch-outside.md) | [androidJvm]<br>open fun [onCanceledOnTouchOutside](on-canceled-on-touch-outside.md)() |
| [onConfigurationChanged](on-configuration-changed.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onConfigurationChanged](on-configuration-changed.md)(newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [onCreateView](on-create-view.md) | [androidJvm]<br>open override fun [onCreateView](on-create-view.md)(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)): [View](https://developer.android.com/reference/kotlin/android/view/View.html)?<br>open override fun [onCreateView](on-create-view.md)(parent: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)): [View](https://developer.android.com/reference/kotlin/android/view/View.html)? |
| [onDetachedFromWindow](on-detached-from-window.md) | [androidJvm]<br>open override fun [onDetachedFromWindow](on-detached-from-window.md)()<br>当窗口从窗口分离时的回调方法 Callback method when the window is detached from the window |
| [onKeyDown](on-key-down.md) | [androidJvm]<br>open override fun [onKeyDown](on-key-down.md)(keyCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onKeyLongPress](on-key-long-press.md) | [androidJvm]<br>open override fun [onKeyLongPress](on-key-long-press.md)(keyCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onKeyMultiple](on-key-multiple.md) | [androidJvm]<br>open override fun [onKeyMultiple](on-key-multiple.md)(keyCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onKeyUp](on-key-up.md) | [androidJvm]<br>open override fun [onKeyUp](on-key-up.md)(keyCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onLocaleChanged](on-locale-changed.md) | [androidJvm]<br>open override fun [onLocaleChanged](on-locale-changed.md)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) |
| [onLowMemory](on-low-memory.md) | [androidJvm]<br>open override fun [onLowMemory](on-low-memory.md)() |
| [onNewIntent](on-new-intent.md) | [androidJvm]<br>open fun [onNewIntent](on-new-intent.md)(intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)) |
| [onNightModeChanged](on-night-mode-changed.md) | [androidJvm]<br>open override fun [onNightModeChanged](on-night-mode-changed.md)(nightMode: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [onTouchEvent](on-touch-event.md) | [androidJvm]<br>open fun [onTouchEvent](on-touch-event.md)(event: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onTrimMemory](on-trim-memory.md) | [androidJvm]<br>open override fun [onTrimMemory](on-trim-memory.md)(level: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [onUserInteraction](on-user-interaction.md) | [androidJvm]<br>open fun [onUserInteraction](on-user-interaction.md)() |
| [onWindowAttributesChanged](on-window-attributes-changed.md) | [androidJvm]<br>open override fun [onWindowAttributesChanged](on-window-attributes-changed.md)(params: [WindowManager.LayoutParams](https://developer.android.com/reference/kotlin/android/view/WindowManager.LayoutParams.html))<br>当窗口属性改变时的回调方法 Callback method when window attributes change |
| [onWindowFocusChanged](on-window-focus-changed.md) | [androidJvm]<br>open override fun [onWindowFocusChanged](on-window-focus-changed.md)(hasWindowFocus: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))<br>当窗口焦点改变时的回调方法 Callback method when window focus changes |
| [post](post.md) | [androidJvm]<br>fun [post](post.md)(runnable: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html)) |
| [postDelayed](post-delayed.md) | [androidJvm]<br>fun [postDelayed](post-delayed.md)(runnable: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html), delayMillis: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)) |
| [setBackground](set-background.md) | [androidJvm]<br>fun [setBackground](set-background.md)(background: [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html)?) |
| [setBackgroundColor](set-background-color.md) | [androidJvm]<br>fun [setBackgroundColor](set-background-color.md)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [setBackgroundDrawable](set-background-drawable.md) | [androidJvm]<br>fun [setBackgroundDrawable](set-background-drawable.md)(background: [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html)?) |
| [setBackgroundResource](set-background-resource.md) | [androidJvm]<br>fun [setBackgroundResource](set-background-resource.md)(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [setCanceledOnTouchOutside](set-canceled-on-touch-outside.md) | [androidJvm]<br>open fun [setCanceledOnTouchOutside](set-canceled-on-touch-outside.md)(cancel: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [setContentView](set-content-view.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [setContentView](set-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html))<br>open fun [setContentView](set-content-view.md)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)layoutResId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [setContentView](set-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), params: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?) |
| [setFlags](set-flags.md) | [androidJvm]<br>fun [setFlags](set-flags.md)(flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), mask: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [show](show.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open fun [show](show.md)() |
| [startActivities](start-activities.md) | [androidJvm]<br>open override fun [startActivities](start-activities.md)(intents: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)&gt;)<br>open override fun [startActivities](start-activities.md)(intents: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)&gt;, options: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?) |
| [startActivity](start-activity.md) | [androidJvm]<br>open override fun [startActivity](start-activity.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html))<br>open override fun [startActivity](start-activity.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), options: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?) |
| [startWindow](start-window.md) | [androidJvm]<br>open override fun &lt;[T](start-window.md) : [Window](index.md)&gt; [startWindow](start-window.md)(intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md))<br>Start window. |
| [startWindowGet](start-window-get.md) | [androidJvm]<br>open override fun &lt;[T](start-window-get.md) : [Window](index.md)&gt; [startWindowGet](start-window-get.md)(intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)): [T](start-window-get.md)<br>Start window get t. |