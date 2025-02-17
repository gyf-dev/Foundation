//[foundation](../../../index.md)/[com.gyf.foundation.ext.flow](../index.md)/[StateFlowDelegate](index.md)

# StateFlowDelegate

[androidJvm]\
class [StateFlowDelegate](index.md)&lt;[T](index.md)&gt;(initializer: () -&gt; [T](index.md)) : [ReadWriteProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-write-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [T](index.md)&gt; , [StateFlowProvider](../-state-flow-provider/index.md)&lt;[T](index.md)&gt; 

StateFlowDelegate 类，实现了 ReadWriteProperty 接口和 StateFlowProvider 接口

## Constructors

| | |
|---|---|
| [StateFlowDelegate](-state-flow-delegate.md) | [androidJvm]<br>constructor(initializer: () -&gt; [T](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [asFlow](as-flow.md) | [androidJvm]<br>open override fun [asFlow](as-flow.md)(): StateFlow&lt;[T](index.md)&gt;<br>重写 asFlow 方法，返回 stateFlow |
| [getValue](get-value.md) | [androidJvm]<br>open operator override fun [getValue](get-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>重写 getValue 方法，返回 stateFlow 的当前值 |
| [setValue](set-value.md) | [androidJvm]<br>open operator override fun [setValue](set-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md))<br>重写 setValue 方法，设置 stateFlow 的值 |