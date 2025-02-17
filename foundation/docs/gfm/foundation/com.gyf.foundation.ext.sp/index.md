//[foundation](../../index.md)/[com.gyf.foundation.ext.sp](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Preference](-preference/index.md) | [androidJvm]<br>class [Preference](-preference/index.md)&lt;[T](-preference/index.md)&gt;(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), defaultValue: [T](-preference/index.md)?, clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](-preference/index.md)&gt;, apply: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;fileName&quot;, setBlock: ([T](-preference/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) : [ReadWriteProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-write-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [T](-preference/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [sp](sp.md) | [androidJvm]<br>inline fun &lt;[R](sp.md), [T](sp.md)&gt; [R](sp.md).[sp](sp.md)(defaultValue: [T](sp.md)? = null, apply: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, noinline after: ([T](sp.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [Preference](-preference/index.md)&lt;[T](sp.md)&gt;<br>SharedPreferences扩展函数 |