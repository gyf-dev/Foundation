//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[dump](dump.md)

# dump

[androidJvm]\
open fun [dump](dump.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)prefix: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)fd: [FileDescriptor](https://developer.android.com/reference/kotlin/java/io/FileDescriptor.html), @[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)writer: [PrintWriter](https://developer.android.com/reference/kotlin/java/io/PrintWriter.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)args: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;)

Print the Activity's state into the given stream. This gets invoked if you run &quot;adb shell dumpsys activity &quot;.

#### Parameters

androidJvm

| | |
|---|---|
| prefix | Desired prefix to prepend at each line of output. |
| fd | The raw file descriptor that the dump is being sent to. |
| writer | The PrintWriter to which you should dump your state. This will be closed for you after you return. |
| args | additional arguments to the dump request. |