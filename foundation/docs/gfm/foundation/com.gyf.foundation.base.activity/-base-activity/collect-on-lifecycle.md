//[foundation](../../../index.md)/[com.gyf.foundation.base.activity](../index.md)/[BaseActivity](index.md)/[collectOnLifecycle](collect-on-lifecycle.md)

# collectOnLifecycle

[androidJvm]\
fun &lt;[T](collect-on-lifecycle.md)&gt; Flow&lt;[T](collect-on-lifecycle.md)&gt;.[collectOnLifecycle](collect-on-lifecycle.md)(state: [Lifecycle.State](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.State.html) = Lifecycle.State.STARTED, scope: CoroutineScope = lifecycleScope, collector: FlowCollector&lt;[T](collect-on-lifecycle.md)&gt;)