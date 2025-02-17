//[foundation](../../../index.md)/[com.gyf.foundation.ext.flow](../index.md)/[StateFlowWrapper](index.md)

# StateFlowWrapper

[androidJvm]\
class [StateFlowWrapper](index.md)&lt;[T](index.md)&gt;(initializer: () -&gt; [T](index.md))

StateFlowWrapper 类，包含了一个 StateFlowDelegate 实例

## Constructors

| | |
|---|---|
| [StateFlowWrapper](-state-flow-wrapper.md) | [androidJvm]<br>constructor(initializer: () -&gt; [T](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [flow](flow.md) | [androidJvm]<br>val [flow](flow.md): StateFlow&lt;[T](index.md)&gt;<br>获取 delegate 的 flow |
| [stateFlow](state-flow.md) | [androidJvm]<br>val [stateFlow](state-flow.md): MutableStateFlow&lt;[T](index.md)&gt;<br>获取 delegate 的 stateFlow |
| [value](value.md) | [androidJvm]<br>var [value](value.md): [T](index.md)<br>使用 delegate 作为 value 的委托 |