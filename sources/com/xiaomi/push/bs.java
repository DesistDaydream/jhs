package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import java.io.File;

/* loaded from: classes3.dex */
public class bs {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                if (new File(str).exists()) {
                    return Os.stat(str).st_size;
                }
                return 0L;
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a(e2);
                return 0L;
            }
        }
        return 0L;
    }
}
