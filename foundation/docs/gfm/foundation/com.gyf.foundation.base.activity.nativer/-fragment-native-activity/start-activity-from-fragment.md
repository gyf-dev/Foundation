//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[startActivityFromFragment](start-activity-from-fragment.md)

# startActivityFromFragment

[androidJvm]\
open fun [startActivityFromFragment](start-activity-from-fragment.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), requestCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))

Called by Fragment.startActivityForResult() to implement its behavior.

#### Parameters

androidJvm

| | |
|---|---|
| fragment | the Fragment to start the activity from. |
| intent | The intent to start. |
| requestCode | The request code to be returned in [onActivityResult](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html#onactivityresult) when the activity exits. Must be between 0 and 65535 to be considered valid. If given requestCode is greater than 65535, an IllegalArgumentException would be thrown. |

[androidJvm]\
open fun [startActivityFromFragment](start-activity-from-fragment.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), requestCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)options: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))

Called by Fragment.startActivityForResult() to implement its behavior.

#### Parameters

androidJvm

| | |
|---|---|
| fragment | the Fragment to start the activity from. |
| intent | The intent to start. |
| requestCode | The request code to be returned in [onActivityResult](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html#onactivityresult) when the activity exits. Must be between 0 and 65535 to be considered valid. If given requestCode is greater than 65535, an IllegalArgumentException would be thrown. |
| options | Additional options for how the Activity should be started. See [startActivity](https://developer.android.com/reference/kotlin/android/content/Context.html#startactivity) for more details. This value may be null. |