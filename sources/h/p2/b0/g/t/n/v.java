package h.p2.b0.g.t.n;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class v extends u implements i {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15609e = new a(null);
    @h.k2.d

    /* renamed from: f  reason: collision with root package name */
    public static boolean f15610f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15611d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public v(@k.e.a.d f0 f0Var, @k.e.a.d f0 f0Var2) {
        super(f0Var, f0Var2);
    }

    private final void U0() {
        if (!f15610f || this.f15611d) {
            return;
        }
        this.f15611d = true;
        x.b(Q0());
        x.b(R0());
        h.k2.v.f0.g(Q0(), R0());
        h.p2.b0.g.t.n.e1.f.a.d(Q0(), R0());
    }

    @Override // h.p2.b0.g.t.n.i
    public boolean A() {
        return (Q0().I0().c() instanceof h.p2.b0.g.t.c.t0) && h.k2.v.f0.g(Q0().I0(), R0().I0());
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    public c1 M0(boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.d(Q0().P0(z), R0().P0(z));
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    public c1 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.d(Q0().Q0(eVar), R0().Q0(eVar));
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public f0 P0() {
        U0();
        return Q0();
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public String S0(@k.e.a.d DescriptorRenderer descriptorRenderer, @k.e.a.d h.p2.b0.g.t.j.b bVar) {
        if (bVar.j()) {
            return '(' + descriptorRenderer.y(Q0()) + ".." + descriptorRenderer.y(R0()) + ')';
        }
        return descriptorRenderer.v(descriptorRenderer.y(Q0()), descriptorRenderer.y(R0()), TypeUtilsKt.h(this));
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: T0 */
    public u N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return new v((f0) hVar.g(Q0()), (f0) hVar.g(R0()));
    }

    @Override // h.p2.b0.g.t.n.i
    @k.e.a.d
    public z h0(@k.e.a.d z zVar) {
        c1 d2;
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            d2 = L0;
        } else if (!(L0 instanceof f0)) {
            throw new NoWhenBranchMatchedException();
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            f0 f0Var = (f0) L0;
            d2 = KotlinTypeFactory.d(f0Var, f0Var.P0(true));
        }
        return a1.b(d2, L0);
    }
}
