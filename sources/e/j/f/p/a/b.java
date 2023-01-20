package e.j.f.p.a;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b extends t {
    private static String[] q(String str, int i2, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i3 = 1; i3 <= i2; i3++) {
            String g2 = t.g(str + i3 + ':', str2, '\r', z);
            if (g2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i2);
            }
            arrayList.add(g2);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // e.j.f.p.a.t
    /* renamed from: r */
    public d k(e.j.f.k kVar) {
        String c2 = t.c(kVar);
        if (c2.contains("MEMORY") && c2.contains("\r\n")) {
            String g2 = t.g("NAME1:", c2, '\r', true);
            String g3 = t.g("NAME2:", c2, '\r', true);
            String[] q = q("TEL", 3, c2, true);
            String[] q2 = q("MAIL", 3, c2, true);
            String g4 = t.g("MEMORY:", c2, '\r', false);
            String g5 = t.g("ADD:", c2, '\r', true);
            return new d(t.j(g2), null, g3, q, null, q2, null, null, g4, g5 != null ? new String[]{g5} : null, null, null, null, null, null, null);
        }
        return null;
    }
}
