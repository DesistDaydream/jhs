package e.j.f.p.a;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class e extends a {
    private static String s(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    private static String[] t(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    @Override // e.j.f.p.a.t
    /* renamed from: u */
    public d k(e.j.f.k kVar) {
        String c2 = t.c(kVar);
        if (c2.startsWith("BIZCARD:")) {
            String s = s(a.r("N:", c2, true), a.r("X:", c2, true));
            String r = a.r("T:", c2, true);
            String r2 = a.r("C:", c2, true);
            return new d(t.j(s), null, null, t(a.r("B:", c2, true), a.r("M:", c2, true), a.r("F:", c2, true)), null, t.j(a.r("E:", c2, true)), null, null, null, a.q("A:", c2, true), null, r2, null, r, null, null);
        }
        return null;
    }
}
