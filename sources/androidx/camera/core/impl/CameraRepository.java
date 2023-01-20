package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    @GuardedBy("mCamerasLock")
    private a<Void> mDeinitFuture;
    private final Object mCamerasLock = new Object();
    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new LinkedHashMap();
    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Object b(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mCamerasLock) {
            this.mDeinitCompleter = completer;
        }
        return "CameraRepository-deinit";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            this.mReleasingCameras.remove(cameraInternal);
            if (this.mReleasingCameras.isEmpty()) {
                Preconditions.checkNotNull(this.mDeinitCompleter);
                this.mDeinitCompleter.set(null);
                this.mDeinitCompleter = null;
                this.mDeinitFuture = null;
            }
        }
    }

    @NonNull
    public a<Void> deinit() {
        synchronized (this.mCamerasLock) {
            if (this.mCameras.isEmpty()) {
                a<Void> aVar = this.mDeinitFuture;
                if (aVar == null) {
                    aVar = Futures.immediateFuture(null);
                }
                return aVar;
            }
            a<Void> aVar2 = this.mDeinitFuture;
            if (aVar2 == null) {
                aVar2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.b2.e
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return CameraRepository.this.b(completer);
                    }
                });
                this.mDeinitFuture = aVar2;
            }
            this.mReleasingCameras.addAll(this.mCameras.values());
            for (final CameraInternal cameraInternal : this.mCameras.values()) {
                cameraInternal.release().addListener(new Runnable() { // from class: c.b.b.b2.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraRepository.this.d(cameraInternal);
                    }
                }, CameraXExecutors.directExecutor());
            }
            this.mCameras.clear();
            return aVar2;
        }
    }

    @NonNull
    public CameraInternal getCamera(@NonNull String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            cameraInternal = this.mCameras.get(str);
            if (cameraInternal == null) {
                throw new IllegalArgumentException("Invalid camera: " + str);
            }
        }
        return cameraInternal;
    }

    @NonNull
    public Set<String> getCameraIds() {
        LinkedHashSet linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet(this.mCameras.keySet());
        }
        return linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> getCameras() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet<>(this.mCameras.values());
        }
        return linkedHashSet;
    }

    public void init(@NonNull CameraFactory cameraFactory) throws InitializationException {
        synchronized (this.mCamerasLock) {
            try {
                try {
                    for (String str : cameraFactory.getAvailableCameraIds()) {
                        Logger.d(TAG, "Added camera: " + str);
                        this.mCameras.put(str, cameraFactory.getCamera(str));
                    }
                } catch (CameraUnavailableException e2) {
                    throw new InitializationException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
