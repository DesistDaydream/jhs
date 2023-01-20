package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class n {
    private int a;
    private final int[] b = new int[10];

    public int a(int i2) {
        return this.b[i2];
    }

    public n a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                this.a = (1 << i2) | this.a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    public void a(n nVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (nVar.d(i2)) {
                a(i2, nVar.a(i2));
            }
        }
    }

    public int b() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    public int b(int i2) {
        return (this.a & 16) != 0 ? this.b[4] : i2;
    }

    public int c() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public int c(int i2) {
        return (this.a & 32) != 0 ? this.b[5] : i2;
    }

    public int d() {
        return Integer.bitCount(this.a);
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.a) != 0;
    }
}
