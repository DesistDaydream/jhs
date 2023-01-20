package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public class AfRegionFlipHorizontallyQuirk implements Quirk {
    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return Build.BRAND.equalsIgnoreCase("SAMSUNG") && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
