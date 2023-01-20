package e.j.f.p.a;

/* loaded from: classes2.dex */
public final class w extends t {
    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public v k(e.j.f.k kVar) {
        String str;
        String c2 = t.c(kVar);
        if (c2.startsWith("smsto:") || c2.startsWith("SMSTO:") || c2.startsWith("mmsto:") || c2.startsWith("MMSTO:")) {
            String substring = c2.substring(6);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str = null;
            }
            return new v(substring, (String) null, (String) null, str);
        }
        return null;
    }
}
