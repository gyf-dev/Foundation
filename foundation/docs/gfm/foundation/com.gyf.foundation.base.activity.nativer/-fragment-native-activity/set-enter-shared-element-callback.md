//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[setEnterSharedElementCallback](set-enter-shared-element-callback.md)

# setEnterSharedElementCallback

[androidJvm]\
open fun [setEnterSharedElementCallback](set-enter-shared-element-callback.md)(@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)callback: [SharedElementCallback](https://developer.android.com/reference/kotlin/androidx/core/app/SharedElementCallback.html))

When [makeSceneTransitionAnimation](https://developer.android.com/reference/kotlin/android/app/ActivityOptions.html#makescenetransitionanimation) was used to start an Activity, callback will be called to handle shared elements on the *launched* Activity. This requires [FEATURE_CONTENT_TRANSITIONS](https://developer.android.com/reference/kotlin/android/view/Window.html#feature_content_transitions).

#### Parameters

androidJvm

| | |
|---|---|
| callback | Used to manipulate shared element transitions on the launched Activity. |