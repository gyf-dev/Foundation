//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[supportFinishAfterTransition](support-finish-after-transition.md)

# supportFinishAfterTransition

[androidJvm]\
open fun [supportFinishAfterTransition](support-finish-after-transition.md)()

Reverses the Activity Scene entry Transition and triggers the calling Activity to reverse its exit Transition. When the exit Transition completes, [finish](https://developer.android.com/reference/kotlin/android/app/Activity.html#finish) is called. If no entry Transition was used, finish() is called immediately and the Activity exit Transition is run. 

On Android 4.4 or lower, this method only finishes the Activity with no special exit transition.