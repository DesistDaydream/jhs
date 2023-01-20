package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.a2.d1;
import h.a2.t0;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.c0;
import h.p2.b0.g.t.c.d1.i;
import h.p2.b0.g.t.c.d1.t;
import h.p2.b0.g.t.c.d1.x;
import h.p2.b0.g.t.c.f0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.y;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.h.c;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.e1.p;
import h.w;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl extends i implements z {
    @d

    /* renamed from: c  reason: collision with root package name */
    private final m f16460c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f16461d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private final c f16462e;
    @e

    /* renamed from: f  reason: collision with root package name */
    private final h.p2.b0.g.t.g.f f16463f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final Map<y<?>, Object> f16464g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final x f16465h;
    @e

    /* renamed from: i  reason: collision with root package name */
    private t f16466i;
    @e

    /* renamed from: j  reason: collision with root package name */
    private c0 f16467j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16468k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.c, f0> f16469l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final w f16470m;

    @h
    public ModuleDescriptorImpl(@d h.p2.b0.g.t.g.f fVar, @d m mVar, @d f fVar2, @e c cVar) {
        this(fVar, mVar, fVar2, cVar, null, null, 48, null);
    }

    public /* synthetic */ ModuleDescriptorImpl(h.p2.b0.g.t.g.f fVar, m mVar, f fVar2, c cVar, Map map, h.p2.b0.g.t.g.f fVar3, int i2, u uVar) {
        this(fVar, mVar, fVar2, (i2 & 8) != 0 ? null : cVar, (i2 & 16) != 0 ? t0.z() : map, (i2 & 32) != 0 ? null : fVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L0() {
        return getName().toString();
    }

    private final h.p2.b0.g.t.c.d1.h N0() {
        return (h.p2.b0.g.t.c.d1.h) this.f16470m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P0() {
        return this.f16467j != null;
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(@d h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return (R) z.a.a(this, mVar, d2);
    }

    @Override // h.p2.b0.g.t.c.z
    @e
    public <T> T D0(@d y<T> yVar) {
        return (T) this.f16464g.get(yVar);
    }

    public void K0() {
        if (!Q0()) {
            throw new InvalidModuleException(h.k2.v.f0.C("Accessing invalid module descriptor ", this));
        }
    }

    @Override // h.p2.b0.g.t.c.z
    public boolean L(@d z zVar) {
        return h.k2.v.f0.g(this, zVar) || CollectionsKt___CollectionsKt.J1(this.f16466i.c(), zVar) || w0().contains(zVar) || zVar.w0().contains(this);
    }

    @d
    public final c0 M0() {
        K0();
        return N0();
    }

    public final void O0(@d c0 c0Var) {
        P0();
        this.f16467j = c0Var;
    }

    public boolean Q0() {
        return this.f16468k;
    }

    public final void R0(@d List<ModuleDescriptorImpl> list) {
        S0(list, d1.k());
    }

    public final void S0(@d List<ModuleDescriptorImpl> list, @d Set<ModuleDescriptorImpl> set) {
        T0(new h.p2.b0.g.t.c.d1.u(list, set, CollectionsKt__CollectionsKt.E(), d1.k()));
    }

    public final void T0(@d t tVar) {
        t tVar2 = this.f16466i;
        this.f16466i = tVar;
    }

    public final void U0(@d ModuleDescriptorImpl... moduleDescriptorImplArr) {
        R0(ArraysKt___ArraysKt.ey(moduleDescriptorImplArr));
    }

    @Override // h.p2.b0.g.t.c.k
    @e
    public k b() {
        return z.a.b(this);
    }

    @Override // h.p2.b0.g.t.c.z
    @d
    public f0 j0(@d h.p2.b0.g.t.g.c cVar) {
        K0();
        return this.f16469l.invoke(cVar);
    }

    @Override // h.p2.b0.g.t.c.z
    @d
    public f k() {
        return this.f16461d;
    }

    @Override // h.p2.b0.g.t.c.z
    @d
    public Collection<h.p2.b0.g.t.g.c> p(@d h.p2.b0.g.t.g.c cVar, @d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        K0();
        return M0().p(cVar, lVar);
    }

    @Override // h.p2.b0.g.t.c.z
    @d
    public List<z> w0() {
        t tVar = this.f16466i;
        if (tVar != null) {
            return tVar.b();
        }
        throw new AssertionError("Dependencies of module " + L0() + " were not set");
    }

    @h
    public ModuleDescriptorImpl(@d h.p2.b0.g.t.g.f fVar, @d m mVar, @d f fVar2, @e c cVar, @d Map<y<?>, ? extends Object> map, @e h.p2.b0.g.t.g.f fVar3) {
        super(h.p2.b0.g.t.c.b1.e.w0.b(), fVar);
        this.f16460c = mVar;
        this.f16461d = fVar2;
        this.f16462e = cVar;
        this.f16463f = fVar3;
        if (fVar.g()) {
            Map<y<?>, Object> J0 = t0.J0(map);
            this.f16464g = J0;
            J0.put(h.p2.b0.g.t.n.e1.i.a(), new p(null));
            x xVar = (x) D0(x.a.a());
            this.f16465h = xVar == null ? x.b.b : xVar;
            this.f16468k = true;
            this.f16469l = mVar.i(new ModuleDescriptorImpl$packages$1(this));
            this.f16470m = h.z.c(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
            return;
        }
        throw new IllegalArgumentException(h.k2.v.f0.C("Module name must be special: ", fVar));
    }
}
