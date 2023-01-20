package e.j.f;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import e.j.f.u.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f implements j {
    private Map<DecodeHintType, ?> a;
    private j[] b;

    private k b(b bVar) throws NotFoundException {
        j[] jVarArr = this.b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                try {
                    return jVar.a(bVar, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public k a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return b(bVar);
    }

    @Override // e.j.f.j
    public k c(b bVar) throws NotFoundException {
        e(null);
        return b(bVar);
    }

    public k d(b bVar) throws NotFoundException {
        if (this.b == null) {
            e(null);
        }
        return b(bVar);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new e.j.f.w.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new e.j.f.r.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new e.j.f.o.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new e.j.f.v.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new e.j.f.s.a());
            }
            if (z && z2) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new o(map));
            }
            arrayList.add(new e.j.f.w.a());
            arrayList.add(new e.j.f.r.a());
            arrayList.add(new e.j.f.o.b());
            arrayList.add(new e.j.f.v.b());
            arrayList.add(new e.j.f.s.a());
            if (z2) {
                arrayList.add(new o(map));
            }
        }
        this.b = (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // e.j.f.j
    public void reset() {
        j[] jVarArr = this.b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.reset();
            }
        }
    }
}
