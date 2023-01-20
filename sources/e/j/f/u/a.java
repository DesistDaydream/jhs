package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a extends q {

    /* renamed from: d  reason: collision with root package name */
    private static final float f11564d = 2.0f;

    /* renamed from: e  reason: collision with root package name */
    private static final float f11565e = 1.5f;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11569i = 3;
    private final StringBuilder a = new StringBuilder(20);
    private int[] b = new int[80];

    /* renamed from: c  reason: collision with root package name */
    private int f11571c = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final String f11566f = "0123456789-$:/.+ABCD";

    /* renamed from: g  reason: collision with root package name */
    public static final char[] f11567g = f11566f.toCharArray();

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f11568h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f11570j = {'A', 'B', 'C', 'D'};

    public static boolean h(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i2) {
        int[] iArr = this.b;
        int i3 = this.f11571c;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.f11571c = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.b = iArr2;
        }
    }

    private int j() throws NotFoundException {
        for (int i2 = 1; i2 < this.f11571c; i2 += 2) {
            int l2 = l(i2);
            if (l2 != -1 && h(f11570j, f11567g[l2])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.b[i4];
                }
                if (i2 == 1 || this.b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void k(e.j.f.q.a aVar) throws NotFoundException {
        int i2 = 0;
        this.f11571c = 0;
        int m2 = aVar.m(0);
        int n = aVar.n();
        if (m2 < n) {
            boolean z = true;
            while (m2 < n) {
                if (aVar.j(m2) != z) {
                    i2++;
                } else {
                    i(i2);
                    z = !z;
                    i2 = 1;
                }
                m2++;
            }
            i(i2);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int l(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f11571c) {
            return -1;
        }
        int[] iArr = this.b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f11568h;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ae, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(int r15) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.a.m(int):void");
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.b, 0);
        k(aVar);
        int j2 = j();
        this.a.setLength(0);
        int i3 = j2;
        do {
            int l2 = l(i3);
            if (l2 != -1) {
                this.a.append((char) l2);
                i3 += 8;
                if (this.a.length() > 1 && h(f11570j, f11567g[l2])) {
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (i3 < this.f11571c);
        int i4 = i3 - 1;
        int i5 = this.b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.b[i3 + i7];
        }
        if (i3 < this.f11571c && i5 < i6 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        m(j2);
        for (int i8 = 0; i8 < this.a.length(); i8++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i8, f11567g[sb.charAt(i8)]);
        }
        char charAt = this.a.charAt(0);
        char[] cArr = f11570j;
        if (h(cArr, charAt)) {
            StringBuilder sb2 = this.a;
            if (h(cArr, sb2.charAt(sb2.length() - 1))) {
                if (this.a.length() > 3) {
                    if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                        StringBuilder sb3 = this.a;
                        sb3.deleteCharAt(sb3.length() - 1);
                        this.a.deleteCharAt(0);
                    }
                    int i9 = 0;
                    for (int i10 = 0; i10 < j2; i10++) {
                        i9 += this.b[i10];
                    }
                    float f2 = i9;
                    while (j2 < i4) {
                        i9 += this.b[j2];
                        j2++;
                    }
                    float f3 = i2;
                    return new e.j.f.k(this.a.toString(), null, new e.j.f.l[]{new e.j.f.l(f2, f3), new e.j.f.l(i9, f3)}, BarcodeFormat.CODABAR);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
