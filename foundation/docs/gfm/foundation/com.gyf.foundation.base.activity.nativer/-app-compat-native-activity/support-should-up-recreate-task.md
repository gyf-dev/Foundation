//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[supportShouldUpRecreateTask](support-should-up-recreate-task.md)

# supportShouldUpRecreateTask

[androidJvm]\
open fun [supportShouldUpRecreateTask](support-should-up-recreate-task.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)targetIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Returns true if sourceActivity should recreate the task when navigating 'up' by using targetIntent. 

If this method returns false the app can trivially call [supportNavigateUpTo](support-navigate-up-to.md) using the same parameters to correctly perform up navigation. If this method returns false, the app should synthesize a new task stack by using [TaskStackBuilder](https://developer.android.com/reference/kotlin/androidx/core/app/TaskStackBuilder.html) or another similar mechanism to perform up navigation.

#### Return

true if navigating up should recreate a new task stack, false if the same task should be used for the destination

#### Parameters

androidJvm

| | |
|---|---|
| targetIntent | An intent representing the target destination for up navigation |