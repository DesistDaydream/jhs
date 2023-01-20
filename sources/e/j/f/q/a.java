package e.j.f.q;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public final class a implements Cloneable {
    private int[] a;
    private int b;

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    private void g(int i2) {
        if (i2 > (this.a.length << 5)) {
            int[] q = q(i2);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, q, 0, iArr.length);
            this.a = q;
        }
    }

    private static int[] q(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void a(boolean z) {
        g(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i2 = this.b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.b++;
    }

    public void b(a aVar) {
        int i2 = aVar.b;
        g(this.b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.j(i3));
        }
    }

    public void c(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            g(this.b + i3);
            while (i3 > 0) {
                boolean z = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void e() {
        int length = this.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.a[i2] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.b == aVar.b && Arrays.equals(this.a, aVar.a);
        }
        return false;
    }

    /* renamed from: f */
    public a clone() {
        return new a((int[]) this.a.clone(), this.b);
    }

    public void h(int i2) {
        int[] iArr = this.a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public boolean j(int i2) {
        return ((1 << (i2 & 31)) & this.a[i2 / 32]) != 0;
    }

    public int[] k() {
        return this.a;
    }

    public int l(int i2) {
        int i3 = this.b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.b;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int m(int i2) {
        int i3 = this.b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.b;
            }
            i5 = ~iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int n() {
        return this.b;
    }

    public int o() {
        return (this.b + 7) / 8;
    }

    public boolean p(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.a[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void r() {
        int[] iArr = new int[this.a.length];
        int i2 = (this.b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i5 = this.b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.a = iArr;
    }

    public void s(int i2) {
        int[] iArr = this.a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void t(int i2, int i3) {
        this.a[i2 / 32] = i3;
    }

    public String toString() {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.b; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(j(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void u(int i2, int i3) {
        if (i3 < i2 || i2 < 0 || i3 > this.b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 31;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            if (i7 >= i6) {
                i8 = 31 & i4;
            }
            int i10 = (2 << i8) - (1 << i9);
            int[] iArr = this.a;
            iArr[i7] = i10 | iArr[i7];
            i7++;
        }
    }

    public void v(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (j(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public void w(a aVar) {
        if (this.b != aVar.b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.a[i2];
            i2++;
        }
    }

    public a(int i2) {
        this.b = i2;
        this.a = q(i2);
    }

    public a(int[] iArr, int i2) {
        this.a = iArr;
        this.b = i2;
    }
}
