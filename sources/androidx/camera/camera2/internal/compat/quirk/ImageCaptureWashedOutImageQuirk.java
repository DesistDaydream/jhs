package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ImageCaptureWashedOutImageQuirk implements UseTorchAsFlashQuirk {
    @VisibleForTesting
    public static final String BUILD_BRAND = "SAMSUNG";
    @VisibleForTesting
    public static final List<String> BUILD_MODELS = Arrays.asList("SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P");

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return "SAMSUNG".equals(str.toUpperCase(locale)) && BUILD_MODELS.contains(Build.MODEL.toUpperCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
