//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[startSupportActionMode](start-support-action-mode.md)

# startSupportActionMode

[androidJvm]\

@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)

open fun [startSupportActionMode](start-support-action-mode.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)callback: [ActionMode.Callback](https://developer.android.com/reference/kotlin/androidx/appcompat/view/ActionMode.Callback.html)): [ActionMode](https://developer.android.com/reference/kotlin/androidx/appcompat/view/ActionMode.html)

Start an action mode.

#### Return

The ContextMode that was started, or null if it was canceled

#### Parameters

androidJvm

| | |
|---|---|
| callback | Callback that will manage lifecycle events for this context mode |