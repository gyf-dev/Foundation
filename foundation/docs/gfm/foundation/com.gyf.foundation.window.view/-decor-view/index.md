//[foundation](../../../index.md)/[com.gyf.foundation.window.view](../index.md)/[DecorView](index.md)

# DecorView

[androidJvm]\
class [DecorView](index.md)@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) : [FrameLayout](https://developer.android.com/reference/kotlin/android/widget/FrameLayout.html)

## Constructors

| | |
|---|---|
| [DecorView](-decor-view.md) | [androidJvm]<br>@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [dispatchKeyEvent](dispatch-key-event.md) | [androidJvm]<br>open override fun [dispatchKeyEvent](dispatch-key-event.md)(event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [dispatchTouchEvent](dispatch-touch-event.md) | [androidJvm]<br>open override fun [dispatchTouchEvent](dispatch-touch-event.md)(ev: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onWindowFocusChanged](on-window-focus-changed.md) | [androidJvm]<br>open override fun [onWindowFocusChanged](on-window-focus-changed.md)(hasWindowFocus: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [setWindowCallback](set-window-callback.md) | [androidJvm]<br>fun [setWindowCallback](set-window-callback.md)(windowCallback: [WindowCallback](../../com.gyf.foundation.window.callback/-window-callback/index.md)?) |
| [superDispatchKeyEvent](super-dispatch-key-event.md) | [androidJvm]<br>fun [superDispatchKeyEvent](super-dispatch-key-event.md)(event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [superDispatchTouchEvent](super-dispatch-touch-event.md) | [androidJvm]<br>fun [superDispatchTouchEvent](super-dispatch-touch-event.md)(event: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |