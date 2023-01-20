package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.e.a.x.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class k extends p implements h.p2.b0.g.t.e.a.x.k {
    @k.e.a.d
    private final Constructor<?> a;

    public k(@k.e.a.d Constructor<?> constructor) {
        this.a = constructor;
    }

    @Override // h.p2.b0.g.t.c.f1.b.p
    @k.e.a.d
    /* renamed from: W */
    public Constructor<?> U() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.z
    @k.e.a.d
    public List<v> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = U().getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.e.a.x.k
    @k.e.a.d
    public List<a0> h() {
        Type[] genericParameterTypes = U().getGenericParameterTypes();
        if (genericParameterTypes.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        Class<?> declaringClass = U().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) h.a2.n.M1(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = U().getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                parameterAnnotations = (Annotation[][]) h.a2.n.M1(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            return V(genericParameterTypes, parameterAnnotations, U().isVarArgs());
        }
        throw new IllegalStateException(f0.C("Illegal generic signature: ", U()));
    }
}
