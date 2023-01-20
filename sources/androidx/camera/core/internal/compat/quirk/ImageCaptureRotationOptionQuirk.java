package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ImageCaptureRotationOptionQuirk implements Quirk {
    private static boolean isHonor9X() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHuaweiMate20Lite() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isHuaweiMate20Lite() || isHonor9X();
    }

    public boolean isSupported(@NonNull Config.Option<?> option) {
        return option != CaptureConfig.OPTION_ROTATION;
    }
}
