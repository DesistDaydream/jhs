package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class z extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public y k(e.j.f.k kVar) {
        String str;
        String c2 = t.c(kVar);
        if (c2.startsWith("tel:") || c2.startsWith("TEL:")) {
            if (c2.startsWith("TEL:")) {
                str = "tel:" + c2.substring(4);
            } else {
                str = c2;
            }
            int indexOf = c2.indexOf(63, 4);
            return new y(indexOf < 0 ? c2.substring(4) : c2.substring(4, indexOf), str, null);
        }
        return null;
    }
}
