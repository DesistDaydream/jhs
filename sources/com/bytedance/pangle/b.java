package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;

/* loaded from: classes.dex */
public final class b {
    public static void a() {
        com.bytedance.pangle.flipped.c bVar;
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            bVar = new FlippedV2Impl();
        } else {
            if (i2 >= 28 || (i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z = true;
            }
            bVar = z ? new com.bytedance.pangle.flipped.b() : new com.bytedance.pangle.flipped.a();
        }
        bVar.invokeHiddenApiRestrictions();
    }
}
