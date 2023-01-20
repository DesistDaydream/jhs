package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.c.d1.j;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class AbstractTypeAliasDescriptor extends j implements s0 {
    @d

    /* renamed from: e  reason: collision with root package name */
    private final s f16451e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends t0> f16452f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final a f16453g;

    /* loaded from: classes3.dex */
    public static final class a implements q0 {
        public a() {
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public q0 a(@d h hVar) {
            return this;
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return true;
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        /* renamed from: e */
        public s0 c() {
            return AbstractTypeAliasDescriptor.this;
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public List<t0> getParameters() {
            return AbstractTypeAliasDescriptor.this.I0();
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public Collection<z> j() {
            return c().r0().I0().j();
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public f k() {
            return DescriptorUtilsKt.g(c());
        }

        @d
        public String toString() {
            return "[typealias " + c().getName().b() + ']';
        }
    }

    public AbstractTypeAliasDescriptor(@d k kVar, @d e eVar, @d h.p2.b0.g.t.g.f fVar, @d o0 o0Var, @d s sVar) {
        super(kVar, eVar, fVar, o0Var);
        this.f16451e = sVar;
        this.f16453g = new a();
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(@d m<R, D> mVar, D d2) {
        return mVar.d(this, d2);
    }

    @d
    public final f0 C0() {
        h.p2.b0.g.t.c.d u = u();
        MemberScope W = u == null ? null : u.W();
        if (W == null) {
            W = MemberScope.b.b;
        }
        return y0.t(this, W, new AbstractTypeAliasDescriptor$computeDefaultType$1(this));
    }

    @Override // h.p2.b0.g.t.c.d1.j
    @d
    /* renamed from: G0 */
    public s0 h0() {
        return (s0) super.a();
    }

    @d
    public final Collection<h.p2.b0.g.t.c.d1.f0> H0() {
        h.p2.b0.g.t.c.d u = u();
        if (u == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        Collection<c> g2 = u.g();
        ArrayList arrayList = new ArrayList();
        for (c cVar : g2) {
            h.p2.b0.g.t.c.d1.f0 b = TypeAliasConstructorDescriptorImpl.H.b(N(), this, cVar);
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    @d
    public abstract List<t0> I0();

    public final void J0(@d List<? extends t0> list) {
        this.f16452f = list;
    }

    @d
    public abstract h.p2.b0.g.t.m.m N();

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @d
    public s getVisibility() {
        return this.f16451e;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.f
    @d
    public q0 j() {
        return this.f16453g;
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return y0.c(r0(), new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    @Override // h.p2.b0.g.t.c.g
    @d
    public List<t0> s() {
        List list = this.f16452f;
        Objects.requireNonNull(list);
        return list;
    }

    @Override // h.p2.b0.g.t.c.w
    @d
    public Modality t() {
        return Modality.FINAL;
    }

    @Override // h.p2.b0.g.t.c.d1.i
    @d
    public String toString() {
        return h.k2.v.f0.C("typealias ", getName().b());
    }
}
