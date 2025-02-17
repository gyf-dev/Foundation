//[foundation](../../../index.md)/[com.gyf.foundation.ext.json](../index.md)/[DefaultIfNullsFactory](index.md)

# DefaultIfNullsFactory

[androidJvm]\
class [DefaultIfNullsFactory](index.md) : JsonAdapter.Factory

DefaultIfNullFactory类是一个JsonAdapter.Factory的实现。 它的主要功能是创建一个新的JsonAdapter，该JsonAdapter可以处理null值。 当从JsonReader读取json值时，如果遇到null值，它会过滤掉这些null值。 在将值写入JsonWriter时，它将委托给下一个适配器来处理。

#### Author

ifan

## Constructors

| | |
|---|---|
| [DefaultIfNullsFactory](-default-if-nulls-factory.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [androidJvm]<br>open override fun [create](create.md)(type: [Type](https://developer.android.com/reference/kotlin/java/lang/reflect/Type.html), annotations: [MutableSet](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-mutable-set/index.html)&lt;out [Annotation](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-annotation/index.html)&gt;, moshi: Moshi): JsonAdapter&lt;*&gt; |