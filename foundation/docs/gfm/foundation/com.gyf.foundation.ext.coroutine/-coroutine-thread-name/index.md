//[foundation](../../../index.md)/[com.gyf.foundation.ext.coroutine](../index.md)/[CoroutineThreadName](index.md)

# CoroutineThreadName

[androidJvm]\
class [CoroutineThreadName](index.md)(val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [AbstractCoroutineContextElement](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html), ThreadContextElement&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; 

CoroutineThreadName 类用于管理协程的线程名称。 它实现了 ThreadContextElement 接口，可以在协程上下文中保存和恢复线程名称。

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [CoroutineThreadName](-coroutine-thread-name.md) | [androidJvm]<br>constructor(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Key](-key/index.md) | [androidJvm]<br>object [Key](-key/index.md) : [CoroutineContext.Key](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)&lt;[CoroutineThreadName](index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>线程名称。 |

## Functions

| Name | Summary |
|---|---|
| [restoreThreadContext](restore-thread-context.md) | [androidJvm]<br>open override fun [restoreThreadContext](restore-thread-context.md)(context: [CoroutineContext](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html), oldState: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>恢复线程上下文的方法，将当前线程的名称设置为旧的名称。 |
| [updateThreadContext](update-thread-context.md) | [androidJvm]<br>open override fun [updateThreadContext](update-thread-context.md)(context: [CoroutineContext](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>更新线程上下文的方法，将当前线程的名称设置为新的名称，并返回旧的名称。 |