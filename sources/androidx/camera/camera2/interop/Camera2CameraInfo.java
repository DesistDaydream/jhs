package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.Map;

@RequiresApi(21)
@ExperimentalCamera2Interop
/* loaded from: classes.dex */
public final class Camera2CameraInfo {
    private static final String TAG = "Camera2CameraInfo";
    private final Camera2CameraInfoImpl mCamera2CameraInfoImpl;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraInfo(@NonNull Camera2CameraInfoImpl camera2CameraInfoImpl) {
        this.mCamera2CameraInfoImpl = camera2CameraInfoImpl;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static CameraCharacteristics extractCameraCharacteristics(@NonNull CameraInfo cameraInfo) {
        Preconditions.checkState(cameraInfo instanceof Camera2CameraInfoImpl, "CameraInfo does not contain any Camera2 information.");
        return ((Camera2CameraInfoImpl) cameraInfo).getCameraCharacteristicsCompat().toCameraCharacteristics();
    }

    @NonNull
    public static Camera2CameraInfo from(@NonNull CameraInfo cameraInfo) {
        Preconditions.checkArgument(cameraInfo instanceof Camera2CameraInfoImpl, "CameraInfo doesn't contain Camera2 implementation.");
        return ((Camera2CameraInfoImpl) cameraInfo).getCamera2CameraInfo();
    }

    @Nullable
    public <T> T getCameraCharacteristic(@NonNull CameraCharacteristics.Key<T> key) {
        return (T) this.mCamera2CameraInfoImpl.getCameraCharacteristicsCompat().get(key);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<String, CameraCharacteristics> getCameraCharacteristicsMap() {
        return this.mCamera2CameraInfoImpl.getCameraCharacteristicsMap();
    }

    @NonNull
    public String getCameraId() {
        return this.mCamera2CameraInfoImpl.getCameraId();
    }
}
