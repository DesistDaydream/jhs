package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class m extends q {
    private static final float b = 0.38f;

    /* renamed from: c  reason: collision with root package name */
    private static final float f11641c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11642d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11643e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11644f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f11645g = {6, 8, 10, 12, 14};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f11646h = {1, 1, 1, 1};

    /* renamed from: i  reason: collision with root package name */
    private static final int[][] f11647i = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: j  reason: collision with root package name */
    private static final int[][] f11648j = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private static int h(int[] iArr) throws NotFoundException {
        int length = f11648j.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float e2 = q.e(iArr, f11648j[i3], 0.5f);
            if (e2 < f2) {
                i2 = i3;
                f2 = e2;
            } else if (e2 == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] i(e.j.f.q.a aVar) throws NotFoundException {
        int i2;
        int[] l2;
        aVar.r();
        try {
            try {
                l2 = l(aVar, m(aVar), f11647i[0]);
            } catch (NotFoundException unused) {
                l2 = l(aVar, i2, f11647i[1]);
            }
            n(aVar, l2[0]);
            int i3 = l2[0];
            l2[0] = aVar.n() - l2[1];
            l2[1] = aVar.n() - i3;
            return l2;
        } finally {
            aVar.r();
        }
    }

    private static void j(e.j.f.q.a aVar, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            q.f(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] k(e.j.f.q.a aVar) throws NotFoundException {
        int[] l2 = l(aVar, m(aVar), f11646h);
        this.a = (l2[1] - l2[0]) / 4;
        n(aVar, l2[0]);
        return l2;
    }

    private static int[] l(e.j.f.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int n = aVar.n();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < n) {
            if (aVar.j(i2) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (q.e(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i3, i2};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int m(e.j.f.q.a aVar) throws NotFoundException {
        int n = aVar.n();
        int l2 = aVar.l(0);
        if (l2 != n) {
            return l2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n(e.j.f.q.a r3, int r4) throws com.google.zxing.NotFoundException {
        /*
            r2 = this;
            int r0 = r2.a
            int r0 = r0 * 10
            if (r0 >= r4) goto L7
            goto L8
        L7:
            r0 = r4
        L8:
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L19
            if (r4 < 0) goto L19
            boolean r1 = r3.j(r4)
            if (r1 != 0) goto L19
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L19:
            if (r0 != 0) goto L1c
            return
        L1c:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.m.n(e.j.f.q.a, int):void");
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] k2 = k(aVar);
        int[] i3 = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, k2[1], i3[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f11645g;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length2) {
                z = false;
                break;
            }
            int i6 = iArr[i4];
            if (length == i6) {
                z = true;
                break;
            }
            if (i6 > i5) {
                i5 = i6;
            }
            i4++;
        }
        if (!z && length > i5) {
            z = true;
        }
        if (z) {
            float f2 = i2;
            return new e.j.f.k(sb2, null, new e.j.f.l[]{new e.j.f.l(k2[1], f2), new e.j.f.l(i3[0], f2)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }
}
