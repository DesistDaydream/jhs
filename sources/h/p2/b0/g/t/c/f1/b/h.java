package h.p2.b0.g.t.c.f1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class h extends u implements h.p2.b0.g.t.e.a.x.f {
    @k.e.a.d
    private final Type b;
    @k.e.a.d

    /* renamed from: c */
    private final u f15195c;
    @k.e.a.d

    /* renamed from: d */
    private final Collection<h.p2.b0.g.t.e.a.x.a> f15196d;

    /* renamed from: e */
    private final boolean f15197e;

    public h(@k.e.a.d Type type) {
        u a;
        this.b = type;
        Type R = R();
        if (!(R instanceof GenericArrayType)) {
            if (R instanceof Class) {
                Class cls = (Class) R;
                a = cls.isArray() ? u.a.a(cls.getComponentType()) : a;
            }
            throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
        }
        u.a.a(((GenericArrayType) R).getGenericComponentType());
        this.f15195c = a;
        this.f15196d = CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return this.f15197e;
    }

    @Override // h.p2.b0.g.t.c.f1.b.u
    @k.e.a.d
    public Type R() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.e.a.x.f
    @k.e.a.d
    /* renamed from: S */
    public u l() {
        return this.f15195c;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.e.a.x.a> getAnnotations() {
        return this.f15196d;
    }
}
