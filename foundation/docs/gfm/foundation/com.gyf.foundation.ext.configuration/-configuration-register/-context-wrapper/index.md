//[foundation](../../../../index.md)/[com.gyf.foundation.ext.configuration](../../index.md)/[ConfigurationRegister](../index.md)/[ContextWrapper](index.md)

# ContextWrapper

[androidJvm]\
inner class [ContextWrapper](index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ConfigurationOwner](../../-configuration-owner/index.md)

## Constructors

| | |
|---|---|
| [ContextWrapper](-context-wrapper.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |

## Functions

| Name | Summary |
|---|---|
| [onConfigChanged](on-config-changed.md) | [androidJvm]<br>open override fun [onConfigChanged](on-config-changed.md)(configuration: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [onLocaleChanged](on-locale-changed.md) | [androidJvm]<br>open override fun [onLocaleChanged](on-locale-changed.md)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) |
| [onNightModeChanged](on-night-mode-changed.md) | [androidJvm]<br>open override fun [onNightModeChanged](on-night-mode-changed.md)(nightMode: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) |
| [onOrientationChanged](on-orientation-changed.md) | [androidJvm]<br>open override fun [onOrientationChanged](on-orientation-changed.md)(orientation: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |