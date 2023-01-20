package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class c extends a {
    private static String t(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        return str;
    }

    @Override // e.j.f.p.a.t
    /* renamed from: s */
    public d k(e.j.f.k kVar) {
        String[] q;
        String c2 = t.c(kVar);
        if (c2.startsWith("MECARD:") && (q = a.q("N:", c2, true)) != null) {
            String t = t(q[0]);
            String r = a.r("SOUND:", c2, true);
            String[] q2 = a.q("TEL:", c2, true);
            String[] q3 = a.q("EMAIL:", c2, true);
            String r2 = a.r("NOTE:", c2, false);
            String[] q4 = a.q("ADR:", c2, true);
            String r3 = a.r("BDAY:", c2, true);
            return new d(t.j(t), null, r, q2, null, q3, null, null, r2, q4, null, a.r("ORG:", c2, true), !t.d(r3, 8) ? null : r3, null, a.q("URL:", c2, true), null);
        }
        return null;
    }
}
