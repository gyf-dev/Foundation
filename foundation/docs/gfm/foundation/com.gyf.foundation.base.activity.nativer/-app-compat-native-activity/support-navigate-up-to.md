//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[supportNavigateUpTo](support-navigate-up-to.md)

# supportNavigateUpTo

[androidJvm]\
open fun [supportNavigateUpTo](support-navigate-up-to.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)upIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html))

Navigate from sourceActivity to the activity specified by upIntent, finishing sourceActivity in the process. upIntent will have the flag [FLAG_ACTIVITY_CLEAR_TOP](https://developer.android.com/reference/kotlin/android/content/Intent.html#flag_activity_clear_top) set by this method, along with any others required for proper up navigation as outlined in the Android Design Guide. 

This method should be used when performing up navigation from within the same task as the destination. If up navigation should cross tasks in some cases, see [supportShouldUpRecreateTask](support-should-up-recreate-task.md).

#### Parameters

androidJvm

| | |
|---|---|
| upIntent | An intent representing the target destination for up navigation |