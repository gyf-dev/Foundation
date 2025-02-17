//[foundation](../../../index.md)/[com.gyf.foundation.queue](../index.md)/[MessageQueueHandler](index.md)

# MessageQueueHandler

[androidJvm]\
class [MessageQueueHandler](index.md)(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), condition: () -&gt; [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), doQueue: (what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), obj: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [MessageQueueHandler](-message-queue-handler.md) | [androidJvm]<br>constructor(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), condition: () -&gt; [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), doQueue: (what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), obj: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>fun [clear](clear.md)()<br>清空消息队列 |
| [queue](queue.md) | [androidJvm]<br>fun [queue](queue.md)(what: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), obj: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?)<br>将消息加入队列 |
| [start](start.md) | [androidJvm]<br>fun [start](start.md)()<br>启动HandlerThread |
| [stop](stop.md) | [androidJvm]<br>fun [stop](stop.md)()<br>停止处理队列 |