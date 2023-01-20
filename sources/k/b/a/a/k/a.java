package k.b.a.a.k;

import com.umeng.analytics.pro.cb;
import k.b.a.a.k.j;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class a extends j {
    private static final int A = 15;
    private static final int t = 4;
    private static final int u = 2;
    private static final int v = 1;
    private static final byte[] w = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, cb.f7124m};
    private static final byte[] x = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final byte[] y = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, cb.f7124m};
    private static final byte[] z = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private final byte[] r;
    private final byte[] s;

    public a() {
        this(false);
    }

    private void A() {
        if (v()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabetcharacter but not a possible encoding. Decoding requires at least two characters to create one byte.");
        }
    }

    private int z(byte b) {
        int i2 = b & 255;
        byte[] bArr = this.r;
        byte b2 = i2 < bArr.length ? bArr[b] : (byte) -1;
        if (b2 != -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid octet in encoded value: " + ((int) b));
    }

    @Override // k.b.a.a.k.j
    public void g(byte[] bArr, int i2, int i3, j.a aVar) {
        if (!aVar.f16056f && i3 >= 0) {
            int min = Math.min(bArr.length - i2, i3);
            int i4 = 0;
            int i5 = (aVar.a != 0 ? 1 : 0) + min;
            if (i5 == 1 && i5 == min) {
                aVar.a = z(bArr[i2]) + 1;
                return;
            }
            int i6 = i5 % 2 == 0 ? i5 : i5 - 1;
            byte[] m2 = m(i6 / 2, aVar);
            if (min < i5) {
                int i7 = i2 + 1;
                int z2 = z(bArr[i2]) | ((aVar.a - 1) << 4);
                int i8 = aVar.f16054d;
                aVar.f16054d = i8 + 1;
                m2[i8] = (byte) z2;
                aVar.a = 0;
                i4 = 2;
                i2 = i7;
            }
            while (i4 < i6) {
                int i9 = i2 + 1;
                int i10 = i9 + 1;
                int z3 = (z(bArr[i2]) << 4) | z(bArr[i9]);
                i4 += 2;
                int i11 = aVar.f16054d;
                aVar.f16054d = i11 + 1;
                m2[i11] = (byte) z3;
                i2 = i10;
            }
            if (i4 < min) {
                aVar.a = z(bArr[i4]) + 1;
                return;
            }
            return;
        }
        aVar.f16056f = true;
        if (aVar.a != 0) {
            A();
        }
    }

    @Override // k.b.a.a.k.j
    public void i(byte[] bArr, int i2, int i3, j.a aVar) {
        if (aVar.f16056f) {
            return;
        }
        if (i3 < 0) {
            aVar.f16056f = true;
            return;
        }
        int i4 = i3 * 2;
        if (i4 >= 0) {
            byte[] m2 = m(i4, aVar);
            int i5 = i3 + i2;
            while (i2 < i5) {
                byte b = bArr[i2];
                int i6 = b & cb.f7124m;
                int i7 = aVar.f16054d;
                int i8 = i7 + 1;
                aVar.f16054d = i8;
                byte[] bArr2 = this.s;
                m2[i7] = bArr2[(b >> 4) & 15];
                aVar.f16054d = i8 + 1;
                m2[i8] = bArr2[i6];
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Input length exceeds maximum size for encoded data: " + i3);
    }

    @Override // k.b.a.a.k.j
    public boolean s(byte b) {
        int i2 = b & 255;
        byte[] bArr = this.r;
        return i2 < bArr.length && bArr[b] != -1;
    }

    public a(boolean z2) {
        this(z2, j.p);
    }

    public a(boolean z2, CodecPolicy codecPolicy) {
        super(1, 2, 0, 0, (byte) 61, codecPolicy);
        if (z2) {
            this.s = z;
            this.r = y;
            return;
        }
        this.s = x;
        this.r = w;
    }
}
