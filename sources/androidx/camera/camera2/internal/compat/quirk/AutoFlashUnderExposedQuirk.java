package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public class AutoFlashUnderExposedQuirk implements Quirk {
    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return false;
    }
}
