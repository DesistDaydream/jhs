package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
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
public final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* renamed from: i  reason: collision with root package name */
    private static final e[] f3259i = new e[0];

    /* renamed from: j  reason: collision with root package name */
    private static final float f3260j = 180.0f;

    /* renamed from: k  reason: collision with root package name */
    private static final float f3261k = 9.0f;

    /* renamed from: l  reason: collision with root package name */
    private static final float f3262l = 0.05f;

    /* renamed from: m  reason: collision with root package name */
    private static final float f3263m = 0.5f;

    /* loaded from: classes2.dex */
    public static final class ModuleSizeComparator implements Serializable, Comparator<d> {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            double i2 = dVar2.i() - dVar.i();
            if (i2 < 0.0d) {
                return -1;
            }
            return i2 > 0.0d ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(b bVar) {
        super(bVar);
    }

    private d[][] s() throws NotFoundException {
        List<d> l2 = l();
        int size = l2.size();
        int i2 = 3;
        if (size >= 3) {
            char c2 = 0;
            if (size == 3) {
                return new d[][]{new d[]{l2.get(0), l2.get(1), l2.get(2)}};
            }
            Collections.sort(l2, new ModuleSizeComparator());
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < size - 2) {
                d dVar = l2.get(i3);
                if (dVar != null) {
                    int i4 = i3 + 1;
                    while (i4 < size - 1) {
                        d dVar2 = l2.get(i4);
                        if (dVar2 != null) {
                            float i5 = (dVar.i() - dVar2.i()) / Math.min(dVar.i(), dVar2.i());
                            float abs = Math.abs(dVar.i() - dVar2.i());
                            float f2 = f3262l;
                            float f3 = 0.5f;
                            if (abs <= 0.5f || i5 < f3262l) {
                                int i6 = i4 + 1;
                                while (i6 < size) {
                                    d dVar3 = l2.get(i6);
                                    if (dVar3 != null) {
                                        float i7 = (dVar2.i() - dVar3.i()) / Math.min(dVar2.i(), dVar3.i());
                                        if (Math.abs(dVar2.i() - dVar3.i()) <= f3 || i7 < f2) {
                                            d[] dVarArr = new d[i2];
                                            dVarArr[c2] = dVar;
                                            dVarArr[1] = dVar2;
                                            dVarArr[2] = dVar3;
                                            l.e(dVarArr);
                                            e eVar = new e(dVarArr);
                                            float b = l.b(eVar.b(), eVar.a());
                                            float b2 = l.b(eVar.c(), eVar.a());
                                            float b3 = l.b(eVar.b(), eVar.c());
                                            float i8 = (b + b3) / (dVar.i() * 2.0f);
                                            if (i8 <= 180.0f && i8 >= 9.0f && Math.abs((b - b3) / Math.min(b, b3)) < 0.1f) {
                                                float sqrt = (float) Math.sqrt((b * b) + (b3 * b3));
                                                if (Math.abs((b2 - sqrt) / Math.min(b2, sqrt)) < 0.1f) {
                                                    arrayList.add(dVarArr);
                                                }
                                            }
                                        }
                                    }
                                    i6++;
                                    i2 = 3;
                                    c2 = 0;
                                    f2 = f3262l;
                                    f3 = 0.5f;
                                }
                            }
                        }
                        i4++;
                        i2 = 3;
                        c2 = 0;
                    }
                }
                i3++;
                i2 = 3;
                c2 = 0;
            }
            if (!arrayList.isEmpty()) {
                return (d[][]) arrayList.toArray(new d[arrayList.size()]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public e[] r(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        b k2 = k();
        int j2 = k2.j();
        int n = k2.n();
        int i2 = ((j2 * 3) / 388 < 3 || z) ? 3 : 3;
        int[] iArr = new int[5];
        for (int i3 = i2 - 1; i3 < j2; i3 += i2) {
            b(iArr);
            int i4 = 0;
            for (int i5 = 0; i5 < n; i5++) {
                if (k2.f(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (FinderPatternFinder.h(iArr) && m(iArr, i3, i5)) {
                        b(iArr);
                        i4 = 0;
                    } else {
                        q(iArr);
                        i4 = 3;
                    }
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
            }
            if (FinderPatternFinder.h(iArr)) {
                m(iArr, i3, n);
            }
        }
        d[][] s = s();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : s) {
            l.e(dVarArr);
            arrayList.add(new e(dVarArr));
        }
        if (arrayList.isEmpty()) {
            return f3259i;
        }
        return (e[]) arrayList.toArray(new e[arrayList.size()]);
    }

    public MultiFinderPatternFinder(b bVar, m mVar) {
        super(bVar, mVar);
    }
}
