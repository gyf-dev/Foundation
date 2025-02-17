//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[getViewModelStore](get-view-model-store.md)

# getViewModelStore

[androidJvm]\

@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)

open fun [getViewModelStore](get-view-model-store.md)(): [ViewModelStore](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStore.html)

Returns the [ViewModelStore](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStore.html) associated with this activity 

 Overriding this method is no longer supported and this method will be made `final` in a future version of

#### Return

a `ViewModelStore`

#### Throws

| | |
|---|---|
| [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html) | if called before the Activity is attached to the Application instance i.e., before onCreate() |