//[foundation](../../../index.md)/[com.gyf.foundation.window.delegate](../index.md)/[DefaultComponent](index.md)/[addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)

# addOnNewWindowIntentListener

[androidJvm]\
open override fun [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)

添加一个新的监听器，当Window.onNewIntent与新的[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)关联时，会回调该监听器 Add a new listener that will get a callback associated with Window.onNewIntent with the new [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| listener | Consumer<WindowIntent> 监听器，当Window.onNewIntent被调用时，应该调用该监听器     The listener that should be called whenever Window.onNewIntent was called. |