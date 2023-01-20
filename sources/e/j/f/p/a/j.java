package e.j.f.p.a;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class j extends a {

    /* renamed from: f */
    private static final Pattern f11432f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean s(String str) {
        return str != null && f11432f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // e.j.f.p.a.t
    /* renamed from: t */
    public h k(e.j.f.k kVar) {
        String[] q;
        String c2 = t.c(kVar);
        if (c2.startsWith("MATMSG:") && (q = a.q("TO:", c2, true)) != null) {
            for (String str : q) {
                if (!s(str)) {
                    return null;
                }
            }
            return new h(q, null, null, a.r("SUB:", c2, false), a.r("BODY:", c2, false));
        }
        return null;
    }
}
