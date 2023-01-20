package e.j.f.u.b0;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import e.j.f.k;
import e.j.f.l;
import e.j.f.m;
import e.j.f.u.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f11585m = {1, 10, 34, 70, 126};
    private static final int[] n = {4, 20, 48, 81};
    private static final int[] o = {0, 161, 961, 2015, 2715};
    private static final int[] p = {0, 336, 1036, 1516};
    private static final int[] q = {8, 6, 4, 3, 1};
    private static final int[] r = {2, 4, 6, 8};
    private static final int[][] s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: k  reason: collision with root package name */
    private final List<d> f11586k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private final List<d> f11587l = new ArrayList();

    private static void s(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r1 < 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
        if (r1 < 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.b0.e.t(boolean, int):void");
    }

    private static boolean u(d dVar, d dVar2) {
        int a = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c2 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c2 > 72) {
            c2--;
        }
        if (c2 > 8) {
            c2--;
        }
        return a == c2;
    }

    private static k v(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        l[] a = dVar.d().a();
        l[] a2 = dVar2.d().a();
        return new k(sb.toString(), null, new l[]{a[0], a[1], a2[0], a2[1]}, BarcodeFormat.RSS_14);
    }

    private b w(e.j.f.q.a aVar, c cVar, boolean z) throws NotFoundException {
        int[] j2 = j();
        for (int i2 = 0; i2 < j2.length; i2++) {
            j2[i2] = 0;
        }
        if (z) {
            q.g(aVar, cVar.b()[0], j2);
        } else {
            q.f(aVar, cVar.b()[1] + 1, j2);
            int i3 = 0;
            for (int length = j2.length - 1; i3 < length; length--) {
                int i4 = j2[i3];
                j2[i3] = j2[length];
                j2[length] = i4;
                i3++;
            }
        }
        int i5 = z ? 16 : 15;
        float d2 = e.j.f.q.l.a.d(j2) / i5;
        int[] n2 = n();
        int[] l2 = l();
        float[] o2 = o();
        float[] m2 = m();
        for (int i6 = 0; i6 < j2.length; i6++) {
            float f2 = j2[i6] / d2;
            int i7 = (int) (0.5f + f2);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                n2[i8] = i7;
                o2[i8] = f2 - i7;
            } else {
                l2[i8] = i7;
                m2[i8] = f2 - i7;
            }
        }
        t(z, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = n2.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + n2[length2];
            i10 += n2[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = l2.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + l2[length3];
            i12 += l2[length3];
        }
        int i13 = i9 + (i11 * 3);
        if (!z) {
            if ((i12 & 1) == 0 && i12 <= 10 && i12 >= 4) {
                int i14 = (10 - i12) / 2;
                int i15 = r[i14];
                return new b((f.b(l2, 9 - i15, false) * n[i14]) + f.b(n2, i15, true) + p[i14], i13);
            }
            throw NotFoundException.getNotFoundInstance();
        } else if ((i10 & 1) == 0 && i10 <= 12 && i10 >= 4) {
            int i16 = (12 - i10) / 2;
            int i17 = q[i16];
            return new b((f.b(n2, i17, false) * f11585m[i16]) + f.b(l2, 9 - i17, true) + o[i16], i13);
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private d x(e.j.f.q.a aVar, boolean z, int i2, Map<DecodeHintType, ?> map) {
        try {
            int[] y = y(aVar, z);
            c z2 = z(aVar, i2, z, y);
            m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (mVar != null) {
                float f2 = (y[0] + y[1]) / 2.0f;
                if (z) {
                    f2 = (aVar.n() - 1) - f2;
                }
                mVar.a(new l(f2, i2));
            }
            b w = w(aVar, z2, true);
            b w2 = w(aVar, z2, false);
            return new d((w.b() * 1597) + w2.b(), w.a() + (w2.a() * 4), z2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] y(e.j.f.q.a aVar, boolean z) throws NotFoundException {
        int[] k2 = k();
        k2[0] = 0;
        k2[1] = 0;
        k2[2] = 0;
        k2[3] = 0;
        int n2 = aVar.n();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < n2) {
            z2 = !aVar.j(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < n2) {
            if (aVar.j(i2) != z2) {
                k2[i4] = k2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (a.q(k2)) {
                    return new int[]{i3, i2};
                } else {
                    i3 += k2[0] + k2[1];
                    k2[0] = k2[2];
                    k2[1] = k2[3];
                    k2[2] = 0;
                    k2[3] = 0;
                    i4--;
                }
                k2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private c z(e.j.f.q.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean j2 = aVar.j(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && j2 != aVar.j(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] k2 = k();
        System.arraycopy(k2, 0, k2, 1, k2.length - 1);
        k2[0] = iArr[0] - i6;
        int r2 = a.r(k2, s);
        int i7 = iArr[1];
        if (z) {
            i3 = (aVar.n() - 1) - i7;
            i4 = (aVar.n() - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(r2, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    @Override // e.j.f.u.q
    public k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        s(this.f11586k, x(aVar, false, i2, map));
        aVar.r();
        s(this.f11587l, x(aVar, true, i2, map));
        aVar.r();
        for (d dVar : this.f11586k) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f11587l) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.q, e.j.f.j
    public void reset() {
        this.f11586k.clear();
        this.f11587l.clear();
    }
}
