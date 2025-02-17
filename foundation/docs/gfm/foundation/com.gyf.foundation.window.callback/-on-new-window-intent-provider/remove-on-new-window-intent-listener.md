//[foundation](../../../index.md)/[com.gyf.foundation.window.callback](../index.md)/[OnNewWindowIntentProvider](index.md)/[removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md)

# removeOnNewWindowIntentListener

[androidJvm]\
abstract fun [removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)

移除之前添加的监听器，它将不会接收到任何未来的回调 Remove a previously added listener. It will not receive any future callbacks.

#### Parameters

androidJvm

| | |
|---|---|
| listener | Consumer<WindowIntent> 之前通过[addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)添加的监听器，应该被移除     The listener previously added with [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md) that should be removed. |