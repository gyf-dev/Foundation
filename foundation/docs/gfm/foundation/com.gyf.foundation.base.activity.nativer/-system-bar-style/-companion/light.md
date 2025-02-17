//[foundation](../../../../index.md)/[com.gyf.foundation.base.activity.nativer](../../index.md)/[SystemBarStyle](../index.md)/[Companion](index.md)/[light](light.md)

# light

[androidJvm]\

@[JvmStatic](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-static/index.html)

fun [light](light.md)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)scrim: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)darkScrim: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [SystemBarStyle](../index.md)

Creates a new instance of [SystemBarStyle](../index.md). This style consistently applies the specified scrim color regardless of the system navigation mode.

#### Parameters

androidJvm

| | |
|---|---|
| scrim | The scrim color to be used for the background. It is expected to be light for the contrast against the dark system icons. |
| darkScrim | The scrim color to be used for the background on devices where the system icon color is always light. It is expected to be dark. |