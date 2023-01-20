package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class f extends a {
    @Override // e.j.f.p.a.t
    /* renamed from: s */
    public b0 k(e.j.f.k kVar) {
        String g2 = kVar.g();
        if (g2.startsWith("MEBKM:")) {
            String r = a.r("TITLE:", g2, true);
            String[] q = a.q("URL:", g2, true);
            if (q == null) {
                return null;
            }
            String str = q[0];
            if (c0.q(str)) {
                return new b0(str, r);
            }
            return null;
        }
        return null;
    }
}
