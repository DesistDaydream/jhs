package h.p2.b0.g.t.c.f1.b;

import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public final class n extends p implements h.p2.b0.g.t.e.a.x.n {
    @k.e.a.d
    private final Field a;

    public n(@k.e.a.d Field field) {
        this.a = field;
    }

    @Override // h.p2.b0.g.t.e.a.x.n
    public boolean J() {
        return U().isEnumConstant();
    }

    @Override // h.p2.b0.g.t.e.a.x.n
    public boolean O() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.f1.b.p
    @k.e.a.d
    /* renamed from: W */
    public Field U() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.n
    @k.e.a.d
    public u getType() {
        return u.a.a(U().getGenericType());
    }
}
