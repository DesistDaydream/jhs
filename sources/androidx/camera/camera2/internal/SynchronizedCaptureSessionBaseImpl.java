package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

@RequiresApi(21)
/* loaded from: classes.dex */
public class SynchronizedCaptureSessionBaseImpl extends SynchronizedCaptureSession.StateCallback implements SynchronizedCaptureSession, SynchronizedCaptureSessionOpener.OpenerImpl {
    private static final String TAG = "SyncCaptureSessionBase";
    @Nullable
    public CameraCaptureSessionCompat mCameraCaptureSessionCompat;
    @NonNull
    public final CaptureSessionRepository mCaptureSessionRepository;
    @Nullable
    public SynchronizedCaptureSession.StateCallback mCaptureSessionStateCallback;
    @NonNull
    public final Handler mCompatHandler;
    @NonNull
    public final Executor mExecutor;
    @Nullable
    @GuardedBy("mLock")
    public CallbackToFutureAdapter.Completer<Void> mOpenCaptureSessionCompleter;
    @Nullable
    @GuardedBy("mLock")
    public a<Void> mOpenCaptureSessionFuture;
    @NonNull
    private final ScheduledExecutorService mScheduledExecutorService;
    @Nullable
    @GuardedBy("mLock")
    private a<List<Surface>> mStartingSurface;
    public final Object mLock = new Object();
    @Nullable
    @GuardedBy("mLock")
    private List<DeferrableSurface> mHeldDeferrableSurfaces = null;
    @GuardedBy("mLock")
    private boolean mClosed = false;
    @GuardedBy("mLock")
    private boolean mOpenerDisabled = false;
    @GuardedBy("mLock")
    private boolean mSessionFinished = false;

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Surface getInputSurface(CameraCaptureSession cameraCaptureSession) {
            return cameraCaptureSession.getInputSurface();
        }
    }

    public SynchronizedCaptureSessionBaseImpl(@NonNull CaptureSessionRepository captureSessionRepository, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mCompatHandler = handler;
        this.mExecutor = executor;
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    /* renamed from: a */
    public /* synthetic */ void b() {
        onSessionFinished(this);
    }

    /* renamed from: c */
    public /* synthetic */ void d(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionRepository.onCaptureSessionClosed(this);
        onSessionFinished(synchronizedCaptureSession);
        this.mCaptureSessionStateCallback.onClosed(synchronizedCaptureSession);
    }

    /* renamed from: e */
    public /* synthetic */ void f(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onSessionFinished(synchronizedCaptureSession);
    }

    /* renamed from: g */
    public /* synthetic */ Object h(List list, CameraDeviceCompat cameraDeviceCompat, SessionConfigurationCompat sessionConfigurationCompat, CallbackToFutureAdapter.Completer completer) throws Exception {
        String str;
        synchronized (this.mLock) {
            holdDeferrableSurfaces(list);
            Preconditions.checkState(this.mOpenCaptureSessionCompleter == null, "The openCaptureSessionCompleter can only set once!");
            this.mOpenCaptureSessionCompleter = completer;
            cameraDeviceCompat.createCaptureSession(sessionConfigurationCompat);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* renamed from: i */
    public /* synthetic */ a j(List list, List list2) throws Exception {
        Logger.d(TAG, "[" + this + "] getSurface...done");
        if (list2.contains(null)) {
            return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf(null))));
        }
        if (list2.isEmpty()) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Unable to open capture session without surfaces"));
        }
        return Futures.immediateFuture(list2);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void abortCaptures() throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().abortCaptures();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureBurstRequests(list, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureSingleRequest(captureRequest, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCaptureSessionRepository.onCaptureSessionClosing(this);
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().close();
        getExecutor().execute(new Runnable() { // from class: c.b.a.d.w1
            {
                SynchronizedCaptureSessionBaseImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SynchronizedCaptureSessionBaseImpl.this.b();
            }
        });
    }

    public void createCaptureSessionCompat(@NonNull CameraCaptureSession cameraCaptureSession) {
        if (this.mCameraCaptureSessionCompat == null) {
            this.mCameraCaptureSessionCompat = CameraCaptureSessionCompat.toCameraCaptureSessionCompat(cameraCaptureSession, this.mCompatHandler);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public SessionConfigurationCompat createSessionConfigurationCompat(int i2, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback) {
        this.mCaptureSessionStateCallback = stateCallback;
        return new SessionConfigurationCompat(i2, list, getExecutor(), new CameraCaptureSession.StateCallback() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl.2
            {
                SynchronizedCaptureSessionBaseImpl.this = this;
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.onActive(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            @RequiresApi(api = 26)
            public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.onCaptureQueueEmpty(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.onClosed(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                CallbackToFutureAdapter.Completer<Void> completer;
                try {
                    SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.onConfigureFailed(synchronizedCaptureSessionBaseImpl);
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.mLock) {
                        Preconditions.checkNotNull(SynchronizedCaptureSessionBaseImpl.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl2 = SynchronizedCaptureSessionBaseImpl.this;
                        completer = synchronizedCaptureSessionBaseImpl2.mOpenCaptureSessionCompleter;
                        synchronizedCaptureSessionBaseImpl2.mOpenCaptureSessionCompleter = null;
                    }
                    completer.setException(new IllegalStateException("onConfigureFailed"));
                } catch (Throwable th) {
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.mLock) {
                        Preconditions.checkNotNull(SynchronizedCaptureSessionBaseImpl.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl3 = SynchronizedCaptureSessionBaseImpl.this;
                        CallbackToFutureAdapter.Completer<Void> completer2 = synchronizedCaptureSessionBaseImpl3.mOpenCaptureSessionCompleter;
                        synchronizedCaptureSessionBaseImpl3.mOpenCaptureSessionCompleter = null;
                        completer2.setException(new IllegalStateException("onConfigureFailed"));
                        throw th;
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                CallbackToFutureAdapter.Completer<Void> completer;
                try {
                    SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.onConfigured(synchronizedCaptureSessionBaseImpl);
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.mLock) {
                        Preconditions.checkNotNull(SynchronizedCaptureSessionBaseImpl.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl2 = SynchronizedCaptureSessionBaseImpl.this;
                        completer = synchronizedCaptureSessionBaseImpl2.mOpenCaptureSessionCompleter;
                        synchronizedCaptureSessionBaseImpl2.mOpenCaptureSessionCompleter = null;
                    }
                    completer.set(null);
                } catch (Throwable th) {
                    synchronized (SynchronizedCaptureSessionBaseImpl.this.mLock) {
                        Preconditions.checkNotNull(SynchronizedCaptureSessionBaseImpl.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl3 = SynchronizedCaptureSessionBaseImpl.this;
                        CallbackToFutureAdapter.Completer<Void> completer2 = synchronizedCaptureSessionBaseImpl3.mOpenCaptureSessionCompleter;
                        synchronizedCaptureSessionBaseImpl3.mOpenCaptureSessionCompleter = null;
                        completer2.set(null);
                        throw th;
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
                SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.onReady(synchronizedCaptureSessionBaseImpl);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            @RequiresApi(api = 23)
            public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
                SynchronizedCaptureSessionBaseImpl.this.createCaptureSessionCompat(cameraCaptureSession);
                SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                synchronizedCaptureSessionBaseImpl.onSurfacePrepared(synchronizedCaptureSessionBaseImpl, surface);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void finishClose() {
        releaseDeferrableSurfaces();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public CameraDevice getDevice() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat.toCameraCaptureSession().getDevice();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @Nullable
    public Surface getInputSurface() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getInputSurface(this.mCameraCaptureSessionCompat.toCameraCaptureSession());
        }
        return null;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public a<Void> getOpeningBlocker() {
        return Futures.immediateFuture(null);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public SynchronizedCaptureSession.StateCallback getStateCallback() {
        return this;
    }

    public void holdDeferrableSurfaces(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        synchronized (this.mLock) {
            releaseDeferrableSurfaces();
            DeferrableSurfaces.incrementAll(list);
            this.mHeldDeferrableSurfaces = list;
        }
    }

    public boolean isCameraCaptureSessionOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mOpenCaptureSessionFuture != null;
        }
        return z;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onActive(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    @RequiresApi(api = 26)
    public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onCaptureQueueEmpty(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(@NonNull final SynchronizedCaptureSession synchronizedCaptureSession) {
        a<Void> aVar;
        synchronized (this.mLock) {
            if (this.mClosed) {
                aVar = null;
            } else {
                this.mClosed = true;
                Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");
                aVar = this.mOpenCaptureSessionFuture;
            }
        }
        finishClose();
        if (aVar != null) {
            aVar.addListener(new Runnable() { // from class: c.b.a.d.u1
                {
                    SynchronizedCaptureSessionBaseImpl.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SynchronizedCaptureSessionBaseImpl.this.d(synchronizedCaptureSession);
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        finishClose();
        this.mCaptureSessionRepository.onCaptureSessionConfigureFail(this);
        this.mCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionRepository.onCaptureSessionCreated(this);
        this.mCaptureSessionStateCallback.onConfigured(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onReady(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onSessionFinished(@NonNull final SynchronizedCaptureSession synchronizedCaptureSession) {
        a<Void> aVar;
        synchronized (this.mLock) {
            if (this.mSessionFinished) {
                aVar = null;
            } else {
                this.mSessionFinished = true;
                Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");
                aVar = this.mOpenCaptureSessionFuture;
            }
        }
        if (aVar != null) {
            aVar.addListener(new Runnable() { // from class: c.b.a.d.s1
                {
                    SynchronizedCaptureSessionBaseImpl.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SynchronizedCaptureSessionBaseImpl.this.f(synchronizedCaptureSession);
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    @RequiresApi(api = 23)
    public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        this.mCaptureSessionStateCallback.onSurfacePrepared(synchronizedCaptureSession, surface);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public a<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat, @NonNull final List<DeferrableSurface> list) {
        synchronized (this.mLock) {
            if (this.mOpenerDisabled) {
                return Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));
            }
            this.mCaptureSessionRepository.onCreateCaptureSession(this);
            final CameraDeviceCompat cameraDeviceCompat = CameraDeviceCompat.toCameraDeviceCompat(cameraDevice, this.mCompatHandler);
            a<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.t1
                {
                    SynchronizedCaptureSessionBaseImpl.this = this;
                }

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return SynchronizedCaptureSessionBaseImpl.this.h(list, cameraDeviceCompat, sessionConfigurationCompat, completer);
                }
            });
            this.mOpenCaptureSessionFuture = future;
            Futures.addCallback(future, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl.1
                {
                    SynchronizedCaptureSessionBaseImpl.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    SynchronizedCaptureSessionBaseImpl.this.finishClose();
                    SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = SynchronizedCaptureSessionBaseImpl.this;
                    synchronizedCaptureSessionBaseImpl.mCaptureSessionRepository.onCaptureSessionConfigureFail(synchronizedCaptureSessionBaseImpl);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, CameraXExecutors.directExecutor());
            return Futures.nonCancellationPropagating(this.mOpenCaptureSessionFuture);
        }
    }

    public void releaseDeferrableSurfaces() {
        synchronized (this.mLock) {
            List<DeferrableSurface> list = this.mHeldDeferrableSurfaces;
            if (list != null) {
                DeferrableSurfaces.decrementAll(list);
                this.mHeldDeferrableSurfaces = null;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setRepeatingBurstRequests(list, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setSingleRepeatingRequest(captureRequest, getExecutor(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public a<List<Surface>> startWithDeferrableSurface(@NonNull final List<DeferrableSurface> list, long j2) {
        synchronized (this.mLock) {
            if (this.mOpenerDisabled) {
                return Futures.immediateFailedFuture(new CancellationException("Opener is disabled"));
            }
            FutureChain transformAsync = FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(list, false, j2, getExecutor(), this.mScheduledExecutorService)).transformAsync(new AsyncFunction() { // from class: c.b.a.d.v1
                {
                    SynchronizedCaptureSessionBaseImpl.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final e.j.c.a.a.a apply(Object obj) {
                    return SynchronizedCaptureSessionBaseImpl.this.j(list, (List) obj);
                }
            }, getExecutor());
            this.mStartingSurface = transformAsync;
            return Futures.nonCancellationPropagating(transformAsync);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean z;
        try {
            synchronized (this.mLock) {
                if (!this.mOpenerDisabled) {
                    a<List<Surface>> aVar = this.mStartingSurface;
                    r1 = aVar != null ? aVar : null;
                    this.mOpenerDisabled = true;
                }
                z = !isCameraCaptureSessionOpen();
            }
            return z;
        } finally {
            if (r1 != null) {
                r1.cancel(true);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void stopRepeating() throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().stopRepeating();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public CameraCaptureSessionCompat toCameraCaptureSessionCompat() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureBurstRequests(list, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}
