package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.q0;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.p.a;
import h.w;
import h.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope {
    @d
    private final MemberScope b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final TypeSubstitutor f16786c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private Map<k, k> f16787d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final w f16788e = z.c(new SubstitutingScope$_allDescriptors$2(this));

    public SubstitutingScope(@d MemberScope memberScope, @d TypeSubstitutor typeSubstitutor) {
        this.b = memberScope;
        this.f16786c = CapturedTypeConstructorKt.f(typeSubstitutor.j(), false, 1, null).c();
    }

    private final Collection<k> k() {
        return (Collection) this.f16788e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends k> Collection<D> l(Collection<? extends D> collection) {
        if (this.f16786c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g2 = a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g2.add(m((k) it.next()));
        }
        return g2;
    }

    private final <D extends k> D m(D d2) {
        if (this.f16786c.k()) {
            return d2;
        }
        if (this.f16787d == null) {
            this.f16787d = new HashMap();
        }
        Map<k, k> map = this.f16787d;
        k kVar = map.get(d2);
        if (kVar == null) {
            if (!(d2 instanceof q0)) {
                throw new IllegalStateException(f0.C("Unknown descriptor in scope: ", d2).toString());
            }
            kVar = ((q0) d2).c(this.f16786c);
            if (kVar != null) {
                map.put(d2, kVar);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
            }
        }
        return (D) kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<? extends n0> a(@d f fVar, @d b bVar) {
        return l(this.b.a(fVar, bVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<f> b() {
        return this.b.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<? extends j0> c(@d f fVar, @d b bVar) {
        return l(this.b.c(fVar, bVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<f> d() {
        return this.b.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @e
    public Set<f> e() {
        return this.b.e();
    }

    @Override // h.p2.b0.g.t.k.r.h
    @e
    public h.p2.b0.g.t.c.f f(@d f fVar, @d b bVar) {
        h.p2.b0.g.t.c.f f2 = this.b.f(fVar, bVar);
        if (f2 == null) {
            return null;
        }
        return (h.p2.b0.g.t.c.f) m(f2);
    }

    @Override // h.p2.b0.g.t.k.r.h
    @d
    public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d l<? super f, Boolean> lVar) {
        return k();
    }

    @Override // h.p2.b0.g.t.k.r.h
    public void h(@d f fVar, @d b bVar) {
        MemberScope.a.a(this, fVar, bVar);
    }
}
