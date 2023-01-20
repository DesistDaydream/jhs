package e.j.f.p.a;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes2.dex */
public final class p extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public o k(e.j.f.k kVar) {
        if (kVar.b() != BarcodeFormat.EAN_13) {
            return null;
        }
        String c2 = t.c(kVar);
        if (c2.length() != 13) {
            return null;
        }
        if (c2.startsWith("978") || c2.startsWith("979")) {
            return new o(c2);
        }
        return null;
    }
}
