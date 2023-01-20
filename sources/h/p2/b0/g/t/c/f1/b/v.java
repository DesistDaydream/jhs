package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.c.f1.b.e;
import h.p2.b0.g.t.e.a.x.y;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class v extends l implements e, y {
    @k.e.a.d
    private final TypeVariable<?> a;

    public v(@k.e.a.d TypeVariable<?> typeVariable) {
        this.a = typeVariable;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return e.a.c(this);
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

    @Override // h.p2.b0.g.t.e.a.x.y
    @k.e.a.d
    /* renamed from: T */
    public List<j> getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new j(type));
        }
        j jVar = (j) CollectionsKt___CollectionsKt.X4(arrayList);
        return f0.g(jVar == null ? null : jVar.R(), Object.class) ? CollectionsKt__CollectionsKt.E() : arrayList;
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof v) && f0.g(this.a, ((v) obj).a);
    }

    @Override // h.p2.b0.g.t.e.a.x.t
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        return h.p2.b0.g.t.g.f.f(this.a.getName());
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // h.p2.b0.g.t.c.f1.b.e
    @k.e.a.e
    public AnnotatedElement r() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @k.e.a.d
    public String toString() {
        return v.class.getName() + ": " + this.a;
    }
}
