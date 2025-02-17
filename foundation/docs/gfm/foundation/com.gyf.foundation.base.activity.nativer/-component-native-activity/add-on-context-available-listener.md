//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[addOnContextAvailableListener](add-on-context-available-listener.md)

# addOnContextAvailableListener

[androidJvm]\
fun [addOnContextAvailableListener](add-on-context-available-listener.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)listener: [OnContextAvailableListener](https://developer.android.com/reference/kotlin/androidx/activity/contextaware/OnContextAvailableListener.html))

 Any listener added here will receive a callback as part of `super.onCreate()`, but importantly before any other logic is done (including calling through to the framework [onCreate](https://developer.android.com/reference/kotlin/android/app/Activity.html#oncreate) with the exception of restoring the state of the [SavedStateRegistry](get-saved-state-registry.md) for use in your listener.