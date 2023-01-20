package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class YuvImageOnePixelShiftQuirk implements OnePixelShiftQuirk {
    private static boolean isMotorolaMotoG3() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "MotoG3".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isSamsungSMG532F() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-G532F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isSamsungSMGJ700F() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-J700F".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return isMotorolaMotoG3() || isSamsungSMG532F() || isSamsungSMGJ700F();
    }
}
