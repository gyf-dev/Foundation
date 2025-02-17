//[foundation](../../../index.md)/[com.gyf.foundation.base.fragment](../index.md)/[BaseFragment](index.md)/[collectOnLifecycle2](collect-on-lifecycle2.md)

# collectOnLifecycle2

[androidJvm]\
fun &lt;[T](collect-on-lifecycle2.md)&gt; Flow&lt;[T](collect-on-lifecycle2.md)&gt;.[collectOnLifecycle2](collect-on-lifecycle2.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = realScope, block: (scope: CoroutineScope, value: [T](collect-on-lifecycle2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))