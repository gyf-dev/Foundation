//[foundation](../../../index.md)/[com.gyf.foundation.window.callback](../index.md)/[OnNewWindowIntentProvider](index.md)/[addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)

# addOnNewWindowIntentListener

[androidJvm]\
abstract fun [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)

添加一个新的监听器，当[Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md)与新的[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)关联时，会回调该监听器 Add a new listener that will get a callback associated with [Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md) with the new [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| listener | Consumer<WindowIntent> 监听器，当[Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md)被调用时，应该调用该监听器     The listener that should be called whenever [Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md) was called. |