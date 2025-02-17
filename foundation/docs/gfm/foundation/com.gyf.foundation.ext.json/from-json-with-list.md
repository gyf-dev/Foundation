//[foundation](../../index.md)/[com.gyf.foundation.ext.json](index.md)/[fromJsonWithList](from-json-with-list.md)

# fromJsonWithList

[androidJvm]\
fun &lt;[T](from-json-with-list.md)&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[fromJsonWithList](from-json-with-list.md)(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](from-json-with-list.md)&gt;, defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](from-json-with-list.md)&gt;

转化为List<T>类型

#### Receiver

String json

#### Return

List<T>

#### Parameters

androidJvm

| | |
|---|---|
| clazz | Class<T> 对象的类型 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |

[androidJvm]\
inline fun &lt;[T](from-json-with-list.md)&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).[fromJsonWithList](from-json-with-list.md)(defaultIfNull: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](from-json-with-list.md)&gt;

转化为List<T>类型

#### Receiver

String json

#### Return

List<T>

#### Parameters

androidJvm

| | |
|---|---|
| defaultIfNull | Boolean 如果json字段的值为null，将使用默认值 |