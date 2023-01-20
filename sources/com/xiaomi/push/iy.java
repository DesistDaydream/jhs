package com.xiaomi.push;

/* loaded from: classes3.dex */
public abstract class iy {
    public abstract int a(byte[] bArr, int i2, int i3);

    public void a(int i2) {
    }

    public byte[] a() {
        return null;
    }

    public int b() {
        return 0;
    }

    public abstract void b(byte[] bArr, int i2, int i3);

    public int c() {
        return -1;
    }

    public int d(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int a = a(bArr, i2 + i4, i3 - i4);
            if (a <= 0) {
                throw new iz("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes.");
            }
            i4 += a;
        }
        return i4;
    }
}
