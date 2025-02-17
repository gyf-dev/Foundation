//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[setExitSharedElementCallback](set-exit-shared-element-callback.md)

# setExitSharedElementCallback

[androidJvm]\
open fun [setExitSharedElementCallback](set-exit-shared-element-callback.md)(@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)listener: [SharedElementCallback](https://developer.android.com/reference/kotlin/androidx/core/app/SharedElementCallback.html))

When [makeSceneTransitionAnimation](https://developer.android.com/reference/kotlin/android/app/ActivityOptions.html#makescenetransitionanimation) was used to start an Activity, listener will be called to handle shared elements on the *launching* Activity. Most calls will only come when returning from the started Activity. This requires [FEATURE_CONTENT_TRANSITIONS](https://developer.android.com/reference/kotlin/android/view/Window.html#feature_content_transitions).

#### Parameters

androidJvm

| | |
|---|---|
| listener | Used to manipulate shared element transitions on the launching Activity. |