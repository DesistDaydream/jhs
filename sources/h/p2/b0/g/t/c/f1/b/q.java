package h.p2.b0.g.t.c.f1.b;

import h.p2.b0.g.t.e.a.x.a0;
import h.p2.b0.g.t.e.a.x.r;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class q extends p implements h.p2.b0.g.t.e.a.x.r {
    @k.e.a.d
    private final Method a;

    public q(@k.e.a.d Method method) {
        this.a = method;
    }

    @Override // h.p2.b0.g.t.e.a.x.r
    public boolean N() {
        return r.a.a(this);
    }

    @Override // h.p2.b0.g.t.c.f1.b.p
    @k.e.a.d
    /* renamed from: W */
    public Method U() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.r
    @k.e.a.d
    /* renamed from: X */
    public u getReturnType() {
        return u.a.a(U().getGenericReturnType());
    }

    @Override // h.p2.b0.g.t.e.a.x.z
    @k.e.a.d
    public List<v> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = U().getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.e.a.x.r
    @k.e.a.d
    public List<a0> h() {
        return V(U().getGenericParameterTypes(), U().getParameterAnnotations(), U().isVarArgs());
    }

    @Override // h.p2.b0.g.t.e.a.x.r
    @k.e.a.e
    public h.p2.b0.g.t.e.a.x.b n() {
        Object defaultValue = U().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return c.b.a(defaultValue, null);
    }
}
