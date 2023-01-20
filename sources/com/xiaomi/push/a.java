package com.xiaomi.push;

/* loaded from: classes3.dex */
public final class a {
    public static final a a = new a(new byte[0]);
    private final byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f8235c = 0;

    private a(byte[] bArr) {
        this.b = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new a(bArr2);
    }

    public int a() {
        return this.b.length;
    }

    public byte[] b() {
        byte[] bArr = this.b;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            byte[] bArr = this.b;
            int length = bArr.length;
            byte[] bArr2 = ((a) obj).b;
            if (length != bArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f8235c;
        if (i2 == 0) {
            byte[] bArr = this.b;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i2 = length == 0 ? 1 : length;
            this.f8235c = i2;
        }
        return i2;
    }
}
