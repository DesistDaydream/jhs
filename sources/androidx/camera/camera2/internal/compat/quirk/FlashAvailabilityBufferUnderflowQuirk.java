package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements Quirk {
    private static final Set<Pair<String, String>> KNOWN_AFFECTED_MODELS = new HashSet(Arrays.asList(new Pair("sprd", "lemp")));

    public static boolean load() {
        Set<Pair<String, String>> set = KNOWN_AFFECTED_MODELS;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
