//[foundation](../../../index.md)/[com.gyf.foundation.ext.log](../index.md)/[ITag](index.md)

# ITag

interface [ITag](index.md)

ITag 接口定义了日志标签和日志级别的获取方式，以及日志的打印方法。

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [BaseNativeActivity](../../com.gyf.foundation.base.activity.nativer/-base-native-activity/index.md) |
| [BaseActivity](../../com.gyf.foundation.base.activity/-base-activity/index.md) |
| [BaseAdapter](../../com.gyf.foundation.base.adapter/-base-adapter/index.md) |
| [BaseBindingAdapter](../../com.gyf.foundation.base.adapter/-base-binding-adapter/index.md) |
| [BaseMultiBindingAdapter](../../com.gyf.foundation.base.adapter/-base-multi-binding-adapter/index.md) |
| [BaseQuickMultiBindingAdapter](../../com.gyf.foundation.base.adapter/-base-quick-multi-binding-adapter/index.md) |
| [OnBindingAdapter](../../com.gyf.foundation.base.adapter/-on-binding-adapter/index.md) |
| [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md) |
| [BaseViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-view-holder/index.md) |
| [BaseFragment](../../com.gyf.foundation.base.fragment/-base-fragment/index.md) |
| [BaseWindow](../../com.gyf.foundation.base.window/-base-window/index.md) |
| [Blur](../../com.gyf.foundation.blur/-blur/index.md) |
| [BlurItemDecoration](../../com.gyf.foundation.blur/-blur-item-decoration/index.md) |
| [ConfigurationRegister](../../com.gyf.foundation.ext.configuration/-configuration-register/index.md) |
| [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md) |
| [ChannelHelper](../../com.gyf.foundation.helper/-channel-helper/index.md) |
| [FeatherEffectTextView](../../com.gyf.foundation.view/-feather-effect-text-view/index.md) |
| [Window](../../com.gyf.foundation.window/-window/index.md) |

## Properties

| Name | Summary |
|---|---|
| [enableLog](enable-log.md) | [androidJvm]<br>open val [enableLog](enable-log.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>获取是否启用日志，缺省值为 true。 |
| [log](log.md) | [androidJvm]<br>open val [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md): [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)<br>打印日志，缺省值为 log()。 |
| [logLevel](log-level.md) | [androidJvm]<br>open val [logLevel](log-level.md): [LogLevel](../-log-level/index.md)<br>获取日志级别，缺省值为 LogLevel.D。 |
| [tagName](tag-name.md) | [androidJvm]<br>open val [tagName](tag-name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>获取日志标签，缺省值为类名。 |

## Functions

| Name | Summary |
|---|---|
| [log](log.md) | [androidJvm]<br>open fun [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md)(logLevel: [LogLevel](../-log-level/index.md) = this@ITag.logLevel, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = this@ITag.enableLog, saveLogger: [Logger](../-logger/index.md)? = null)<br>打印日志的方法，可以指定日志级别、是否启用日志以及日志保存的位置。 |