package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class gp {
    public static boolean a(Context context) {
        return !com.xiaomi.push.service.be.b.isEmpty() && al.f(context) && ii.m(context);
    }

    public static boolean a(Context context, int i2) {
        if (context != null && i2 > 0) {
            String c2 = com.xiaomi.push.service.cq.c(context);
            if (!TextUtils.isEmpty(c2)) {
                for (int i3 = 1; i3 <= i2; i3++) {
                    if (ff.a(10) == jm.a(c2.substring(c2.length() - 1, c2.length()), -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
