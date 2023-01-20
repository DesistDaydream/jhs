package e.j.f.p.a;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes2.dex */
public final class s extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public r k(e.j.f.k kVar) {
        BarcodeFormat b = kVar.b();
        if (b == BarcodeFormat.UPC_A || b == BarcodeFormat.UPC_E || b == BarcodeFormat.EAN_8 || b == BarcodeFormat.EAN_13) {
            String c2 = t.c(kVar);
            if (t.d(c2, c2.length())) {
                return new r(c2, (b == BarcodeFormat.UPC_E && c2.length() == 8) ? e.j.f.u.z.s(c2) : c2);
            }
            return null;
        }
        return null;
    }
}
