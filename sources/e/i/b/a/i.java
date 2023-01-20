package e.i.b.a;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class i implements h {
    @Override // e.i.b.a.h
    public Set<String> a() {
        if (c() != null) {
            return c().keySet();
        }
        return null;
    }

    @Override // e.i.b.a.h
    public String[] b(String str) {
        if (c() != null) {
            return c().get(str);
        }
        return null;
    }

    public abstract Map<String, String[]> c();
}
