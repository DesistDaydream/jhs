package e.j.f.u.b0.g;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import e.j.f.k;
import e.j.f.l;
import e.j.f.u.b0.f;
import e.j.f.u.b0.g.e.j;
import e.j.f.u.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends e.j.f.u.b0.a {
    private static final int A = 11;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;

    /* renamed from: k  reason: collision with root package name */
    private final List<b> f11591k = new ArrayList(11);

    /* renamed from: l  reason: collision with root package name */
    private final List<c> f11592l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private final int[] f11593m = new int[2];
    private boolean n;
    private static final int[] o = {7, 5, 4, 3, 1};
    private static final int[] p = {4, 20, 52, 104, AdEventType.VIDEO_PAUSE};
    private static final int[] q = {0, 348, 1388, 2948, 3988};
    private static final int[][] r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, CameraInterface.TYPE_CAPTURE, 13, 39, 117, 140, AdEventType.VIDEO_INIT, AdEventType.VIDEO_STOP}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, AdEventType.VIDEO_RESUME, 187, 139, AdEventType.VIDEO_COMPLETE, 196, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, CameraInterface.TYPE_RECORDER, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, AdEventType.VIDEO_READY, AdEventType.VIDEO_CLICKED, AdEventType.VIDEO_START, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, AdEventType.VIDEO_PAUSE, 190}, new int[]{e.j.f.u.d.f11631g, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, AdEventType.VIDEO_ERROR, 199, HideBottomViewOnScrollBehavior.f2749f}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private static int A(e.j.f.q.a aVar, int i2) {
        if (aVar.j(i2)) {
            return aVar.l(aVar.m(i2));
        }
        return aVar.m(aVar.l(i2));
    }

    private static boolean C(e.j.f.u.b0.c cVar, boolean z2, boolean z3) {
        return (cVar.c() == 0 && z2 && z3) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean D(java.lang.Iterable<e.j.f.u.b0.g.b> r7, java.lang.Iterable<e.j.f.u.b0.g.c> r8) {
        /*
            java.util.Iterator r8 = r8.iterator()
        L4:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto L46
            java.lang.Object r0 = r8.next()
            e.j.f.u.b0.g.c r0 = (e.j.f.u.b0.g.c) r0
            java.util.Iterator r2 = r7.iterator()
        L15:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L42
            java.lang.Object r3 = r2.next()
            e.j.f.u.b0.g.b r3 = (e.j.f.u.b0.g.b) r3
            java.util.List r5 = r0.a()
            java.util.Iterator r5 = r5.iterator()
        L2a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L3e
            java.lang.Object r6 = r5.next()
            e.j.f.u.b0.g.b r6 = (e.j.f.u.b0.g.b) r6
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L2a
            r3 = 1
            goto L3f
        L3e:
            r3 = 0
        L3f:
            if (r3 != 0) goto L15
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 == 0) goto L4
            return r4
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.b0.g.d.D(java.lang.Iterable, java.lang.Iterable):boolean");
    }

    private static boolean E(List<b> list) {
        int[][] iArr;
        boolean z2;
        for (int[] iArr2 : z) {
            if (list.size() <= iArr2.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z2 = true;
                        break;
                    } else if (list.get(i2).b().c() != iArr2[i2]) {
                        z2 = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private e.j.f.u.b0.c F(e.j.f.q.a aVar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        if (z2) {
            int i6 = this.f11593m[0] - 1;
            while (i6 >= 0 && !aVar.j(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f11593m;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.f11593m;
            int i8 = iArr2[0];
            int m2 = aVar.m(iArr2[1] + 1);
            i3 = m2;
            i4 = i8;
            i5 = m2 - this.f11593m[1];
        }
        int[] k2 = k();
        System.arraycopy(k2, 0, k2, 1, k2.length - 1);
        k2[0] = i5;
        try {
            return new e.j.f.u.b0.c(e.j.f.u.b0.a.r(k2, r), new int[]{i4, i3}, i4, i3, i2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void G(java.util.List<e.j.f.u.b0.g.b> r6, java.util.List<e.j.f.u.b0.g.c> r7) {
        /*
            java.util.Iterator r7 = r7.iterator()
        L4:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L56
            java.lang.Object r0 = r7.next()
            e.j.f.u.b0.g.c r0 = (e.j.f.u.b0.g.c) r0
            java.util.List r1 = r0.a()
            int r1 = r1.size()
            int r2 = r6.size()
            if (r1 == r2) goto L4
            java.util.List r0 = r0.a()
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r0.next()
            e.j.f.u.b0.g.b r1 = (e.j.f.u.b0.g.b) r1
            java.util.Iterator r4 = r6.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4b
            java.lang.Object r5 = r4.next()
            e.j.f.u.b0.g.b r5 = (e.j.f.u.b0.g.b) r5
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L38
            goto L4c
        L4b:
            r3 = 0
        L4c:
            if (r3 != 0) goto L26
            goto L50
        L4f:
            r2 = 1
        L50:
            if (r2 == 0) goto L4
            r7.remove()
            goto L4
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.b0.g.d.G(java.util.List, java.util.List):void");
    }

    private static void I(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void J(int i2, boolean z2) {
        boolean z3 = false;
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 >= this.f11592l.size()) {
                break;
            }
            c cVar = this.f11592l.get(i3);
            if (cVar.b() > i2) {
                z3 = cVar.c(this.f11591k);
                break;
            } else {
                z4 = cVar.c(this.f11591k);
                i3++;
            }
        }
        if (z3 || z4 || D(this.f11591k, this.f11592l)) {
            return;
        }
        this.f11592l.add(i3, new c(this.f11591k, i2, z2));
        G(this.f11591k, this.f11592l);
    }

    private void s(int i2) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int d2 = e.j.f.q.l.a.d(n());
        int d3 = e.j.f.q.l.a.d(l());
        boolean z6 = true;
        if (d2 > 13) {
            z2 = false;
            z3 = true;
        } else {
            z2 = d2 < 4;
            z3 = false;
        }
        if (d3 > 13) {
            z4 = false;
            z5 = true;
        } else {
            z4 = d3 < 4;
            z5 = false;
        }
        int i3 = (d2 + d3) - i2;
        boolean z7 = (d2 & 1) == 1;
        boolean z8 = (d3 & 1) == 0;
        if (i3 == 1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
                z3 = true;
            } else if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z6 = z2;
                z5 = true;
            }
        } else if (i3 == -1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z6 = z2;
                z4 = true;
            }
        } else if (i3 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            if (z7) {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (d2 >= d3) {
                    z6 = z2;
                    z4 = true;
                    z3 = true;
                }
                z5 = true;
            } else if (z8) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z6 = z2;
            }
        }
        if (z6) {
            if (!z3) {
                e.j.f.u.b0.a.p(n(), o());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (z3) {
            e.j.f.u.b0.a.i(n(), o());
        }
        if (z4) {
            if (!z5) {
                e.j.f.u.b0.a.p(l(), o());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (z5) {
            e.j.f.u.b0.a.i(l(), m());
        }
    }

    private boolean t() {
        b bVar = this.f11591k.get(0);
        e.j.f.u.b0.b c2 = bVar.c();
        e.j.f.u.b0.b d2 = bVar.d();
        if (d2 == null) {
            return false;
        }
        int a = d2.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f11591k.size(); i3++) {
            b bVar2 = this.f11591k.get(i3);
            a += bVar2.c().a();
            i2++;
            e.j.f.u.b0.b d3 = bVar2.d();
            if (d3 != null) {
                a += d3.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * AdEventType.VIDEO_LOADING) + (a % AdEventType.VIDEO_LOADING) == c2.b();
    }

    private List<b> u(List<c> list, int i2) throws NotFoundException {
        while (i2 < this.f11592l.size()) {
            c cVar = this.f11592l.get(i2);
            this.f11591k.clear();
            for (c cVar2 : list) {
                this.f11591k.addAll(cVar2.a());
            }
            this.f11591k.addAll(cVar.a());
            if (E(this.f11591k)) {
                if (t()) {
                    return this.f11591k;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<b> v(boolean z2) {
        List<b> list = null;
        if (this.f11592l.size() > 25) {
            this.f11592l.clear();
            return null;
        }
        this.f11591k.clear();
        if (z2) {
            Collections.reverse(this.f11592l);
        }
        try {
            list = u(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z2) {
            Collections.reverse(this.f11592l);
        }
        return list;
    }

    public static k w(List<b> list) throws NotFoundException, FormatException {
        String d2 = j.a(a.a(list)).d();
        l[] a = list.get(0).b().a();
        l[] a2 = list.get(list.size() - 1).b().a();
        return new k(d2, null, new l[]{a[0], a[1], a2[0], a2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void z(e.j.f.q.a aVar, List<b> list, int i2) throws NotFoundException {
        int[] k2 = k();
        k2[0] = 0;
        k2[1] = 0;
        k2[2] = 0;
        k2[3] = 0;
        int n = aVar.n();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z2 = list.size() % 2 != 0;
        if (this.n) {
            z2 = !z2;
        }
        boolean z3 = false;
        while (i2 < n) {
            z3 = !aVar.j(i2);
            if (!z3) {
                break;
            }
            i2++;
        }
        boolean z4 = z3;
        int i3 = 0;
        int i4 = i2;
        while (i2 < n) {
            if (aVar.j(i2) != z4) {
                k2[i3] = k2[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z2) {
                        I(k2);
                    }
                    if (e.j.f.u.b0.a.q(k2)) {
                        int[] iArr = this.f11593m;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z2) {
                        I(k2);
                    }
                    i4 += k2[0] + k2[1];
                    k2[0] = k2[2];
                    k2[1] = k2[3];
                    k2[2] = 0;
                    k2[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                k2[i3] = 1;
                z4 = !z4;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public List<c> B() {
        return this.f11592l;
    }

    public b H(e.j.f.q.a aVar, List<b> list, int i2) throws NotFoundException {
        e.j.f.u.b0.c F;
        e.j.f.u.b0.b bVar;
        boolean z2 = list.size() % 2 == 0;
        if (this.n) {
            z2 = !z2;
        }
        int i3 = -1;
        boolean z3 = true;
        do {
            z(aVar, list, i3);
            F = F(aVar, i2, z2);
            if (F == null) {
                i3 = A(aVar, this.f11593m[0]);
                continue;
            } else {
                z3 = false;
                continue;
            }
        } while (z3);
        e.j.f.u.b0.b x2 = x(aVar, F, z2, true);
        if (!list.isEmpty() && list.get(list.size() - 1).g()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVar = x(aVar, F, z2, false);
        } catch (NotFoundException unused) {
            bVar = null;
        }
        return new b(x2, bVar, F, true);
    }

    @Override // e.j.f.u.q
    public k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f11591k.clear();
        this.n = false;
        try {
            return w(y(i2, aVar));
        } catch (NotFoundException unused) {
            this.f11591k.clear();
            this.n = true;
            return w(y(i2, aVar));
        }
    }

    @Override // e.j.f.u.q, e.j.f.j
    public void reset() {
        this.f11591k.clear();
        this.f11592l.clear();
    }

    public e.j.f.u.b0.b x(e.j.f.q.a aVar, e.j.f.u.b0.c cVar, boolean z2, boolean z3) throws NotFoundException {
        int[] j2 = j();
        for (int i2 = 0; i2 < j2.length; i2++) {
            j2[i2] = 0;
        }
        if (z3) {
            q.g(aVar, cVar.b()[0], j2);
        } else {
            q.f(aVar, cVar.b()[1], j2);
            int i3 = 0;
            for (int length = j2.length - 1; i3 < length; length--) {
                int i4 = j2[i3];
                j2[i3] = j2[length];
                j2[length] = i4;
                i3++;
            }
        }
        float d2 = e.j.f.q.l.a.d(j2) / 17.0f;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d2 - f2) / f2 <= 0.3f) {
            int[] n = n();
            int[] l2 = l();
            float[] o2 = o();
            float[] m2 = m();
            for (int i5 = 0; i5 < j2.length; i5++) {
                float f3 = (j2[i5] * 1.0f) / d2;
                int i6 = (int) (0.5f + f3);
                if (i6 <= 0) {
                    if (f3 < 0.3f) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    i6 = 1;
                } else if (i6 > 8) {
                    if (f3 > 8.7f) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    i6 = 8;
                }
                int i7 = i5 / 2;
                if ((i5 & 1) == 0) {
                    n[i7] = i6;
                    o2[i7] = f3 - i6;
                } else {
                    l2[i7] = i6;
                    m2[i7] = f3 - i6;
                }
            }
            s(17);
            int c2 = (((cVar.c() * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
            int i8 = 0;
            int i9 = 0;
            for (int length2 = n.length - 1; length2 >= 0; length2--) {
                if (C(cVar, z2, z3)) {
                    i8 += n[length2] * s[c2][length2 * 2];
                }
                i9 += n[length2];
            }
            int i10 = 0;
            for (int length3 = l2.length - 1; length3 >= 0; length3--) {
                if (C(cVar, z2, z3)) {
                    i10 += l2[length3] * s[c2][(length3 * 2) + 1];
                }
            }
            int i11 = i8 + i10;
            if ((i9 & 1) == 0 && i9 <= 13 && i9 >= 4) {
                int i12 = (13 - i9) / 2;
                int i13 = o[i12];
                return new e.j.f.u.b0.b((f.b(n, i13, true) * p[i12]) + f.b(l2, 9 - i13, false) + q[i12], i11);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public List<b> y(int i2, e.j.f.q.a aVar) throws NotFoundException {
        boolean z2 = false;
        while (!z2) {
            try {
                List<b> list = this.f11591k;
                list.add(H(aVar, list, i2));
            } catch (NotFoundException e2) {
                if (this.f11591k.isEmpty()) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (t()) {
            return this.f11591k;
        }
        boolean z3 = !this.f11592l.isEmpty();
        J(i2, false);
        if (z3) {
            List<b> v2 = v(false);
            if (v2 != null) {
                return v2;
            }
            List<b> v3 = v(true);
            if (v3 != null) {
                return v3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
