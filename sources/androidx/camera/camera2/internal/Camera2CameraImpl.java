package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.b.b.b2.a0;
import c.b.b.w1;
import e.j.b.a.c;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    private final CameraAvailability mCameraAvailability;
    @NonNull
    private CameraConfig mCameraConfig;
    private final Camera2CameraControlImpl mCameraControlInternal;
    @Nullable
    public CameraDevice mCameraDevice;
    public int mCameraDeviceError;
    @NonNull
    public final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateMachine mCameraStateMachine;
    private final CameraStateRegistry mCameraStateRegistry;
    public CaptureSessionInterface mCaptureSession;
    @NonNull
    private final SynchronizedCaptureSessionOpener.Builder mCaptureSessionOpenerBuilder;
    @NonNull
    private final CaptureSessionRepository mCaptureSessionRepository;
    public final Set<CaptureSession> mConfiguringForClose;
    @NonNull
    private final DisplayInfoManager mDisplayInfoManager;
    private final Executor mExecutor;
    public boolean mIsActiveResumingMode;
    public final Object mLock;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set<String> mNotifyStateAttachedSet;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    public final AtomicInteger mReleaseRequestCount;
    public final Map<CaptureSessionInterface, a<Void>> mReleasedCaptureSessions;
    private final ScheduledExecutorService mScheduledExecutorService;
    @Nullable
    @GuardedBy("mLock")
    private SessionProcessor mSessionProcessor;
    public volatile InternalState mState = InternalState.INITIALIZED;
    private final StateCallback mStateCallback;
    private final UseCaseAttachState mUseCaseAttachState;
    public a<Void> mUserReleaseFuture;
    public CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    /* renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$3 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState = iArr;
            try {
                iArr[InternalState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.PENDING_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.CLOSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.REOPENING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable = true;
        private final String mCameraId;

        public CameraAvailability(String str) {
            Camera2CameraImpl.this = r1;
            this.mCameraId = str;
        }

        public boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.tryOpenCameraDevice(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.tryOpenCameraDevice(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        public ControlUpdateListenerInternal() {
            Camera2CameraImpl.this = r1;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig() {
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }
    }

    /* loaded from: classes.dex */
    public enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public final class StateCallback extends CameraDevice.StateCallback {
        @NonNull
        private final CameraReopenMonitor mCameraReopenMonitor = new CameraReopenMonitor();
        private final Executor mExecutor;
        public ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;

        /* loaded from: classes.dex */
        public class CameraReopenMonitor {
            public static final int ACTIVE_REOPEN_DELAY_BASE_MS = 1000;
            public static final int ACTIVE_REOPEN_LIMIT_MS = 1800000;
            public static final int INVALID_TIME = -1;
            public static final int REOPEN_DELAY_MS = 700;
            public static final int REOPEN_LIMIT_MS = 10000;
            private long mFirstReopenTime = -1;

            public CameraReopenMonitor() {
                StateCallback.this = r3;
            }

            public boolean canScheduleCameraReopen() {
                if (getElapsedTime() >= ((long) getReopenLimitMs())) {
                    reset();
                    return false;
                }
                return true;
            }

            public long getElapsedTime() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.mFirstReopenTime == -1) {
                    this.mFirstReopenTime = uptimeMillis;
                }
                return uptimeMillis - this.mFirstReopenTime;
            }

            public int getReopenDelayMs() {
                if (StateCallback.this.shouldActiveResume()) {
                    long elapsedTime = getElapsedTime();
                    if (elapsedTime <= 120000) {
                        return 1000;
                    }
                    return elapsedTime <= 300000 ? 2000 : 4000;
                }
                return 700;
            }

            public int getReopenLimitMs() {
                if (StateCallback.this.shouldActiveResume()) {
                    return ACTIVE_REOPEN_LIMIT_MS;
                }
                return 10000;
            }

            public void reset() {
                this.mFirstReopenTime = -1L;
            }
        }

        /* loaded from: classes.dex */
        public class ScheduledReopen implements Runnable {
            private boolean mCancelled = false;
            private Executor mExecutor;

            public ScheduledReopen(@NonNull Executor executor) {
                StateCallback.this = r1;
                this.mExecutor = executor;
            }

            /* renamed from: a */
            public /* synthetic */ void b() {
                if (this.mCancelled) {
                    return;
                }
                Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.REOPENING);
                if (StateCallback.this.shouldActiveResume()) {
                    Camera2CameraImpl.this.tryForceOpenCameraDevice(true);
                } else {
                    Camera2CameraImpl.this.tryOpenCameraDevice(true);
                }
            }

            public void cancel() {
                this.mCancelled = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.t
                    {
                        Camera2CameraImpl.StateCallback.ScheduledReopen.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera2CameraImpl.StateCallback.ScheduledReopen.this.b();
                    }
                });
            }
        }

        public StateCallback(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
            Camera2CameraImpl.this = r1;
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
        }

        private void handleErrorOnOpen(@NonNull CameraDevice cameraDevice, int i2) {
            boolean z = Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.REOPENING;
            Preconditions.checkState(z, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (i2 != 1 && i2 != 2 && i2 != 4) {
                Logger.e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i2) + " closing camera.");
                Camera2CameraImpl.this.setState(InternalState.CLOSING, CameraState.StateError.create(i2 == 3 ? 5 : 6));
                Camera2CameraImpl.this.closeCamera(false);
                return;
            }
            Logger.d(Camera2CameraImpl.TAG, String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2)));
            reopenCameraAfterError(i2);
        }

        private void reopenCameraAfterError(int i2) {
            int i3 = 1;
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i2 == 1) {
                i3 = 2;
            } else if (i2 != 2) {
                i3 = 3;
            }
            Camera2CameraImpl.this.setState(InternalState.REOPENING, CameraState.StateError.create(i3));
            Camera2CameraImpl.this.closeCamera(false);
        }

        public boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle != null) {
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                camera2CameraImpl.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable);
                this.mScheduledReopenRunnable.cancel();
                this.mScheduledReopenRunnable = null;
                this.mScheduledReopenHandle.cancel(false);
                this.mScheduledReopenHandle = null;
                return true;
            }
            return false;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()");
            boolean z = Camera2CameraImpl.this.mCameraDevice == null;
            Preconditions.checkState(z, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i2 != 3) {
                if (i2 == 6) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.mCameraDeviceError != 0) {
                        camera2CameraImpl.debugLog("Camera closed due to error: " + Camera2CameraImpl.getErrorMessage(Camera2CameraImpl.this.mCameraDeviceError));
                        scheduleCameraReopen();
                        return;
                    }
                    camera2CameraImpl.tryOpenCameraDevice(false);
                    return;
                } else if (i2 != 7) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.finishClose();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i2;
            int i3 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[camera2CameraImpl.mState.ordinal()];
            if (i3 != 3) {
                if (i3 == 4 || i3 == 5 || i3 == 6) {
                    Logger.d(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2), Camera2CameraImpl.this.mState.name()));
                    handleErrorOnOpen(cameraDevice, i2);
                    return;
                } else if (i3 != 7) {
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            Logger.e(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2), Camera2CameraImpl.this.mState.name()));
            Camera2CameraImpl.this.closeCamera(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = 0;
            resetReopenMonitor();
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i2 != 3) {
                if (i2 == 5 || i2 == 6) {
                    Camera2CameraImpl.this.setState(InternalState.OPENED);
                    Camera2CameraImpl.this.openCaptureSession();
                    return;
                } else if (i2 != 7) {
                    throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.mCameraDevice.close();
            Camera2CameraImpl.this.mCameraDevice = null;
        }

        public void resetReopenMonitor() {
            this.mCameraReopenMonitor.reset();
        }

        public void scheduleCameraReopen() {
            Preconditions.checkState(this.mScheduledReopenRunnable == null);
            Preconditions.checkState(this.mScheduledReopenHandle == null);
            if (this.mCameraReopenMonitor.canScheduleCameraReopen()) {
                this.mScheduledReopenRunnable = new ScheduledReopen(this.mExecutor);
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                camera2CameraImpl.debugLog("Attempting camera re-open in " + this.mCameraReopenMonitor.getReopenDelayMs() + "ms: " + this.mScheduledReopenRunnable + " activeResuming = " + Camera2CameraImpl.this.mIsActiveResumingMode);
                this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, (long) this.mCameraReopenMonitor.getReopenDelayMs(), TimeUnit.MILLISECONDS);
                return;
            }
            Logger.e(Camera2CameraImpl.TAG, "Camera reopening attempted for " + this.mCameraReopenMonitor.getReopenLimitMs() + "ms without success.");
            Camera2CameraImpl.this.setState(InternalState.PENDING_OPEN, null, false);
        }

        public boolean shouldActiveResume() {
            int i2;
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            return camera2CameraImpl.mIsActiveResumingMode && ((i2 = camera2CameraImpl.mCameraDeviceError) == 1 || i2 == 2);
        }
    }

    @c
    /* loaded from: classes.dex */
    public static abstract class UseCaseInfo {
        @NonNull
        public static UseCaseInfo create(@NonNull String str, @NonNull Class<?> cls, @NonNull SessionConfig sessionConfig, @Nullable Size size) {
            return new AutoValue_Camera2CameraImpl_UseCaseInfo(str, cls, sessionConfig, size);
        }

        @NonNull
        public static UseCaseInfo from(@NonNull UseCase useCase) {
            return create(Camera2CameraImpl.getUseCaseId(useCase), useCase.getClass(), useCase.getSessionConfig(), useCase.getAttachedSurfaceResolution());
        }

        @NonNull
        public abstract SessionConfig getSessionConfig();

        @Nullable
        public abstract Size getSurfaceResolution();

        @NonNull
        public abstract String getUseCaseId();

        @NonNull
        public abstract Class<?> getUseCaseType();
    }

    public Camera2CameraImpl(@NonNull CameraManagerCompat cameraManagerCompat, @NonNull String str, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull CameraStateRegistry cameraStateRegistry, @NonNull Executor executor, @NonNull Handler handler, @NonNull DisplayInfoManager displayInfoManager) throws CameraUnavailableException {
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.mObservableState = liveDataObservable;
        this.mCameraDeviceError = 0;
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mConfiguringForClose = new HashSet();
        this.mNotifyStateAttachedSet = new HashSet();
        this.mLock = new Object();
        this.mIsActiveResumingMode = false;
        this.mCameraManager = cameraManagerCompat;
        this.mCameraStateRegistry = cameraStateRegistry;
        ScheduledExecutorService newHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mScheduledExecutorService = newHandlerExecutor;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = newSequentialExecutor;
        this.mStateCallback = new StateCallback(newSequentialExecutor, newHandlerExecutor);
        this.mUseCaseAttachState = new UseCaseAttachState(str);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        CameraStateMachine cameraStateMachine = new CameraStateMachine(cameraStateRegistry);
        this.mCameraStateMachine = cameraStateMachine;
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(newSequentialExecutor);
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mDisplayInfoManager = displayInfoManager;
        this.mCaptureSession = newCaptureSession();
        try {
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraManagerCompat.getCameraCharacteristicsCompat(str), newHandlerExecutor, newSequentialExecutor, new ControlUpdateListenerInternal(), camera2CameraInfoImpl.getCameraQuirks());
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = camera2CameraInfoImpl;
            camera2CameraInfoImpl.linkWithCameraControl(camera2CameraControlImpl);
            camera2CameraInfoImpl.setCameraStateSource(cameraStateMachine.getStateLiveData());
            this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSessionOpener.Builder(newSequentialExecutor, newHandlerExecutor, handler, captureSessionRepository, camera2CameraInfoImpl.getCameraQuirks(), DeviceQuirks.getAll());
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.mCameraAvailability = cameraAvailability;
            cameraStateRegistry.registerCamera(this, newSequentialExecutor, cameraAvailability);
            cameraManagerCompat.registerAvailabilityCallback(newSequentialExecutor, cameraAvailability);
        } catch (CameraAccessExceptionCompat e2) {
            throw CameraUnavailableExceptionHelper.createFrom(e2);
        }
    }

    /* renamed from: A */
    public /* synthetic */ Object B(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.r
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.z(completer);
            }
        });
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    /* renamed from: C */
    public /* synthetic */ void D(boolean z) {
        this.mIsActiveResumingMode = z;
        if (z && this.mState == InternalState.PENDING_OPEN) {
            tryForceOpenCameraDevice(false);
        }
    }

    private void addMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            useCaseAttachState.setUseCaseAttached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
            UseCaseAttachState useCaseAttachState2 = this.mUseCaseAttachState;
            useCaseAttachState2.setUseCaseActive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
        }
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        SessionConfig build = this.mUseCaseAttachState.getAttachedBuilder().build();
        CaptureConfig repeatingCaptureConfig = build.getRepeatingCaptureConfig();
        int size = repeatingCaptureConfig.getSurfaces().size();
        int size2 = build.getSurfaces().size();
        if (build.getSurfaces().isEmpty()) {
            return;
        }
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            if (this.mMeteringRepeatingSession == null) {
                this.mMeteringRepeatingSession = new MeteringRepeatingSession(this.mCameraInfoInternal.getCameraCharacteristicsCompat(), this.mDisplayInfoManager);
            }
            addMeteringRepeating();
        } else if (size2 == 1 && size == 1) {
            removeMeteringRepeating();
        } else if (size >= 2) {
            removeMeteringRepeating();
        } else {
            Logger.d(TAG, "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void c(List list) {
        try {
            tryAttachUseCases(list);
        } finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Logger.w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        for (SessionConfig sessionConfig : this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs()) {
            List<DeferrableSurface> surfaces = sessionConfig.getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                for (DeferrableSurface deferrableSurface : surfaces) {
                    builder.addSurface(deferrableSurface);
                }
            }
        }
        if (builder.getSurfaces().isEmpty()) {
            Logger.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
            return false;
        }
        return true;
    }

    public void closeInternal() {
        debugLog("Closing camera.");
        int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        if (i2 == 2) {
            Preconditions.checkState(this.mCameraDevice == null);
            setState(InternalState.INITIALIZED);
        } else if (i2 == 4) {
            setState(InternalState.CLOSING);
            closeCamera(false);
        } else if (i2 != 5 && i2 != 6) {
            debugLog("close() ignored due to being in state: " + this.mState);
        } else {
            boolean cancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
            setState(InternalState.CLOSING);
            if (cancelScheduledReopen) {
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
            }
        }
    }

    private void configAndClose(boolean z) {
        final CaptureSession captureSession = new CaptureSession();
        this.mConfiguringForClose.add(captureSession);
        resetCaptureSession(z);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final Runnable runnable = new Runnable() { // from class: c.b.a.d.d0
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.e(surface, surfaceTexture);
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        final ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        builder.addNonRepeatingSurface(immediateSurface);
        builder.setTemplateType(1);
        debugLog("Start configAndClose.");
        captureSession.open(builder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()).addListener(new Runnable() { // from class: c.b.a.d.z
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.g(captureSession, immediateSurface, runnable);
            }
        }, this.mExecutor);
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
        arrayList.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    public static /* synthetic */ void e(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    public static String getErrorMessage(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    private a<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.w
                    {
                        Camera2CameraImpl.this = this;
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return Camera2CameraImpl.this.k(completer);
                    }
                });
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    @NonNull
    public static String getUseCaseId(@NonNull UseCase useCase) {
        return useCase.getName() + useCase.hashCode();
    }

    private boolean isLegacyDevice() {
        return ((Camera2CameraInfoImpl) getCameraInfoInternal()).getSupportedHardwareLevel() == 2;
    }

    /* renamed from: j */
    public /* synthetic */ Object k(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(this.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = completer;
        return "Release[camera=" + this + "]";
    }

    /* renamed from: l */
    public /* synthetic */ Object m(final String str, final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.v
                {
                    Camera2CameraImpl.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraImpl.this.o(completer, str);
                }
            });
            return "isUseCaseAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
            return "isUseCaseAttached";
        }
    }

    /* renamed from: n */
    public /* synthetic */ void o(CallbackToFutureAdapter.Completer completer, String str) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(str)));
    }

    @NonNull
    private CaptureSessionInterface newCaptureSession() {
        synchronized (this.mLock) {
            if (this.mSessionProcessor == null) {
                return new CaptureSession();
            }
            return new ProcessingCaptureSession(this.mSessionProcessor, this.mCameraInfoInternal, this.mExecutor, this.mScheduledExecutorService);
        }
    }

    private void notifyStateAttachedToUseCases(List<UseCase> list) {
        for (UseCase useCase : list) {
            String useCaseId = getUseCaseId(useCase);
            if (!this.mNotifyStateAttachedSet.contains(useCaseId)) {
                this.mNotifyStateAttachedSet.add(useCaseId);
                useCase.onStateAttached();
            }
        }
    }

    private void notifyStateDetachedToUseCases(List<UseCase> list) {
        for (UseCase useCase : list) {
            String useCaseId = getUseCaseId(useCase);
            if (this.mNotifyStateAttachedSet.contains(useCaseId)) {
                useCase.onStateDetached();
                this.mNotifyStateAttachedSet.remove(useCaseId);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void openCameraDevice(boolean z) {
        if (!z) {
            this.mStateCallback.resetReopenMonitor();
        }
        this.mStateCallback.cancelScheduledReopen();
        debugLog("Opening camera.");
        setState(InternalState.OPENING);
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e2) {
            debugLog("Unable to open camera due to " + e2.getMessage());
            if (e2.getReason() != 10001) {
                return;
            }
            setState(InternalState.INITIALIZED, CameraState.StateError.create(7, e2));
        } catch (SecurityException e3) {
            debugLog("Unable to open camera due to " + e3.getMessage());
            setState(InternalState.REOPENING);
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    public void openInternal() {
        int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        if (i2 == 1 || i2 == 2) {
            tryForceOpenCameraDevice(false);
        } else if (i2 != 3) {
            debugLog("open() ignored due to being in state: " + this.mState);
        } else {
            setState(InternalState.REOPENING);
            if (isSessionCloseComplete() || this.mCameraDeviceError != 0) {
                return;
            }
            Preconditions.checkState(this.mCameraDevice != null, "Camera Device should be open if session close is not complete");
            setState(InternalState.OPENED);
            openCaptureSession();
        }
    }

    /* renamed from: p */
    public /* synthetic */ void q(String str, SessionConfig sessionConfig) {
        debugLog("Use case " + str + " ACTIVE");
        this.mUseCaseAttachState.setUseCaseActive(str, sessionConfig);
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig);
        updateCaptureSessionConfig();
    }

    /* renamed from: r */
    public /* synthetic */ void s(String str) {
        debugLog("Use case " + str + " INACTIVE");
        this.mUseCaseAttachState.setUseCaseInactive(str);
        updateCaptureSessionConfig();
    }

    private a<Void> releaseInternal() {
        a<Void> orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 2:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
                break;
            case 3:
            case 5:
            case 6:
            case 7:
                boolean cancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
                setState(InternalState.RELEASING);
                if (cancelScheduledReopen) {
                    Preconditions.checkState(isSessionCloseComplete());
                    finishClose();
                    break;
                }
                break;
            case 4:
                setState(InternalState.RELEASING);
                closeCamera(false);
                break;
            default:
                debugLog("release() ignored due to being in state: " + this.mState);
                break;
        }
        return orCreateUserReleaseFuture;
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            useCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            UseCaseAttachState useCaseAttachState2 = this.mUseCaseAttachState;
            useCaseAttachState2.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mMeteringRepeatingSession.clear();
            this.mMeteringRepeatingSession = null;
        }
    }

    /* renamed from: t */
    public /* synthetic */ void u(String str, SessionConfig sessionConfig) {
        debugLog("Use case " + str + " RESET");
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig);
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    @NonNull
    private Collection<UseCaseInfo> toUseCaseInfos(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            arrayList.add(UseCaseInfo.from(useCase));
        }
        return arrayList;
    }

    private void tryAttachUseCases(@NonNull Collection<UseCaseInfo> collection) {
        Size surfaceResolution;
        boolean isEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (UseCaseInfo useCaseInfo : collection) {
            if (!this.mUseCaseAttachState.isUseCaseAttached(useCaseInfo.getUseCaseId())) {
                this.mUseCaseAttachState.setUseCaseAttached(useCaseInfo.getUseCaseId(), useCaseInfo.getSessionConfig());
                arrayList.add(useCaseInfo.getUseCaseId());
                if (useCaseInfo.getUseCaseType() == Preview.class && (surfaceResolution = useCaseInfo.getSurfaceResolution()) != null) {
                    rational = new Rational(surfaceResolution.getWidth(), surfaceResolution.getHeight());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (isEmpty) {
            this.mCameraControlInternal.setActive(true);
            this.mCameraControlInternal.incrementUseCount();
        }
        addOrRemoveMeteringRepeatingUseCase();
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        } else {
            openInternal();
        }
        if (rational != null) {
            this.mCameraControlInternal.setPreviewAspectRatio(rational);
        }
    }

    /* renamed from: tryDetachUseCases */
    public void i(@NonNull Collection<UseCaseInfo> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (UseCaseInfo useCaseInfo : collection) {
            if (this.mUseCaseAttachState.isUseCaseAttached(useCaseInfo.getUseCaseId())) {
                this.mUseCaseAttachState.removeUseCase(useCaseInfo.getUseCaseId());
                arrayList.add(useCaseInfo.getUseCaseId());
                if (useCaseInfo.getUseCaseType() == Preview.class) {
                    z = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        if (z) {
            this.mCameraControlInternal.setPreviewAspectRatio(null);
        }
        addOrRemoveMeteringRepeatingUseCase();
        if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
            this.mCameraControlInternal.decrementUseCount();
            resetCaptureSession(false);
            this.mCameraControlInternal.setActive(false);
            this.mCaptureSession = newCaptureSession();
            closeInternal();
            return;
        }
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    /* renamed from: v */
    public /* synthetic */ void w(String str, SessionConfig sessionConfig) {
        debugLog("Use case " + str + " UPDATED");
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig);
        updateCaptureSessionConfig();
    }

    /* renamed from: y */
    public /* synthetic */ void z(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        this.mCameraControlInternal.incrementUseCount();
        notifyStateAttachedToUseCases(new ArrayList(arrayList));
        final ArrayList arrayList2 = new ArrayList(toUseCaseInfos(arrayList));
        try {
            this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.a0
                {
                    Camera2CameraImpl.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraImpl.this.c(arrayList2);
                }
            });
        } catch (RejectedExecutionException e2) {
            debugLog("Unable to attach use cases.", e2);
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.x
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.closeInternal();
            }
        });
    }

    public void closeCamera(boolean z) {
        boolean z2 = this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0);
        Preconditions.checkState(z2, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 23 && i2 < 29 && isLegacyDevice() && this.mCameraDeviceError == 0) {
            configAndClose(z);
        } else {
            resetCaptureSession(z);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public void debugLog(@NonNull String str) {
        debugLog(str, null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(toUseCaseInfos(arrayList));
        notifyStateDetachedToUseCases(new ArrayList(arrayList));
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.f0
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.i(arrayList2);
            }
        });
    }

    @Nullable
    public SessionConfig findSessionConfigForSurface(@NonNull DeferrableSurface deferrableSurface) {
        for (SessionConfig sessionConfig : this.mUseCaseAttachState.getAttachedSessionConfigs()) {
            if (sessionConfig.getSurfaces().contains(deferrableSurface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    public void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public CameraAvailability getCameraAvailability() {
        return this.mCameraAvailability;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ CameraControl getCameraControl() {
        CameraControl cameraControlInternal;
        cameraControlInternal = getCameraControlInternal();
        return cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ CameraInfo getCameraInfo() {
        CameraInfo cameraInfoInternal;
        cameraInfoInternal = getCameraInfoInternal();
        return cameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ LinkedHashSet getCameraInternals() {
        return a0.$default$getCameraInternals(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    @NonNull
    public CameraConfig getExtendedConfig() {
        return this.mCameraConfig;
    }

    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty() && this.mConfiguringForClose.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public boolean isUseCaseAttached(@NonNull UseCase useCase) {
        try {
            final String useCaseId = getUseCaseId(useCase);
            return ((Boolean) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.p
                {
                    Camera2CameraImpl.this = this;
                }

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return Camera2CameraImpl.this.m(useCaseId, completer);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException("Unable to check if use case is attached.", e2);
        }
    }

    @Override // androidx.camera.core.Camera
    public /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return w1.$default$isUseCasesCombinationSupported(this, useCaseArr);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(@NonNull UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        final String useCaseId = getUseCaseId(useCase);
        final SessionConfig sessionConfig = useCase.getSessionConfig();
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.q
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.q(useCaseId, sessionConfig);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        final String useCaseId = getUseCaseId(useCase);
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.u
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.s(useCaseId);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(@NonNull UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        final String useCaseId = getUseCaseId(useCase);
        final SessionConfig sessionConfig = useCase.getSessionConfig();
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.b0
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.u(useCaseId, sessionConfig);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        final String useCaseId = getUseCaseId(useCase);
        final SessionConfig sessionConfig = useCase.getSessionConfig();
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.o
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.w(useCaseId, sessionConfig);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.s
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.openInternal();
            }
        });
    }

    public void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (!attachedBuilder.isValid()) {
            debugLog("Unable to create capture session due to conflicting configurations");
        } else {
            Futures.addCallback(this.mCaptureSession.open(attachedBuilder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
                {
                    Camera2CameraImpl.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        SessionConfig findSessionConfigForSurface = Camera2CameraImpl.this.findSessionConfigForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                        if (findSessionConfigForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(findSessionConfigForSurface);
                        }
                    } else if (th instanceof CancellationException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera cancelled");
                    } else {
                        InternalState internalState = Camera2CameraImpl.this.mState;
                        InternalState internalState2 = InternalState.OPENED;
                        if (internalState == internalState2) {
                            Camera2CameraImpl.this.setState(internalState2, CameraState.StateError.create(4, th));
                        }
                        if (th instanceof CameraAccessException) {
                            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                            camera2CameraImpl.debugLog("Unable to configure camera due to " + th.getMessage());
                        } else if (th instanceof TimeoutException) {
                            Logger.e(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + ", timeout!");
                        }
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, this.mExecutor);
        }
    }

    public void postSurfaceClosedError(@NonNull final SessionConfig sessionConfig) {
        ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (errorListeners.isEmpty()) {
            return;
        }
        final SessionConfig.ErrorListener errorListener = errorListeners.get(0);
        debugLog("Posting surface closed", new Throwable());
        mainThreadExecutor.execute(new Runnable() { // from class: c.b.a.d.c0
            @Override // java.lang.Runnable
            public final void run() {
                errorListener.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public a<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.y
            {
                Camera2CameraImpl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraImpl.this.B(completer);
            }
        });
    }

    /* renamed from: releaseNoOpSession */
    public void g(@NonNull CaptureSession captureSession, @NonNull DeferrableSurface deferrableSurface, @NonNull Runnable runnable) {
        this.mConfiguringForClose.remove(captureSession);
        a<Void> releaseSession = releaseSession(captureSession, false);
        deferrableSurface.close();
        Futures.successfulAsList(Arrays.asList(releaseSession, deferrableSurface.getTerminationFuture())).addListener(runnable, CameraXExecutors.directExecutor());
    }

    public a<Void> releaseSession(@NonNull final CaptureSessionInterface captureSessionInterface, boolean z) {
        captureSessionInterface.close();
        a<Void> release = captureSessionInterface.release(z);
        debugLog("Releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(captureSessionInterface, release);
        Futures.addCallback(release, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
            {
                Camera2CameraImpl.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r2) {
                CameraDevice cameraDevice;
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSessionInterface);
                int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
                if (i2 != 3) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.mCameraDeviceError == 0) {
                        return;
                    }
                }
                if (!Camera2CameraImpl.this.isSessionCloseComplete() || (cameraDevice = Camera2CameraImpl.this.mCameraDevice) == null) {
                    return;
                }
                ApiCompat.Api21Impl.close(cameraDevice);
                Camera2CameraImpl.this.mCameraDevice = null;
            }
        }, CameraXExecutors.directExecutor());
        return release;
    }

    public void resetCaptureSession(boolean z) {
        Preconditions.checkState(this.mCaptureSession != null);
        debugLog("Resetting Capture Session");
        CaptureSessionInterface captureSessionInterface = this.mCaptureSession;
        SessionConfig sessionConfig = captureSessionInterface.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSessionInterface.getCaptureConfigs();
        CaptureSessionInterface newCaptureSession = newCaptureSession();
        this.mCaptureSession = newCaptureSession;
        newCaptureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        releaseSession(captureSessionInterface, z);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setActiveResumingMode(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.e0
            {
                Camera2CameraImpl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.this.D(z);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        if (cameraConfig == null) {
            cameraConfig = CameraConfigs.emptyConfig();
        }
        SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor(null);
        this.mCameraConfig = cameraConfig;
        synchronized (this.mLock) {
            this.mSessionProcessor = sessionProcessor;
        }
        getCameraControlInternal().setZslDisabled(cameraConfig.isZslDisabled().booleanValue());
    }

    public void setState(@NonNull InternalState internalState) {
        setState(internalState, null);
    }

    public void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder from = CaptureConfig.Builder.from(captureConfig);
            if (captureConfig.getTemplateType() == 5 && captureConfig.getCameraCaptureResult() != null) {
                from.setCameraCaptureResult(captureConfig.getCameraCaptureResult());
            }
            if (!captureConfig.getSurfaces().isEmpty() || !captureConfig.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(from)) {
                arrayList.add(from.build());
            }
        }
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    public void tryForceOpenCameraDevice(boolean z) {
        debugLog("Attempting to force open the camera.");
        if (!this.mCameraStateRegistry.tryOpenCamera(this)) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        openCameraDevice(z);
    }

    public void tryOpenCameraDevice(boolean z) {
        debugLog("Attempting to open the camera.");
        if (!(this.mCameraAvailability.isCameraAvailable() && this.mCameraStateRegistry.tryOpenCamera(this))) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        openCameraDevice(z);
    }

    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (activeAndAttachedBuilder.isValid()) {
            this.mCameraControlInternal.setTemplate(activeAndAttachedBuilder.build().getTemplateType());
            activeAndAttachedBuilder.add(this.mCameraControlInternal.getSessionConfig());
            this.mCaptureSession.setSessionConfig(activeAndAttachedBuilder.build());
            return;
        }
        this.mCameraControlInternal.resetTemplate();
        this.mCaptureSession.setSessionConfig(this.mCameraControlInternal.getSessionConfig());
    }

    private void debugLog(@NonNull String str, @Nullable Throwable th) {
        Logger.d(TAG, String.format("{%s} %s", toString(), str), th);
    }

    public void setState(@NonNull InternalState internalState, @Nullable CameraState.StateError stateError) {
        setState(internalState, stateError, true);
    }

    public void setState(@NonNull InternalState internalState, @Nullable CameraState.StateError stateError, boolean z) {
        CameraInternal.State state;
        debugLog("Transitioning camera internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
        switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[internalState.ordinal()]) {
            case 1:
                state = CameraInternal.State.CLOSED;
                break;
            case 2:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 3:
                state = CameraInternal.State.CLOSING;
                break;
            case 4:
                state = CameraInternal.State.OPEN;
                break;
            case 5:
            case 6:
                state = CameraInternal.State.OPENING;
                break;
            case 7:
                state = CameraInternal.State.RELEASING;
                break;
            case 8:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.mCameraStateRegistry.markCameraState(this, state, z);
        this.mObservableState.postValue(state);
        this.mCameraStateMachine.updateState(state, stateError);
    }
}
