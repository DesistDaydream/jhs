package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class WaitForRepeatingRequestStart {
    private final boolean mHasCaptureSessionStuckQuirk;
    private boolean mHasSubmittedRepeating;
    public CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;
    @NonNull
    private final a<Void> mStartStreamingFuture;
    private final Object mLock = new Object();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.1
        {
            WaitForRepeatingRequestStart.this = this;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i2) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.setCancelled();
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j2, long j3) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.set(null);
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }
    };

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface OpenCaptureSession {
        @NonNull
        a<Void> run(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list);
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface SingleRepeatingRequest {
        int run(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public WaitForRepeatingRequestStart(@NonNull Quirks quirks) {
        this.mHasCaptureSessionStuckQuirk = quirks.contains(CaptureSessionStuckQuirk.class);
        if (shouldWaitRepeatingSubmit()) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.k2.w.a
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return WaitForRepeatingRequestStart.this.b(completer);
                }
            });
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
    }

    /* renamed from: a */
    public /* synthetic */ Object b(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mStartStreamingCompleter = completer;
        return "WaitForRepeatingRequestStart[" + this + "]";
    }

    public static /* synthetic */ a c(OpenCaptureSession openCaptureSession, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list, List list2) throws Exception {
        return openCaptureSession.run(cameraDevice, sessionConfigurationCompat, list);
    }

    @NonNull
    public a<Void> getStartStreamFuture() {
        return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    public void onSessionEnd() {
        synchronized (this.mLock) {
            if (shouldWaitRepeatingSubmit() && !this.mHasSubmittedRepeating) {
                this.mStartStreamingFuture.cancel(true);
            }
        }
    }

    @NonNull
    public a<Void> openCaptureSession(@NonNull final CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat, @NonNull final List<DeferrableSurface> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull final OpenCaptureSession openCaptureSession) {
        ArrayList arrayList = new ArrayList();
        for (SynchronizedCaptureSession synchronizedCaptureSession : list2) {
            arrayList.add(synchronizedCaptureSession.getOpeningBlocker());
        }
        return FutureChain.from(Futures.successfulAsList(arrayList)).transformAsync(new AsyncFunction() { // from class: c.b.a.d.k2.w.b
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final e.j.c.a.a.a apply(Object obj) {
                return WaitForRepeatingRequestStart.c(WaitForRepeatingRequestStart.OpenCaptureSession.this, cameraDevice, sessionConfigurationCompat, list, (List) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull SingleRepeatingRequest singleRepeatingRequest) throws CameraAccessException {
        int run;
        synchronized (this.mLock) {
            if (shouldWaitRepeatingSubmit()) {
                captureCallback = Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, captureCallback);
                this.mHasSubmittedRepeating = true;
            }
            run = singleRepeatingRequest.run(captureRequest, captureCallback);
        }
        return run;
    }

    public boolean shouldWaitRepeatingSubmit() {
        return this.mHasCaptureSessionStuckQuirk;
    }
}
