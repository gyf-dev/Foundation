//[foundation](../../../index.md)/[com.gyf.foundation.helper](../index.md)/[ChannelHelper](index.md)

# ChannelHelper

open class [ChannelHelper](index.md)&lt;[T](index.md)&gt;(val scope: CoroutineScope) : [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [FlowTextHelper](../-flow-text-helper/index.md) |

## Constructors

| | |
|---|---|
| [ChannelHelper](-channel-helper.md) | [androidJvm]<br>constructor(scope: CoroutineScope) |

## Properties

| Name | Summary |
|---|---|
| [interval](interval.md) | [androidJvm]<br>var [interval](interval.md): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) |
| [isEnd](is-end.md) | [androidJvm]<br>val [isEnd](is-end.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isRunning](is-running.md) | [androidJvm]<br>val [isRunning](is-running.md): [AtomicBoolean](https://developer.android.com/reference/kotlin/java/util/concurrent/atomic/AtomicBoolean.html) |
| [maskEnd](mask-end.md) | [androidJvm]<br>var [maskEnd](mask-end.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onBinding](on-binding.md) | [androidJvm]<br>var [onBinding](on-binding.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onCollect](on-collect.md) | [androidJvm]<br>var [onCollect](on-collect.md): suspend ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onEnd](on-end.md) | [androidJvm]<br>var [onEnd](on-end.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onEndJoin](on-end-join.md) | [androidJvm]<br>var [onEndJoin](on-end-join.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onNew](on-new.md) | [androidJvm]<br>var [onNew](on-new.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onStart](on-start.md) | [androidJvm]<br>var [onStart](on-start.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onStartJoin](on-start-join.md) | [androidJvm]<br>var [onStartJoin](on-start-join.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | [androidJvm]<br>var [onStop](on-stop.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onStopJoin](on-stop-join.md) | [androidJvm]<br>var [onStopJoin](on-stop-join.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onUnbinding](on-unbinding.md) | [androidJvm]<br>var [onUnbinding](on-unbinding.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [scope](scope.md) | [androidJvm]<br>val [scope](scope.md): CoroutineScope |

## Functions

| Name | Summary |
|---|---|
| [addOnEndListener](add-on-end-listener.md) | [androidJvm]<br>fun [addOnEndListener](add-on-end-listener.md)(listener: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [addOnTextListener](add-on-text-listener.md) | [androidJvm]<br>fun [addOnTextListener](add-on-text-listener.md)(listener: ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [bind](bind.md) | [androidJvm]<br>fun [bind](bind.md)(autoUnbind: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onTextListener: ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onEndListener: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [cancel](cancel.md) | [androidJvm]<br>fun [cancel](cancel.md)(): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [end](end.md) | [androidJvm]<br>fun [end](end.md)(): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [endJoin](end-join.md) | [androidJvm]<br>suspend fun [endJoin](end-join.md)(): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [new](new.md) | [androidJvm]<br>fun [new](new.md)(): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [removeOnEndListener](remove-on-end-listener.md) | [androidJvm]<br>fun [removeOnEndListener](remove-on-end-listener.md)(listener: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [removeOnTextListener](remove-on-text-listener.md) | [androidJvm]<br>fun [removeOnTextListener](remove-on-text-listener.md)(listener: ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [send](send.md) | [androidJvm]<br>fun [send](send.md)(element: [T](index.md)?): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [start](start.md) | [androidJvm]<br>fun [start](start.md)(from: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;start&quot;): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [startJoin](start-join.md) | [androidJvm]<br>suspend fun [startJoin](start-join.md)(from: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;startJoin&quot;): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [stop](stop.md) | [androidJvm]<br>fun [stop](stop.md)(from: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;stop&quot;): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [stopJoin](stop-join.md) | [androidJvm]<br>suspend fun [stopJoin](stop-join.md)(from: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;stopJoin&quot;): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |
| [unbind](unbind.md) | [androidJvm]<br>fun [unbind](unbind.md)(): [ChannelHelper](index.md)&lt;[T](index.md)&gt; |