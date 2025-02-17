//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[getDefaultViewModelCreationExtras](get-default-view-model-creation-extras.md)

# getDefaultViewModelCreationExtras

[androidJvm]\

@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [getDefaultViewModelCreationExtras](get-default-view-model-creation-extras.md)(): [CreationExtras](https://developer.android.com/reference/kotlin/androidx/lifecycle/viewmodel/CreationExtras.html)

The extras of [getIntent](https://developer.android.com/reference/kotlin/android/app/Activity.html#getintent) when this is first called will be used as the defaults to any [androidx.lifecycle.SavedStateHandle](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle.html) passed to a view model created using this extra.