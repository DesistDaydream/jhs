package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class x extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public h k(e.j.f.k kVar) {
        String str;
        String str2;
        String c2 = t.c(kVar);
        if (c2.startsWith("smtp:") || c2.startsWith("SMTP:")) {
            String substring = c2.substring(5);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                String substring2 = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
                int indexOf2 = substring2.indexOf(58);
                if (indexOf2 >= 0) {
                    String substring3 = substring2.substring(indexOf2 + 1);
                    str = substring2.substring(0, indexOf2);
                    str2 = substring3;
                } else {
                    str2 = null;
                    str = substring2;
                }
            } else {
                str = null;
                str2 = null;
            }
            return new h(new String[]{substring}, null, null, str, str2);
        }
        return null;
    }
}
