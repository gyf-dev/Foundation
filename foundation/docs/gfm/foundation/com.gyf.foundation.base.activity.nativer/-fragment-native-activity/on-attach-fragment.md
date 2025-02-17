//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[onAttachFragment](on-attach-fragment.md)

# onAttachFragment

[androidJvm]\

@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)

open fun [~~onAttachFragment~~](on-attach-fragment.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html))

---

### Deprecated

The responsibility for listening for fragments being attached has been moved to FragmentManager. You can add a listener to [this Activity's FragmentManager](get-support-fragment-manager.md) by calling [addFragmentOnAttachListener](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentManager.html#addfragmentonattachlistener) in your constructor to get callbacks when a fragment is attached directly to the activity's FragmentManager.

---

Called when a fragment is attached to the activity. 

This is called after the attached fragment's `onAttach` and before the attached fragment's `onCreate` if the fragment has not yet had a previous call to `onCreate`.