package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final SavedStateHandle mHandle;
    private boolean mIsAttached = false;
    private final String mKey;

    /* loaded from: classes.dex */
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@NonNull SavedStateRegistryOwner owner) {
            if (owner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
                for (String str : viewModelStore.keys()) {
                    SavedStateHandleController.attachHandleIfNeeded(viewModelStore.get(str), savedStateRegistry, owner.getLifecycle());
                }
                if (viewModelStore.keys().isEmpty()) {
                    return;
                }
                savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String key, SavedStateHandle handle) {
        this.mKey = key;
        this.mHandle = handle;
    }

    public static void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.isAttached()) {
            return;
        }
        savedStateHandleController.attachToLifecycle(registry, lifecycle);
        tryToAddRecreator(registry, lifecycle);
    }

    public static SavedStateHandleController create(SavedStateRegistry registry, Lifecycle lifecycle, String key, Bundle defaultArgs) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(key, SavedStateHandle.createHandle(registry.consumeRestoredStateForKey(key), defaultArgs));
        savedStateHandleController.attachToLifecycle(registry, lifecycle);
        tryToAddRecreator(registry, lifecycle);
        return savedStateHandleController;
    }

    private static void tryToAddRecreator(final SavedStateRegistry registry, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED && !currentState.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.removeObserver(this);
                        registry.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
        } else {
            registry.runOnNextRecreation(OnRecreation.class);
        }
    }

    public void attachToLifecycle(SavedStateRegistry registry, Lifecycle lifecycle) {
        if (!this.mIsAttached) {
            this.mIsAttached = true;
            lifecycle.addObserver(this);
            registry.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    public SavedStateHandle getHandle() {
        return this.mHandle;
    }

    public boolean isAttached() {
        return this.mIsAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.mIsAttached = false;
            source.getLifecycle().removeObserver(this);
        }
    }
}
