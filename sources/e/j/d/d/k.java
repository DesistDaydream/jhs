package e.j.d.d;

import java.util.Set;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements e.j.d.g.a {
    private final Set a;

    private k(Set set) {
        this.a = set;
    }

    public static e.j.d.g.a a(Set set) {
        return new k(set);
    }

    @Override // e.j.d.g.a
    public Object get() {
        return m.g(this.a);
    }
}
