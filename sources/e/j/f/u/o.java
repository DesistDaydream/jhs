package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o extends q {
    private final q[] a;

    public o(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new d(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new e.j.f.u.b0.e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new e.j.f.u.b0.g.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new d());
            arrayList.add(new a());
            arrayList.add(new f());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new e.j.f.u.b0.e());
            arrayList.add(new e.j.f.u.b0.g.d());
        }
        this.a = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (q qVar : this.a) {
            try {
                return qVar.b(i2, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.q, e.j.f.j
    public void reset() {
        for (q qVar : this.a) {
            qVar.reset();
        }
    }
}
