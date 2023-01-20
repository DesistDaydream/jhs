package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ProcessingCaptureSession;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

@OptIn(markerClass = {ExperimentalCamera2Interop.class})
@RequiresApi(21)
/* loaded from: classes.dex */
public final class ProcessingCaptureSession implements CaptureSessionInterface {
    private static final String TAG = "ProcessingCaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    private static List<DeferrableSurface> sHeldProcessorSurfaces = new ArrayList();
    private static int sNextInstanceId = 0;
    private final Camera2CameraInfoImpl mCamera2CameraInfoImpl;
    public final Executor mExecutor;
    private int mInstanceId;
    @Nullable
    private SessionConfig mProcessorSessionConfig;
    @Nullable
    private Camera2RequestProcessor mRequestProcessor;
    private final ScheduledExecutorService mScheduledExecutorService;
    @Nullable
    private SessionConfig mSessionConfig;
    private final SessionProcessor mSessionProcessor;
    private final SessionProcessorCaptureCallback mSessionProcessorCaptureCallback;
    private List<DeferrableSurface> mOutputSurfaces = new ArrayList();
    private boolean mIsRepeatingRequestStarted = false;
    @Nullable
    private volatile CaptureConfig mPendingCaptureConfig = null;
    public volatile boolean mIsExecutingStillCaptureRequest = false;
    private CaptureRequestOptions mSessionOptions = new CaptureRequestOptions.Builder().build();
    private CaptureRequestOptions mStillCaptureOptions = new CaptureRequestOptions.Builder().build();
    private final CaptureSession mCaptureSession = new CaptureSession();
    private ProcessorState mProcessorState = ProcessorState.UNINITIALIZED;

    /* renamed from: androidx.camera.camera2.internal.ProcessingCaptureSession$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements SessionProcessor.CaptureCallback {
        public final /* synthetic */ CaptureConfig val$captureConfig;

        public AnonymousClass2(CaptureConfig captureConfig) {
            ProcessingCaptureSession.this = r1;
            this.val$captureConfig = captureConfig;
        }

        /* renamed from: a */
        public /* synthetic */ void b(CaptureConfig captureConfig) {
            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.getCameraCaptureCallbacks()) {
                cameraCaptureCallback.onCaptureFailed(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
            }
            ProcessingCaptureSession.this.mIsExecutingStillCaptureRequest = false;
        }

