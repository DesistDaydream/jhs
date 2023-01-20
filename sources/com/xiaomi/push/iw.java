package com.xiaomi.push;

/* loaded from: classes3.dex */
public class iw extends iy {
    private Cif a;
    private int b;

    public iw(int i2) {
        this.a = new Cif(i2);
    }

    @Override // com.xiaomi.push.iy
    public int a(byte[] bArr, int i2, int i3) {
        byte[] a = this.a.a();
        if (i3 > this.a.b() - this.b) {
            i3 = this.a.b() - this.b;
        }
        if (i3 > 0) {
            System.arraycopy(a, this.b, bArr, i2, i3);
            this.b += i3;
        }
        return i3;
    }

    public int a_() {
        return this.a.size();
    }

    @Override // com.xiaomi.push.iy
    public void b(byte[] bArr, int i2, int i3) {
        this.a.write(bArr, i2, i3);
    }
}
