//[foundation](../../index.md)/[com.gyf.foundation.ext.toast](index.md)/[toast](toast.md)

# toast

[androidJvm]\
fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[toast](toast.md)(msg: [CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息 Show a short duration Toast message

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object

#### Parameters

androidJvm

| | |
|---|---|
| msg | CharSequence 要显示的消息     CharSequence message to be displayed |

[androidJvm]\
fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[toast](toast.md)(@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息（通过资源ID） Show a short duration Toast message (using resource ID)

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object

#### Parameters

androidJvm

| | |
|---|---|
| resId | Int 要显示的消息资源ID     Int resource ID of the message to be displayed |

[androidJvm]\
fun [toast](toast.md)(msg: [CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息（使用全局上下文） Show a short duration Toast message (using global context)

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object

#### Parameters

androidJvm

| | |
|---|---|
| msg | CharSequence 要显示的消息     CharSequence message to be displayed |

[androidJvm]\
fun [toast](toast.md)(@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息（通过资源ID，使用全局上下文） Show a short duration Toast message (using resource ID and global context)

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object

#### Parameters

androidJvm

| | |
|---|---|
| resId | Int 要显示的消息资源ID     Int resource ID of the message to be displayed |

[androidJvm]\
val [CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html).[toast](toast.md): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息的属性扩展 Property extension to show a short duration Toast message

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object

[androidJvm]\
val [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html).[toast](toast.md): [Toast](https://developer.android.com/reference/kotlin/android/widget/Toast.html)

短时间显示Toast消息的属性扩展（通过资源ID） Property extension to show a short duration Toast message (using resource ID)

#### Return

Toast 返回显示的Toast对象     Returns the displayed Toast object