package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public final class ch extends ci {
    private byte[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7125c;

    public ch() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i2, int i3) throws cj {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.f7125c = i2 + i3;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.ci
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.ci
    public int h() {
        return this.f7125c - this.b;
    }

    public ch(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i2, int i3) throws cj {
        int h2 = h();
        if (i3 > h2) {
            i3 = h2;
        }
        if (i3 > 0) {
            System.arraycopy(this.a, this.b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    public ch(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.ci
    public void a(int i2) {
        this.b += i2;
    }
}
