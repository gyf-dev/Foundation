//[foundation](../../index.md)/[com.gyf.foundation.ext.log](index.md)/[log](log.md)

# log

[androidJvm]\
fun [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[log](log.md)(tag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), logLevel: [LogLevel](-log-level/index.md) = LogLevel.D, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, saveLogger: [Logger](-logger/index.md)? = null)

字符串的日志打印扩展函数。

#### Receiver

String

#### Parameters

androidJvm

| | |
|---|---|
| tag | String 日志标签 |
| logLevel | LogLevel 日志级别，默认为 LogLevel.D |
| enabled | Boolean 是否启用日志，默认为 true |
| saveLogger | Logger 日志保存的位置，默认为 logger |

[androidJvm]\
fun [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md)(tag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), logLevel: [LogLevel](-log-level/index.md) = LogLevel.D, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, saveLogger: [Logger](-logger/index.md)? = null)

任意对象的日志打印扩展函数。

#### Receiver

Any?

#### Parameters

androidJvm

| | |
|---|---|
| tag | String 日志标签 |
| logLevel | LogLevel 日志级别，默认为 LogLevel.D |
| enabled | Boolean 是否启用日志，默认为 true |
| saveLogger | Logger 日志保存的位置，默认为 logger |