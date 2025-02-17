//[foundation](../../index.md)/[com.gyf.foundation.ext.log](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ITag](-i-tag/index.md) | [androidJvm]<br>interface [ITag](-i-tag/index.md)<br>ITag 接口定义了日志标签和日志级别的获取方式，以及日志的打印方法。 |
| [Logger](-logger/index.md) | [androidJvm]<br>class [Logger](-logger/index.md)(dirName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [ICoroutine](../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)<br>Logger类用于管理日志的写入和读取。 它实现了ICoroutine接口，可以在协程中进行日志操作。 |
| [LogLevel](-log-level/index.md) | [androidJvm]<br>sealed class [LogLevel](-log-level/index.md)<br>LogLevel 是一个封闭类，代表日志级别。 它有四个数据对象：D、I、W、E，分别代表 Debug、Info、Warning 和 Error。 |

## Functions

| Name | Summary |
|---|---|
| [log](log.md) | [androidJvm]<br>fun [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?.[log](log.md)(tag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), logLevel: [LogLevel](-log-level/index.md) = LogLevel.D, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, saveLogger: [Logger](-logger/index.md)? = null)<br>任意对象的日志打印扩展函数。<br>[androidJvm]<br>fun [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[log](log.md)(tag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), logLevel: [LogLevel](-log-level/index.md) = LogLevel.D, enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, saveLogger: [Logger](-logger/index.md)? = null)<br>字符串的日志打印扩展函数。 |