        /* renamed from: c */
        public /* synthetic */ void d(CaptureConfig captureConfig) {
            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.getCameraCaptureCallbacks()) {
                cameraCaptureCallback.onCaptureCompleted(new CameraCaptureResult.EmptyCameraCaptureResult());
            }
            ProcessingCaptureSession.this.mIsExecutingStillCaptureRequest = false;
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureFailed(int i2) {
            Executor executor = ProcessingCaptureSession.this.mExecutor;
            final CaptureConfig captureConfig = this.val$captureConfig;
            executor.execute(new Runnable() { // from class: c.b.a.d.m1
                {
                    ProcessingCaptureSession.AnonymousClass2.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.AnonymousClass2.this.b(captureConfig);
                }
            });
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureProcessStarted(int i2) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceAborted(int i2) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceCompleted(int i2) {
            Executor executor = ProcessingCaptureSession.this.mExecutor;
            final CaptureConfig captureConfig = this.val$captureConfig;
            executor.execute(new Runnable() { // from class: c.b.a.d.l1
                {
                    ProcessingCaptureSession.AnonymousClass2.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.AnonymousClass2.this.d(captureConfig);
                }
            });
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureStarted(int i2, long j2) {
        }
    }

    /* renamed from: androidx.camera.camera2.internal.ProcessingCaptureSession$3 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState;

        static {
            int[] iArr = new int[ProcessorState.values().length];
            $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState = iArr;
            try {
                iArr[ProcessorState.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.SESSION_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.ON_CAPTURE_SESSION_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.ON_CAPTURE_SESSION_ENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[ProcessorState.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum ProcessorState {
        UNINITIALIZED,
        SESSION_INITIALIZED,
        ON_CAPTURE_SESSION_STARTED,
        ON_CAPTURE_SESSION_ENDED,
        CLOSED
    }

    /* loaded from: classes.dex */
    public static class SessionProcessorCaptureCallback implements SessionProcessor.CaptureCallback {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks = Collections.emptyList();
        private final Executor mExecutor;

        public SessionProcessorCaptureCallback(@NonNull Executor executor) {
            this.mExecutor = executor;
        }

        /* renamed from: a */
        public /* synthetic */ void b() {
            for (CameraCaptureCallback cameraCaptureCallback : this.mCameraCaptureCallbacks) {
                cameraCaptureCallback.onCaptureFailed(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
            }
        }

        /* renamed from: c */
        public /* synthetic */ void d() {
            for (CameraCaptureCallback cameraCaptureCallback : this.mCameraCaptureCallbacks) {
                cameraCaptureCallback.onCaptureCompleted(CameraCaptureResult.EmptyCameraCaptureResult.create());
            }
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureFailed(int i2) {
            this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.n1
                {
                    ProcessingCaptureSession.SessionProcessorCaptureCallback.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.SessionProcessorCaptureCallback.this.b();
                }
            });
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureProcessStarted(int i2) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceAborted(int i2) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceCompleted(int i2) {
            this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.o1
                {
                    ProcessingCaptureSession.SessionProcessorCaptureCallback.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.SessionProcessorCaptureCallback.this.d();
                }
            });
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureStarted(int i2, long j2) {
        }

        public void setCameraCaptureCallbacks(@NonNull List<CameraCaptureCallback> list) {
            this.mCameraCaptureCallbacks = list;
        }
    }

    public ProcessingCaptureSession(@NonNull SessionProcessor sessionProcessor, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.mInstanceId = 0;
        this.mSessionProcessor = sessionProcessor;
        this.mCamera2CameraInfoImpl = camera2CameraInfoImpl;
        this.mExecutor = executor;
        this.mScheduledExecutorService = scheduledExecutorService;
        this.mSessionProcessorCaptureCallback = new SessionProcessorCaptureCallback(executor);
        int i2 = sNextInstanceId;
        sNextInstanceId = i2 + 1;
        this.mInstanceId = i2;
        Logger.d(TAG, "New ProcessingCaptureSession (id=" + this.mInstanceId + ")");
    }

    /* renamed from: a */
    public /* synthetic */ void b() {
        DeferrableSurfaces.decrementAll(this.mOutputSurfaces);
    }

    private static void cancelRequests(@NonNull List<CaptureConfig> list) {
        for (CaptureConfig captureConfig : list) {
            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.getCameraCaptureCallbacks()) {
                cameraCaptureCallback.onCaptureCancelled();
            }
        }
    }

