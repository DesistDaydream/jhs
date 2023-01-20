package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CaptureSession implements CaptureSessionInterface {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    @GuardedBy("mSessionLock")
    public CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    @GuardedBy("mSessionLock")
    public a<Void> mReleaseFuture;
    @Nullable
    @GuardedBy("mSessionLock")
    public SessionConfig mSessionConfig;
    @GuardedBy("mSessionLock")
    public State mState;
    @Nullable
    @GuardedBy("mSessionLock")
    public SynchronizedCaptureSession mSynchronizedCaptureSession;
    @Nullable
    @GuardedBy("mSessionLock")
    public SynchronizedCaptureSessionOpener mSynchronizedCaptureSessionOpener;
    public final Object mSessionLock = new Object();
    @GuardedBy("mSessionLock")
    private final List<CaptureConfig> mCaptureConfigs = new ArrayList();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        }
    };
    @NonNull
    @GuardedBy("mSessionLock")
    public Config mCameraEventOnRepeatingOptions = OptionsBundle.emptyBundle();
    @NonNull
    @GuardedBy("mSessionLock")
    public CameraEventCallbacks mCameraEventCallbacks = CameraEventCallbacks.createEmptyCallback();
    @GuardedBy("mSessionLock")
    private final Map<DeferrableSurface, Surface> mConfiguredSurfaceMap = new HashMap();
    @GuardedBy("mSessionLock")
    public List<DeferrableSurface> mConfiguredDeferrableSurfaces = Collections.emptyList();
    public final StillCaptureFlow mStillCaptureFlow = new StillCaptureFlow();
    @GuardedBy("mSessionLock")
    private final StateCallback mCaptureSessionStateCallback = new StateCallback();

    /* renamed from: androidx.camera.camera2.internal.CaptureSession$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = iArr;
            try {
                iArr[State.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.GET_SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    /* loaded from: classes.dex */
    public final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        public StateCallback() {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                    case 6:
                    case 7:
                        CaptureSession.this.finishClose();
                        break;
                    case 8:
                        Logger.d(CaptureSession.TAG, "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                Logger.e(CaptureSession.TAG, "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.mState);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                        CaptureSession captureSession = CaptureSession.this;
                        captureSession.mState = State.OPENED;
                        captureSession.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        if (captureSession.mSessionConfig != null) {
                            List<CaptureConfig> onEnableSession = captureSession.mCameraEventCallbacks.createComboCallback().onEnableSession();
                            if (!onEnableSession.isEmpty()) {
                                CaptureSession captureSession2 = CaptureSession.this;
                                captureSession2.issueBurstCaptureRequest(captureSession2.setupConfiguredSurface(onEnableSession));
                            }
                        }
                        Logger.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");
                        CaptureSession captureSession3 = CaptureSession.this;
                        captureSession3.issueRepeatingCaptureRequests(captureSession3.mSessionConfig);
                        CaptureSession.this.issuePendingCaptureRequest();
                        break;
                    case 6:
                        CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        break;
                    case 7:
                        synchronizedCaptureSession.close();
                        break;
                }
                Logger.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()] != 1) {
                    Logger.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                }
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                if (CaptureSession.this.mState != State.UNINITIALIZED) {
                    Logger.d(CaptureSession.TAG, "onSessionFinished()");
                    CaptureSession.this.finishClose();
                } else {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.mState);
                }
            }
        }
    }

    public CaptureSession() {
        this.mState = State.UNINITIALIZED;
        this.mState = State.INITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(CameraCaptureSession cameraCaptureSession, int i2, boolean z) {
        synchronized (this.mSessionLock) {
            if (this.mState == State.OPENED) {
                issueRepeatingCaptureRequests(this.mSessionConfig);
            }
        }
    }

    @GuardedBy("mSessionLock")
    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback cameraCaptureCallback : list) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(cameraCaptureCallback));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Object f(CallbackToFutureAdapter.Completer completer) throws Exception {
        String str;
        synchronized (this.mSessionLock) {
            Preconditions.checkState(this.mReleaseCompleter == null, "Release completer expected to be null");
            this.mReleaseCompleter = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    @NonNull
    private static Config mergeOptions(List<CaptureConfig> list) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        for (CaptureConfig captureConfig : list) {
            Config implementationOptions = captureConfig.getImplementationOptions();
            for (Config.Option<?> option : implementationOptions.listOptions()) {
                Object retrieveOption = implementationOptions.retrieveOption(option, null);
                if (create.containsOption(option)) {
                    Object retrieveOption2 = create.retrieveOption(option, null);
                    if (!Objects.equals(retrieveOption2, retrieveOption)) {
                        Logger.d(TAG, "Detect conflicting option " + option.getId() + " : " + retrieveOption + " != " + retrieveOption2);
                    }
                } else {
                    create.insertOption(option, retrieveOption);
                }
            }
        }
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    /* renamed from: openCaptureSession */
    public a<Void> d(@NonNull List<Surface> list, @NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice) {
        synchronized (this.mSessionLock) {
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    this.mConfiguredSurfaceMap.clear();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i3), list.get(i3));
                    }
                    ArrayList<Surface> arrayList = new ArrayList(new LinkedHashSet(list));
                    this.mState = State.OPENING;
                    Logger.d(TAG, "Opening capture session.");
                    SynchronizedCaptureSession.StateCallback createComboCallback = SynchronizedCaptureSessionStateCallbacks.createComboCallback(this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.getSessionStateCallbacks()));
                    Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(sessionConfig.getImplementationOptions());
                    CameraEventCallbacks cameraEventCallback = camera2ImplConfig.getCameraEventCallback(CameraEventCallbacks.createEmptyCallback());
                    this.mCameraEventCallbacks = cameraEventCallback;
                    List<CaptureConfig> onPresetSession = cameraEventCallback.createComboCallback().onPresetSession();
                    CaptureConfig.Builder from = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                    for (CaptureConfig captureConfig : onPresetSession) {
                        from.addImplementationOptions(captureConfig.getImplementationOptions());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Surface surface : arrayList) {
                        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(surface);
                        outputConfigurationCompat.setPhysicalCameraId(camera2ImplConfig.getPhysicalCameraId(null));
                        arrayList2.add(outputConfigurationCompat);
                    }
                    SessionConfigurationCompat createSessionConfigurationCompat = this.mSynchronizedCaptureSessionOpener.createSessionConfigurationCompat(0, arrayList2, createComboCallback);
                    try {
                        CaptureRequest buildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(from.build(), cameraDevice);
                        if (buildWithoutTarget != null) {
                            createSessionConfigurationCompat.setSessionParameters(buildWithoutTarget);
                        }
                        return this.mSynchronizedCaptureSessionOpener.openCaptureSession(cameraDevice, createSessionConfigurationCompat, this.mConfiguredDeferrableSurfaces);
                    } catch (CameraAccessException e2) {
                        return Futures.immediateFailedFuture(e2);
                    }
                } else if (i2 != 5) {
                    return Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                }
            }
            return Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
        }
    }

    public void abortCaptures() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to abort captures. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.abortCaptures();
            } catch (CameraAccessException e2) {
                Logger.e(TAG, "Unable to abort captures.", e2);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        ArrayList<CaptureConfig> arrayList;
        synchronized (this.mSessionLock) {
            if (this.mCaptureConfigs.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(this.mCaptureConfigs);
                this.mCaptureConfigs.clear();
            }
        }
        if (arrayList != null) {
            for (CaptureConfig captureConfig : arrayList) {
                for (CameraCaptureCallback cameraCaptureCallback : captureConfig.getCameraCaptureCallbacks()) {
                    cameraCaptureCallback.onCaptureCancelled();
                }
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        synchronized (this.mSessionLock) {
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                if (this.mSessionConfig != null) {
                                    List<CaptureConfig> onDisableSession = this.mCameraEventCallbacks.createComboCallback().onDisableSession();
                                    if (!onDisableSession.isEmpty()) {
                                        try {
                                            issueCaptureRequests(setupConfiguredSurface(onDisableSession));
                                        } catch (IllegalStateException e2) {
                                            Logger.e(TAG, "Unable to issue the request before close the capture session", e2);
                                        }
                                    }
                                }
                            }
                        }
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener = this.mSynchronizedCaptureSessionOpener;
                        Preconditions.checkNotNull(synchronizedCaptureSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                        this.mSynchronizedCaptureSessionOpener.stop();
                        this.mState = State.CLOSED;
                        this.mSessionConfig = null;
                    } else {
                        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener2 = this.mSynchronizedCaptureSessionOpener;
                        Preconditions.checkNotNull(synchronizedCaptureSessionOpener2, "The Opener shouldn't null in state:" + this.mState);
                        this.mSynchronizedCaptureSessionOpener.stop();
                    }
                }
                this.mState = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
        }
    }

    @GuardedBy("mSessionLock")
    public void finishClose() {
        State state = this.mState;
        State state2 = State.RELEASED;
        if (state == state2) {
            Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = state2;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.mSessionLock) {
            unmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return unmodifiableList;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @Nullable
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mSessionLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    public State getState() {
        State state;
        synchronized (this.mSessionLock) {
            state = this.mState;
        }
        return state;
    }

    public int issueBurstCaptureRequest(List<CaptureConfig> list) {
        CameraBurstCaptureCallback cameraBurstCaptureCallback;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        synchronized (this.mSessionLock) {
            if (list.isEmpty()) {
                return -1;
            }
            try {
                cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                arrayList = new ArrayList();
                Logger.d(TAG, "Issuing capture request.");
                z = false;
                for (CaptureConfig captureConfig : list) {
                    if (captureConfig.getSurfaces().isEmpty()) {
                        Logger.d(TAG, "Skipping issuing empty capture request.");
                    } else {
                        Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = true;
                                break;
                            }
                            DeferrableSurface next = it.next();
                            if (!this.mConfiguredSurfaceMap.containsKey(next)) {
                                Logger.d(TAG, "Skipping capture request with invalid surface: " + next);
                                z2 = false;
                                break;
                            }
                        }
                        if (z2) {
                            if (captureConfig.getTemplateType() == 2) {
                                z = true;
                            }
                            CaptureConfig.Builder from = CaptureConfig.Builder.from(captureConfig);
                            if (captureConfig.getTemplateType() == 5 && captureConfig.getCameraCaptureResult() != null) {
                                from.setCameraCaptureResult(captureConfig.getCameraCaptureResult());
                            }
                            SessionConfig sessionConfig = this.mSessionConfig;
                            if (sessionConfig != null) {
                                from.addImplementationOptions(sessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                            }
                            from.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                            from.addImplementationOptions(captureConfig.getImplementationOptions());
                            CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                            if (build == null) {
                                Logger.d(TAG, "Skipping issuing request without surface.");
                                return -1;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (CameraCaptureCallback cameraCaptureCallback : captureConfig.getCameraCaptureCallbacks()) {
                                CaptureCallbackConverter.toCaptureCallback(cameraCaptureCallback, arrayList2);
                            }
                            cameraBurstCaptureCallback.addCamera2Callbacks(build, arrayList2);
                            arrayList.add(build);
                        }
                    }
                }
            } catch (CameraAccessException e2) {
                Logger.e(TAG, "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
            }
            if (!arrayList.isEmpty()) {
                if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(arrayList, z)) {
                    this.mSynchronizedCaptureSession.stopRepeating();
                    cameraBurstCaptureCallback.setCaptureSequenceCallback(new CameraBurstCaptureCallback.CaptureSequenceCallback() { // from class: c.b.a.d.u0
                        {
                            CaptureSession.this = this;
                        }

                        @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
                        public final void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i2, boolean z3) {
                            CaptureSession.this.b(cameraCaptureSession, i2, z3);
                        }
                    });
                }
                return this.mSynchronizedCaptureSession.captureBurstRequests(arrayList, cameraBurstCaptureCallback);
            }
            Logger.d(TAG, "Skipping issuing burst request due to no valid request elements");
            return -1;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(@NonNull List<CaptureConfig> list) {
        synchronized (this.mSessionLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mCaptureConfigs.addAll(list);
                    break;
                case 5:
                    this.mCaptureConfigs.addAll(list);
                    issuePendingCaptureRequest();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    @GuardedBy("mSessionLock")
    public void issuePendingCaptureRequest() {
        if (this.mCaptureConfigs.isEmpty()) {
            return;
        }
        try {
            issueBurstCaptureRequest(this.mCaptureConfigs);
        } finally {
            this.mCaptureConfigs.clear();
        }
    }

    public int issueRepeatingCaptureRequests(@Nullable SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            if (sessionConfig == null) {
                Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
                Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.mSynchronizedCaptureSession.stopRepeating();
                } catch (CameraAccessException e2) {
                    Logger.e(TAG, "Unable to access camera: " + e2.getMessage());
                    Thread.dumpStack();
                }
                return -1;
            }
            try {
                Logger.d(TAG, "Issuing request for session.");
                CaptureConfig.Builder from = CaptureConfig.Builder.from(repeatingCaptureConfig);
                Config mergeOptions = mergeOptions(this.mCameraEventCallbacks.createComboCallback().onRepeating());
                this.mCameraEventOnRepeatingOptions = mergeOptions;
                from.addImplementationOptions(mergeOptions);
                CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                if (build == null) {
                    Logger.d(TAG, "Skipping issuing empty request for session.");
                    return -1;
                }
                return this.mSynchronizedCaptureSession.setSingleRepeatingRequest(build, createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.mCaptureCallback));
            } catch (CameraAccessException e3) {
                Logger.e(TAG, "Unable to access camera: " + e3.getMessage());
                Thread.dumpStack();
                return -1;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @NonNull
    public a<Void> open(@NonNull final SessionConfig sessionConfig, @NonNull final CameraDevice cameraDevice, @NonNull SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener) {
        synchronized (this.mSessionLock) {
            if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()] != 2) {
                Logger.e(TAG, "Open not allowed in state: " + this.mState);
                return Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
            }
            this.mState = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
            this.mConfiguredDeferrableSurfaces = arrayList;
            this.mSynchronizedCaptureSessionOpener = synchronizedCaptureSessionOpener;
            FutureChain transformAsync = FutureChain.from(synchronizedCaptureSessionOpener.startWithDeferrableSurface(arrayList, 5000L)).transformAsync(new AsyncFunction() { // from class: c.b.a.d.t0
                {
                    CaptureSession.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final e.j.c.a.a.a apply(Object obj) {
                    return CaptureSession.this.d(sessionConfig, cameraDevice, (List) obj);
                }
            }, this.mSynchronizedCaptureSessionOpener.getExecutor());
            Futures.addCallback(transformAsync, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.CaptureSession.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    synchronized (CaptureSession.this.mSessionLock) {
                        CaptureSession.this.mSynchronizedCaptureSessionOpener.stop();
                        int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()];
                        if ((i2 == 4 || i2 == 6 || i2 == 7) && !(th instanceof CancellationException)) {
                            Logger.w(CaptureSession.TAG, "Opening session with fail " + CaptureSession.this.mState, th);
                            CaptureSession.this.finishClose();
                        }
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, this.mSynchronizedCaptureSessionOpener.getExecutor());
            return Futures.nonCancellationPropagating(transformAsync);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00a6, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x009f, B:7:0x0012, B:10:0x0018, B:14:0x0024, B:13:0x001d, B:15:0x0029, B:17:0x004d, B:18:0x0051, B:20:0x0055, B:21:0x0060, B:22:0x0062, B:24:0x0064, B:25:0x0081, B:26:0x0086, B:27:0x009e), top: B:36:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[Catch: all -> 0x00a6, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:28:0x009f, B:7:0x0012, B:10:0x0018, B:14:0x0024, B:13:0x001d, B:15:0x0029, B:17:0x004d, B:18:0x0051, B:20:0x0055, B:21:0x0060, B:22:0x0062, B:24:0x0064, B:25:0x0081, B:26:0x0086, B:27:0x009e), top: B:36:0x0003, inners: #0 }] */
    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e.j.c.a.a.a<java.lang.Void> release(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mSessionLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> La6
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> La6
            r1 = r1[r2]     // Catch: java.lang.Throwable -> La6
            switch(r1) {
                case 1: goto L86;
                case 2: goto L81;
                case 3: goto L64;
                case 4: goto L29;
                case 5: goto L12;
                case 6: goto L12;
                case 7: goto L51;
                default: goto L10;
            }     // Catch: java.lang.Throwable -> La6
        L10:
            goto L9f
        L12:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r3.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L29
            if (r4 == 0) goto L24
            r1.abortCaptures()     // Catch: android.hardware.camera2.CameraAccessException -> L1c java.lang.Throwable -> La6
            goto L24
        L1c:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r1, r2, r4)     // Catch: java.lang.Throwable -> La6
        L24:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r3.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> La6
            r4.close()     // Catch: java.lang.Throwable -> La6
        L29:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch: java.lang.Throwable -> La6
            r3.mState = r4     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> La6
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La6
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> La6
            boolean r4 = r4.stop()     // Catch: java.lang.Throwable -> La6
            if (r4 == 0) goto L51
            r3.finishClose()     // Catch: java.lang.Throwable -> La6
            goto L9f
        L51:
            e.j.c.a.a.a<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> La6
            if (r4 != 0) goto L60
            c.b.a.d.s0 r4 = new c.b.a.d.s0     // Catch: java.lang.Throwable -> La6
            r4.<init>()     // Catch: java.lang.Throwable -> La6
            e.j.c.a.a.a r4 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r4)     // Catch: java.lang.Throwable -> La6
            r3.mReleaseFuture = r4     // Catch: java.lang.Throwable -> La6
        L60:
            e.j.c.a.a.a<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> La6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            return r4
        L64:
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> La6
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La6
            androidx.core.util.Preconditions.checkNotNull(r4, r1)     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener r4 = r3.mSynchronizedCaptureSessionOpener     // Catch: java.lang.Throwable -> La6
            r4.stop()     // Catch: java.lang.Throwable -> La6
        L81:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch: java.lang.Throwable -> La6
            r3.mState = r4     // Catch: java.lang.Throwable -> La6
            goto L9f
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> La6
            r1.append(r2)     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La6
            r4.<init>(r1)     // Catch: java.lang.Throwable -> La6
            throw r4     // Catch: java.lang.Throwable -> La6
        L9f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            r4 = 0
            e.j.c.a.a.a r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        La6:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):e.j.c.a.a.a");
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(@Nullable SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mSessionConfig = sessionConfig;
                    break;
                case 5:
                    this.mSessionConfig = sessionConfig;
                    if (sessionConfig != null) {
                        if (!this.mConfiguredSurfaceMap.keySet().containsAll(sessionConfig.getSurfaces())) {
                            Logger.e(TAG, "Does not have the proper configured lists");
                            return;
                        }
                        Logger.d(TAG, "Attempting to submit CaptureRequest after setting");
                        issueRepeatingCaptureRequests(this.mSessionConfig);
                        break;
                    } else {
                        return;
                    }
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
            }
        }
    }

    @GuardedBy("mSessionLock")
    public List<CaptureConfig> setupConfiguredSurface(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder from = CaptureConfig.Builder.from(captureConfig);
            from.setTemplateType(1);
            for (DeferrableSurface deferrableSurface : this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces()) {
                from.addSurface(deferrableSurface);
            }
            arrayList.add(from.build());
        }
        return arrayList;
    }

    public void stopRepeating() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to stop repeating. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.stopRepeating();
            } catch (CameraAccessException e2) {
                Logger.e(TAG, "Unable to stop repeating.", e2);
            }
        }
    }
}
