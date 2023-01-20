package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* loaded from: classes.dex */
public final class ZslUtil {
    private ZslUtil() {
    }

    @RequiresApi(21)
    public static boolean isCapabilitySupported(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2) {
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }
}
