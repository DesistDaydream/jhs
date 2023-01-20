package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class j extends x {

    /* renamed from: k  reason: collision with root package name */
    private final int[] f11640k = new int[4];

    @Override // e.j.f.u.x
    public int l(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f11640k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int n = aVar.n();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < n; i3++) {
            sb.append((char) (x.j(aVar, iArr2, i2, x.f11660i) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = x.n(aVar, i2, true, x.f11658g)[1];
        for (int i6 = 0; i6 < 4 && i5 < n; i6++) {
            sb.append((char) (x.j(aVar, iArr2, i5, x.f11660i) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // e.j.f.u.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
