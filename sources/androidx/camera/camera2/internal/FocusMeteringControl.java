package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.camera.camera2.internal.compat.workaround.MeteringRegionCorrection;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@RequiresApi(21)
/* loaded from: classes.dex */
public class FocusMeteringControl {
    private static final MeteringRectangle[] EMPTY_RECTANGLES = new MeteringRectangle[0];
    private static final String TAG = "FocusMeteringControl";
    private MeteringRectangle[] mAeRects;
    private MeteringRectangle[] mAfRects;
    private ScheduledFuture<?> mAutoCancelHandle;
    private MeteringRectangle[] mAwbRects;
    private final Camera2CameraControlImpl mCameraControl;
    public final Executor mExecutor;
    @NonNull
    private final MeteringRegionCorrection mMeteringRegionCorrection;
    public CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter;
    public CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter;
    private final ScheduledExecutorService mScheduler;
    private volatile boolean mIsActive = false;
    private volatile Rational mPreviewAspectRatio = null;
    private boolean mIsInAfAutoMode = false;
    @NonNull
    public Integer mCurrentAfState = 0;
    public long mFocusTimeoutCounter = 0;
    public boolean mIsAutoFocusCompleted = false;
    public boolean mIsFocusSuccessful = false;
    private int mTemplate = 1;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForFocus = null;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForCancel = null;

