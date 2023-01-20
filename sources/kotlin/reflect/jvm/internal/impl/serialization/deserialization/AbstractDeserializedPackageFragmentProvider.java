package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.a2.d1;
import h.k2.u.l;
import h.p2.b0.g.t.c.a0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.e0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.l.b.g;
import h.p2.b0.g.t.l.b.k;
import h.p2.b0.g.t.l.b.o;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.p.a;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements e0 {
    @d
    private final m a;
    @d
    private final o b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final z f16791c;

    /* renamed from: d  reason: collision with root package name */
    public g f16792d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.m.g<c, b0> f16793e;

    public AbstractDeserializedPackageFragmentProvider(@d m mVar, @d o oVar, @d z zVar) {
        this.a = mVar;
        this.b = oVar;
        this.f16791c = zVar;
        this.f16793e = mVar.g(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    public List<b0> a(@d c cVar) {
        return CollectionsKt__CollectionsKt.M(this.f16793e.invoke(cVar));
    }

    @Override // h.p2.b0.g.t.c.e0
    public void b(@d c cVar, @d Collection<b0> collection) {
        a.a(collection, this.f16793e.invoke(cVar));
    }

    @Override // h.p2.b0.g.t.c.e0
    public boolean c(@d c cVar) {
        a0 d2;
        if (this.f16793e.x(cVar)) {
            d2 = (b0) this.f16793e.invoke(cVar);
        } else {
            d2 = d(cVar);
        }
        return d2 == null;
    }

    @e
    public abstract k d(@d c cVar);

    @d
    public final g e() {
        g gVar = this.f16792d;
        Objects.requireNonNull(gVar);
        return gVar;
    }

    @d
    public final o f() {
        return this.b;
    }

    @d
    public final z g() {
        return this.f16791c;
    }

    @d
    public final m h() {
        return this.a;
    }

    public final void i(@d g gVar) {
        this.f16792d = gVar;
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    public Collection<c> p(@d c cVar, @d l<? super f, Boolean> lVar) {
        return d1.k();
    }
}
