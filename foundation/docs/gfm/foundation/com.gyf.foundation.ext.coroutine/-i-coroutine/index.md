//[foundation](../../../index.md)/[com.gyf.foundation.ext.coroutine](../index.md)/[ICoroutine](index.md)

# ICoroutine

interface [ICoroutine](index.md) : [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md), [LifecycleEventObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleEventObserver.html)

ICoroutine 接口定义了协程的基本行为。 它继承了 ITag 接口，可以获取日志标签和日志级别，以及打印日志。

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [Foundation](../../com.gyf.foundation/-foundation/index.md) |
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |
| [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md) |
| [AbsService](../../com.gyf.foundation.cs.common.service/-abs-service/index.md) |
| [IServiceProvider](../../com.gyf.foundation.cs.common.service.face/-i-service-provider/index.md) |
| [SimpleCoroutine](../-simple-coroutine/index.md) |
| [Logger](../../com.gyf.foundation.ext.log/-logger/index.md) |
| [TypewriterEffectHelper](../../com.gyf.foundation.helper/-typewriter-effect-helper/index.md) |
| [AbsMonitor](../../com.gyf.foundation.monitor/-abs-monitor/index.md) |
| [WindowStarter](../../com.gyf.foundation.window.ext/-window-starter/index.md) |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](../coroutine-scope.md) | [androidJvm]<br>val [ICoroutine](index.md).[coroutineScope](../coroutine-scope.md): CoroutineScope<br>ICoroutine 的默认协程作用域属性，如果不存在则创建一个新的协程作用域并存入 defaultScopeHashMap。 |
| [ioScope](../io-scope.md) | [androidJvm]<br>val [ICoroutine](index.md).[ioScope](../io-scope.md): CoroutineScope<br>ICoroutine 的 IO 协程作用域属性，如果不存在则创建一个新的 IO 协程作用域并存入 ioScopeHashMap。 |
| [mainScope](../main-scope.md) | [androidJvm]<br>val [ICoroutine](index.md).[mainScope](../main-scope.md): CoroutineScope |

## Functions

| Name | Summary |
|---|---|
| [bindLifecycleOwner](../bind-lifecycle-owner.md) | [androidJvm]<br>fun [ICoroutine](index.md).[bindLifecycleOwner](../bind-lifecycle-owner.md)(lifecycleOwner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html))<br>绑定 ICoroutine 的生命周期方法 |
| [collectQuick](collect-quick.md) | [androidJvm]<br>open fun &lt;[T](collect-quick.md)&gt; Flow&lt;[T](collect-quick.md)&gt;.[collectQuick](collect-quick.md)(scope: CoroutineScope = coroutineScope, collector: FlowCollector&lt;[T](collect-quick.md)&gt;): Job |
| [collectQuick2](collect-quick2.md) | [androidJvm]<br>open fun &lt;[T](collect-quick2.md)&gt; Flow&lt;[T](collect-quick2.md)&gt;.[collectQuick2](collect-quick2.md)(scope: CoroutineScope = coroutineScope, block: (scope: CoroutineScope, value: [T](collect-quick2.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): Job |
| [onStateChanged](on-state-changed.md) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>open override fun [onStateChanged](on-state-changed.md)(source: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html), event: [Lifecycle.Event](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.Event.html))<br>声明周期 |
| [removeAllScope](../remove-all-scope.md) | [androidJvm]<br>fun [ICoroutine](index.md).[removeAllScope](../remove-all-scope.md)()<br>移除 ICoroutine 的所有协程作用域的方法，从 defaultScopeHashMap ,ioScopeHashMap,mainScopeHashMap 中移除对应的协程作用域。 |
| [removeDefaultScope](../remove-default-scope.md) | [androidJvm]<br>fun [ICoroutine](index.md).[removeDefaultScope](../remove-default-scope.md)()<br>移除 ICoroutine 的默认协程作用域的方法，从 defaultScopeHashMap 中移除对应的协程作用域。 |
| [removeIoScope](../remove-io-scope.md) | [androidJvm]<br>fun [ICoroutine](index.md).[removeIoScope](../remove-io-scope.md)()<br>移除 ICoroutine 的 IO 协程作用域的方法，从 ioScopeHashMap 中移除对应的协程作用域。 |
| [removeMainScope](../remove-main-scope.md) | [androidJvm]<br>fun [ICoroutine](index.md).[removeMainScope](../remove-main-scope.md)()<br>移除 ICoroutine 的 Main 协程作用域的方法，从 mainScopeHashMap 中移除对应的协程作用域。 |
| [unbindLifecycleOwner](../unbind-lifecycle-owner.md) | [androidJvm]<br>fun [ICoroutine](index.md).[unbindLifecycleOwner](../unbind-lifecycle-owner.md)(lifecycleOwner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html))<br>解绑 ICoroutine 的生命周期方法 |