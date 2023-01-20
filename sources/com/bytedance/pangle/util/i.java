package com.bytedance.pangle.util;

import android.os.Build;

/* loaded from: classes.dex */
public final class i {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 21 && i2 <= 23;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            return i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
