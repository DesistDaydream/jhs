package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.v.n0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.i;
import h.p2.b0.g.t.c.f0;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public class LazyPackageViewDescriptorImpl extends i implements f0 {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16454h = {n0.r(new PropertyReference1Impl(n0.d(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;")), n0.r(new PropertyReference1Impl(n0.d(LazyPackageViewDescriptorImpl.class), "empty", "getEmpty()Z"))};
    @d

    /* renamed from: c  reason: collision with root package name */
    private final ModuleDescriptorImpl f16455c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final c f16456d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h f16457e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final h f16458f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final MemberScope f16459g;

    public LazyPackageViewDescriptorImpl(@d ModuleDescriptorImpl moduleDescriptorImpl, @d c cVar, @d m mVar) {
        super(e.w0.b(), cVar.h());
        this.f16455c = moduleDescriptorImpl;
        this.f16456d = cVar;
        this.f16457e = mVar.c(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.f16458f = mVar.c(new LazyPackageViewDescriptorImpl$empty$2(this));
        this.f16459g = new LazyScopeAdapter(mVar, new LazyPackageViewDescriptorImpl$memberScope$1(this));
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(@d h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.b(this, d2);
    }

    public final boolean C0() {
        return ((Boolean) l.a(this.f16458f, this, f16454h[1])).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.f0
    @d
    /* renamed from: G0 */
    public ModuleDescriptorImpl y0() {
        return this.f16455c;
    }

    @Override // h.p2.b0.g.t.c.f0
    @d
    public c e() {
        return this.f16456d;
    }

    public boolean equals(@k.e.a.e Object obj) {
        f0 f0Var = obj instanceof f0 ? (f0) obj : null;
        return f0Var != null && h.k2.v.f0.g(e(), f0Var.e()) && h.k2.v.f0.g(y0(), f0Var.y0());
    }

    @Override // h.p2.b0.g.t.c.f0
    @d
    public List<b0> g0() {
        return (List) l.a(this.f16457e, this, f16454h[0]);
    }

    @Override // h.p2.b0.g.t.c.k
    @k.e.a.e
    /* renamed from: h0 */
    public f0 b() {
        if (e().d()) {
            return null;
        }
        return y0().j0(e().e());
    }

    public int hashCode() {
        return (y0().hashCode() * 31) + e().hashCode();
    }

    @Override // h.p2.b0.g.t.c.f0
    public boolean isEmpty() {
        return C0();
    }

    @Override // h.p2.b0.g.t.c.f0
    @d
    public MemberScope q() {
        return this.f16459g;
    }
}
