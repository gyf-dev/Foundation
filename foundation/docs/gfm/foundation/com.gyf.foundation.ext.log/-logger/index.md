//[foundation](../../../index.md)/[com.gyf.foundation.ext.log](../index.md)/[Logger](index.md)

# Logger

[androidJvm]\
class [Logger](index.md)(dirName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)

Logger类用于管理日志的写入和读取。 它实现了ICoroutine接口，可以在协程中进行日志操作。

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [Logger](-logger.md) | [androidJvm]<br>constructor(dirName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [read](read.md) | [androidJvm]<br>fun [read](read.md)(date: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>读取日志方法，根据日期读取日志文件。<br>[androidJvm]<br>fun [read](read.md)(date: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), block: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>异步读取日志方法，根据日期读取日志文件，并在读取完成后调用回调函数。 |
| [readBySuspend](read-by-suspend.md) | [androidJvm]<br>suspend fun [readBySuspend](read-by-suspend.md)(date: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>协程版本的读取日志方法，根据日期读取日志文件。 |
| [write](write.md) | [androidJvm]<br>fun [write](write.md)(tag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>写入日志方法，将标签和消息写入日志文件。 |