    /* renamed from: d */
    public /* synthetic */ a e(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener, List list) throws Exception {
        Logger.d(TAG, "-- getSurfaces done, start init (id=" + this.mInstanceId + ")");
        if (this.mProcessorState == ProcessorState.CLOSED) {
            return Futures.immediateFailedFuture(new IllegalStateException("SessionProcessorCaptureSession is closed."));
        }
        OutputSurface outputSurface = null;
        if (list.contains(null)) {
            return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", sessionConfig.getSurfaces().get(list.indexOf(null))));
        }
        try {
            DeferrableSurfaces.incrementAll(this.mOutputSurfaces);
            OutputSurface outputSurface2 = null;
            OutputSurface outputSurface3 = null;
            for (int i2 = 0; i2 < sessionConfig.getSurfaces().size(); i2++) {
                DeferrableSurface deferrableSurface = sessionConfig.getSurfaces().get(i2);
                if (Objects.equals(deferrableSurface.getContainerClass(), Preview.class)) {
                    outputSurface = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
                } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageCapture.class)) {
                    outputSurface2 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
                } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageAnalysis.class)) {
                    outputSurface3 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
                }
            }
            this.mProcessorState = ProcessorState.SESSION_INITIALIZED;
            Logger.w(TAG, "== initSession (id=" + this.mInstanceId + ")");
            SessionConfig initSession = this.mSessionProcessor.initSession(this.mCamera2CameraInfoImpl, outputSurface, outputSurface2, outputSurface3);
            this.mProcessorSessionConfig = initSession;
            initSession.getSurfaces().get(0).getTerminationFuture().addListener(new Runnable() { // from class: c.b.a.d.p1
                {
                    ProcessingCaptureSession.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingCaptureSession.this.b();
                }
            }, CameraXExecutors.directExecutor());
            for (final DeferrableSurface deferrableSurface2 : this.mProcessorSessionConfig.getSurfaces()) {
                sHeldProcessorSurfaces.add(deferrableSurface2);
                deferrableSurface2.getTerminationFuture().addListener(new Runnable() { // from class: c.b.a.d.q1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingCaptureSession.sHeldProcessorSurfaces.remove(deferrableSurface2);
                    }
                }, this.mExecutor);
            }
            SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
            validatingBuilder.add(sessionConfig);
            validatingBuilder.clearSurfaces();
            validatingBuilder.add(this.mProcessorSessionConfig);
            Preconditions.checkArgument(validatingBuilder.isValid(), "Cannot transform the SessionConfig");
            a<Void> open = this.mCaptureSession.open(validatingBuilder.build(), (CameraDevice) Preconditions.checkNotNull(cameraDevice), synchronizedCaptureSessionOpener);
            Futures.addCallback(open, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.ProcessingCaptureSession.1
                {
                    ProcessingCaptureSession.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    Logger.e(ProcessingCaptureSession.TAG, "open session failed ", th);
                    ProcessingCaptureSession.this.close();
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, this.mExecutor);
            return open;
        } catch (DeferrableSurface.SurfaceClosedException e2) {
            return Futures.immediateFailedFuture(e2);
        }
    }

    /* renamed from: f */
    public /* synthetic */ Void g(Void r1) {
        onConfigured(this.mCaptureSession);
        return null;
    }

    private static List<SessionProcessorSurface> getSessionProcessorSurfaceList(List<DeferrableSurface> list) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Preconditions.checkArgument(deferrableSurface instanceof SessionProcessorSurface, "Surface must be SessionProcessorSurface");
            arrayList.add((SessionProcessorSurface) deferrableSurface);
        }
        return arrayList;
    }

    private boolean isStillCapture(@NonNull List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (CaptureConfig captureConfig : list) {
            if (captureConfig.getTemplateType() != 2) {
                return false;
            }
        }
        return true;
    }

    private void updateParameters(@NonNull CaptureRequestOptions captureRequestOptions, @NonNull CaptureRequestOptions captureRequestOptions2) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.insertAllOptions(captureRequestOptions);
        builder.insertAllOptions(captureRequestOptions2);
        this.mSessionProcessor.setParameters(builder.build());
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        Logger.d(TAG, "cancelIssuedCaptureRequests (id=" + this.mInstanceId + ")");
        if (this.mPendingCaptureConfig != null) {
            for (CameraCaptureCallback cameraCaptureCallback : this.mPendingCaptureConfig.getCameraCaptureCallbacks()) {
                cameraCaptureCallback.onCaptureCancelled();
            }
            this.mPendingCaptureConfig = null;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        Logger.d(TAG, "close (id=" + this.mInstanceId + ") state=" + this.mProcessorState);
        int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[this.mProcessorState.ordinal()];
        if (i2 != 2) {
            if (i2 == 3) {
                this.mSessionProcessor.onCaptureSessionEnd();
                Camera2RequestProcessor camera2RequestProcessor = this.mRequestProcessor;
                if (camera2RequestProcessor != null) {
                    camera2RequestProcessor.close();
                }
                this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_ENDED;
            } else if (i2 != 4) {
                if (i2 == 5) {
                    return;
                }
                this.mProcessorState = ProcessorState.CLOSED;
                this.mCaptureSession.close();
            }
        }
        this.mSessionProcessor.deInitSession();
        this.mProcessorState = ProcessorState.CLOSED;
        this.mCaptureSession.close();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public List<CaptureConfig> getCaptureConfigs() {
        return this.mPendingCaptureConfig != null ? Arrays.asList(this.mPendingCaptureConfig) : Collections.emptyList();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @Nullable
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(@NonNull List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() <= 1 && isStillCapture(list)) {
            if (this.mPendingCaptureConfig == null && !this.mIsExecutingStillCaptureRequest) {
                CaptureConfig captureConfig = list.get(0);
                Logger.d(TAG, "issueCaptureRequests (id=" + this.mInstanceId + ") + state =" + this.mProcessorState);
                int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$ProcessingCaptureSession$ProcessorState[this.mProcessorState.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    this.mPendingCaptureConfig = captureConfig;
                    return;
                } else if (i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        Logger.d(TAG, "Run issueCaptureRequests in wrong state, state = " + this.mProcessorState);
                        cancelRequests(list);
                        return;
                    }
                    return;
                } else {
                    this.mIsExecutingStillCaptureRequest = true;
                    CaptureRequestOptions.Builder from = CaptureRequestOptions.Builder.from(captureConfig.getImplementationOptions());
                    Config implementationOptions = captureConfig.getImplementationOptions();
                    Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
                    if (implementationOptions.containsOption(option)) {
                        from.setCaptureRequestOption(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
                    }
                    Config implementationOptions2 = captureConfig.getImplementationOptions();
                    Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
                    if (implementationOptions2.containsOption(option2)) {
                        from.setCaptureRequestOption(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
                    }
                    CaptureRequestOptions build = from.build();
                    this.mStillCaptureOptions = build;
                    updateParameters(this.mSessionOptions, build);
                    this.mSessionProcessor.startCapture(new AnonymousClass2(captureConfig));
                    return;
                }
            }
            cancelRequests(list);
            return;
        }
        cancelRequests(list);
    }

    public void onConfigured(@NonNull CaptureSession captureSession) {
        boolean z = this.mProcessorState == ProcessorState.SESSION_INITIALIZED;
        Preconditions.checkArgument(z, "Invalid state state:" + this.mProcessorState);
        Camera2RequestProcessor camera2RequestProcessor = new Camera2RequestProcessor(captureSession, getSessionProcessorSurfaceList(this.mProcessorSessionConfig.getSurfaces()));
        this.mRequestProcessor = camera2RequestProcessor;
        this.mSessionProcessor.onCaptureSessionStart(camera2RequestProcessor);
        this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig sessionConfig = this.mSessionConfig;
        if (sessionConfig != null) {
            setSessionConfig(sessionConfig);
        }
        if (this.mPendingCaptureConfig != null) {
            List<CaptureConfig> asList = Arrays.asList(this.mPendingCaptureConfig);
            this.mPendingCaptureConfig = null;
            issueCaptureRequests(asList);
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public a<Void> open(@NonNull final SessionConfig sessionConfig, @NonNull final CameraDevice cameraDevice, @NonNull final SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        boolean z = this.mProcessorState == ProcessorState.UNINITIALIZED;
        Preconditions.checkArgument(z, "Invalid state state:" + this.mProcessorState);
        Preconditions.checkArgument(sessionConfig.getSurfaces().isEmpty() ^ true, "SessionConfig contains no surfaces");
        Logger.d(TAG, "open (id=" + this.mInstanceId + ")");
        List<DeferrableSurface> surfaces = sessionConfig.getSurfaces();
        this.mOutputSurfaces = surfaces;
        return FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(surfaces, false, 5000L, this.mExecutor, this.mScheduledExecutorService)).transformAsync(new AsyncFunction() { // from class: c.b.a.d.k1
            {
                ProcessingCaptureSession.this = this;
            }

            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final e.j.c.a.a.a apply(Object obj) {
                return ProcessingCaptureSession.this.e(sessionConfig, cameraDevice, synchronizedCaptureSessionOpener, (List) obj);
            }
        }, this.mExecutor).transform(new Function() { // from class: c.b.a.d.r1
            {
                ProcessingCaptureSession.this = this;
            }

            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ProcessingCaptureSession.this.g((Void) obj);
            }
        }, this.mExecutor);
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public a<Void> release(boolean z) {
        Preconditions.checkState(this.mProcessorState == ProcessorState.CLOSED, "release() can only be called in CLOSED state");
        Logger.d(TAG, "release (id=" + this.mInstanceId + ")");
        return this.mCaptureSession.release(z);
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(@Nullable SessionConfig sessionConfig) {
        Logger.d(TAG, "setSessionConfig (id=" + this.mInstanceId + ")");
        this.mSessionConfig = sessionConfig;
        if (sessionConfig == null) {
            return;
        }
        Camera2RequestProcessor camera2RequestProcessor = this.mRequestProcessor;
        if (camera2RequestProcessor != null) {
            camera2RequestProcessor.updateSessionConfig(sessionConfig);
        }
        if (this.mProcessorState == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
            CaptureRequestOptions build = CaptureRequestOptions.Builder.from(sessionConfig.getImplementationOptions()).build();
            this.mSessionOptions = build;
            updateParameters(build, this.mStillCaptureOptions);
            if (this.mIsRepeatingRequestStarted) {
                return;
            }
            this.mSessionProcessor.startRepeating(this.mSessionProcessorCaptureCallback);
            this.mIsRepeatingRequestStarted = true;
        }
    }
}
