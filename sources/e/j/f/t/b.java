package e.j.f.t;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements c {
    private static final int b = 100;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11562c = 4;
    private final j a;

    public b(j jVar) {
        this.a = jVar;
    }

    private void a(e.j.f.b bVar, Map<DecodeHintType, ?> map, List<k> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        float f3;
        int i5;
        int i6;
        if (i4 > 4) {
            return;
        }
        try {
            k a = this.a.a(bVar, map);
            Iterator<k> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g().equals(a.g())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(c(a, i2, i3));
            }
            l[] f4 = a.f();
            if (f4 == null || f4.length == 0) {
                return;
            }
            int e2 = bVar.e();
            int d2 = bVar.d();
            float f5 = e2;
            float f6 = d2;
            float f7 = 0.0f;
            float f8 = 0.0f;
            for (l lVar : f4) {
                if (lVar != null) {
                    float c2 = lVar.c();
                    float d3 = lVar.d();
                    if (c2 < f5) {
                        f5 = c2;
                    }
                    if (d3 < f6) {
                        f6 = d3;
                    }
                    if (c2 > f7) {
                        f7 = c2;
                    }
                    if (d3 > f8) {
                        f8 = d3;
                    }
                }
            }
            if (f5 > 100.0f) {
                f2 = f7;
                f3 = f6;
                i5 = d2;
                i6 = e2;
                a(bVar.a(0, 0, (int) f5, d2), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f7;
                f3 = f6;
                i5 = d2;
                i6 = e2;
            }
            if (f3 > 100.0f) {
                a(bVar.a(0, 0, i6, (int) f3), map, list, i2, i3, i4 + 1);
            }
            float f9 = f2;
            if (f9 < i6 - 100) {
                int i7 = (int) f9;
                a(bVar.a(i7, 0, i6 - i7, i5), map, list, i2 + i7, i3, i4 + 1);
            }
            if (f8 < i5 - 100) {
                int i8 = (int) f8;
                a(bVar.a(0, i8, i6, i5 - i8), map, list, i2, i3 + i8, i4 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static k c(k kVar, int i2, int i3) {
        l[] f2 = kVar.f();
        if (f2 == null) {
            return kVar;
        }
        l[] lVarArr = new l[f2.length];
        for (int i4 = 0; i4 < f2.length; i4++) {
            l lVar = f2[i4];
            if (lVar != null) {
                lVarArr[i4] = new l(lVar.c() + i2, lVar.d() + i3);
            }
        }
        k kVar2 = new k(kVar.g(), kVar.d(), kVar.c(), lVarArr, kVar.b(), kVar.h());
        kVar2.i(kVar.e());
        return kVar2;
    }

    @Override // e.j.f.t.c
    public k[] b(e.j.f.b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // e.j.f.t.c
    public k[] d(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(bVar, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (k[]) arrayList.toArray(new k[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
