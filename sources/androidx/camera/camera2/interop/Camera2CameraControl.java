package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.concurrent.Executor;

@RequiresApi(21)
@ExperimentalCamera2Interop
/* loaded from: classes.dex */
public final class Camera2CameraControl {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_KEY = "Camera2CameraControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    public CallbackToFutureAdapter.Completer<Void> mCompleter;
    public final Executor mExecutor;
    private boolean mIsActive = false;
    private boolean mPendingUpdate = false;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    private Camera2ImplConfig.Builder mBuilder = new Camera2ImplConfig.Builder();
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: c.b.a.e.d
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            return Camera2CameraControl.this.j(totalCaptureResult);
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    private void addCaptureRequestOptionsInternal(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.mLock) {
            for (Config.Option<?> option : captureRequestOptions.listOptions()) {
                this.mBuilder.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Object d(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.e.c
            {
                Camera2CameraControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.b(completer);
            }
        });
        return "addCaptureRequestOptions";
    }

    private void clearCaptureRequestOptionsInternal() {
        synchronized (this.mLock) {
            this.mBuilder = new Camera2ImplConfig.Builder();
        }
    }

    @NonNull
    public static Camera2CameraControl from(@NonNull CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) cameraControl).getCamera2CameraControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ Object h(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.e.a
            {
                Camera2CameraControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.f(completer);
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ boolean j(android.hardware.camera2.TotalCaptureResult r3) {
        /*
            r2 = this;
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.mCompleter
            r1 = 0
            if (r0 == 0) goto L32
            android.hardware.camera2.CaptureRequest r3 = r3.getRequest()
            java.lang.Object r3 = r3.getTag()
            boolean r0 = r3 instanceof androidx.camera.core.impl.TagBundle
            if (r0 == 0) goto L32
            androidx.camera.core.impl.TagBundle r3 = (androidx.camera.core.impl.TagBundle) r3
            java.lang.String r0 = "Camera2CameraControl"
            java.lang.Object r3 = r3.getTag(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.mCompleter
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r3 = r2.mCompleter
            r2.mCompleter = r1
            goto L33
        L32:
            r3 = r1
        L33:
            if (r3 == 0) goto L38
            r3.set(r1)
        L38:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.interop.Camera2CameraControl.j(android.hardware.camera2.TotalCaptureResult):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ Object p(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.e.b
            {
                Camera2CameraControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.n(completer);
            }
        });
        return "setCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setActiveInternal */
    public void l(boolean z) {
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            if (this.mPendingUpdate) {
                updateSession();
                return;
            }
            return;
        }
        CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("The camera control has became inactive."));
            this.mCompleter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateConfig */
    public void n(CallbackToFutureAdapter.Completer<Void> completer) {
        this.mPendingUpdate = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mCompleter;
        if (completer2 == null) {
            completer2 = null;
        }
        this.mCompleter = completer;
        if (this.mIsActive) {
            updateSession();
        }
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    @NonNull
    public a<Void> addCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.e.h
            {
                Camera2CameraControl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.this.d(completer);
            }
        }));
    }

    @NonNull
    public a<Void> clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.e.e
            {
                Camera2CameraControl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.this.h(completer);
            }
        }));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2ImplConfig getCamera2ImplConfig() {
        Camera2ImplConfig build;
        synchronized (this.mLock) {
            if (this.mCompleter != null) {
                this.mBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION, Integer.valueOf(this.mCompleter.hashCode()));
            }
            build = this.mBuilder.build();
        }
        return build;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControlImpl.CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    @NonNull
    public CaptureRequestOptions getCaptureRequestOptions() {
        CaptureRequestOptions build;
        synchronized (this.mLock) {
            build = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();
        }
        return build;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActive(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.e.g
            {
                Camera2CameraControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.l(z);
            }
        });
    }

    @NonNull
    public a<Void> setCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.e.f
            {
                Camera2CameraControl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.this.p(completer);
            }
        }));
    }
}
