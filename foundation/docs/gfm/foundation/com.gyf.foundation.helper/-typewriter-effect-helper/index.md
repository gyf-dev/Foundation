//[foundation](../../../index.md)/[com.gyf.foundation.helper](../index.md)/[TypewriterEffectHelper](index.md)

# TypewriterEffectHelper

[androidJvm]\
class [TypewriterEffectHelper](index.md)(var typingDelay: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 30, var onUpdateText: ([CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, var onComplete: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, var onNewLine: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) : [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)

打字机效果类，用于实现文本的逐字显示动画效果。 Typewriter effect class for implementing character-by-character text animation.

## Constructors

| | |
|---|---|
| [TypewriterEffectHelper](-typewriter-effect-helper.md) | [androidJvm]<br>constructor(typingDelay: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 30, onUpdateText: ([CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onComplete: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null, onNewLine: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [isTyping](is-typing.md) | [androidJvm]<br>val [isTyping](is-typing.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [onComplete](on-complete.md) | [androidJvm]<br>var [onComplete](on-complete.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>动画完成时的回调函数。 Callback function when the animation is complete. |
| [onNewLine](on-new-line.md) | [androidJvm]<br>var [onNewLine](on-new-line.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>新行开始时的回调函数。 Callback function when a new line starts. |
| [onUpdateText](on-update-text.md) | [androidJvm]<br>var [onUpdateText](on-update-text.md): ([CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>文本更新时的回调函数。 Callback function for text updates. |
| [textHeight](text-height.md) | [androidJvm]<br>var [textHeight](text-height.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>文本高度，新行开始时可能会改变。 Text height, may change when a new line starts. |
| [typingDelay](typing-delay.md) | [androidJvm]<br>var [typingDelay](typing-delay.md): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)<br>打字延迟时间，控制动画速度。 Typing delay time in milliseconds, controls the speed of the animation. |

## Functions

| Name | Summary |
|---|---|
| [animateText](animate-text.md) | [androidJvm]<br>fun [animateText](animate-text.md)(txt: [CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html))<br>开始文本动画。 Starts the text animation. |