package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import e.j.f.l;
import e.j.f.m;
import e.j.f.q.b;
import e.j.f.w.d.d;
import e.j.f.w.d.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FinderPatternFinder {

    /* renamed from: f  reason: collision with root package name */
    private static final int f3286f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f3287g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f3288h = 97;
    private final b a;
    private final List<d> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3289c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f3290d;

    /* renamed from: e  reason: collision with root package name */
    private final m f3291e;

    /* loaded from: classes2.dex */
    public static final class CenterComparator implements Serializable, Comparator<d> {
        private final float average;

        private CenterComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            int compare = Integer.compare(dVar2.h(), dVar.h());
            return compare == 0 ? Float.compare(Math.abs(dVar.i() - this.average), Math.abs(dVar2.i() - this.average)) : compare;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FurthestFromAverageComparator implements Serializable, Comparator<d> {
        private final float average;

        private FurthestFromAverageComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.i() - this.average), Math.abs(dVar.i() - this.average));
        }
    }

    public FinderPatternFinder(b bVar) {
        this(bVar, null);
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean c(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] j2 = j();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.a.f(i3 - i7, i2 - i7)) {
            j2[2] = j2[2] + 1;
            i7++;
        }
        if (j2[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.a.f(i3 - i7, i2 - i7)) {
            j2[1] = j2[1] + 1;
            i7++;
        }
        if (j2[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.a.f(i3 - i7, i2 - i7)) {
            j2[0] = j2[0] + 1;
            i7++;
        }
        if (j2[0] == 0) {
            return false;
        }
        int j3 = this.a.j();
        int n = this.a.n();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= j3 || (i6 = i3 + i8) >= n || !this.a.f(i6, i9)) {
                break;
            }
            j2[2] = j2[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= j3 || (i5 = i3 + i8) >= n || this.a.f(i5, i10)) {
                break;
            }
            j2[3] = j2[3] + 1;
            i8++;
        }
        if (j2[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= j3 || (i4 = i3 + i8) >= n || !this.a.f(i4, i11)) {
                break;
            }
            j2[4] = j2[4] + 1;
            i8++;
        }
        if (j2[4] == 0) {
            return false;
        }
        return i(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r3 < 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r0.f(r3, r12) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r2[0] > r13) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        if (r2[0] <= r13) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
        if (r0.f(r11, r12) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
        if (r11 != r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        if (r0.f(r11, r12) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
        if (r2[3] >= r13) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
        if (r11 == r1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r2[3] < r13) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
        if (r11 >= r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        if (r0.f(r11, r12) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r2[4] >= r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
        if (r2[4] < r13) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b9, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00be, code lost:
        if (h(r2) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c4, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float d(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.d(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r3 < 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r0.f(r12, r3) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r2[0] > r13) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        if (r2[0] <= r13) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
        if (r0.f(r12, r11) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
        if (r11 != r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        if (r0.f(r12, r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
        if (r2[3] >= r13) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
        if (r11 == r1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r2[3] < r13) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
        if (r11 >= r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        if (r0.f(r12, r11) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r2[4] >= r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
        if (r2[4] < r13) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b9, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bb, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c0, code lost:
        if (h(r2) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float e(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.e(int, int, int, int):float");
    }

    private int g() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f3289c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    public static boolean h(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public static boolean i(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] j() {
        b(this.f3290d);
        return this.f3290d;
    }

    private boolean o() {
        int size = this.b.size();
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        for (d dVar : this.b) {
            if (dVar.h() >= 2) {
                i2++;
                f3 += dVar.i();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / size;
        for (d dVar2 : this.b) {
            f2 += Math.abs(dVar2.i() - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    private d[] p() throws NotFoundException {
        float f2;
        int size = this.b.size();
        if (size >= 3) {
            float f3 = 0.0f;
            if (size > 3) {
                float f4 = 0.0f;
                float f5 = 0.0f;
                for (d dVar : this.b) {
                    float i2 = dVar.i();
                    f4 += i2;
                    f5 += i2 * i2;
                }
                float f6 = f4 / size;
                float sqrt = (float) Math.sqrt((f5 / f2) - (f6 * f6));
                Collections.sort(this.b, new FurthestFromAverageComparator(f6));
                float max = Math.max(0.2f * f6, sqrt);
                int i3 = 0;
                while (i3 < this.b.size() && this.b.size() > 3) {
                    if (Math.abs(this.b.get(i3).i() - f6) > max) {
                        this.b.remove(i3);
                        i3--;
                    }
                    i3++;
                }
            }
            if (this.b.size() > 3) {
                for (d dVar2 : this.b) {
                    f3 += dVar2.i();
                }
                Collections.sort(this.b, new CenterComparator(f3 / this.b.size()));
                List<d> list = this.b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{this.b.get(0), this.b.get(1), this.b.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void b(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    public final e f(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int j2 = this.a.j();
        int n = this.a.n();
        int i2 = ((j2 * 3) / 388 < 3 || z) ? 3 : 3;
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z2 = false;
        while (i3 < j2 && !z2) {
            b(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < n) {
                if (this.a.f(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 == 4) {
                    if (h(iArr)) {
                        if (m(iArr, i3, i4)) {
                            if (this.f3289c) {
                                z2 = o();
                            } else {
                                int g2 = g();
                                if (g2 > iArr[2]) {
                                    i3 += (g2 - iArr[2]) - 2;
                                    i4 = n - 1;
                                }
                            }
                            b(iArr);
                            i2 = 2;
                            i5 = 0;
                        } else {
                            q(iArr);
                        }
                    } else {
                        q(iArr);
                    }
                    i5 = 3;
                } else {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                }
                i4++;
            }
            if (h(iArr) && m(iArr, i3, n)) {
                i2 = iArr[0];
                if (this.f3289c) {
                    z2 = o();
                }
            }
            i3 += i2;
        }
        d[] p = p();
        l.e(p);
        return new e(p);
    }

    public final b k() {
        return this.a;
    }

    public final List<d> l() {
        return this.b;
    }

    public final boolean m(int[] iArr, int i2, int i3) {
        boolean z = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i3);
        float e2 = e(i2, a2, iArr[2], i4);
        if (!Float.isNaN(e2)) {
            int i5 = (int) e2;
            float d2 = d(a2, i5, iArr[2], i4);
            if (!Float.isNaN(d2) && c(i5, (int) d2)) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.b.size()) {
                        break;
                    }
                    d dVar = this.b.get(i6);
                    if (dVar.f(f2, e2, d2)) {
                        this.b.set(i6, dVar.g(e2, d2, f2));
                        z = true;
                        break;
                    }
                    i6++;
                }
                if (!z) {
                    d dVar2 = new d(d2, e2, f2);
                    this.b.add(dVar2);
                    m mVar = this.f3291e;
                    if (mVar != null) {
                        mVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final boolean n(int[] iArr, int i2, int i3, boolean z) {
        return m(iArr, i2, i3);
    }

    public final void q(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public FinderPatternFinder(b bVar, m mVar) {
        this.a = bVar;
        this.b = new ArrayList();
        this.f3290d = new int[5];
        this.f3291e = mVar;
    }
}
