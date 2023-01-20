package e.j.f.q.l;

import com.google.zxing.NotFoundException;
import e.j.f.l;

@Deprecated
/* loaded from: classes2.dex */
public final class b {
    private static final int b = 32;
    private final e.j.f.q.b a;

    public b(e.j.f.q.b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0031 A[EDGE_INSN: B:70:0x0031->B:22:0x0031 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0067 A[EDGE_INSN: B:86:0x0067->B:47:0x0067 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] a(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 < r8) goto L3a
            e.j.f.q.b r3 = r5.a
            if (r10 == 0) goto L12
            boolean r3 = r3.f(r2, r6)
            if (r3 == 0) goto L1b
            goto L18
        L12:
            boolean r3 = r3.f(r6, r2)
            if (r3 == 0) goto L1b
        L18:
            int r2 = r2 + (-1)
            goto L5
        L1b:
            r3 = r2
        L1c:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L31
            e.j.f.q.b r4 = r5.a
            if (r10 == 0) goto L2b
            boolean r4 = r4.f(r3, r6)
            if (r4 == 0) goto L1c
            goto L31
        L2b:
            boolean r4 = r4.f(r6, r3)
            if (r4 == 0) goto L1c
        L31:
            int r4 = r2 - r3
            if (r3 < r8) goto L3a
            if (r4 <= r7) goto L38
            goto L3a
        L38:
            r2 = r3
            goto L5
        L3a:
            r8 = 1
            int r2 = r2 + r8
        L3c:
            if (r0 >= r9) goto L70
            e.j.f.q.b r3 = r5.a
            if (r10 == 0) goto L49
            boolean r3 = r3.f(r0, r6)
            if (r3 == 0) goto L52
            goto L4f
        L49:
            boolean r3 = r3.f(r6, r0)
            if (r3 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r3 = r0
        L53:
            int r3 = r3 + r8
            if (r3 >= r9) goto L67
            e.j.f.q.b r4 = r5.a
            if (r10 == 0) goto L61
            boolean r4 = r4.f(r3, r6)
            if (r4 == 0) goto L53
            goto L67
        L61:
            boolean r4 = r4.f(r6, r3)
            if (r4 == 0) goto L53
        L67:
            int r4 = r3 - r0
            if (r3 >= r9) goto L70
            if (r4 <= r7) goto L6e
            goto L70
        L6e:
            r0 = r3
            goto L3c
        L70:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L7c
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            return r6
        L7c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.q.l.b.a(int, int, int, int, boolean):int[]");
    }

    private l c(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws NotFoundException {
        int[] a;
        int[] iArr = null;
        int i11 = i2;
        int i12 = i6;
        while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
            if (i3 == 0) {
                a = a(i12, i10, i4, i5, true);
            } else {
                a = a(i11, i10, i8, i9, false);
            }
            if (a == null) {
                if (iArr != null) {
                    if (i3 == 0) {
                        int i13 = i12 - i7;
                        if (iArr[0] < i2) {
                            if (iArr[1] > i2) {
                                return new l(iArr[i7 > 0 ? (char) 0 : (char) 1], i13);
                            }
                            return new l(iArr[0], i13);
                        }
                        return new l(iArr[1], i13);
                    }
                    int i14 = i11 - i3;
                    if (iArr[0] < i6) {
                        if (iArr[1] > i6) {
                            return new l(i14, iArr[i3 < 0 ? (char) 0 : (char) 1]);
                        }
                        return new l(i14, iArr[0]);
                    }
                    return new l(i14, iArr[1]);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            i12 += i7;
            i11 += i3;
            iArr = a;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public l[] b() throws NotFoundException {
        int j2 = this.a.j();
        int n = this.a.n();
        int i2 = j2 / 2;
        int i3 = n / 2;
        int max = Math.max(1, j2 / 256);
        int max2 = Math.max(1, n / 256);
        int i4 = -max;
        int i5 = i3 / 2;
        int d2 = ((int) c(i3, 0, 0, n, i2, i4, 0, j2, i5).d()) - 1;
        int i6 = i2 / 2;
        l c2 = c(i3, -max2, 0, n, i2, 0, d2, j2, i6);
        int c3 = ((int) c2.c()) - 1;
        l c4 = c(i3, max2, c3, n, i2, 0, d2, j2, i6);
        int c5 = ((int) c4.c()) + 1;
        l c6 = c(i3, 0, c3, c5, i2, max, d2, j2, i5);
        return new l[]{c(i3, 0, c3, c5, i2, i4, d2, ((int) c6.d()) + 1, i3 / 4), c2, c4, c6};
    }
}
