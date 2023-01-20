package androidx.camera.lifecycle;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import e.j.b.a.c;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class LifecycleCameraRepository {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private final Map<Key, LifecycleCamera> mCameraMap = new HashMap();
    @GuardedBy("mLock")
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap = new HashMap();
    @GuardedBy("mLock")
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners = new ArrayDeque<>();

    @c
    /* loaded from: classes.dex */
    public static abstract class Key {
        public static Key create(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter.CameraId cameraId) {
            return new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraId);
        }

        @NonNull
        public abstract CameraUseCaseAdapter.CameraId getCameraId();

        @NonNull
        public abstract LifecycleOwner getLifecycleOwner();
    }

    /* loaded from: classes.dex */
    public static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        public LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
            this.mLifecycleOwner = lifecycleOwner;
            this.mLifecycleCameraRepository = lifecycleCameraRepository;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setActive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
        }
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.mLifecycleObserverMap.keySet()) {
                if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.getLifecycleOwner())) {
                    return lifecycleCameraRepositoryObserver;
                }
            }
            return null;
        }
    }

    private boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return false;
            }
            for (Key key : this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver)) {
                if (!((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(key))).getUseCases().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void registerCamera(LifecycleCamera lifecycleCamera) {
        Set<Key> hashSet;
        synchronized (this.mLock) {
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Key create = Key.create(lifecycleOwner, lifecycleCamera.getCameraUseCaseAdapter().getCameraId());
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver != null) {
                hashSet = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver);
            } else {
                hashSet = new HashSet<>();
            }
            hashSet.add(create);
            this.mCameraMap.put(create, lifecycleCamera);
            if (lifecycleCameraRepositoryObserver == null) {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver2 = new LifecycleCameraRepositoryObserver(lifecycleOwner, this);
                this.mLifecycleObserverMap.put(lifecycleCameraRepositoryObserver2, hashSet);
                lifecycleOwner.getLifecycle().addObserver(lifecycleCameraRepositoryObserver2);
            }
        }
    }

    private void suspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            for (Key key : this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver)) {
                ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(key))).suspend();
            }
        }
    }

    private void unsuspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            for (Key key : this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner))) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(key);
                if (!((LifecycleCamera) Preconditions.checkNotNull(lifecycleCamera)).getUseCases().isEmpty()) {
                    lifecycleCamera.unsuspend();
                }
            }
        }
    }

    public void bindToLifecycleCamera(@NonNull LifecycleCamera lifecycleCamera, @Nullable ViewPort viewPort, @NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            Preconditions.checkArgument(!collection.isEmpty());
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            for (Key key : this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner))) {
                LifecycleCamera lifecycleCamera2 = (LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(key));
                if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.getUseCases().isEmpty()) {
                    throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                }
            }
            try {
                lifecycleCamera.getCameraUseCaseAdapter().setViewPort(viewPort);
                lifecycleCamera.bind(collection);
                if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    setActive(lifecycleOwner);
                }
            } catch (CameraUseCaseAdapter.CameraException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : new HashSet(this.mLifecycleObserverMap.keySet())) {
                unregisterLifecycle(lifecycleCameraRepositoryObserver.getLifecycleOwner());
            }
        }
    }

    public LifecycleCamera createLifecycleCamera(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            Preconditions.checkArgument(this.mCameraMap.get(Key.create(lifecycleOwner, cameraUseCaseAdapter.getCameraId())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.getUseCases().isEmpty()) {
                    lifecycleCamera.suspend();
                }
                registerCamera(lifecycleCamera);
            } else {
                throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
            }
        }
        return lifecycleCamera;
    }

    @Nullable
    public LifecycleCamera getLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            lifecycleCamera = this.mCameraMap.get(Key.create(lifecycleOwner, cameraId));
        }
        return lifecycleCamera;
    }

    public Collection<LifecycleCamera> getLifecycleCameras() {
        Collection<LifecycleCamera> unmodifiableCollection;
        synchronized (this.mLock) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.mCameraMap.values());
        }
        return unmodifiableCollection;
    }

    public void setActive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            if (hasUseCaseBound(lifecycleOwner)) {
                if (this.mActiveLifecycleOwners.isEmpty()) {
                    this.mActiveLifecycleOwners.push(lifecycleOwner);
                } else {
                    LifecycleOwner peek = this.mActiveLifecycleOwners.peek();
                    if (!lifecycleOwner.equals(peek)) {
                        suspendUseCases(peek);
                        this.mActiveLifecycleOwners.remove(lifecycleOwner);
                        this.mActiveLifecycleOwners.push(lifecycleOwner);
                    }
                }
                unsuspendUseCases(lifecycleOwner);
            }
        }
    }

    public void setInactive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            this.mActiveLifecycleOwners.remove(lifecycleOwner);
            suspendUseCases(lifecycleOwner);
            if (!this.mActiveLifecycleOwners.isEmpty()) {
                unsuspendUseCases(this.mActiveLifecycleOwners.peek());
            }
        }
    }

    public void unbind(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            for (Key key : this.mCameraMap.keySet()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(key);
                boolean z = !lifecycleCamera.getUseCases().isEmpty();
                lifecycleCamera.unbind(collection);
                if (z && lifecycleCamera.getUseCases().isEmpty()) {
                    setInactive(lifecycleCamera.getLifecycleOwner());
                }
            }
        }
    }

    public void unbindAll() {
        synchronized (this.mLock) {
            for (Key key : this.mCameraMap.keySet()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(key);
                lifecycleCamera.unbindAll();
                setInactive(lifecycleCamera.getLifecycleOwner());
            }
        }
    }

    public void unregisterLifecycle(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            setInactive(lifecycleOwner);
            for (Key key : this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver)) {
                this.mCameraMap.remove(key);
            }
            this.mLifecycleObserverMap.remove(lifecycleCameraRepositoryObserver);
            lifecycleCameraRepositoryObserver.getLifecycleOwner().getLifecycle().removeObserver(lifecycleCameraRepositoryObserver);
        }
    }
}
