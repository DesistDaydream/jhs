package com.xiaomi.push.service;

import com.xiaomi.push.gw;
import com.xiaomi.push.gx;

/* loaded from: classes3.dex */
public /* synthetic */ class af {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[gx.values().length];
        b = iArr;
        try {
            iArr[gx.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[gx.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[gx.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[gx.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[gw.values().length];
        a = iArr2;
        try {
            iArr2[gw.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[gw.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
