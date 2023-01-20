package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class JpegHalCorruptImageQuirk implements SoftwareJpegEncodingPreferredQuirk {
    private static final Set<String> KNOWN_AFFECTED_DEVICES = new HashSet(Arrays.asList("heroqltevzw", "heroqltetmo"));

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return KNOWN_AFFECTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.US));
    }
}
