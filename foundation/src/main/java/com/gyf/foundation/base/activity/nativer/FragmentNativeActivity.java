package com.gyf.foundation.base.activity.nativer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * @Author Ifan.Ge
 * @Date 2024/9/29 10:40
 */
public class FragmentNativeActivity extends ComponentNativeActivity implements
        ActivityCompat.OnRequestPermissionsResultCallback {

    static final String LIFECYCLE_TAG = "android:support:lifecycle";

    final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
    /**
     * A {@link Lifecycle} that is exactly nested outside of when the FragmentController
     * has its state changed, providing the proper nesting of Lifecycle callbacks
     * <p>
     * TODO(b/127528777) Drive Fragment Lifecycle with LifecycleObserver
     */
    final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);

    boolean mCreated;
    boolean mResumed;
    boolean mStopped = true;

    /**
     * Default constructor for FragmentGameActivity. All Activities must have a default constructor
     * for API 27 and lower devices or when using the default
     * {@link android.app.AppComponentFactory}.
     */
    public FragmentNativeActivity() {
        super();
        init();
    }

    /**
     * Alternate constructor that can be used to provide a default layout
     * that will be inflated as part of <code>super.onCreate(savedInstanceState)</code>.
     *
     * <p>This should generally be called from your constructor that takes no parameters,
     * as is required for API 27 and lower or when using the default
     * {@link android.app.AppComponentFactory}.
     *
     * @see #FragmentNativeActivity()
     */
    @ContentView
    public FragmentNativeActivity(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, () -> {
            mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            return new Bundle();
        });
        // Ensure that the first OnConfigurationChangedListener
        // marks the FragmentManager's state as not saved
        addOnConfigurationChangedListener(newConfig -> mFragments.noteStateNotSaved());
        // Ensure that the first OnNewIntentListener
        // marks the FragmentManager's state as not saved
        addOnNewIntentListener(newConfig -> mFragments.noteStateNotSaved());
        addOnContextAvailableListener(context -> mFragments.attachHost(null /*parent*/));
    }

    // ------------------------------------------------------------------------
    // HOOKS INTO ACTIVITY
    // ------------------------------------------------------------------------

    @SuppressWarnings("deprecation")
    @Override
    @CallSuper
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mFragments.noteStateNotSaved();
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * Reverses the Activity Scene entry Transition and triggers the calling Activity
     * to reverse its exit Transition. When the exit Transition completes,
     * {@link #finish()} is called. If no entry Transition was used, finish() is called
     * immediately and the Activity exit Transition is run.
     *
     * <p>On Android 4.4 or lower, this method only finishes the Activity with no
     * special exit transition.</p>
     */
    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    /**
     * When {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>callback</var>
     * will be called to handle shared elements on the <i>launched</i> Activity. This requires
     * {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * @param callback Used to manipulate shared element transitions on the launched Activity.
     */
    public void setEnterSharedElementCallback(@Nullable SharedElementCallback callback) {
        ActivityCompat.setEnterSharedElementCallback(this, callback);
    }

    /**
     * When {@link android.app.ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>listener</var>
     * will be called to handle shared elements on the <i>launching</i> Activity. Most
     * calls will only come when returning from the started Activity.
     * This requires {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * @param listener Used to manipulate shared element transitions on the launching Activity.
     */
    public void setExitSharedElementCallback(@Nullable SharedElementCallback listener) {
        ActivityCompat.setExitSharedElementCallback(this, listener);
    }

    /**
     * Support library version of {@link Activity#postponeEnterTransition()} that works
     * only on API 21 and later.
     */
    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    /**
     * Support library version of {@link Activity#startPostponedEnterTransition()}
     * that only works with API 21 and later.
     */
    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Perform initialization of all fragments.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        mFragments.dispatchCreate();
    }

    @Override
    @Nullable
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context,
                             @NonNull AttributeSet attrs) {
        final View v = dispatchFragmentsOnCreateView(parent, name, context, attrs);
        if (v == null) {
            return super.onCreateView(parent, name, context, attrs);
        }
        return v;
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull String name, @NonNull Context context,
                             @NonNull AttributeSet attrs) {
        final View v = dispatchFragmentsOnCreateView(null, name, context, attrs);
        if (v == null) {
            return super.onCreateView(name, context, attrs);
        }
        return v;
    }

    @Nullable
    final View dispatchFragmentsOnCreateView(@Nullable View parent, @NonNull String name,
                                             @NonNull Context context, @NonNull AttributeSet attrs) {
        return mFragments.onCreateView(parent, name, context, attrs);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Destroy all fragments.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragments.dispatchDestroy();
        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, @NonNull MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }

        if (featureId == Window.FEATURE_CONTEXT_MENU) {
            return mFragments.dispatchContextItemSelected(item);
        }

        return false;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mResumed = false;
        mFragments.dispatchPause();
        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Hook in to note that fragment state is no longer saved.
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onStateNotSaved() {
        mFragments.noteStateNotSaved();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    public void onResume() {
        mFragments.noteStateNotSaved();
        super.onResume();
        mResumed = true;
        mFragments.execPendingActions();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onResume() to fragments.
     */
    @Override
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    protected void onResumeFragments() {
        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        mFragments.dispatchResume();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onStart() to all fragments.
     */
    @Override
    public void onStart() {
        mFragments.noteStateNotSaved();
        super.onStart();

        mStopped = false;

        if (!mCreated) {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        }

        mFragments.execPendingActions();

        // NOTE: HC onStart goes here.

        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        mFragments.dispatchStart();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onStop() to all fragments.
     */
    @Override
    public void onStop() {
        super.onStop();

        mStopped = true;
        mFragments.dispatchStop();
        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    // ------------------------------------------------------------------------
    // NEW METHODS
    // ------------------------------------------------------------------------

    /**
     * Support library version of {@link Activity#invalidateOptionsMenu}.
     *
     * <p>Invalidate the activity's options menu. This will cause relevant presentations
     * of the menu to fully update via calls to onCreateOptionsMenu and
     * onPrepareOptionsMenu the next time the menu is requested.
     *
     * @deprecated Call {@link Activity#invalidateOptionsMenu} directly.
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    /**
     * Print the Activity's state into the given stream.  This gets invoked if
     * you run "adb shell dumpsys activity <activity_component_name>".
     *
     * @param prefix Desired prefix to prepend at each line of output.
     * @param fd     The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     *               closed for you after you return.
     * @param args   additional arguments to the dump request.
     */
    @SuppressWarnings("deprecation")
    @Override
    public void dump(@NonNull String prefix, @Nullable FileDescriptor fd,
                     @NonNull PrintWriter writer, @Nullable String[] args) {
        super.dump(prefix, fd, writer, args);

        writer.print(prefix);
        writer.print("Local FragmentGameActivity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix = prefix + "  ";
        writer.print(innerPrefix);
        writer.print("mCreated=");
        writer.print(mCreated);
        writer.print(" mResumed=");
        writer.print(mResumed);
        writer.print(" mStopped=");
        writer.print(mStopped);

        if (getApplication() != null) {
            LoaderManager.getInstance(this).dump(innerPrefix, fd, writer, args);
        }
        mFragments.getSupportFragmentManager().dump(prefix, fd, writer, args);
    }

    // ------------------------------------------------------------------------
    // FRAGMENT SUPPORT
    // ------------------------------------------------------------------------

    /**
     * Called when a fragment is attached to the activity.
     *
     * <p>This is called after the attached fragment's <code>onAttach</code> and before
     * the attached fragment's <code>onCreate</code> if the fragment has not yet had a previous
     * call to <code>onCreate</code>.</p>
     *
     * @deprecated The responsibility for listening for fragments being attached has been moved
     * to FragmentManager. You can add a listener to
     * {@link #getSupportFragmentManager() this Activity's FragmentManager} by calling
     * {@link FragmentManager#addFragmentOnAttachListener(FragmentOnAttachListener)}
     * in your constructor to get callbacks when a fragment is attached directly to
     * the activity's FragmentManager.
     */
    @SuppressWarnings({"unused", "DeprecatedIsStillUsed"})
    @Deprecated
    @MainThread
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return mFragments.getSupportFragmentManager();
    }

    /**
     * @deprecated Use
     * {@link LoaderManager#getInstance(LifecycleOwner) LoaderManager.getInstance(this)}.
     */
    @Deprecated
    @NonNull
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @SuppressWarnings("deprecation")
    @CallSuper
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Called by Fragment.startActivityForResult() to implement its behavior.
     *
     * @param fragment    the Fragment to start the activity from.
     * @param intent      The intent to start.
     * @param requestCode The request code to be returned in
     *                    {@link Fragment#onActivityResult(int, int, Intent)} when the activity exits. Must be
     *                    between 0 and 65535 to be considered valid. If given requestCode is
     *                    greater than 65535, an IllegalArgumentException would be thrown.
     */
    public void startActivityFromFragment(@NonNull Fragment fragment,
                                          @SuppressLint("UnknownNullness") Intent intent, int requestCode) {
        startActivityFromFragment(fragment, intent, requestCode, null);
    }

    /**
     * Called by Fragment.startActivityForResult() to implement its behavior.
     *
     * @param fragment    the Fragment to start the activity from.
     * @param intent      The intent to start.
     * @param requestCode The request code to be returned in
     *                    {@link Fragment#onActivityResult(int, int, Intent)} when the activity exits. Must be
     *                    between 0 and 65535 to be considered valid. If given requestCode is
     *                    greater than 65535, an IllegalArgumentException would be thrown.
     * @param options     Additional options for how the Activity should be started. See
     *                    {@link Context#startActivity(Intent, Bundle)} for more details. This value may be null.
     */
    @SuppressWarnings("deprecation")
    public void startActivityFromFragment(@NonNull Fragment fragment,
                                          @SuppressLint("UnknownNullness") Intent intent, int requestCode,
                                          @Nullable Bundle options) {
        // request code will be -1 if called from fragment.startActivity
        if (requestCode == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, options);
            return;
        }
        // If for some reason this method is being called directly with a requestCode that is not
        // -1, redirect it to the fragment.startActivityForResult method
        fragment.startActivityForResult(intent, requestCode, options);
    }

    /**
     * Called by Fragment.startIntentSenderForResult() to implement its behavior.
     *
     * @param fragment     the Fragment to start the intent sender from.
     * @param intent       The IntentSender to launch.
     * @param requestCode  The request code to be returned in
     *                     {@link Fragment#onActivityResult(int, int, Intent)} when the activity exits. Must be
     *                     between 0 and 65535 to be considered valid. If given requestCode is
     *                     greater than 65535, an IllegalArgumentException would be thrown.
     * @param fillInIntent If non-null, this will be provided as the intent parameter to
     *                     {@link IntentSender#sendIntent(Context, int, Intent, IntentSender.OnFinished, Handler)}.
     *                     This value may be null.
     * @param flagsMask    Intent flags in the original IntentSender that you would like to change.
     * @param flagsValues  Desired values for any bits set in <code>flagsMask</code>.
     * @param extraFlags   Always set to 0.
     * @param options      Additional options for how the Activity should be started. See
     *                     {@link Context#startActivity(Intent, Bundle)} for more details. This value may be null.
     * @throws IntentSender.SendIntentException if the call fails to execute.
     * @deprecated Fragments should use
     * {@link Fragment#registerForActivityResult(ActivityResultContract, ActivityResultCallback)}
     * with the {@link ActivityResultContracts.StartIntentSenderForResult} contract. This method will still be called when
     * Fragments call the deprecated <code>startIntentSenderForResult()</code> method.
     */
    @SuppressWarnings({"deprecation"})
    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment,
                                              @SuppressLint("UnknownNullness") IntentSender intent, int requestCode,
                                              @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags,
                                              @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (requestCode == -1) {
            ActivityCompat.startIntentSenderForResult(this, intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, extraFlags, options);
            return;
        }
        fragment.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
                flagsValues, extraFlags, options);
    }

    class HostCallbacks extends FragmentHostCallback<FragmentNativeActivity> implements
            OnConfigurationChangedProvider,
            OnTrimMemoryProvider,
            OnMultiWindowModeChangedProvider,
            OnPictureInPictureModeChangedProvider,
            ViewModelStoreOwner,
            OnBackPressedDispatcherOwner,
            ActivityResultRegistryOwner,
            SavedStateRegistryOwner,
            FragmentOnAttachListener,
            MenuHost {

        public HostCallbacks() {
            super(FragmentNativeActivity.this, new Handler(Looper.getMainLooper()), 0);
        }

        @NonNull
        @Override
        public Lifecycle getLifecycle() {
            // Instead of directly using the Activity's Lifecycle, we
            // use a LifecycleRegistry that is nested exactly outside of
            // when Fragments get their lifecycle changed
            // TODO(b/127528777) Drive Fragment Lifecycle with LifecycleObserver
            return mFragmentLifecycleRegistry;
        }

        @NonNull
        @Override
        public ViewModelStore getViewModelStore() {
            return FragmentNativeActivity.this.getViewModelStore();
        }

        @NonNull
        @Override
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentNativeActivity.this.getOnBackPressedDispatcher();
        }

        @Override
        public void onDump(@NonNull String prefix, @Nullable FileDescriptor fd,
                           @NonNull PrintWriter writer, @Nullable String[] args) {
            FragmentNativeActivity.this.dump(prefix, fd, writer, args);
        }

        @Override
        public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
            return !isFinishing();
        }

        @Override
        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            return FragmentNativeActivity.this.getLayoutInflater().cloneInContext(FragmentNativeActivity.this);
        }

        @Override
        public FragmentNativeActivity onGetHost() {
            return FragmentNativeActivity.this;
        }

        @Override
        public void onSupportInvalidateOptionsMenu() {
            invalidateMenu();
        }

        @Override
        public boolean onShouldShowRequestPermissionRationale(@NonNull String permission) {
            return ActivityCompat.shouldShowRequestPermissionRationale(
                    FragmentNativeActivity.this, permission);
        }

        @Override
        public boolean onHasWindowAnimations() {
            return getWindow() != null;
        }

        @Override
        public int onGetWindowAnimations() {
            final Window w = getWindow();
            return (w == null) ? 0 : w.getAttributes().windowAnimations;
        }

        @SuppressWarnings("deprecation")
        @Override
        public void onAttachFragment(@NonNull FragmentManager fragmentManager,
                                     @NonNull Fragment fragment) {
            FragmentNativeActivity.this.onAttachFragment(fragment);
        }

        @Nullable
        @Override
        public View onFindViewById(int id) {
            return FragmentNativeActivity.this.findViewById(id);
        }

        @Override
        public boolean onHasView() {
            final Window w = getWindow();
            return (w != null && w.peekDecorView() != null);
        }

        @NonNull
        @Override
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentNativeActivity.this.getActivityResultRegistry();
        }

        @NonNull
        @Override
        public SavedStateRegistry getSavedStateRegistry() {
            return FragmentNativeActivity.this.getSavedStateRegistry();
        }

        @Override
        public void addOnConfigurationChangedListener(
                @NonNull Consumer<Configuration> listener
        ) {
            FragmentNativeActivity.this.addOnConfigurationChangedListener(listener);
        }

        @Override
        public void removeOnConfigurationChangedListener(
                @NonNull Consumer<Configuration> listener
        ) {
            FragmentNativeActivity.this.removeOnConfigurationChangedListener(listener);
        }

        @Override
        public void addOnTrimMemoryListener(@NonNull Consumer<Integer> listener) {
            FragmentNativeActivity.this.addOnTrimMemoryListener(listener);
        }

        @Override
        public void removeOnTrimMemoryListener(@NonNull Consumer<Integer> listener) {
            FragmentNativeActivity.this.removeOnTrimMemoryListener(listener);
        }

        @Override
        public void addOnMultiWindowModeChangedListener(
                @NonNull Consumer<MultiWindowModeChangedInfo> listener) {
            FragmentNativeActivity.this.addOnMultiWindowModeChangedListener(listener);
        }

        @Override
        public void removeOnMultiWindowModeChangedListener(
                @NonNull Consumer<MultiWindowModeChangedInfo> listener) {
            FragmentNativeActivity.this.removeOnMultiWindowModeChangedListener(listener);
        }

        @Override
        public void addOnPictureInPictureModeChangedListener(
                @NonNull Consumer<PictureInPictureModeChangedInfo> listener) {
            FragmentNativeActivity.this.addOnPictureInPictureModeChangedListener(listener);
        }

        @Override
        public void removeOnPictureInPictureModeChangedListener(
                @NonNull Consumer<PictureInPictureModeChangedInfo> listener) {
            FragmentNativeActivity.this.removeOnPictureInPictureModeChangedListener(listener);
        }

        @Override
        public void addMenuProvider(@NonNull MenuProvider provider) {
            FragmentNativeActivity.this.addMenuProvider(provider);
        }

        @Override
        public void addMenuProvider(@NonNull MenuProvider provider, @NonNull LifecycleOwner owner) {
            FragmentNativeActivity.this.addMenuProvider(provider, owner);
        }

        @Override
        public void addMenuProvider(@NonNull MenuProvider provider, @NonNull LifecycleOwner owner,
                                    @NonNull Lifecycle.State state) {
            FragmentNativeActivity.this.addMenuProvider(provider, owner, state);
        }

        @Override
        public void removeMenuProvider(@NonNull MenuProvider provider) {
            FragmentNativeActivity.this.removeMenuProvider(provider);
        }

        @Override
        public void invalidateMenu() {
            FragmentNativeActivity.this.invalidateOptionsMenu();
        }
    }
}