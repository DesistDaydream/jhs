package com.xiaomi.push;

/* loaded from: classes3.dex */
public final class ix extends iy {
    private byte[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f9012c;

    @Override // com.xiaomi.push.iy
    public int a(byte[] bArr, int i2, int i3) {
        int c2 = c();
        if (i3 > c2) {
            i3 = c2;
        }
        if (i3 > 0) {
            System.arraycopy(this.a, this.b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.iy
    public void a(int i2) {
        this.b += i2;
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.iy
    public byte[] a() {
        return this.a;
    }

    @Override // com.xiaomi.push.iy
    public int b() {
        return this.b;
    }

    @Override // com.xiaomi.push.iy
    public void b(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.iy
    public int c() {
        return this.f9012c - this.b;
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.f9012c = i2 + i3;
    }
}
