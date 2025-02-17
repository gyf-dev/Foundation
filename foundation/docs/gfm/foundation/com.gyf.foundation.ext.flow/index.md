//[foundation](../../index.md)/[com.gyf.foundation.ext.flow](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [StateFlowDelegate](-state-flow-delegate/index.md) | [androidJvm]<br>class [StateFlowDelegate](-state-flow-delegate/index.md)&lt;[T](-state-flow-delegate/index.md)&gt;(initializer: () -&gt; [T](-state-flow-delegate/index.md)) : [ReadWriteProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-write-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [T](-state-flow-delegate/index.md)&gt; , [StateFlowProvider](-state-flow-provider/index.md)&lt;[T](-state-flow-delegate/index.md)&gt; <br>StateFlowDelegate 类，实现了 ReadWriteProperty 接口和 StateFlowProvider 接口 |
| [StateFlowProvider](-state-flow-provider/index.md) | [androidJvm]<br>interface [StateFlowProvider](-state-flow-provider/index.md)&lt;[T](-state-flow-provider/index.md)&gt;<br>定义一个接口，该接口提供了一个 asFlow 方法，用于将对象转换为 StateFlow |
| [StateFlowWrapper](-state-flow-wrapper/index.md) | [androidJvm]<br>class [StateFlowWrapper](-state-flow-wrapper/index.md)&lt;[T](-state-flow-wrapper/index.md)&gt;(initializer: () -&gt; [T](-state-flow-wrapper/index.md))<br>StateFlowWrapper 类，包含了一个 StateFlowDelegate 实例 |
| [StateFlowWrapperDelegate](-state-flow-wrapper-delegate/index.md) | [androidJvm]<br>class [StateFlowWrapperDelegate](-state-flow-wrapper-delegate/index.md)&lt;[T](-state-flow-wrapper-delegate/index.md)&gt;(initializer: () -&gt; [T](-state-flow-wrapper-delegate/index.md))<br>StateFlowWrapperDelegate 类，包含了一个 StateFlowWrapper 实例 |

## Functions

| Name | Summary |
|---|---|
| [stateFlow](state-flow.md) | [androidJvm]<br>fun &lt;[T](state-flow.md)&gt; [stateFlow](state-flow.md)(value: [T](state-flow.md)): [StateFlowWrapperDelegate](-state-flow-wrapper-delegate/index.md)&lt;[T](state-flow.md)&gt;<br>fun &lt;[T](state-flow.md)&gt; [stateFlow](state-flow.md)(initializer: () -&gt; [T](state-flow.md)): [StateFlowWrapperDelegate](-state-flow-wrapper-delegate/index.md)&lt;[T](state-flow.md)&gt;<br>创建一个 StateFlowWrapperDelegate 实例 |
| [stateFlowDelegate](state-flow-delegate.md) | [androidJvm]<br>fun &lt;[T](state-flow-delegate.md)&gt; [stateFlowDelegate](state-flow-delegate.md)(value: [T](state-flow-delegate.md)): [StateFlowDelegate](-state-flow-delegate/index.md)&lt;[T](state-flow-delegate.md)&gt;<br>fun &lt;[T](state-flow-delegate.md)&gt; [stateFlowDelegate](state-flow-delegate.md)(initializer: () -&gt; [T](state-flow-delegate.md)): [StateFlowDelegate](-state-flow-delegate/index.md)&lt;[T](state-flow-delegate.md)&gt;<br>创建一个 StateFlowDelegate 实例 |