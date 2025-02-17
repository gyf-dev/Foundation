//[foundation](../../../index.md)/[com.gyf.foundation.window.delegate](../index.md)/[IComponent](index.md)

# IComponent

interface [IComponent](index.md) : [ContextAware](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/ContextAware.html), [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html), [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html), [HasDefaultViewModelProviderFactory](https://developer.android.com/reference/kotlin/androidx/lifecycle/HasDefaultViewModelProviderFactory.html), [SavedStateRegistryOwner](https://developer.android.com/reference/kotlin/androidx/savedstate/SavedStateRegistryOwner.html), [OnBackPressedDispatcherOwner](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcherOwner.html), [OnConfigurationChangedProvider](https://developer.android.com/reference/kotlin/androidx/core/content/OnConfigurationChangedProvider.html), [OnTrimMemoryProvider](https://developer.android.com/reference/kotlin/androidx/core/content/OnTrimMemoryProvider.html), [OnNewWindowIntentProvider](../../com.gyf.foundation.window.callback/-on-new-window-intent-provider/index.md), [IComponentRegistry](../-i-component-registry/index.md), [IViewThreeRegistry](../-i-view-three-registry/index.md)

IComponent接口，包含了一系列的生命周期方法和窗口相关的方法 IComponent interface, includes a series of lifecycle methods and window related methods

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [ComponentWindow](../../com.gyf.foundation.window/-component-window/index.md) |
| [DefaultComponent](../-default-component/index.md) |
| [FragmentHostCallbacks](../-fragment-host-callbacks/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addOnContextAvailableListener](add-on-context-available-listener.md) | [androidJvm]<br>open override fun [addOnContextAvailableListener](add-on-context-available-listener.md)(listener: [OnContextAvailableListener](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/OnContextAvailableListener.html))<br>添加上下文可用的监听器 Add a listener for when the context is available |
| [peekAvailableContext](peek-available-context.md) | [androidJvm]<br>open override fun [peekAvailableContext](peek-available-context.md)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)?<br>获取可用的上下文 Get the available context |
| [removeOnContextAvailableListener](remove-on-context-available-listener.md) | [androidJvm]<br>open override fun [removeOnContextAvailableListener](remove-on-context-available-listener.md)(listener: [OnContextAvailableListener](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/OnContextAvailableListener.html))<br>移除上下文可用的监听器 Remove a listener for when the context is available |