//[foundation](../../../index.md)/[com.gyf.foundation.window.callback](../index.md)/[WindowCallback](index.md)

# WindowCallback

interface [WindowCallback](index.md)

WindowCallback接口，用于处理窗口的回调 The WindowCallback interface, used for handling window callbacks

#### Author

: Ifan Ge

#### Inheritors

| |
|---|
| [Window](../../com.gyf.foundation.window/-window/index.md) |

## Functions

| Name | Summary |
|---|---|
| [dispatchKeyEvent](dispatch-key-event.md) | [androidJvm]<br>abstract fun [dispatchKeyEvent](dispatch-key-event.md)(event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>分发键盘事件的方法 Method for dispatching keyboard events |
| [dispatchTouchEvent](dispatch-touch-event.md) | [androidJvm]<br>abstract fun [dispatchTouchEvent](dispatch-touch-event.md)(event: [MotionEvent](https://developer.android.com/reference/kotlin/android/view/MotionEvent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>分发触摸事件的方法 Method for dispatching touch events |
| [onAttachedToWindow](on-attached-to-window.md) | [androidJvm]<br>abstract fun [onAttachedToWindow](on-attached-to-window.md)()<br>当窗口附加到窗口时的回调方法 Callback method when the window is attached to the window |
| [onDetachedFromWindow](on-detached-from-window.md) | [androidJvm]<br>abstract fun [onDetachedFromWindow](on-detached-from-window.md)()<br>当窗口从窗口分离时的回调方法 Callback method when the window is detached from the window |
| [onWindowAttributesChanged](on-window-attributes-changed.md) | [androidJvm]<br>abstract fun [onWindowAttributesChanged](on-window-attributes-changed.md)(params: [WindowManager.LayoutParams](https://developer.android.com/reference/kotlin/android/view/WindowManager.LayoutParams.html))<br>当窗口属性改变时的回调方法 Callback method when window attributes change |
| [onWindowFocusChanged](on-window-focus-changed.md) | [androidJvm]<br>abstract fun [onWindowFocusChanged](on-window-focus-changed.md)(hasWindowFocus: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))<br>当窗口焦点改变时的回调方法 Callback method when window focus changes |