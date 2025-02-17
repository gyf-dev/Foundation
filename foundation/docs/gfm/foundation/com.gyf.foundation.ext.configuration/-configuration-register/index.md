//[foundation](../../../index.md)/[com.gyf.foundation.ext.configuration](../index.md)/[ConfigurationRegister](index.md)

# ConfigurationRegister

[androidJvm]\
class [ConfigurationRegister](index.md)(val configurationOwner: [ConfigurationOwner](../-configuration-owner/index.md)) : [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [ConfigurationRegister](-configuration-register.md) | [androidJvm]<br>constructor(configurationOwner: [ConfigurationOwner](../-configuration-owner/index.md)) |

## Types

| Name | Summary |
|---|---|
| [ContextWrapper](-context-wrapper/index.md) | [androidJvm]<br>inner class [ContextWrapper](-context-wrapper/index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ConfigurationOwner](../-configuration-owner/index.md) |

## Properties

| Name | Summary |
|---|---|
| [configurationOwner](configuration-owner.md) | [androidJvm]<br>val [configurationOwner](configuration-owner.md): [ConfigurationOwner](../-configuration-owner/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delegate](delegate.md) | [androidJvm]<br>fun [delegate](delegate.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [ConfigurationRegister](index.md) |
| [dispatchConfigurationChanged](dispatch-configuration-changed.md) | [androidJvm]<br>fun [dispatchConfigurationChanged](dispatch-configuration-changed.md)(configuration: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [register](register.md) | [androidJvm]<br>fun [register](register.md)() |
| [setAppCompatSameComponentEnabled](set-app-compat-same-component-enabled.md) | [androidJvm]<br>fun [setAppCompatSameComponentEnabled](set-app-compat-same-component-enabled.md)(enable: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [ConfigurationRegister](index.md) |
| [unregister](unregister.md) | [androidJvm]<br>fun [unregister](unregister.md)() |