    public FocusMeteringControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull Quirks quirks) {
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mRunningActionCompleter = null;
        this.mRunningCancelCompleter = null;
        this.mCameraControl = camera2CameraControlImpl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
        this.mMeteringRegionCorrection = new MeteringRegionCorrection(quirks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Object d(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.f1
            {
                FocusMeteringControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FocusMeteringControl.this.b(completer);
            }
        });
        return "cancelFocusAndMetering";
    }

    private void completeActionFuture(boolean z) {
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.set(FocusMeteringResult.create(z));
            this.mRunningActionCompleter = null;
        }
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    private void disableAutoCancel() {
        ScheduledFuture<?> scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mAutoCancelHandle = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ boolean f(int i2, long j2, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() == i2 && Camera2CameraControlImpl.isSessionUpdated(totalCaptureResult, j2)) {
            completeCancelFuture();
            return true;
        }
        return false;
    }

    private void executeMeteringAction(@NonNull MeteringRectangle[] meteringRectangleArr, @NonNull MeteringRectangle[] meteringRectangleArr2, @NonNull MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction) {
        final long updateSessionConfigSynchronous;
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr2;
        this.mAwbRects = meteringRectangleArr3;
        if (shouldTriggerAF()) {
            this.mIsInAfAutoMode = true;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            updateSessionConfigSynchronous = this.mCameraControl.updateSessionConfigSynchronous();
            triggerAf(null, true);
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = true;
            this.mIsFocusSuccessful = false;
            updateSessionConfigSynchronous = this.mCameraControl.updateSessionConfigSynchronous();
        }
        this.mCurrentAfState = 0;
        final boolean isAfModeSupported = isAfModeSupported();
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: c.b.a.d.g1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                return FocusMeteringControl.this.h(isAfModeSupported, updateSessionConfigSynchronous, totalCaptureResult);
            }
        };
        this.mSessionListenerForFocus = captureResultListener;
        this.mCameraControl.addCaptureResultListener(captureResultListener);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            final long j2 = this.mFocusTimeoutCounter + 1;
            this.mFocusTimeoutCounter = j2;
            this.mAutoCancelHandle = this.mScheduler.schedule(new Runnable() { // from class: c.b.a.d.b1
                {
                    FocusMeteringControl.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FocusMeteringControl.this.l(j2);
                }
            }, focusMeteringAction.getAutoCancelDurationInMillis(), TimeUnit.MILLISECONDS);
        }
    }

    private void failActionFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningActionCompleter = null;
        }
    }

    private void failCancelFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningCancelCompleter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ boolean h(boolean z, long j2, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF()) {
            if (z && num != null) {
                if (this.mCurrentAfState.intValue() == 3) {
                    if (num.intValue() == 4) {
                        this.mIsFocusSuccessful = true;
                        this.mIsAutoFocusCompleted = true;
                    } else if (num.intValue() == 5) {
                        this.mIsFocusSuccessful = false;
                        this.mIsAutoFocusCompleted = true;
                    }
                }
            } else {
                this.mIsFocusSuccessful = true;
                this.mIsAutoFocusCompleted = true;
            }
        }
        if (this.mIsAutoFocusCompleted && Camera2CameraControlImpl.isSessionUpdated(totalCaptureResult, j2)) {
            completeActionFuture(this.mIsFocusSuccessful);
            return true;
        }
        if (!this.mCurrentAfState.equals(num) && num != null) {
            this.mCurrentAfState = num;
        }
        return false;
    }

    private Rational getDefaultAspectRatio() {
        if (this.mPreviewAspectRatio != null) {
            return this.mPreviewAspectRatio;
        }
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        return new Rational(cropSensorRegion.width(), cropSensorRegion.height());
    }

    private static PointF getFovAdjustedPoint(@NonNull MeteringPoint meteringPoint, @NonNull Rational rational, @NonNull Rational rational2, int i2, MeteringRegionCorrection meteringRegionCorrection) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF correctedPoint = meteringRegionCorrection.getCorrectedPoint(meteringPoint, i2);
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float doubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                correctedPoint.y = (((float) ((doubleValue - 1.0d) / 2.0d)) + correctedPoint.y) * (1.0f / doubleValue);
            } else {
                float doubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                correctedPoint.x = (((float) ((doubleValue2 - 1.0d) / 2.0d)) + correctedPoint.x) * (1.0f / doubleValue2);
            }
        }
        return correctedPoint;
    }

    private static MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int width = (int) (rect.left + (pointF.x * rect.width()));
        int height = (int) (rect.top + (pointF.y * rect.height()));
        int size = ((int) (meteringPoint.getSize() * rect.width())) / 2;
        int size2 = ((int) (meteringPoint.getSize() * rect.height())) / 2;
        Rect rect2 = new Rect(width - size, height - size2, width + size, height + size2);
        rect2.left = rangeLimit(rect2.left, rect.right, rect.left);
        rect2.right = rangeLimit(rect2.right, rect.right, rect.left);
        rect2.top = rangeLimit(rect2.top, rect.bottom, rect.top);
        rect2.bottom = rangeLimit(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    @NonNull
    private List<MeteringRectangle> getMeteringRectangles(@NonNull List<MeteringPoint> list, int i2, @NonNull Rational rational, @NonNull Rect rect, int i3) {
        if (!list.isEmpty() && i2 != 0) {
            ArrayList arrayList = new ArrayList();
            Rational rational2 = new Rational(rect.width(), rect.height());
            for (MeteringPoint meteringPoint : list) {
                if (arrayList.size() == i2) {
                    break;
                } else if (isValid(meteringPoint)) {
                    MeteringRectangle meteringRect = getMeteringRect(meteringPoint, getFovAdjustedPoint(meteringPoint, rational2, rational, i3, this.mMeteringRegionCorrection), rect);
                    if (meteringRect.getWidth() != 0 && meteringRect.getHeight() != 0) {
                        arrayList.add(meteringRect);
                    }
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(long j2) {
        if (j2 == this.mFocusTimeoutCounter) {
            cancelFocusAndMeteringWithoutAsyncResult();
        }
    }

    private boolean isAfModeSupported() {
        return this.mCameraControl.getSupportedAfMode(1) == 1;
    }

    private static boolean isValid(@NonNull MeteringPoint meteringPoint) {
        return meteringPoint.getX() >= 0.0f && meteringPoint.getX() <= 1.0f && meteringPoint.getY() >= 0.0f && meteringPoint.getY() <= 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(final long j2) {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.a1
            {
                FocusMeteringControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FocusMeteringControl.this.j(j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ Object p(final FocusMeteringAction focusMeteringAction, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: c.b.a.d.c1
            {
                FocusMeteringControl.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FocusMeteringControl.this.n(completer, focusMeteringAction);
            }
        });
        return "startFocusAndMetering";
    }

    private static int rangeLimit(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i4), i3);
    }

    private boolean shouldTriggerAF() {
        return this.mAfRects.length > 0;
    }

    public void addFocusMeteringOptions(@NonNull Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.mCameraControl.getSupportedAfMode(this.mIsInAfAutoMode ? 1 : getDefaultAfMode())));
        MeteringRectangle[] meteringRectangleArr = this.mAfRects;
        if (meteringRectangleArr.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.mAeRects;
        if (meteringRectangleArr2.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.mAwbRects;
        if (meteringRectangleArr3.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    public void cancelAfAeTrigger(boolean z, boolean z2) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(this.mTemplate);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z2) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
        }
    }

    public a<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.e1
            {
                FocusMeteringControl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return FocusMeteringControl.this.d(completer);
            }
        });
    }

    /* renamed from: cancelFocusAndMeteringInternal */
    public void b(@Nullable CallbackToFutureAdapter.Completer<Void> completer) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = completer;
        disableAutoCancel();
        if (shouldTriggerAF()) {
            cancelAfAeTrigger(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mIsInAfAutoMode = false;
        final long updateSessionConfigSynchronous = this.mCameraControl.updateSessionConfigSynchronous();
        if (this.mRunningCancelCompleter != null) {
            final int supportedAfMode = this.mCameraControl.getSupportedAfMode(getDefaultAfMode());
            Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: c.b.a.d.d1
                @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
                public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                    return FocusMeteringControl.this.f(supportedAfMode, updateSessionConfigSynchronous, totalCaptureResult);
                }
            };
            this.mSessionListenerForCancel = captureResultListener;
            this.mCameraControl.addCaptureResultListener(captureResultListener);
        }
    }

    public void cancelFocusAndMeteringWithoutAsyncResult() {
        a(null);
    }

    @VisibleForTesting
    public int getDefaultAfMode() {
        return this.mTemplate != 3 ? 4 : 3;
    }

    public boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction) {
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational defaultAspectRatio = getDefaultAspectRatio();
        return (getMeteringRectangles(focusMeteringAction.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), defaultAspectRatio, cropSensorRegion, 1).isEmpty() && getMeteringRectangles(focusMeteringAction.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), defaultAspectRatio, cropSensorRegion, 2).isEmpty() && getMeteringRectangles(focusMeteringAction.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), defaultAspectRatio, cropSensorRegion, 4).isEmpty()) ? false : true;
    }

    public void setActive(boolean z) {
        if (z == this.mIsActive) {
            return;
        }
        this.mIsActive = z;
        if (this.mIsActive) {
            return;
        }
        cancelFocusAndMeteringWithoutAsyncResult();
    }

    public void setPreviewAspectRatio(@Nullable Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    public void setTemplate(int i2) {
        this.mTemplate = i2;
    }

    public a<FocusMeteringResult> startFocusAndMetering(@NonNull final FocusMeteringAction focusMeteringAction) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.a.d.h1
            {
                FocusMeteringControl.this = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return FocusMeteringControl.this.p(focusMeteringAction, completer);
            }
        });
    }

    /* renamed from: startFocusAndMeteringInternal */
    public void n(@NonNull CallbackToFutureAdapter.Completer<FocusMeteringResult> completer, @NonNull FocusMeteringAction focusMeteringAction) {
        if (!this.mIsActive) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational defaultAspectRatio = getDefaultAspectRatio();
        List<MeteringRectangle> meteringRectangles = getMeteringRectangles(focusMeteringAction.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), defaultAspectRatio, cropSensorRegion, 1);
        List<MeteringRectangle> meteringRectangles2 = getMeteringRectangles(focusMeteringAction.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), defaultAspectRatio, cropSensorRegion, 2);
        List<MeteringRectangle> meteringRectangles3 = getMeteringRectangles(focusMeteringAction.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), defaultAspectRatio, cropSensorRegion, 4);
        if (meteringRectangles.isEmpty() && meteringRectangles2.isEmpty() && meteringRectangles3.isEmpty()) {
            completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
            return;
        }
        failActionFuture("Cancelled by another startFocusAndMetering()");
        failCancelFuture("Cancelled by another startFocusAndMetering()");
        disableAutoCancel();
        this.mRunningActionCompleter = completer;
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        executeMeteringAction((MeteringRectangle[]) meteringRectangles.toArray(meteringRectangleArr), (MeteringRectangle[]) meteringRectangles2.toArray(meteringRectangleArr), (MeteringRectangle[]) meteringRectangles3.toArray(meteringRectangleArr), focusMeteringAction);
    }

    public void triggerAePrecapture(@Nullable final CallbackToFutureAdapter.Completer<Void> completer) {
        if (!this.mIsActive) {
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(this.mTemplate);
        builder.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        builder.addImplementationOptions(builder2.build());
        builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCancelled() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.set(null);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
    }

    public void triggerAf(@Nullable final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer, boolean z) {
        if (!this.mIsActive) {
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(this.mTemplate);
        builder.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        if (z) {
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.mCameraControl.getSupportedAeMode(1)));
        }
        builder.addImplementationOptions(builder2.build());
        builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCancelled() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.set(cameraCaptureResult);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
    }
}
