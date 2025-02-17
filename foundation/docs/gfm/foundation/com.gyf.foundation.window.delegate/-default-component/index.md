//[foundation](../../../index.md)/[com.gyf.foundation.window.delegate](../index.md)/[DefaultComponent](index.md)

# DefaultComponent

[androidJvm]\
class [DefaultComponent](index.md) : [IComponent](../-i-component/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [DefaultComponent](-default-component.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [defaultViewModelProviderFactory](default-view-model-provider-factory.md) | [androidJvm]<br>open override val [defaultViewModelProviderFactory](default-view-model-provider-factory.md): [ViewModelProvider.Factory](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelProvider.Factory.html) |
| [lifecycle](lifecycle.md) | [androidJvm]<br>open override val [lifecycle](lifecycle.md): [Lifecycle](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.html) |
| [onBackPressedDispatcher](on-back-pressed-dispatcher.md) | [androidJvm]<br>open override val [onBackPressedDispatcher](on-back-pressed-dispatcher.md): [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html) |
| [savedStateRegistry](saved-state-registry.md) | [androidJvm]<br>open override val [savedStateRegistry](saved-state-registry.md): [SavedStateRegistry](https://developer.android.com/reference/kotlin/androidx/savedstate/SavedStateRegistry.html) |
| [viewModelStore](view-model-store.md) | [androidJvm]<br>open override val [viewModelStore](view-model-store.md): [ViewModelStore](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStore.html) |

## Functions

| Name | Summary |
|---|---|
| [addOnConfigurationChangedListener](add-on-configuration-changed-listener.md) | [androidJvm]<br>open override fun [addOnConfigurationChangedListener](add-on-configuration-changed-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)&gt;) |
| [addOnContextAvailableListener](add-on-context-available-listener.md) | [androidJvm]<br>open override fun [addOnContextAvailableListener](add-on-context-available-listener.md)(listener: [OnContextAvailableListener](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/OnContextAvailableListener.html))<br>添加上下文可用的监听器 Add a listener for when the context is available |
| [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md) | [androidJvm]<br>open override fun [addOnNewWindowIntentListener](add-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)<br>添加一个新的监听器，当Window.onNewIntent与新的[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)关联时，会回调该监听器 Add a new listener that will get a callback associated with Window.onNewIntent with the new [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md). |
| [addOnTrimMemoryListener](add-on-trim-memory-listener.md) | [androidJvm]<br>open override fun [addOnTrimMemoryListener](add-on-trim-memory-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt;) |
| [configurationChanged](configuration-changed.md) | [androidJvm]<br>open override fun [configurationChanged](configuration-changed.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [create](create.md) | [androidJvm]<br>open override fun [create](create.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?) |
| [destroy](destroy.md) | [androidJvm]<br>open override fun [destroy](destroy.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [initializeViewTreeOwners](initialize-view-tree-owners.md) | [androidJvm]<br>open override fun [initializeViewTreeOwners](initialize-view-tree-owners.md)(decorView: [DecorView](../../com.gyf.foundation.window.view/-decor-view/index.md)) |
| [newIntent](new-intent.md) | [androidJvm]<br>open override fun [newIntent](new-intent.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)) |
| [pause](pause.md) | [androidJvm]<br>open override fun [pause](pause.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [peekAvailableContext](peek-available-context.md) | [androidJvm]<br>open override fun [peekAvailableContext](peek-available-context.md)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)?<br>获取可用的上下文 Get the available context |
| [removeOnConfigurationChangedListener](remove-on-configuration-changed-listener.md) | [androidJvm]<br>open override fun [removeOnConfigurationChangedListener](remove-on-configuration-changed-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)&gt;) |
| [removeOnContextAvailableListener](remove-on-context-available-listener.md) | [androidJvm]<br>open override fun [removeOnContextAvailableListener](remove-on-context-available-listener.md)(listener: [OnContextAvailableListener](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/OnContextAvailableListener.html))<br>移除上下文可用的监听器 Remove a listener for when the context is available |
| [removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md) | [androidJvm]<br>open override fun [removeOnNewWindowIntentListener](remove-on-new-window-intent-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)&gt;)<br>移除之前添加的监听器，它将不会接收到任何未来的回调 Remove a previously added listener. It will not receive any future callbacks. |
| [removeOnTrimMemoryListener](remove-on-trim-memory-listener.md) | [androidJvm]<br>open override fun [removeOnTrimMemoryListener](remove-on-trim-memory-listener.md)(listener: [Consumer](https://developer.android.com/reference/kotlin/androidx/core/util/Consumer.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt;) |
| [resume](resume.md) | [androidJvm]<br>open override fun [resume](resume.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [saveInstanceState](save-instance-state.md) | [androidJvm]<br>open override fun [saveInstanceState](save-instance-state.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), outState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)) |
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [stop](stop.md) | [androidJvm]<br>open override fun [stop](stop.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [trimMemory](trim-memory.md) | [androidJvm]<br>open override fun [trimMemory](trim-memory.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), level: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |