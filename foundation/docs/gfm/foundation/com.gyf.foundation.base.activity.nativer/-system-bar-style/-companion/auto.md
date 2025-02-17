//[foundation](../../../../index.md)/[com.gyf.foundation.base.activity.nativer](../../index.md)/[SystemBarStyle](../index.md)/[Companion](index.md)/[auto](auto.md)

# auto

[androidJvm]\

@[JvmStatic](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-static/index.html)

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [auto](auto.md)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)lightScrim: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)darkScrim: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), detectDarkMode: ([Resources](https://developer.android.com/reference/kotlin/android/content/res/Resources.html)) -&gt; [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = { resources -&gt;
                (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                        Configuration.UI_MODE_NIGHT_YES
            }): [SystemBarStyle](../index.md)

Creates a new instance of [SystemBarStyle](../index.md). This style detects the dark mode automatically.

- 
   On API level 29 and above, the bar will be transparent in the gesture navigation mode. If this is used for the navigation bar, it will have the scrim automatically applied by the system in the 3-button navigation mode. *Note that neither of the specified colors are used*. If you really want a custom color on these API levels, use [dark](dark.md) or [light](light.md).
- 
   On API level 28 and below, the bar will be one of the specified scrim colors depending on the dark mode.

#### Parameters

androidJvm

| | |
|---|---|
| lightScrim | The scrim color to be used for the background when the app is in light mode. |
| darkScrim | The scrim color to be used for the background when the app is in dark mode. This is also used on devices where the system icon color is always light. |
| detectDarkMode | Optional. Detects whether UI currently uses dark mode or not. The default implementation can detect any of the standard dark mode features from the platform, appcompat, and Jetpack Compose. |