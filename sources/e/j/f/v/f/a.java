package e.j.f.v.f;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import e.j.f.l;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final float f11708c = 0.42f;

    /* renamed from: d  reason: collision with root package name */
    private static final float f11709d = 0.8f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11712g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11713h = 5;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11714i = 25;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11715j = 5;

    /* renamed from: k  reason: collision with root package name */
    private static final int f11716k = 10;
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f11710e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f11711f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private a() {
    }

    private static void a(l[] lVarArr, l[] lVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            lVarArr[iArr[i2]] = lVarArr2[i2];
        }
    }

    public static b b(e.j.f.b bVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        e.j.f.q.b b2 = bVar.b();
        List<l[]> c2 = c(z, b2);
        if (c2.isEmpty()) {
            b2 = b2.clone();
            b2.q();
            c2 = c(z, b2);
        }
        return new b(b2, c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r4.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5 = (e.j.f.l[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5[3] == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<e.j.f.l[]> c(boolean r8, e.j.f.q.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.j()
            if (r3 >= r6) goto L7c
            e.j.f.l[] r4 = f(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L52
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L52
            if (r5 == 0) goto L7c
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            e.j.f.l[] r5 = (e.j.f.l[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.d()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.d()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            goto L8
        L52:
            r0.add(r4)
            if (r8 == 0) goto L7c
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6a
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
            goto L78
        L6a:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
        L78:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.v.f.a.c(boolean, e.j.f.q.b):java.util.List");
    }

    private static int[] d(e.j.f.q.b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.f(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i7 = 0;
        int i8 = i2;
        while (i2 < i4) {
            if (bVar.f(i2, i3) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else if (g(iArr2, iArr, f11709d) < f11708c) {
                    return new int[]{i8, i2};
                } else {
                    i8 += iArr2[0] + iArr2[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i7 != length - 1 || g(iArr2, iArr, f11709d) >= f11708c) {
            return null;
        }
        return new int[]{i8, i2 - 1};
    }

    private static l[] e(e.j.f.q.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int i7;
        int i8;
        l[] lVarArr = new l[4];
        int[] iArr2 = new int[iArr.length];
        int i9 = i4;
        while (true) {
            if (i9 >= i2) {
                z = false;
                break;
            }
            int[] d2 = d(bVar, i5, i9, i3, false, iArr, iArr2);
            if (d2 != null) {
                int i10 = i9;
                int[] iArr3 = d2;
                int i11 = i10;
                while (true) {
                    if (i11 <= 0) {
                        i8 = i11;
                        break;
                    }
                    int i12 = i11 - 1;
                    int[] d3 = d(bVar, i5, i12, i3, false, iArr, iArr2);
                    if (d3 == null) {
                        i8 = i12 + 1;
                        break;
                    }
                    iArr3 = d3;
                    i11 = i12;
                }
                float f2 = i8;
                lVarArr[0] = new l(iArr3[0], f2);
                lVarArr[1] = new l(iArr3[1], f2);
                i9 = i8;
                z = true;
            } else {
                i9 += 5;
            }
        }
        int i13 = i9 + 1;
        if (z) {
            int[] iArr4 = {(int) lVarArr[0].c(), (int) lVarArr[1].c()};
            int i14 = i13;
            int i15 = 0;
            while (true) {
                if (i14 >= i2) {
                    i6 = i15;
                    i7 = i14;
                    break;
                }
                i6 = i15;
                i7 = i14;
                int[] d4 = d(bVar, iArr4[0], i14, i3, false, iArr, iArr2);
                if (d4 != null && Math.abs(iArr4[0] - d4[0]) < 5 && Math.abs(iArr4[1] - d4[1]) < 5) {
                    iArr4 = d4;
                    i15 = 0;
                } else if (i6 > 25) {
                    break;
                } else {
                    i15 = i6 + 1;
                }
                i14 = i7 + 1;
            }
            i13 = i7 - (i6 + 1);
            float f3 = i13;
            lVarArr[2] = new l(iArr4[0], f3);
            lVarArr[3] = new l(iArr4[1], f3);
        }
        if (i13 - i9 < 10) {
            Arrays.fill(lVarArr, (Object) null);
        }
        return lVarArr;
    }

    private static l[] f(e.j.f.q.b bVar, int i2, int i3) {
        int j2 = bVar.j();
        int n = bVar.n();
        l[] lVarArr = new l[8];
        a(lVarArr, e(bVar, j2, n, i2, i3, f11710e), a);
        if (lVarArr[4] != null) {
            i3 = (int) lVarArr[4].c();
            i2 = (int) lVarArr[4].d();
        }
        a(lVarArr, e(bVar, j2, n, i2, i3, f11711f), b);
        return lVarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
