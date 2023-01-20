package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class d0 extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public b0 k(e.j.f.k kVar) {
        int indexOf;
        String c2 = t.c(kVar);
        if ((c2.startsWith("urlto:") || c2.startsWith("URLTO:")) && (indexOf = c2.indexOf(58, 6)) >= 0) {
            return new b0(c2.substring(indexOf + 1), indexOf > 6 ? c2.substring(6, indexOf) : null);
        }
        return null;
    }
}
