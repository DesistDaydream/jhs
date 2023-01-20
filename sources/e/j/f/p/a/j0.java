package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class j0 extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public i0 k(e.j.f.k kVar) {
        String substring;
        String g2;
        String c2 = t.c(kVar);
        if (!c2.startsWith("WIFI:") || (g2 = t.g("S:", (substring = c2.substring(5)), ';', false)) == null || g2.isEmpty()) {
            return null;
        }
        String g3 = t.g("P:", substring, ';', false);
        String g4 = t.g("T:", substring, ';', false);
        if (g4 == null) {
            g4 = "nopass";
        }
        return new i0(g4, g2, g3, Boolean.parseBoolean(t.g("H:", substring, ';', false)), t.g("I:", substring, ';', false), t.g("A:", substring, ';', false), t.g("E:", substring, ';', false), t.g("H:", substring, ';', false));
    }
}
