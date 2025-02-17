//[foundation](../../../index.md)/[com.gyf.foundation.provider](../index.md)/[DefaultContentProvider](index.md)

# DefaultContentProvider

open class [DefaultContentProvider](index.md) : [ContentProvider](https://developer.android.com/reference/kotlin/android/content/ContentProvider.html)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [FoundationContentProvider](../-foundation-content-provider/index.md) |

## Constructors

| | |
|---|---|
| [DefaultContentProvider](-default-content-provider.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>open override fun [delete](delete.md)(uri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), selection: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, selectionArgs: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;?): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [getType](get-type.md) | [androidJvm]<br>open override fun [getType](get-type.md)(uri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? |
| [insert](insert.md) | [androidJvm]<br>open override fun [insert](insert.md)(uri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), values: [ContentValues](https://developer.android.com/reference/kotlin/android/content/ContentValues.html)?): [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html)? |
| [onCreate](on-create.md) | [androidJvm]<br>open override fun [onCreate](on-create.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [query](query.md) | [androidJvm]<br>open override fun [query](query.md)(uri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), projection: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;?, selection: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, selectionArgs: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;?, sortOrder: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html)? |
| [update](update.md) | [androidJvm]<br>open override fun [update](update.md)(uri: [Uri](https://developer.android.com/reference/kotlin/android/net/Uri.html), values: [ContentValues](https://developer.android.com/reference/kotlin/android/content/ContentValues.html)?, selection: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, selectionArgs: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;?): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |