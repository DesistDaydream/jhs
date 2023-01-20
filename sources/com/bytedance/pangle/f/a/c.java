package com.bytedance.pangle.f.a;

/* loaded from: classes.dex */
public final class c {
    public int[] a = new int[32];
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f2283c;

    public final void a() {
        b();
        int i2 = this.b;
        int[] iArr = this.a;
        iArr[i2] = 0;
        iArr[i2 + 1] = 0;
        this.b = i2 + 2;
        this.f2283c++;
    }

    public final void b() {
        int[] iArr = this.a;
        int length = iArr.length;
        int i2 = this.b;
        int i3 = length - i2;
        if (i3 <= 2) {
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.a = iArr2;
        }
    }
}
