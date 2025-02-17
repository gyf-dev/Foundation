//[foundation](../../../index.md)/[com.gyf.foundation.base.activity](../index.md)/[BaseActivity](index.md)

# BaseActivity

open class [BaseActivity](index.md) : [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), [ConfigurationOwner](../../com.gyf.foundation.ext.configuration/-configuration-owner/index.md), [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

这是一个基础活动类，它扩���了AppCompatActivity并实现了ITag接口。 This is a base activity class that extends AppCompatActivity and implements the ITag interface.

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [BaseBindingActivity](../-base-binding-activity/index.md) |

## Constructors

| | |
|---|---|
| [BaseActivity](-base-activity.md) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)contentLayoutId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>这是一个带有一个参数的构造函数，该参数是内容布局的ID。 This is a constructor with one parameter, which is the ID of the content layout.<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [collectOnLifecycle](collect-on-lifecycle.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle.md)&gt; Flow&lt;[T](collect-on-lifecycle.md)&gt;.[collectOnLifecycle](collect-on-lifecycle.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = lifecycleScope, collector: FlowCollector&lt;[T](collect-on-lifecycle.md)&gt;) |
| [collectOnLifecycle2](collect-on-lifecycle2.md) | [androidJvm]<br>fun &lt;[T](collect-on-lifecycle2.md)&gt; Flow&lt;[T](collect-on-lifecycle2.md)&gt;.[collectOnLifecycle2](collect-on-lifecycle2.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = lifecycleScope, block: (scope: CoroutineScope, value: [T](collect-on-lifecycle2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |
| [collectQuick](collect-quick.md) | [androidJvm]<br>fun &lt;[T](collect-quick.md)&gt; Flow&lt;[T](collect-quick.md)&gt;.[collectQuick](collect-quick.md)(scope: CoroutineScope = lifecycleScope, collector: FlowCollector&lt;[T](collect-quick.md)&gt;): Job |
| [collectQuick2](collect-quick2.md) | [androidJvm]<br>fun &lt;[T](collect-quick2.md)&gt; Flow&lt;[T](collect-quick2.md)&gt;.[collectQuick2](collect-quick2.md)(scope: CoroutineScope = lifecycleScope, block: (scope: CoroutineScope, value: [T](collect-quick2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): Job |
| [onConfigurationChanged](on-configuration-changed.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onConfigurationChanged](on-configuration-changed.md)(newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [onLocaleChanged](on-locale-changed.md) | [androidJvm]<br>open override fun [onLocaleChanged](on-locale-changed.md)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) |
| [onNightModeChanged](on-night-mode-changed.md) | [androidJvm]<br>open override fun [onNightModeChanged](on-night-mode-changed.md)(nightMode: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |