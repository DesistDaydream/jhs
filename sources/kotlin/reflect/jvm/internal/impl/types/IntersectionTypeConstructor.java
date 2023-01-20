package kotlin.reflect.jvm.internal.impl.types;

import h.a2.u;
import h.b2.b;
import h.k2.v.f0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.g1.f;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;

/* loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements q0, f {
    @e
    private z a;
    @d
    private final LinkedHashSet<z> b;

    /* renamed from: c */
    private final int f16870c;

    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.g(((z) t).toString(), ((z) t2).toString());
        }
    }

    public IntersectionTypeConstructor(@d Collection<? extends z> collection) {
        collection.isEmpty();
        LinkedHashSet<z> linkedHashSet = new LinkedHashSet<>(collection);
        this.b = linkedHashSet;
        this.f16870c = linkedHashSet.hashCode();
    }

    private final String h(Iterable<? extends z> iterable) {
        return CollectionsKt___CollectionsKt.Z2(CollectionsKt___CollectionsKt.h5(iterable, new a()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // h.p2.b0.g.t.n.q0
    @e
    public h.p2.b0.g.t.c.f c() {
        return null;
    }

    @Override // h.p2.b0.g.t.n.q0
    public boolean d() {
        return false;
    }

    @d
    public final MemberScope e() {
        return TypeIntersectionScope.f16789d.a("member scope for intersection type", this.b);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return f0.g(this.b, ((IntersectionTypeConstructor) obj).b);
        }
        return false;
    }

    @d
    public final h.p2.b0.g.t.n.f0 f() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.k(h.p2.b0.g.t.c.b1.e.w0.b(), this, CollectionsKt__CollectionsKt.E(), false, e(), new IntersectionTypeConstructor$createType$1(this));
    }

    @e
    public final z g() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public List<t0> getParameters() {
        return CollectionsKt__CollectionsKt.E();
    }

    public int hashCode() {
        return this.f16870c;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    /* renamed from: i */
    public IntersectionTypeConstructor a(@d h hVar) {
        Collection<z> j2 = j();
        ArrayList arrayList = new ArrayList(u.Y(j2, 10));
        boolean z = false;
        for (z zVar : j2) {
            arrayList.add(zVar.K0(hVar));
            z = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        if (z) {
            z g2 = g();
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).l(g2 != null ? g2.K0(hVar) : null);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public Collection<z> j() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public h.p2.b0.g.t.b.f k() {
        return this.b.iterator().next().I0().k();
    }

    @d
    public final IntersectionTypeConstructor l(@e z zVar) {
        return new IntersectionTypeConstructor(this.b, zVar);
    }

    @d
    public String toString() {
        return h(this.b);
    }

    private IntersectionTypeConstructor(Collection<? extends z> collection, z zVar) {
        this(collection);
        this.a = zVar;
    }
}
