package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p extends q {
    private final x[] a;

    public p(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z;
        int[] p = x.p(aVar);
        for (x xVar : this.a) {
            try {
                e.j.f.k m2 = xVar.m(i2, aVar, p, map);
                boolean z2 = m2.b() == BarcodeFormat.EAN_13 && m2.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                    z = false;
                    if (z2 || !z) {
                        return m2;
                    }
                    e.j.f.k kVar = new e.j.f.k(m2.g().substring(1), m2.d(), m2.f(), BarcodeFormat.UPC_A);
                    kVar.i(m2.e());
                    return kVar;
                }
                z = true;
                if (z2) {
                }
                return m2;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.q, e.j.f.j
    public void reset() {
        for (x xVar : this.a) {
            xVar.reset();
        }
    }
}
