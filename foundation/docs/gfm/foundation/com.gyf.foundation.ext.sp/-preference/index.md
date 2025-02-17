//[foundation](../../../index.md)/[com.gyf.foundation.ext.sp](../index.md)/[Preference](index.md)

# Preference

[androidJvm]\
class [Preference](index.md)&lt;[T](index.md)&gt;(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), defaultValue: [T](index.md)?, clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;, apply: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;fileName&quot;, setBlock: ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) : [ReadWriteProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-write-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [T](index.md)&gt;

## Constructors

| | |
|---|---|
| [Preference](-preference.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), defaultValue: [T](index.md)?, clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;, apply: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;fileName&quot;, setBlock: ([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [androidJvm]<br>open operator override fun [getValue](get-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md) |
| [setValue](set-value.md) | [androidJvm]<br>open operator override fun [setValue](set-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md)) |