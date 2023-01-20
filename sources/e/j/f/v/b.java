package e.j.f.v;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import e.j.f.v.e.i;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements j, e.j.f.t.c {
    private static k[] e(e.j.f.b bVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        e.j.f.v.f.b b = e.j.f.v.f.a.b(bVar, map, z);
        for (l[] lVarArr : b.b()) {
            e.j.f.q.d i2 = i.i(b.a(), lVarArr[4], lVarArr[5], lVarArr[6], lVarArr[7], h(lVarArr), f(lVarArr));
            k kVar = new k(i2.j(), i2.g(), lVarArr, BarcodeFormat.PDF_417);
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, i2.b());
            c cVar = (c) i2.f();
            if (cVar != null) {
                kVar.j(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    private static int f(l[] lVarArr) {
        return Math.max(Math.max(g(lVarArr[0], lVarArr[4]), (g(lVarArr[6], lVarArr[2]) * 17) / 18), Math.max(g(lVarArr[1], lVarArr[5]), (g(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    private static int g(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return 0;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    private static int h(l[] lVarArr) {
        return Math.min(Math.min(i(lVarArr[0], lVarArr[4]), (i(lVarArr[6], lVarArr[2]) * 17) / 18), Math.min(i(lVarArr[1], lVarArr[5]), (i(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    private static int i(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    @Override // e.j.f.j
    public k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        k[] e2 = e(bVar, map, false);
        if (e2 != null && e2.length != 0 && e2[0] != null) {
            return e2[0];
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.t.c
    public k[] b(e.j.f.b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // e.j.f.j
    public k c(e.j.f.b bVar) throws NotFoundException, FormatException, ChecksumException {
        return a(bVar, null);
    }

    @Override // e.j.f.t.c
    public k[] d(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return e(bVar, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // e.j.f.j
    public void reset() {
    }
}
