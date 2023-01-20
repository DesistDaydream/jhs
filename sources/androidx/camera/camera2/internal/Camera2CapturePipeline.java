package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.OverrideAeModeForStillCapture;
import androidx.camera.camera2.internal.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import c.b.a.d.h0;
import c.b.a.d.k0;
import c.b.a.d.q0;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@RequiresApi(21)
/* loaded from: classes.dex */
public class Camera2CapturePipeline {
    private static final String TAG = "Camera2CapturePipeline";
    @NonNull
    private final Camera2CameraControlImpl mCameraControl;
    @NonNull
    private final Quirks mCameraQuirk;
    @NonNull
    private final Executor mExecutor;
    private final boolean mIsLegacyDevice;
    private int mTemplate = 1;
    @NonNull
    private final UseTorchAsFlash mUseTorchAsFlash;

    /* loaded from: classes.dex */
    public static class AePreCaptureTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private final int mFlashMode;
        private boolean mIsExecuted = false;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;

        public AePreCaptureTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i2, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.mCameraControl = camera2CameraControlImpl;
            this.mFlashMode = i2;
            this.mOverrideAeModeForStillCapture = overrideAeModeForStillCapture;
        }

        /* renamed from: a */
        public /* synthetic */ Object b(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCameraControl.getFocusMeteringControl().triggerAePrecapture(completer);
            this.mOverrideAeModeForStillCapture.onAePrecaptureStarted();
            return "AePreCapture";
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            return this.mFlashMode == 0;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted) {
                Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAePreCapture");
                this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
                this.mOverrideAeModeForStillCapture.onAePrecaptureFinished();
            }
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public a<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            if (Camera2CapturePipeline.isFlashRequired(this.mFlashMode, totalCaptureResult)) {
                Logger.d(Camera2CapturePipeline.TAG, "Trigger AE");
                this.mIsExecuted = true;
                return FutureChain.from(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.g0
                    {
                        Camera2CapturePipeline.AePreCaptureTask.this = this;
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return Camera2CapturePipeline.AePreCaptureTask.this.b(completer);
                    }
                })).transform(h0.a, CameraXExecutors.directExecutor());
            }
            return Futures.immediateFuture(Boolean.FALSE);
        }
    }

    /* loaded from: classes.dex */
    public static class AfTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private boolean mIsExecuted = false;

        public AfTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
            this.mCameraControl = camera2CameraControlImpl;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            return true;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted) {
                Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAF");
                this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(true, false);
            }
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public a<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            Integer num;
            a<Boolean> immediateFuture = Futures.immediateFuture(Boolean.TRUE);
            if (totalCaptureResult == null || (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) == null) {
                return immediateFuture;
            }
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 2) {
                Logger.d(Camera2CapturePipeline.TAG, "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    Logger.d(Camera2CapturePipeline.TAG, "Trigger AF");
                    this.mIsExecuted = true;
                    this.mCameraControl.getFocusMeteringControl().triggerAf(null, false);
                }
            }
            return immediateFuture;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class Pipeline {
        private static final long CHECK_3A_TIMEOUT_IN_NS;
        private static final long CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS;
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final boolean mIsLegacyDevice;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;
        private final int mTemplate;
        private long mTimeout3A = CHECK_3A_TIMEOUT_IN_NS;
        public final List<PipelineTask> mTasks = new ArrayList();
        private final PipelineTask mPipelineSubTask = new AnonymousClass1();

        /* renamed from: androidx.camera.camera2.internal.Camera2CapturePipeline$Pipeline$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements PipelineTask {
            public AnonymousClass1() {
                Pipeline.this = r1;
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public boolean isCaptureResultNeeded() {
                for (PipelineTask pipelineTask : Pipeline.this.mTasks) {
                    if (pipelineTask.isCaptureResultNeeded()) {
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public void postCapture() {
                for (PipelineTask pipelineTask : Pipeline.this.mTasks) {
                    pipelineTask.postCapture();
                }
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            @NonNull
            public a<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                for (PipelineTask pipelineTask : Pipeline.this.mTasks) {
                    arrayList.add(pipelineTask.preCapture(totalCaptureResult));
                }
                return Futures.transform(Futures.allAsList(arrayList), k0.a, CameraXExecutors.directExecutor());
            }
        }

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            CHECK_3A_TIMEOUT_IN_NS = timeUnit.toNanos(1L);
            CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS = timeUnit.toNanos(5L);
        }

        public Pipeline(int i2, @NonNull Executor executor, @NonNull Camera2CameraControlImpl camera2CameraControlImpl, boolean z, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.mTemplate = i2;
            this.mExecutor = executor;
            this.mCameraControl = camera2CameraControlImpl;
            this.mIsLegacyDevice = z;
            this.mOverrideAeModeForStillCapture = overrideAeModeForStillCapture;
        }

        @OptIn(markerClass = {ExperimentalCamera2Interop.class})
        private void applyAeModeQuirk(@NonNull CaptureConfig.Builder builder) {
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, 3);
            builder.addImplementationOptions(builder2.build());
        }

        private void applyStillCaptureTemplate(@NonNull CaptureConfig.Builder builder, @NonNull CaptureConfig captureConfig) {
            int i2;
            if (this.mTemplate != 3 || this.mIsLegacyDevice) {
                i2 = (captureConfig.getTemplateType() == -1 || captureConfig.getTemplateType() == 5) ? 2 : -1;
            } else {
                i2 = 4;
            }
            if (i2 != -1) {
                builder.setTemplateType(i2);
            }
        }

        /* renamed from: b */
        public /* synthetic */ a c(int i2, TotalCaptureResult totalCaptureResult) throws Exception {
            if (Camera2CapturePipeline.isFlashRequired(i2, totalCaptureResult)) {
                setTimeout3A(CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS);
            }
            return this.mPipelineSubTask.preCapture(totalCaptureResult);
        }

        /* renamed from: d */
        public /* synthetic */ a e(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return waitForResult(this.mTimeout3A, new ResultListener.Checker() { // from class: c.b.a.d.l0
                    {
                        Camera2CapturePipeline.Pipeline.this = this;
                    }

                    @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.ResultListener.Checker
                    public final boolean check(TotalCaptureResult totalCaptureResult) {
                        boolean is3AConverged;
                        is3AConverged = Camera2CapturePipeline.Pipeline.this.is3AConverged(totalCaptureResult);
                        return is3AConverged;
                    }
                });
            }
            return Futures.immediateFuture(null);
        }

        /* renamed from: f */
        public /* synthetic */ a g(List list, int i2, TotalCaptureResult totalCaptureResult) throws Exception {
            return submitConfigsInternal(list, i2);
        }

        /* renamed from: h */
        public /* synthetic */ void i() {
            this.mPipelineSubTask.postCapture();
        }

        public boolean is3AConverged(@Nullable TotalCaptureResult totalCaptureResult) {
            if (totalCaptureResult == null) {
                return false;
            }
            Camera2CameraCaptureResult camera2CameraCaptureResult = new Camera2CameraCaptureResult(totalCaptureResult);
            boolean z = camera2CameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || camera2CameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || camera2CameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.PASSIVE_FOCUSED || camera2CameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED || camera2CameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED || camera2CameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
            boolean z2 = camera2CameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.CONVERGED || camera2CameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED || camera2CameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.UNKNOWN;
            boolean z3 = camera2CameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED || camera2CameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.UNKNOWN;
            Logger.d(Camera2CapturePipeline.TAG, "checkCaptureResult, AE=" + camera2CameraCaptureResult.getAeState() + " AF =" + camera2CameraCaptureResult.getAfState() + " AWB=" + camera2CameraCaptureResult.getAwbState());
            return z && z2 && z3;
        }

        /* renamed from: j */
        public /* synthetic */ Object k(CaptureConfig.Builder builder, final CallbackToFutureAdapter.Completer completer) throws Exception {
            builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.Camera2CapturePipeline.Pipeline.2
                {
                    Pipeline.this = this;
                }

                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void onCaptureCancelled() {
                    completer.setException(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
                }

                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                    completer.set(null);
                }

                @Override // androidx.camera.core.impl.CameraCaptureCallback
                public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                    completer.setException(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.getReason(), null));
                }
            });
            return "submitStillCapture";
        }

        private void setTimeout3A(long j2) {
            this.mTimeout3A = j2;
        }

        @NonNull
        private a<TotalCaptureResult> waitForResult(long j2, @Nullable ResultListener.Checker checker) {
            ResultListener resultListener = new ResultListener(j2, checker);
            this.mCameraControl.addCaptureResultListener(resultListener);
            return resultListener.getFuture();
        }

        public void addTask(@NonNull PipelineTask pipelineTask) {
            this.mTasks.add(pipelineTask);
        }

        @NonNull
        public a<List<Void>> executeCapture(@NonNull final List<CaptureConfig> list, final int i2) {
            a immediateFuture = Futures.immediateFuture(null);
            if (!this.mTasks.isEmpty()) {
                immediateFuture = FutureChain.from(this.mPipelineSubTask.isCaptureResultNeeded() ? waitForResult(0L, null) : Futures.immediateFuture(null)).transformAsync(new AsyncFunction() { // from class: c.b.a.d.o0
                    {
                        Camera2CapturePipeline.Pipeline.this = this;
                    }

                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final e.j.c.a.a.a apply(Object obj) {
                        return Camera2CapturePipeline.Pipeline.this.c(i2, (TotalCaptureResult) obj);
                    }
                }, this.mExecutor).transformAsync(new AsyncFunction() { // from class: c.b.a.d.n0
                    {
                        Camera2CapturePipeline.Pipeline.this = this;
                    }

                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final e.j.c.a.a.a apply(Object obj) {
                        return Camera2CapturePipeline.Pipeline.this.e((Boolean) obj);
                    }
                }, this.mExecutor);
            }
            FutureChain transformAsync = FutureChain.from(immediateFuture).transformAsync(new AsyncFunction() { // from class: c.b.a.d.m0
                {
                    Camera2CapturePipeline.Pipeline.this = this;
                }

                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final e.j.c.a.a.a apply(Object obj) {
                    return Camera2CapturePipeline.Pipeline.this.g(list, i2, (TotalCaptureResult) obj);
                }
            }, this.mExecutor);
            transformAsync.addListener(new Runnable() { // from class: c.b.a.d.i0
                {
                    Camera2CapturePipeline.Pipeline.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CapturePipeline.Pipeline.this.i();
                }
            }, this.mExecutor);
            return transformAsync;
        }

        @NonNull
        public a<List<Void>> submitConfigsInternal(@NonNull List<CaptureConfig> list, int i2) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (CaptureConfig captureConfig : list) {
                final CaptureConfig.Builder from = CaptureConfig.Builder.from(captureConfig);
                CameraCaptureResult cameraCaptureResult = null;
                if (captureConfig.getTemplateType() == 5) {
                    ImageProxy dequeueImageFromBuffer = this.mCameraControl.getZslControl().dequeueImageFromBuffer();
                    if (dequeueImageFromBuffer != null && this.mCameraControl.getZslControl().enqueueImageToImageWriter(dequeueImageFromBuffer)) {
                        cameraCaptureResult = CameraCaptureResults.retrieveCameraCaptureResult(dequeueImageFromBuffer.getImageInfo());
                    }
                }
                if (cameraCaptureResult != null) {
                    from.setCameraCaptureResult(cameraCaptureResult);
                } else {
                    applyStillCaptureTemplate(from, captureConfig);
                }
                if (this.mOverrideAeModeForStillCapture.shouldSetAeModeAlwaysFlash(i2)) {
                    applyAeModeQuirk(from);
                }
                arrayList.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.j0
                    {
                        Camera2CapturePipeline.Pipeline.this = this;
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return Camera2CapturePipeline.Pipeline.this.k(from, completer);
                    }
                }));
                arrayList2.add(from.build());
            }
            this.mCameraControl.submitCaptureRequestsInternal(arrayList2);
            return Futures.allAsList(arrayList);
        }
    }

    /* loaded from: classes.dex */
    public interface PipelineTask {
        boolean isCaptureResultNeeded();

        void postCapture();

        @NonNull
        a<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult);
    }

    /* loaded from: classes.dex */
    public static class ResultListener implements Camera2CameraControlImpl.CaptureResultListener {
        public static final long NO_TIMEOUT = 0;
        private final Checker mChecker;
        private CallbackToFutureAdapter.Completer<TotalCaptureResult> mCompleter;
        private final long mTimeLimitNs;
        private final a<TotalCaptureResult> mFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.p0
            {
                Camera2CapturePipeline.ResultListener.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CapturePipeline.ResultListener.this.b(completer);
            }
        });
        private volatile Long mTimestampOfFirstUpdateNs = null;

        /* loaded from: classes.dex */
        public interface Checker {
            boolean check(@NonNull TotalCaptureResult totalCaptureResult);
        }

        public ResultListener(long j2, @Nullable Checker checker) {
            this.mTimeLimitNs = j2;
            this.mChecker = checker;
        }

        /* renamed from: a */
        public /* synthetic */ Object b(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCompleter = completer;
            return "waitFor3AResult";
        }

        @NonNull
        public a<TotalCaptureResult> getFuture() {
            return this.mFuture;
        }

        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
            Long l2 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
            if (l2 != null && this.mTimestampOfFirstUpdateNs == null) {
                this.mTimestampOfFirstUpdateNs = l2;
            }
            Long l3 = this.mTimestampOfFirstUpdateNs;
            if (0 != this.mTimeLimitNs && l3 != null && l2 != null && l2.longValue() - l3.longValue() > this.mTimeLimitNs) {
                this.mCompleter.set(null);
                Logger.d(Camera2CapturePipeline.TAG, "Wait for capture result timeout, current:" + l2 + " first: " + l3);
                return true;
            }
            Checker checker = this.mChecker;
            if (checker == null || checker.check(totalCaptureResult)) {
                this.mCompleter.set(totalCaptureResult);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class TorchTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private final int mFlashMode;
        private boolean mIsExecuted = false;

        public TorchTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i2) {
            this.mCameraControl = camera2CameraControlImpl;
            this.mFlashMode = i2;
        }

        /* renamed from: a */
        public /* synthetic */ Object b(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCameraControl.getTorchControl().a(completer, true);
            return "TorchOn";
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            return this.mFlashMode == 0;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted) {
                this.mCameraControl.getTorchControl().a(null, false);
                Logger.d(Camera2CapturePipeline.TAG, "Turn off torch");
            }
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        @NonNull
        public a<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            if (Camera2CapturePipeline.isFlashRequired(this.mFlashMode, totalCaptureResult)) {
                if (this.mCameraControl.isTorchOn()) {
                    Logger.d(Camera2CapturePipeline.TAG, "Torch already on, not turn on");
                } else {
                    Logger.d(Camera2CapturePipeline.TAG, "Turn on torch");
                    this.mIsExecuted = true;
                    return FutureChain.from(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.r0
                        {
                            Camera2CapturePipeline.TorchTask.this = this;
                        }

                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return Camera2CapturePipeline.TorchTask.this.b(completer);
                        }
                    })).transform(q0.a, CameraXExecutors.directExecutor());
                }
            }
            return Futures.immediateFuture(Boolean.FALSE);
        }
    }

    public Camera2CapturePipeline(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Quirks quirks, @NonNull Executor executor) {
        boolean z = true;
        this.mCameraControl = camera2CameraControlImpl;
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.mIsLegacyDevice = (num == null || num.intValue() != 2) ? false : false;
        this.mExecutor = executor;
        this.mCameraQuirk = quirks;
        this.mUseTorchAsFlash = new UseTorchAsFlash(quirks);
    }

    public static boolean isFlashRequired(int i2, @Nullable TotalCaptureResult totalCaptureResult) {
        if (i2 == 0) {
            Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
            return num != null && num.intValue() == 4;
        } else if (i2 != 1) {
            if (i2 == 2) {
                return false;
            }
            throw new AssertionError(i2);
        } else {
            return true;
        }
    }

    private boolean isTorchAsFlash(int i2) {
        return this.mUseTorchAsFlash.shouldUseTorchAsFlash() || this.mTemplate == 3 || i2 == 1;
    }

    public void setTemplate(int i2) {
        this.mTemplate = i2;
    }

    @NonNull
    public a<List<Void>> submitStillCaptures(@NonNull List<CaptureConfig> list, int i2, int i3, int i4) {
        OverrideAeModeForStillCapture overrideAeModeForStillCapture = new OverrideAeModeForStillCapture(this.mCameraQuirk);
        Pipeline pipeline = new Pipeline(this.mTemplate, this.mExecutor, this.mCameraControl, this.mIsLegacyDevice, overrideAeModeForStillCapture);
        if (i2 == 0) {
            pipeline.addTask(new AfTask(this.mCameraControl));
        }
        if (isTorchAsFlash(i4)) {
            pipeline.addTask(new TorchTask(this.mCameraControl, i3));
        } else {
            pipeline.addTask(new AePreCaptureTask(this.mCameraControl, i3, overrideAeModeForStillCapture));
        }
        return Futures.nonCancellationPropagating(pipeline.executeCapture(list, i3));
    }
}
