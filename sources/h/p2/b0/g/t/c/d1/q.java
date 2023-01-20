package h.p2.b0.g.t.c.d1;

import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.v0;
import h.p2.b0.g.t.n.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class q extends r {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f15150h = false;
    private final r b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeSubstitutor f15151c;

    /* renamed from: d  reason: collision with root package name */
    private TypeSubstitutor f15152d;

    /* renamed from: e  reason: collision with root package name */
    private List<t0> f15153e;

    /* renamed from: f  reason: collision with root package name */
    private List<t0> f15154f;

    /* renamed from: g  reason: collision with root package name */
    private q0 f15155g;

    /* loaded from: classes3.dex */
    public class a implements h.k2.u.l<t0, Boolean> {
        public a() {
        }

        @Override // h.k2.u.l
        /* renamed from: a */
        public Boolean invoke(t0 t0Var) {
            return Boolean.valueOf(!t0Var.S());
        }
    }

    public q(r rVar, TypeSubstitutor typeSubstitutor) {
        this.b = rVar;
        this.f15151c = typeSubstitutor;
    }

    private TypeSubstitutor C0() {
        if (this.f15152d == null) {
            if (this.f15151c.k()) {
                this.f15152d = this.f15151c;
            } else {
                List<t0> parameters = this.b.j().getParameters();
                this.f15153e = new ArrayList(parameters.size());
                this.f15152d = h.p2.b0.g.t.n.n.b(parameters, this.f15151c.j(), this, this.f15153e);
                this.f15154f = CollectionsKt___CollectionsKt.Z1(this.f15153e, new a());
            }
        }
        return this.f15152d;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void h0(int r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.c.d1.q.h0(int):void");
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    public MemberScope A(@k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (v0Var == null) {
            h0(5);
        }
        if (hVar == null) {
            h0(6);
        }
        MemberScope A = this.b.A(v0Var, hVar);
        if (this.f15151c.k()) {
            if (A == null) {
                h0(7);
            }
            return A;
        }
        return new SubstitutingScope(A, C0());
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.a(this, d2);
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.c E() {
        return this.b.E();
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public m0 F0() {
        throw new UnsupportedOperationException();
    }

    @Override // h.p2.b0.g.t.c.q0
    @k.e.a.d
    /* renamed from: G0 */
    public h.p2.b0.g.t.c.d c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            h0(22);
        }
        return typeSubstitutor.k() ? this : new q(this, TypeSubstitutor.h(typeSubstitutor.j(), C0().j()));
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope U() {
        MemberScope U = this.b.U();
        if (U == null) {
            h0(27);
        }
        return U;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope W() {
        MemberScope f0 = f0(DescriptorUtilsKt.k(h.p2.b0.g.t.k.c.g(this.b)));
        if (f0 == null) {
            h0(12);
        }
        return f0;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return this.b.X();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean a0() {
        return this.b.a0();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.k b() {
        h.p2.b0.g.t.c.k b = this.b.b();
        if (b == null) {
            h0(21);
        }
        return b;
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    public MemberScope f0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (hVar == null) {
            h0(13);
        }
        MemberScope f0 = this.b.f0(hVar);
        if (this.f15151c.k()) {
            if (f0 == null) {
                h0(14);
            }
            return f0;
        }
        return new SubstitutingScope(f0, C0());
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.c> g() {
        Collection<h.p2.b0.g.t.c.c> g2 = this.b.g();
        ArrayList arrayList = new ArrayList(g2.size());
        for (h.p2.b0.g.t.c.c cVar : g2) {
            arrayList.add(((h.p2.b0.g.t.c.c) cVar.x().m(cVar.a()).j(cVar.t()).g(cVar.getVisibility()).q(cVar.i()).n(false).build()).c(C0()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        h.p2.b0.g.t.c.b1.e annotations = this.b.getAnnotations();
        if (annotations == null) {
            h0(18);
        }
        return annotations;
    }

    @Override // h.p2.b0.g.t.c.a0
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        h.p2.b0.g.t.g.f name = this.b.getName();
        if (name == null) {
            h0(19);
        }
        return name;
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        o0 o0Var = o0.a;
        if (o0Var == null) {
            h0(28);
        }
        return o0Var;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s visibility = this.b.getVisibility();
        if (visibility == null) {
            h0(26);
        }
        return visibility;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public ClassKind i() {
        ClassKind i2 = this.b.i();
        if (i2 == null) {
            h0(24);
        }
        return i2;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return this.b.i0();
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return this.b.isExternal();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean isInline() {
        return this.b.isInline();
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public q0 j() {
        q0 j2 = this.b.j();
        if (this.f15151c.k()) {
            if (j2 == null) {
                h0(0);
            }
            return j2;
        }
        if (this.f15155g == null) {
            TypeSubstitutor C0 = C0();
            Collection<h.p2.b0.g.t.n.z> j3 = j2.j();
            ArrayList arrayList = new ArrayList(j3.size());
            for (h.p2.b0.g.t.n.z zVar : j3) {
                arrayList.add(C0.p(zVar, Variance.INVARIANT));
            }
            this.f15155g = new h.p2.b0.g.t.n.h(this, this.f15153e, arrayList, LockBasedStorageManager.f16850e);
        }
        q0 q0Var = this.f15155g;
        if (q0Var == null) {
            h0(1);
        }
        return q0Var;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope k0() {
        MemberScope k0 = this.b.k0();
        if (k0 == null) {
            h0(15);
        }
        return k0;
    }

    @Override // h.p2.b0.g.t.c.d
    public h.p2.b0.g.t.c.d l0() {
        return this.b.l0();
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.d> m() {
        Collection<h.p2.b0.g.t.c.d> m2 = this.b.m();
        if (m2 == null) {
            h0(30);
        }
        return m2;
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return this.b.n();
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope o0(@k.e.a.d v0 v0Var) {
        if (v0Var == null) {
            h0(10);
        }
        MemberScope A = A(v0Var, DescriptorUtilsKt.k(h.p2.b0.g.t.k.c.g(this)));
        if (A == null) {
            h0(11);
        }
        return A;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r() {
        h.p2.b0.g.t.n.f0 j2 = KotlinTypeFactory.j(getAnnotations(), j(), y0.g(j().getParameters()), false, W());
        if (j2 == null) {
            h0(16);
        }
        return j2;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @k.e.a.d
    public List<t0> s() {
        C0();
        List<t0> list = this.f15154f;
        if (list == null) {
            h0(29);
        }
        return list;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality t = this.b.t();
        if (t == null) {
            h0(25);
        }
        return t;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean v() {
        return this.b.v();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean w() {
        return this.b.w();
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean y() {
        return this.b.y();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.d a() {
        h.p2.b0.g.t.c.d a2 = this.b.a();
        if (a2 == null) {
            h0(20);
        }
        return a2;
    }
}
