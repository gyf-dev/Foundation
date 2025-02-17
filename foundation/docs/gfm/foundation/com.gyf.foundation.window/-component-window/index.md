//[foundation](../../../index.md)/[com.gyf.foundation.window](../index.md)/[ComponentWindow](index.md)

# ComponentWindow

open class [ComponentWindow](index.md) : [Window](../-window/index.md), [IComponent](../../com.gyf.foundation.window.delegate/-i-component/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [FragmentWindow](../-fragment-window/index.md) |

## Constructors

| | |
|---|---|
| [ComponentWindow](-component-window.md) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)contentLayoutId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))constructor() |

## Functions

| Name | Summary |
|---|---|
| [addContentView](add-content-view.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [addContentView](add-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, params: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?) |
| [onBackPressed](on-back-pressed.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onBackPressed](on-back-pressed.md)() |
| [onConfigurationChanged](on-configuration-changed.md) | [androidJvm]<br>open override fun [onConfigurationChanged](on-configuration-changed.md)(newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [onNewIntent](on-new-intent.md) | [androidJvm]<br>open override fun [onNewIntent](on-new-intent.md)(intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)) |
| [onTrimMemory](on-trim-memory.md) | [androidJvm]<br>open override fun [onTrimMemory](on-trim-memory.md)(level: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [setContent](../../com.gyf.foundation.window.compose/set-content.md) | [androidJvm]<br>fun [ComponentWindow](index.md).[setContent](../../com.gyf.foundation.window.compose/set-content.md)(parent: [CompositionContext](https://developer.android.com/reference/kotlin/androidx/compose/runtime/CompositionContext.html)? = null, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Composes the given composable into the given window. The [content](../../com.gyf.foundation.window.compose/set-content.md) will become the root view of the given window. |
| [setContentView](set-content-view.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [setContentView](set-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html))<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [setContentView](set-content-view.md)(layoutResId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [setContentView](set-content-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), params: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?) |