package com.xiaomi.push;

/* loaded from: classes3.dex */
public final class ee {
    public static final int a = a(1, 3);
    public static final int b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f8500c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f8501d = a(3, 2);

    public static int a(int i2) {
        return i2 & 7;
    }

    public static int a(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static int b(int i2) {
        return i2 >>> 3;
    }
}
