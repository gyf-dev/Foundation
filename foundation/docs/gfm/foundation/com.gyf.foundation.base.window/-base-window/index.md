//[foundation](../../../index.md)/[com.gyf.foundation.base.window](../index.md)/[BaseWindow](index.md)

# BaseWindow

open class [BaseWindow](index.md) : [FragmentWindow](../../com.gyf.foundation.window/-fragment-window/index.md), [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [BaseBindingWindow](../-base-binding-window/index.md) |

## Constructors

| | |
|---|---|
| [BaseWindow](-base-window.md) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)contentLayoutId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))constructor() |

## Functions

| Name | Summary |
|---|---|
| [collectOnLifecycle](collect-on-lifecycle.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle.md)&gt; Flow&lt;[T](collect-on-lifecycle.md)&gt;.[collectOnLifecycle](collect-on-lifecycle.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = lifecycleScope, collector: FlowCollector&lt;[T](collect-on-lifecycle.md)&gt;) |
| [collectOnLifecycle2](collect-on-lifecycle2.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle2.md)&gt; Flow&lt;[T](collect-on-lifecycle2.md)&gt;.[collectOnLifecycle2](collect-on-lifecycle2.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = lifecycleScope, block: (scope: CoroutineScope, value: [T](collect-on-lifecycle2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |
| [collectQuick](collect-quick.md) | [androidJvm]<br>fun &lt;[T](collect-quick.md)&gt; Flow&lt;[T](collect-quick.md)&gt;.[collectQuick](collect-quick.md)(scope: CoroutineScope = lifecycleScope, collector: FlowCollector&lt;[T](collect-quick.md)&gt;): Job |
| [collectQuick2](collect-quick2.md) | [androidJvm]<br>fun &lt;[T](collect-quick2.md)&gt; Flow&lt;[T](collect-quick2.md)&gt;.[collectQuick2](collect-quick2.md)(scope: CoroutineScope = lifecycleScope, block: (scope: CoroutineScope, value: [T](collect-quick2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): Job |