package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CropRegionZoomImpl implements ZoomControl.ZoomImpl {
    public static final float MIN_DIGITAL_ZOOM = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private Rect mCurrentCropRect = null;
    private Rect mPendingZoomCropRegion = null;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;

    public CropRegionZoomImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
    }

    @NonNull
    private static Rect getCropRectByRatio(@NonNull Rect rect, float f2) {
        float width = rect.width() / f2;
        float height = rect.height() / f2;
        float width2 = (rect.width() - width) / 2.0f;
        float height2 = (rect.height() - height) / 2.0f;
        return new Rect((int) width2, (int) height2, (int) (width2 + width), (int) (height2 + height));
    }

    private Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(@NonNull Camera2ImplConfig.Builder builder) {
        Rect rect = this.mCurrentCropRect;
        if (rect != null) {
            builder.setCaptureRequestOption(CaptureRequest.SCALER_CROP_REGION, rect);
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    @NonNull
    public Rect getCropSensorRegion() {
        Rect rect = this.mCurrentCropRect;
        return rect != null ? rect : getSensorRect();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        Float f2 = (Float) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 == null) {
            return 1.0f;
        }
        if (f2.floatValue() < getMinZoom()) {
            return getMinZoom();
        }
        return f2.floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
        if (this.mPendingZoomRatioCompleter != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            Rect rect2 = this.mPendingZoomCropRegion;
            if (rect2 == null || !rect2.equals(rect)) {
                return;
            }
            this.mPendingZoomRatioCompleter.set(null);
            this.mPendingZoomRatioCompleter = null;
            this.mPendingZoomCropRegion = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mPendingZoomCropRegion = null;
        this.mCurrentCropRect = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mPendingZoomRatioCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            this.mPendingZoomRatioCompleter = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float f2, @NonNull CallbackToFutureAdapter.Completer<Void> completer) {
        this.mCurrentCropRect = getCropRectByRatio(getSensorRect(), f2);
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mPendingZoomRatioCompleter;
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.mPendingZoomCropRegion = this.mCurrentCropRect;
        this.mPendingZoomRatioCompleter = completer;
    }
}
