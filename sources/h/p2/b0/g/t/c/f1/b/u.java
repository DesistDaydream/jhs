package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.e.a.x.x;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: classes3.dex */
public abstract class u implements h.p2.b0.g.t.e.a.x.x {
    @k.e.a.d
    public static final a a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final u a(@k.e.a.d Type type) {
            u hVar;
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new t(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z || !((Class) type).isArray())) {
                hVar = type instanceof WildcardType ? new x((WildcardType) type) : new j(type);
            } else {
                hVar = new h(type);
            }
            return hVar;
        }
    }

    @k.e.a.d
    public abstract Type R();

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.e
    public h.p2.b0.g.t.e.a.x.a c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return x.a.a(this, cVar);
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof u) && f0.g(R(), ((u) obj).R());
    }

    public int hashCode() {
        return R().hashCode();
    }

    @k.e.a.d
    public String toString() {
        return getClass().getName() + ": " + R();
    }
}
