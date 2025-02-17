//[foundation](../../../index.md)/[[root]](../index.md)/[ConfigurationMonitor](index.md)

# ConfigurationMonitor

[androidJvm]\
class [ConfigurationMonitor](index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AbsMonitor](../../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)&gt; 

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [ConfigurationMonitor](-configuration-monitor.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [configurationFlow](configuration-flow.md) | [androidJvm]<br>val [configurationFlow](configuration-flow.md): StateFlow&lt;[Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)&gt; |
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [localeFlow](locale-flow.md) | [androidJvm]<br>val [localeFlow](locale-flow.md): StateFlow&lt;[Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)&gt; |
| [nightModeFlow](night-mode-flow.md) | [androidJvm]<br>val [nightModeFlow](night-mode-flow.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addOnConfigurationChangedListener](add-on-configuration-changed-listener.md) | [androidJvm]<br>fun [addOnConfigurationChangedListener](add-on-configuration-changed-listener.md)(listener: ([Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |
| [addOnLocaleChangedListener](add-on-locale-changed-listener.md) | [androidJvm]<br>fun [addOnLocaleChangedListener](add-on-locale-changed-listener.md)(listener: ([Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |
| [addOnNightModeChangedListener](add-on-night-mode-changed-listener.md) | [androidJvm]<br>fun [addOnNightModeChangedListener](add-on-night-mode-changed-listener.md)(listener: ([Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |
| [removeOnConfigurationChangedListener](remove-on-configuration-changed-listener.md) | [androidJvm]<br>fun [removeOnConfigurationChangedListener](remove-on-configuration-changed-listener.md)(listener: ([Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |
| [removeOnLocaleChangedListener](remove-on-locale-changed-listener.md) | [androidJvm]<br>fun [removeOnLocaleChangedListener](remove-on-locale-changed-listener.md)(listener: ([Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |
| [removeOnNightModeChangedListener](remove-on-night-mode-changed-listener.md) | [androidJvm]<br>fun [removeOnNightModeChangedListener](remove-on-night-mode-changed-listener.md)(listener: ([Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ConfigurationMonitor](index.md) |