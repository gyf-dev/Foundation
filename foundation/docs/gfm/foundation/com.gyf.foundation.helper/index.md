//[foundation](../../index.md)/[com.gyf.foundation.helper](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ChannelHelper](-channel-helper/index.md) | [androidJvm]<br>open class [ChannelHelper](-channel-helper/index.md)&lt;[T](-channel-helper/index.md)&gt;(val scope: CoroutineScope) : [ITag](../com.gyf.foundation.ext.log/-i-tag/index.md) |
| [FlowTextHelper](-flow-text-helper/index.md) | [androidJvm]<br>class [FlowTextHelper](-flow-text-helper/index.md) : [ChannelHelper](-channel-helper/index.md)&lt;[CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)&gt; |
| [TypewriterEffectHelper](-typewriter-effect-helper/index.md) | [androidJvm]<br>class [TypewriterEffectHelper](-typewriter-effect-helper/index.md)(var typingDelay: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 30, var onUpdateText: ([CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, var onComplete: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, var onNewLine: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) : [ICoroutine](../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)<br>打字机效果类，用于实现文本的逐字显示动画效果。 Typewriter effect class for implementing character-by-character text animation. |