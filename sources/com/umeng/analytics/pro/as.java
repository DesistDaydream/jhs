package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public class as {
    public static final void a(int i2, byte[] bArr) {
        a(i2, bArr, 0);
    }

    public static final boolean a(int i2, int i3) {
        return (i2 & (1 << i3)) != 0;
    }

    public static final boolean a(long j2, int i2) {
        return (j2 & (1 << i2)) != 0;
    }

    public static final byte b(byte b, int i2) {
        return (byte) b((int) b, i2);
    }

    public static final int b(int i2, int i3) {
        return i2 & (~(1 << i3));
    }

    public static final long b(long j2, int i2) {
        return j2 & (~(1 << i2));
    }

    public static final void a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
    }

    public static final short b(short s, int i2) {
        return (short) b((int) s, i2);
    }

    public static final int a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static final int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static final boolean a(byte b, int i2) {
        return a((int) b, i2);
    }

    public static final boolean a(short s, int i2) {
        return a((int) s, i2);
    }

    public static final byte a(byte b, int i2, boolean z) {
        return (byte) a((int) b, i2, z);
    }

    public static final short a(short s, int i2, boolean z) {
        return (short) a((int) s, i2, z);
    }

    public static final int a(int i2, int i3, boolean z) {
        return z ? i2 | (1 << i3) : b(i2, i3);
    }

    public static final long a(long j2, int i2, boolean z) {
        return z ? j2 | (1 << i2) : b(j2, i2);
    }
}
