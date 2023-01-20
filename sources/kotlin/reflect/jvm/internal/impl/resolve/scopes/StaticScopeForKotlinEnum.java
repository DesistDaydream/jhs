package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.k.r.f;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16784d = {n0.r(new PropertyReference1Impl(n0.d(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    @d
    private final h.p2.b0.g.t.c.d b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h f16785c;

    public StaticScopeForKotlinEnum(@d m mVar, @d h.p2.b0.g.t.c.d dVar) {
        this.b = dVar;
        dVar.i();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.f16785c = mVar.c(new StaticScopeForKotlinEnum$functions$2(this));
    }

    private final List<h.p2.b0.g.t.c.n0> m() {
        return (List) l.a(this.f16785c, this, f16784d[0]);
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    public /* bridge */ /* synthetic */ h.p2.b0.g.t.c.f f(h.p2.b0.g.t.g.f fVar, b bVar) {
        return (h.p2.b0.g.t.c.f) j(fVar, bVar);
    }

    @e
    public Void j(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        return null;
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @d
    /* renamed from: k */
    public List<h.p2.b0.g.t.c.n0> g(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        return m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    /* renamed from: l */
    public h.p2.b0.g.t.p.d<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        List<h.p2.b0.g.t.c.n0> m2 = m();
        h.p2.b0.g.t.p.d<h.p2.b0.g.t.c.n0> dVar = new h.p2.b0.g.t.p.d<>();
        for (Object obj : m2) {
            if (f0.g(((h.p2.b0.g.t.c.n0) obj).getName(), fVar)) {
                dVar.add(obj);
            }
        }
        return dVar;
    }
}
