//[foundation](../../../index.md)/[com.gyf.foundation.ext.coroutine](../index.md)/[CoroutineThreadName](index.md)/[restoreThreadContext](restore-thread-context.md)

# restoreThreadContext

[androidJvm]\
open override fun [restoreThreadContext](restore-thread-context.md)(context: [CoroutineContext](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines/-coroutine-context/index.html), oldState: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

恢复线程上下文的方法，将当前线程的名称设置为旧的名称。

#### Parameters

androidJvm

| | |
|---|---|
| context | 协程上下文。 |
| oldState | 旧的线程名称。 |