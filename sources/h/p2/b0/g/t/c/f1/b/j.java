package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.c.f1.b.u;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes3.dex */
public final class j extends u implements h.p2.b0.g.t.e.a.x.j {
    @k.e.a.d
    private final Type b;
    @k.e.a.d

    /* renamed from: c */
    private final h.p2.b0.g.t.e.a.x.i f15199c;

    public j(@k.e.a.d Type type) {
        h.p2.b0.g.t.e.a.x.i reflectJavaClass;
        this.b = type;
        Type R = R();
        if (R instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) R);
        } else if (R instanceof TypeVariable) {
            reflectJavaClass = new v((TypeVariable) R);
        } else if (!(R instanceof ParameterizedType)) {
            throw new IllegalStateException("Not a classifier type (" + R.getClass() + "): " + R);
        } else {
            Type rawType = ((ParameterizedType) R).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.f15199c = reflectJavaClass;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.j
    @k.e.a.d
    public String E() {
        return R().toString();
    }

    @Override // h.p2.b0.g.t.e.a.x.j
    @k.e.a.d
    public String H() {
        throw new UnsupportedOperationException(f0.C("Type not found: ", R()));
    }

    @Override // h.p2.b0.g.t.c.f1.b.u
    @k.e.a.d
    public Type R() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.e.a.x.j
    @k.e.a.d
    public h.p2.b0.g.t.e.a.x.i a() {
        return this.f15199c;
    }

    @Override // h.p2.b0.g.t.c.f1.b.u, h.p2.b0.g.t.e.a.x.d
    @k.e.a.e
    public h.p2.b0.g.t.e.a.x.a c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return null;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.e.a.x.a> getAnnotations() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.e.a.x.j
    public boolean s() {
        Type R = R();
        if (R instanceof Class) {
            return (((Class) R).getTypeParameters().length == 0) ^ true;
        }
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.j
    @k.e.a.d
    public List<h.p2.b0.g.t.e.a.x.x> z() {
        List<Type> d2 = ReflectClassUtilKt.d(R());
        u.a aVar = u.a;
        ArrayList arrayList = new ArrayList(h.a2.u.Y(d2, 10));
        for (Type type : d2) {
            arrayList.add(aVar.a(type));
        }
        return arrayList;
    }
}
