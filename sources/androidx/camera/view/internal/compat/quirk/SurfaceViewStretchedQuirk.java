package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public class SurfaceViewStretchedQuirk implements Quirk {
    private static final String GALAXY_Z_FOLD_2 = "F2Q";
    private static final String GALAXY_Z_FOLD_3 = "Q2Q";
    private static final String OPPO = "OPPO";
    private static final String OPPO_FIND_N = "OP4E75L1";
    private static final String SAMSUNG = "SAMSUNG";

    private static boolean isOppoFoldable() {
        return OPPO.equalsIgnoreCase(Build.MANUFACTURER) && OPPO_FIND_N.equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isSamsungFold2OrFold3() {
        if ("SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
            String str = Build.DEVICE;
            if (GALAXY_Z_FOLD_2.equalsIgnoreCase(str) || GALAXY_Z_FOLD_3.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean load() {
        return isSamsungFold2OrFold3() || isOppoFoldable();
    }
}
