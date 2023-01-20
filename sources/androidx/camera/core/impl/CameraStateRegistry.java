package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.core.util.Preconditions;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraStateRegistry {
    private static final String TAG = "CameraStateRegistry";
    @GuardedBy("mLock")
    private int mAvailableCameras;
    private final int mMaxAllowedOpenedCameras;
    private final StringBuilder mDebugString = new StringBuilder();
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private final Map<Camera, CameraRegistration> mCameraStates = new HashMap();

    /* loaded from: classes.dex */
    public static class CameraRegistration {
        private final OnOpenAvailableListener mCameraAvailableListener;
        private final Executor mNotifyExecutor;
        private CameraInternal.State mState;

        public CameraRegistration(@Nullable CameraInternal.State state, @NonNull Executor executor, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
            this.mState = state;
            this.mNotifyExecutor = executor;
            this.mCameraAvailableListener = onOpenAvailableListener;
        }

        public CameraInternal.State getState() {
            return this.mState;
        }

        public void notifyListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                final OnOpenAvailableListener onOpenAvailableListener = this.mCameraAvailableListener;
                Objects.requireNonNull(onOpenAvailableListener);
                executor.execute(new Runnable() { // from class: c.b.b.b2.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraStateRegistry.OnOpenAvailableListener.this.onOpenAvailable();
                    }
                });
            } catch (RejectedExecutionException e2) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera.", e2);
            }
        }

        public CameraInternal.State setState(@Nullable CameraInternal.State state) {
            CameraInternal.State state2 = this.mState;
            this.mState = state;
            return state2;
        }
    }

    /* loaded from: classes.dex */
    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    public CameraStateRegistry(int i2) {
        this.mMaxAllowedOpenedCameras = i2;
        synchronized ("mLock") {
            this.mAvailableCameras = i2;
        }
    }

    private static boolean isOpen(@Nullable CameraInternal.State state) {
        return state != null && state.holdsCameraSlot();
    }

    @GuardedBy("mLock")
    @WorkerThread
    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.mDebugString.append("-------------------------------------------------------------------\n");
        }
        int i2 = 0;
        for (Map.Entry<Camera, CameraRegistration> entry : this.mCameraStates.entrySet()) {
            if (Logger.isDebugEnabled(TAG)) {
                this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", entry.getKey().toString(), entry.getValue().getState() != null ? entry.getValue().getState().toString() : GrsBaseInfo.CountryCodeSource.UNKNOWN));
            }
            if (isOpen(entry.getValue().getState())) {
                i2++;
            }
        }
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.append("-------------------------------------------------------------------\n");
            this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", Integer.valueOf(i2), Integer.valueOf(this.mMaxAllowedOpenedCameras)));
            Logger.d(TAG, this.mDebugString.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - i2, 0);
    }

    @Nullable
    @GuardedBy("mLock")
    private CameraInternal.State unregisterCamera(Camera camera) {
        CameraRegistration remove = this.mCameraStates.remove(camera);
        if (remove != null) {
            recalculateAvailableCameras();
            return remove.getState();
        }
        return null;
    }

    @Nullable
    @GuardedBy("mLock")
    private CameraInternal.State updateAndVerifyState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        CameraInternal.State state2 = ((CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(camera), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(state);
        CameraInternal.State state3 = CameraInternal.State.OPENING;
        if (state == state3) {
            Preconditions.checkState(isOpen(state) || state2 == state3, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (state2 != state) {
            recalculateAvailableCameras();
        }
        return state2;
    }

    public boolean isCameraClosing() {
        synchronized (this.mLock) {
            for (Map.Entry<Camera, CameraRegistration> entry : this.mCameraStates.entrySet()) {
                if (entry.getValue().getState() == CameraInternal.State.CLOSING) {
                    return true;
                }
            }
            return false;
        }
    }

    public void markCameraState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        markCameraState(camera, state, true);
    }

    public void registerCamera(@NonNull Camera camera, @NonNull Executor executor, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
        synchronized (this.mLock) {
            boolean z = !this.mCameraStates.containsKey(camera);
            Preconditions.checkState(z, "Camera is already registered: " + camera);
            this.mCameraStates.put(camera, new CameraRegistration(null, executor, onOpenAvailableListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0052, B:9:0x0056, B:14:0x0069, B:16:0x0071, B:20:0x0080, B:22:0x0096, B:23:0x0099, B:13:0x0063), top: B:28:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096 A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0052, B:9:0x0056, B:14:0x0069, B:16:0x0071, B:20:0x0080, B:22:0x0096, B:23:0x0099, B:13:0x0063), top: B:28:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean tryOpenCamera(@androidx.annotation.NonNull androidx.camera.core.Camera r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.mLock
            monitor-enter(r0)
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r1 = r9.mCameraStates     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r1 = r1.get(r10)     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = "Camera must first be registered with registerCamera()"
            java.lang.Object r1 = androidx.core.util.Preconditions.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = "CameraStateRegistry"
            boolean r2 = androidx.camera.core.Logger.isDebugEnabled(r2)     // Catch: java.lang.Throwable -> L9b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L52
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch: java.lang.Throwable -> L9b
            r2.setLength(r4)     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch: java.lang.Throwable -> L9b
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L9b
            java.lang.String r6 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L9b
            r7[r4] = r10     // Catch: java.lang.Throwable -> L9b
            int r10 = r9.mAvailableCameras     // Catch: java.lang.Throwable -> L9b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L9b
            r7[r3] = r10     // Catch: java.lang.Throwable -> L9b
            r10 = 2
            androidx.camera.core.impl.CameraInternal$State r8 = r1.getState()     // Catch: java.lang.Throwable -> L9b
            boolean r8 = isOpen(r8)     // Catch: java.lang.Throwable -> L9b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L9b
            r7[r10] = r8     // Catch: java.lang.Throwable -> L9b
            r10 = 3
            androidx.camera.core.impl.CameraInternal$State r8 = r1.getState()     // Catch: java.lang.Throwable -> L9b
            r7[r10] = r8     // Catch: java.lang.Throwable -> L9b
            java.lang.String r10 = java.lang.String.format(r5, r6, r7)     // Catch: java.lang.Throwable -> L9b
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b
        L52:
            int r10 = r9.mAvailableCameras     // Catch: java.lang.Throwable -> L9b
            if (r10 > 0) goto L63
            androidx.camera.core.impl.CameraInternal$State r10 = r1.getState()     // Catch: java.lang.Throwable -> L9b
            boolean r10 = isOpen(r10)     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L61
            goto L63
        L61:
            r10 = 0
            goto L69
        L63:
            androidx.camera.core.impl.CameraInternal$State r10 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch: java.lang.Throwable -> L9b
            r1.setState(r10)     // Catch: java.lang.Throwable -> L9b
            r10 = 1
        L69:
            java.lang.String r1 = "CameraStateRegistry"
            boolean r1 = androidx.camera.core.Logger.isDebugEnabled(r1)     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L94
            java.lang.StringBuilder r1 = r9.mDebugString     // Catch: java.lang.Throwable -> L9b
            java.util.Locale r2 = java.util.Locale.US     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = " --> %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9b
            if (r10 == 0) goto L7e
            java.lang.String r6 = "SUCCESS"
            goto L80
        L7e:
            java.lang.String r6 = "FAIL"
        L80:
            r3[r4] = r6     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = java.lang.String.format(r2, r5, r3)     // Catch: java.lang.Throwable -> L9b
            r1.append(r2)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = "CameraStateRegistry"
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch: java.lang.Throwable -> L9b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9b
            androidx.camera.core.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L9b
        L94:
            if (r10 == 0) goto L99
            r9.recalculateAvailableCameras()     // Catch: java.lang.Throwable -> L9b
        L99:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r10
        L9b:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCamera(androidx.camera.core.Camera):boolean");
    }

    public void markCameraState(@NonNull Camera camera, @NonNull CameraInternal.State state, boolean z) {
        CameraInternal.State updateAndVerifyState;
        HashMap hashMap;
        synchronized (this.mLock) {
            int i2 = this.mAvailableCameras;
            if (state == CameraInternal.State.RELEASED) {
                updateAndVerifyState = unregisterCamera(camera);
            } else {
                updateAndVerifyState = updateAndVerifyState(camera, state);
            }
            if (updateAndVerifyState == state) {
                return;
            }
            if (i2 < 1 && this.mAvailableCameras > 0) {
                hashMap = new HashMap();
                for (Map.Entry<Camera, CameraRegistration> entry : this.mCameraStates.entrySet()) {
                    if (entry.getValue().getState() == CameraInternal.State.PENDING_OPEN) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            } else if (state != CameraInternal.State.PENDING_OPEN || this.mAvailableCameras <= 0) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put(camera, this.mCameraStates.get(camera));
            }
            if (hashMap != null && !z) {
                hashMap.remove(camera);
            }
            if (hashMap != null) {
                for (CameraRegistration cameraRegistration : hashMap.values()) {
                    cameraRegistration.notifyListener();
                }
            }
        }
    }
}
