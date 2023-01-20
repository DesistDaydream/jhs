package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Collections;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraCharacteristicsBaseImpl implements CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl {
    @NonNull
    public final CameraCharacteristics mCameraCharacteristics;

    public CameraCharacteristicsBaseImpl(@NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    @Nullable
    public <T> T get(@NonNull CameraCharacteristics.Key<T> key) {
        return (T) this.mCameraCharacteristics.get(key);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    @NonNull
    public Set<String> getPhysicalCameraIds() {
        return Collections.emptySet();
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    @NonNull
    public CameraCharacteristics unwrap() {
        return this.mCameraCharacteristics;
    }
}
