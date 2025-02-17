//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[onSupportNavigateUp](on-support-navigate-up.md)

# onSupportNavigateUp

[androidJvm]\
open fun [onSupportNavigateUp](on-support-navigate-up.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

This method is called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar. 

If a parent was specified in the manifest for this activity or an activity-alias to it, default Up navigation will be handled automatically. See [getSupportParentActivityIntent](get-support-parent-activity-intent.md) for how to specify the parent. If any activity along the parent chain requires extra Intent arguments, the Activity subclass should override the method [onPrepareSupportNavigateUpTaskStack](on-prepare-support-navigate-up-task-stack.md) to supply those arguments.

See [Tasks and Back Stack]({@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html) from the developer guide and [Navigation]({@docRoot}design/patterns/navigation.html) from the design guide for more information about navigating within your app.

See the [TaskStackBuilder](https://developer.android.com/reference/kotlin/androidx/core/app/TaskStackBuilder.html) class and the Activity methods [getSupportParentActivityIntent](get-support-parent-activity-intent.md), [supportShouldUpRecreateTask](support-should-up-recreate-task.md), and [supportNavigateUpTo](support-navigate-up-to.md) for help implementing custom Up navigation.

#### Return

true if Up navigation completed successfully and this Activity was finished, false otherwise.