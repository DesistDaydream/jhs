package com.bytedance.pangle.log;

import com.bytedance.pangle.util.k;

/* loaded from: classes.dex */
public final class c {
    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static int b(Object obj) {
        if (obj == null) {
            return -1;
        }
        return k.a(obj.toString());
    }
}
