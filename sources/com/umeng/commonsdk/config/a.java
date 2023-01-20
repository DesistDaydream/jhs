package com.umeng.commonsdk.config;

/* loaded from: classes3.dex */
public class a {
    public static boolean a(int i2, int i3) {
        return i3 >= 0 && i3 <= 31 && (i2 & (1 << i3)) != 0;
    }

    public static boolean a(long j2, int i2) {
        return i2 >= 0 && i2 <= 63 && (j2 & (1 << i2)) != 0;
    }

    public static int b(int i2, int i3) {
        return i2 | (1 << i3);
    }

    public static long b(long j2, int i2) {
        return (i2 < 0 || i2 > 63) ? j2 : j2 | (1 << i2);
    }

    public static int c(int i2, int i3) {
        return i2 & (~(1 << i3));
    }

    public static long c(long j2, int i2) {
        return (i2 < 0 || i2 > 63) ? j2 : j2 & (~(1 << i2));
    }
}
