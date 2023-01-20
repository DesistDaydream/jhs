package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class h extends x {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f11638l = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: k  reason: collision with root package name */
    private final int[] f11639k = new int[4];

    private static void s(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f11638l[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.x
    public int l(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f11639k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int n = aVar.n();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < n; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f11661j);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        s(sb, i3);
        int i6 = x.n(aVar, i2, true, x.f11658g)[1];
        for (int i7 = 0; i7 < 6 && i6 < n; i7++) {
            sb.append((char) (x.j(aVar, iArr2, i6, x.f11660i) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // e.j.f.u.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
