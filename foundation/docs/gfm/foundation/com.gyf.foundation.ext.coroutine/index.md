//[foundation](../../index.md)/[com.gyf.foundation.ext.coroutine](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CoroutineThreadName](-coroutine-thread-name/index.md) | [androidJvm]<br>class [CoroutineThreadName](-coroutine-thread-name/index.md)(val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [AbstractCoroutineContextElement](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html), ThreadContextElement&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; <br>CoroutineThreadName 类用于管理协程的线程名称。 它实现了 ThreadContextElement 接口，可以在协程上下文中保存和恢复线程名称。 |
| [ICoroutine](-i-coroutine/index.md) | [androidJvm]<br>interface [ICoroutine](-i-coroutine/index.md) : [ITag](../com.gyf.foundation.ext.log/-i-tag/index.md), [LifecycleEventObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleEventObserver.html)<br>ICoroutine 接口定义了协程的基本行为。 它继承了 ITag 接口，可以获取日志标签和日志级别，以及打印日志。 |
| [SimpleCoroutine](-simple-coroutine/index.md) | [androidJvm]<br>open class [SimpleCoroutine](-simple-coroutine/index.md) : [ICoroutine](-i-coroutine/index.md) |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](coroutine-scope.md) | [androidJvm]<br>val [ICoroutine](-i-coroutine/index.md).[coroutineScope](coroutine-scope.md): CoroutineScope<br>ICoroutine 的默认协程作用域属性，如果不存在则创建一个新的协程作用域并存入 defaultScopeHashMap。 |
| [ioScope](io-scope.md) | [androidJvm]<br>val [ICoroutine](-i-coroutine/index.md).[ioScope](io-scope.md): CoroutineScope<br>ICoroutine 的 IO 协程作用域属性，如果不存在则创建一个新的 IO 协程作用域并存入 ioScopeHashMap。 |
| [mainScope](main-scope.md) | [androidJvm]<br>val [ICoroutine](-i-coroutine/index.md).[mainScope](main-scope.md): CoroutineScope |

## Functions

| Name | Summary |
|---|---|
| [bindLifecycleOwner](bind-lifecycle-owner.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[bindLifecycleOwner](bind-lifecycle-owner.md)(lifecycleOwner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html))<br>绑定 ICoroutine 的生命周期方法 |
| [removeAllScope](remove-all-scope.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[removeAllScope](remove-all-scope.md)()<br>移除 ICoroutine 的所有协程作用域的方法，从 defaultScopeHashMap ,ioScopeHashMap,mainScopeHashMap 中移除对应的协程作用域。 |
| [removeDefaultScope](remove-default-scope.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[removeDefaultScope](remove-default-scope.md)()<br>移除 ICoroutine 的默认协程作用域的方法，从 defaultScopeHashMap 中移除对应的协程作用域。 |
| [removeIoScope](remove-io-scope.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[removeIoScope](remove-io-scope.md)()<br>移除 ICoroutine 的 IO 协程作用域的方法，从 ioScopeHashMap 中移除对应的协程作用域。 |
| [removeMainScope](remove-main-scope.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[removeMainScope](remove-main-scope.md)()<br>移除 ICoroutine 的 Main 协程作用域的方法，从 mainScopeHashMap 中移除对应的协程作用域。 |
| [unbindLifecycleOwner](unbind-lifecycle-owner.md) | [androidJvm]<br>fun [ICoroutine](-i-coroutine/index.md).[unbindLifecycleOwner](unbind-lifecycle-owner.md)(lifecycleOwner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html))<br>解绑 ICoroutine 的生命周期方法 |