//[foundation](../../../index.md)/[com.gyf.foundation.window.callback](../index.md)/[OnNewWindowIntentProvider](index.md)

# OnNewWindowIntentProvider

interface [OnNewWindowIntentProvider](index.md)

OnNewWindowIntentProvider接口，用于提供新窗口意图 The OnNewWindowIntentProvider interface, used for providing new window intents

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IComponent](../../com.gyf.foundation.window.delegate/-i-component/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md) | [androidJvm]<br>abstract fun [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)<br>添加一个新的监听器，当[Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md)与新的[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)关联时，会回调该监听器 Add a new listener that will get a callback associated with [Window.onNewIntent](../../com.gyf.foundation.window/-window/on-new-intent.md) with the new [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md). |
| [removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md) | [androidJvm]<br>abstract fun [removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)<br>移除之前添加的监听器，它将不会接收到任何未来的回调 Remove a previously added listener. It will not receive any future callbacks. |