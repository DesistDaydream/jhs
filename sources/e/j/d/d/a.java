package e.j.d.d;

import java.util.Set;

/* loaded from: classes2.dex */
public abstract class a implements f {
    @Override // e.j.d.d.f
    public <T> T a(Class<T> cls) {
        e.j.d.g.a<T> d2 = d(cls);
        if (d2 == null) {
            return null;
        }
        return d2.get();
    }

    @Override // e.j.d.d.f
    public <T> Set<T> c(Class<T> cls) {
        return b(cls).get();
    }
}
