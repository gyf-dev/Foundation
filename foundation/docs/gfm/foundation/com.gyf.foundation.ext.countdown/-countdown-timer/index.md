//[foundation](../../../index.md)/[com.gyf.foundation.ext.countdown](../index.md)/[CountdownTimer](index.md)

# CountdownTimer

[androidJvm]\
class [CountdownTimer](index.md)(initialTime: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), onTick: ([Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onCancel: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onFinish: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) : [SimpleLifecycle](../../com.gyf.foundation.lifecycle/-simple-lifecycle/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [CountdownTimer](-countdown-timer.md) | [androidJvm]<br>constructor(initialTime: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), onTick: ([Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onCancel: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onFinish: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [androidJvm]<br>open override fun [create](create.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [destroy](destroy.md) | [androidJvm]<br>open override fun [destroy](destroy.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [onStateChanged](on-state-changed.md) | [androidJvm]<br>open override fun [onStateChanged](on-state-changed.md)(source: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html), event: [Lifecycle.Event](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.Event.html))<br>声明周期 |
| [pause](pause.md) | [androidJvm]<br>open override fun [pause](pause.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [reset](reset.md) | [androidJvm]<br>open override fun [reset](reset.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [resume](resume.md) | [androidJvm]<br>open override fun [resume](resume.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |
| [stop](stop.md) | [androidJvm]<br>open override fun [stop](stop.md)(vararg inParams: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)) |