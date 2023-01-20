package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.f1.b.e;
import h.p2.b0.g.t.c.f1.b.r;
import h.p2.b0.g.t.e.a.x.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes3.dex */
public abstract class p extends l implements e, r, h.p2.b0.g.t.e.a.x.q {
    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return e.a.c(this);
    }

    @Override // h.p2.b0.g.t.c.f1.b.r
    public int I() {
        return U().getModifiers();
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean Q() {
        return r.a.d(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.e
    /* renamed from: R */
    public b c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.a.a(this, cVar);
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    /* renamed from: S */
    public List<b> getAnnotations() {
        return e.a.b(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.q
    @k.e.a.d
    /* renamed from: T */
    public ReflectJavaClass P() {
        return new ReflectJavaClass(U().getDeclaringClass());
    }

    @k.e.a.d
    public abstract Member U();

    @k.e.a.d
    public final List<a0> V(@k.e.a.d Type[] typeArr, @k.e.a.d Annotation[][] annotationArr, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> b = a.a.b(U());
        Integer valueOf = b == null ? null : Integer.valueOf(b.size());
        int intValue = valueOf == null ? 0 : valueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                u a = u.a.a(typeArr[i2]);
                if (b == null) {
                    str = null;
                } else {
                    str = (String) CollectionsKt___CollectionsKt.J2(b, i2 + intValue);
                    if (str == null) {
                        throw new IllegalStateException(("No parameter with index " + i2 + '+' + intValue + " (name=" + getName() + " type=" + a + ") in " + b + "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new w(a, annotationArr[i2], str, z && i2 == ArraysKt___ArraysKt.Td(typeArr)));
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof p) && f0.g(U(), ((p) obj).U());
    }

    @Override // h.p2.b0.g.t.e.a.x.t
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        String name = U().getName();
        h.p2.b0.g.t.g.f f2 = name == null ? null : h.p2.b0.g.t.g.f.f(name);
        return f2 == null ? h.p2.b0.g.t.g.h.a : f2;
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    @k.e.a.d
    public a1 getVisibility() {
        return r.a.a(this);
    }

    public int hashCode() {
        return U().hashCode();
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean isAbstract() {
        return r.a.b(this);
    }

    @Override // h.p2.b0.g.t.e.a.x.s
    public boolean isFinal() {
        return r.a.c(this);
    }

    @Override // h.p2.b0.g.t.c.f1.b.e
    @k.e.a.d
    public AnnotatedElement r() {
        return (AnnotatedElement) U();
    }

    @k.e.a.d
    public String toString() {
        return getClass().getName() + ": " + U();
    }
}
