//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[startIntentSenderFromFragment](start-intent-sender-from-fragment.md)

# startIntentSenderFromFragment

[androidJvm]\
open fun [~~startIntentSenderFromFragment~~](start-intent-sender-from-fragment.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), intent: [IntentSender](https://developer.android.com/reference/kotlin/android/content/IntentSender.html), requestCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)fillInIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), flagsMask: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), flagsValues: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), extraFlags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)options: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html))

---

### Deprecated

Fragments should use [registerForActivityResult](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html#registerforactivityresult) with the [ActivityResultContracts.StartIntentSenderForResult](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContracts.StartIntentSenderForResult.html) contract. This method will still be called when Fragments call the deprecated `startIntentSenderForResult()` method.

---

Called by Fragment.startIntentSenderForResult() to implement its behavior.

#### Parameters

androidJvm

| | |
|---|---|
| fragment | the Fragment to start the intent sender from. |
| intent | The IntentSender to launch. |
| requestCode | The request code to be returned in [onActivityResult](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html#onactivityresult) when the activity exits. Must be between 0 and 65535 to be considered valid. If given requestCode is greater than 65535, an IllegalArgumentException would be thrown. |
| fillInIntent | If non-null, this will be provided as the intent parameter to [sendIntent](https://developer.android.com/reference/kotlin/android/content/IntentSender.html#sendintent). This value may be null. |
| flagsMask | Intent flags in the original IntentSender that you would like to change. |
| flagsValues | Desired values for any bits set in `flagsMask`. |
| extraFlags | Always set to 0. |
| options | Additional options for how the Activity should be started. See [startActivity](https://developer.android.com/reference/kotlin/android/content/Context.html#startactivity) for more details. This value may be null. |

#### Throws

| | |
|---|---|
| [IntentSender.SendIntentException](https://developer.android.com/reference/kotlin/android/content/IntentSender.SendIntentException.html) | if the call fails to execute. |