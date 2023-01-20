package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class ba {
    public static az a(Class<? extends az> cls, int i2) {
        try {
            return (az) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i2));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
