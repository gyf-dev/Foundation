//[foundation](../../index.md)/[com.gyf.foundation.ext.json](index.md)/[fromJsonNotNull](from-json-not-null.md)

# fromJsonNotNull

[androidJvm]\
fun &lt;[T](from-json-not-null.md)&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[fromJsonNotNull](from-json-not-null.md)(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](from-json-not-null.md)&gt;, defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true): [T](from-json-not-null.md)

转化为具体类型

#### Receiver

String json

#### Return

T

#### Parameters

androidJvm

| | |
|---|---|
| clazz | Class<T> 对象的类型 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |

[androidJvm]\
inline fun &lt;[T](from-json-not-null.md)&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[fromJsonNotNull](from-json-not-null.md)(defaultIfNull: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true): [T](from-json-not-null.md)

转化为具体类型

#### Receiver

String json

#### Return

T

#### Parameters

androidJvm

| | |
|---|---|
| defaultIfNull | Boolean 如果json字段的值为null，将使用默认值 |