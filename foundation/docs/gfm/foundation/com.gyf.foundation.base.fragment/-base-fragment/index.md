//[foundation](../../../index.md)/[com.gyf.foundation.base.fragment](../index.md)/[BaseFragment](index.md)

# BaseFragment

open class [BaseFragment](index.md) : [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), [ConfigurationOwner](../../com.gyf.foundation.ext.configuration/-configuration-owner/index.md), [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [BaseBindingFragment](../-base-binding-fragment/index.md) |

## Constructors

| | |
|---|---|
| [BaseFragment](-base-fragment.md) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)contentLayoutId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))constructor() |

## Functions

| Name | Summary |
|---|---|
| [collectOnLifecycle](collect-on-lifecycle.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle.md)&gt; Flow&lt;[T](collect-on-lifecycle.md)&gt;.[collectOnLifecycle](collect-on-lifecycle.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = realScope, collector: FlowCollector&lt;[T](collect-on-lifecycle.md)&gt;) |
| [collectOnLifecycle2](collect-on-lifecycle2.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle2.md)&gt; Flow&lt;[T](collect-on-lifecycle2.md)&gt;.[collectOnLifecycle2](collect-on-lifecycle2.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = realScope, block: (scope: CoroutineScope, value: [T](collect-on-lifecycle2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |
| [collectQuick](collect-quick.md) | [androidJvm]<br>fun &lt;[T](collect-quick.md)&gt; Flow&lt;[T](collect-quick.md)&gt;.[collectQuick](collect-quick.md)(scope: CoroutineScope = realScope, collector: FlowCollector&lt;[T](collect-quick.md)&gt;): Job |
| [collectQuick2](collect-quick2.md) | [androidJvm]<br>fun &lt;[T](collect-quick2.md)&gt; Flow&lt;[T](collect-quick2.md)&gt;.[collectQuick2](collect-quick2.md)(scope: CoroutineScope = realScope, block: (scope: CoroutineScope, value: [T](collect-quick2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): Job |
| [onConfigurationChanged](on-configuration-changed.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onConfigurationChanged](on-configuration-changed.md)(newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [onCreateView](on-create-view.md) | [androidJvm]<br>open override fun [onCreateView](on-create-view.md)(inflater: [LayoutInflater](https://developer.android.com/reference/kotlin/android/view/LayoutInflater.html), container: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html)?, savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?): [View](https://developer.android.com/reference/kotlin/android/view/View.html)? |
| [onLocaleChanged](on-locale-changed.md) | [androidJvm]<br>open override fun [onLocaleChanged](on-locale-changed.md)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) |
| [onNightModeChanged](on-night-mode-changed.md) | [androidJvm]<br>open override fun [onNightModeChanged](on-night-mode-changed.md)(nightMode: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |