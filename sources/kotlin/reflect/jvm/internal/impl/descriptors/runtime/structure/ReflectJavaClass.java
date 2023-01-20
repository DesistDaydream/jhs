package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.a2.u;
import h.k2.v.f0;
import h.k2.v.r0;
import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.f1.b.b;
import h.p2.b0.g.t.c.f1.b.e;
import h.p2.b0.g.t.c.f1.b.k;
import h.p2.b0.g.t.c.f1.b.l;
import h.p2.b0.g.t.c.f1.b.n;
import h.p2.b0.g.t.c.f1.b.q;
import h.p2.b0.g.t.c.f1.b.r;
import h.p2.b0.g.t.c.f1.b.v;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.j;
import h.p2.b0.g.t.e.a.x.w;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class ReflectJavaClass extends l implements e, r, g {
    @d
    private final Class<?> a;

    public ReflectJavaClass(@d Class<?> cls) {
        this.a = cls;
    }

    public final boolean a0(Method method) {
        String name = method.getName();
        if (f0.g(name, "values")) {
            if (method.getParameterTypes().length == 0) {
                return true;
            }
        } else if (f0.g(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    public Collection<j> C() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return e.a.c(this);
    }

    @Override // h.p2.b0.g.t.c.f1.b.r
    public int I() {
        return this.a.getModifiers();
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean K() {
        return this.a.isInterface();
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @k.e.a.e
    public LightClassOriginKind L() {
        return null;
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean Q() {
        return r.a.d(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.e
    /* renamed from: S */
    public b c(@d c cVar) {
        return e.a.a(this, cVar);
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @d
    /* renamed from: T */
    public List<b> getAnnotations() {
        return e.a.b(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    /* renamed from: U */
    public List<k> g() {
        return SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.d1(SequencesKt___SequencesKt.n0(ArraysKt___ArraysKt.h5(this.a.getDeclaredConstructors()), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @Override // h.p2.b0.g.t.c.f1.b.e
    @d
    /* renamed from: V */
    public Class<?> r() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    /* renamed from: W */
    public List<n> y() {
        return SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.d1(SequencesKt___SequencesKt.n0(ArraysKt___ArraysKt.h5(this.a.getDeclaredFields()), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    /* renamed from: X */
    public List<f> A() {
        return SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.i1(SequencesKt___SequencesKt.n0(ArraysKt___ArraysKt.h5(this.a.getDeclaredClasses()), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    /* renamed from: Y */
    public List<q> B() {
        return SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.d1(SequencesKt___SequencesKt.i0(ArraysKt___ArraysKt.h5(this.a.getDeclaredMethods()), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @k.e.a.e
    /* renamed from: Z */
    public ReflectJavaClass f() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    public c e() {
        return ReflectClassUtilKt.a(this.a).b();
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof ReflectJavaClass) && f0.g(this.a, ((ReflectJavaClass) obj).a);
    }

    @Override // h.p2.b0.g.t.e.a.x.t
    @d
    public f getName() {
        return f.f(this.a.getSimpleName());
    }

    @Override // h.p2.b0.g.t.e.a.x.z
    @d
    public List<v> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    @d
    public a1 getVisibility() {
        return r.a.a(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    public Collection<w> i() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean isAbstract() {
        return r.a.b(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean isFinal() {
        return r.a.c(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    @d
    public Collection<j> j() {
        Class cls;
        cls = Object.class;
        if (f0.g(this.a, cls)) {
            return CollectionsKt__CollectionsKt.E();
        }
        r0 r0Var = new r0(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        r0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        r0Var.b(this.a.getGenericInterfaces());
        List<Type> L = CollectionsKt__CollectionsKt.L(r0Var.d(new Type[r0Var.c()]));
        ArrayList arrayList = new ArrayList(u.Y(L, 10));
        for (Type type : L) {
            arrayList.add(new h.p2.b0.g.t.c.f1.b.j(type));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean m() {
        return this.a.isAnnotation();
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean o() {
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean p() {
        return false;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean q() {
        return false;
    }

    @d
    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.g
    public boolean w() {
        return this.a.isEnum();
    }
}
