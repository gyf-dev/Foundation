//[foundation](../../../index.md)/[com.gyf.foundation.ext.log](../index.md)/[Logger](index.md)/[read](read.md)

# read

[androidJvm]\
fun [read](read.md)(date: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)

读取日志方法，根据日期读取日志文件。

#### Return

日志文件内容。

#### Parameters

androidJvm

| | |
|---|---|
| date | 日期字符串，格式为&quot;yyyy-MM-dd&quot;。 |

[androidJvm]\
fun [read](read.md)(date: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), block: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

异步读取日志方法，根据日期读取日志文件，并在读取完成后调用回调函数。

#### Parameters

androidJvm

| | |
|---|---|
| date | 日期字符串，格式为&quot;yyyy-MM-dd&quot;。 |
| block | 读取完成后的回调函数。 |