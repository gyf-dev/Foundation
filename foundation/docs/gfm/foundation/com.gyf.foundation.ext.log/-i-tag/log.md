//[foundation](../../../index.md)/[com.gyf.foundation.ext.log](../index.md)/[ITag](index.md)/[log](log.md)

# log

[androidJvm]\
open fun [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md)(logLevel: [LogLevel](../-log-level/index.md) = this@ITag.logLevel, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = this@ITag.enableLog, saveLogger: [Logger](../-logger/index.md)? = null)

打印日志的方法，可以指定日志级别、是否启用日志以及日志保存的位置。

#### Parameters

androidJvm

| | |
|---|---|
| logLevel | LogLevel 日志级别，默认为接口定义的日志级别。 |
| enabled | Boolean 是否启用日志，默认为接口定义的启用日志。 |
| saveLogger | Logger 日志保存的位置，默认为 logger。 |

[androidJvm]\
open val [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md): [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)

打印日志，缺省值为 log()。