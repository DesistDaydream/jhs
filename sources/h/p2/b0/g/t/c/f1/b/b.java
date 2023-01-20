package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.e.a.x.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes3.dex */
public final class b extends l implements h.p2.b0.g.t.e.a.x.a {
    @k.e.a.d
    private final Annotation a;

    public b(@k.e.a.d Annotation annotation) {
        this.a = annotation;
    }

    @Override // h.p2.b0.g.t.e.a.x.a
    public boolean G() {
        return a.C0445a.a(this);
    }

    @k.e.a.d
    public final Annotation R() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.a
    @k.e.a.d
    /* renamed from: S */
    public ReflectJavaClass t() {
        return new ReflectJavaClass(h.k2.a.c(h.k2.a.a(this.a)));
    }

    @Override // h.p2.b0.g.t.e.a.x.a
    @k.e.a.d
    public h.p2.b0.g.t.g.b b() {
        return ReflectClassUtilKt.a(h.k2.a.c(h.k2.a.a(this.a)));
    }

    @Override // h.p2.b0.g.t.e.a.x.a
    public boolean d() {
        return a.C0445a.b(this);
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof b) && f0.g(this.a, ((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return b.class.getName() + ": " + this.a;
    }

    @Override // h.p2.b0.g.t.e.a.x.a
    @k.e.a.d
    public Collection<h.p2.b0.g.t.e.a.x.b> u() {
        Method[] declaredMethods = h.k2.a.c(h.k2.a.a(this.a)).getDeclaredMethods();
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            arrayList.add(c.b.a(method.invoke(R(), new Object[0]), h.p2.b0.g.t.g.f.f(method.getName())));
        }
        return arrayList;
    }
}
