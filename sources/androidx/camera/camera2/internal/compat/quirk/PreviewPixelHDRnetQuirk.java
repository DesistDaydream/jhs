package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RequiresApi(21)
/* loaded from: classes.dex */
public class PreviewPixelHDRnetQuirk implements Quirk {
    private static final List<String> SUPPORTED_DEVICES = Arrays.asList("sunfish", "bramble", "redfin", "barbet");

    public static boolean load() {
        return "Google".equals(Build.MANUFACTURER) && SUPPORTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.getDefault()));
    }
}
