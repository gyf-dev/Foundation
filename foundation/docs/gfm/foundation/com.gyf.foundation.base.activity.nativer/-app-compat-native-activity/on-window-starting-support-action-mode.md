//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[onWindowStartingSupportActionMode](on-window-starting-support-action-mode.md)

# onWindowStartingSupportActionMode

[androidJvm]\

@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)

open fun [onWindowStartingSupportActionMode](on-window-starting-support-action-mode.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)callback: [ActionMode.Callback](https://developer.android.com/reference/kotlin/androidx/appcompat/view/ActionMode.Callback.html)): [ActionMode](https://developer.android.com/reference/kotlin/androidx/appcompat/view/ActionMode.html)

Called when a support action mode is being started for this window. Gives the callback an opportunity to handle the action mode in its own unique and beautiful way. If this method returns null the system can choose a way to present the mode or choose not to start the mode at all.

#### Return

The ActionMode that was started, or null if the system should present it

#### Parameters

androidJvm

| | |
|---|---|
| callback | Callback to control the lifecycle of this action mode |