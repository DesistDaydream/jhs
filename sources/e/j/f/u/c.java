package e.j.f.u;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class c extends q {
    public static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final float b = 0.25f;

    /* renamed from: c  reason: collision with root package name */
    private static final float f11618c = 0.7f;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11619d = 98;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11620e = 99;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11621f = 100;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11622g = 101;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11623h = 102;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11624i = 97;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11625j = 96;

    /* renamed from: k  reason: collision with root package name */
    private static final int f11626k = 101;

    /* renamed from: l  reason: collision with root package name */
    private static final int f11627l = 100;

    /* renamed from: m  reason: collision with root package name */
    private static final int f11628m = 103;
    private static final int n = 104;
    private static final int o = 105;
    private static final int p = 106;

    private static int h(e.j.f.q.a aVar, int[] iArr, int i2) throws NotFoundException {
        q.f(aVar, i2, iArr);
        float f2 = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i4 >= iArr2.length) {
                break;
            }
            float e2 = q.e(iArr, iArr2[i4], f11618c);
            if (e2 < f2) {
                i3 = i4;
                f2 = e2;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] i(e.j.f.q.a aVar) throws NotFoundException {
        int n2 = aVar.n();
        int l2 = aVar.l(0);
        int[] iArr = new int[6];
        int i2 = l2;
        boolean z = false;
        int i3 = 0;
        while (l2 < n2) {
            if (aVar.j(l2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    float f2 = 0.25f;
                    int i4 = -1;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float e2 = q.e(iArr, a[i5], f11618c);
                        if (e2 < f2) {
                            i4 = i5;
                            f2 = e2;
                        }
                    }
                    if (i4 >= 0 && aVar.p(Math.max(0, i2 - ((l2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, l2, i4};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i6 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i6);
                    iArr[i6] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            l2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e1, code lost:
        if (r9 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0127, code lost:
        if (r9 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0129, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012e A[PHI: r17 
      PHI: (r17v10 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:67:0x0107, B:43:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013a A[PHI: r16 r17 
      PHI: (r16v4 boolean) = (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v3 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean) binds: [B:67:0x0107, B:69:0x010b, B:73:0x0117, B:72:0x0113, B:85:0x0138, B:43:0x00c1, B:45:0x00c6, B:49:0x00d3, B:48:0x00ce] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r17v9 boolean) = (r17v6 boolean), (r17v6 boolean), (r17v6 boolean), (r17v6 boolean), (r17v8 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean) binds: [B:67:0x0107, B:69:0x010b, B:73:0x0117, B:72:0x0113, B:85:0x0138, B:43:0x00c1, B:45:0x00c6, B:49:0x00d3, B:48:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // e.j.f.u.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e.j.f.k b(int r25, e.j.f.q.a r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.c.b(int, e.j.f.q.a, java.util.Map):e.j.f.k");
    }
}
