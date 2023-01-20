package androidx.camera.core.internal.compat.quirk;

import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

@RequiresApi(21)
/* loaded from: classes.dex */
public class SurfaceOrderQuirk implements Quirk {
    public static boolean load() {
        return true;
    }
}
