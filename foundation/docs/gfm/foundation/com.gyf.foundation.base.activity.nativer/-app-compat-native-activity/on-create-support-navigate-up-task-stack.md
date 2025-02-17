//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[onCreateSupportNavigateUpTaskStack](on-create-support-navigate-up-task-stack.md)

# onCreateSupportNavigateUpTaskStack

[androidJvm]\
open fun [onCreateSupportNavigateUpTaskStack](on-create-support-navigate-up-task-stack.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)builder: [TaskStackBuilder](https://developer.android.com/reference/kotlin/androidx/core/app/TaskStackBuilder.html))

Support version of [onCreateNavigateUpTaskStack](https://developer.android.com/reference/kotlin/android/app/Activity.html#oncreatenavigateuptaskstack). This method will be called on all platform versions. 

 Define the synthetic task stack that will be generated during Up navigation from a different task. 

The default implementation of this method adds the parent chain of this activity as specified in the manifest to the supplied [TaskStackBuilder](https://developer.android.com/reference/kotlin/androidx/core/app/TaskStackBuilder.html). Applications may choose to override this method to construct the desired task stack in a different way.

This method will be invoked by the default implementation of [onNavigateUp](https://developer.android.com/reference/kotlin/android/app/Activity.html#onnavigateup) if [shouldUpRecreateTask](https://developer.android.com/reference/kotlin/android/app/Activity.html#shoulduprecreatetask) returns true when supplied with the intent returned by [getParentActivityIntent](https://developer.android.com/reference/kotlin/android/app/Activity.html#getparentactivityintent).

Applications that wish to supply extra Intent parameters to the parent stack defined by the manifest should override [onPrepareSupportNavigateUpTaskStack](on-prepare-support-navigate-up-task-stack.md).

#### Parameters

androidJvm

| | |
|---|---|
| builder | An empty TaskStackBuilder - the application should add intents representing the desired task stack |