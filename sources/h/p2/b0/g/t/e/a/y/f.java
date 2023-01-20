package h.p2.b0.g.t.e.a.y;

import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.c0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.u;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class f extends h.p2.b0.g.t.n.l implements c0 {
    @k.e.a.d
    private final f0 b;

    public f(@k.e.a.d f0 f0Var) {
        this.b = f0Var;
    }

    private final f0 U0(f0 f0Var) {
        f0 P0 = f0Var.P0(false);
        return !TypeUtilsKt.n(f0Var) ? P0 : new f(P0);
    }

    @Override // h.p2.b0.g.t.n.i
    public boolean A() {
        return true;
    }

    @Override // h.p2.b0.g.t.n.l, h.p2.b0.g.t.n.z
    public boolean J0() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return z ? R0().P0(true) : this;
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    public f0 R0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    /* renamed from: V0 */
    public f Q0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return new f(R0().Q0(eVar));
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    /* renamed from: W0 */
    public f T0(@k.e.a.d f0 f0Var) {
        return new f(f0Var);
    }

    @Override // h.p2.b0.g.t.n.i
    @k.e.a.d
    public z h0(@k.e.a.d z zVar) {
        c1 L0 = zVar.L0();
        if (TypeUtilsKt.n(L0) || y0.l(L0)) {
            if (L0 instanceof f0) {
                return U0((f0) L0);
            }
            if (L0 instanceof u) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                u uVar = (u) L0;
                return a1.d(KotlinTypeFactory.d(U0(uVar.Q0()), U0(uVar.R0())), a1.a(L0));
            }
            throw new IllegalStateException(h.k2.v.f0.C("Incorrect type: ", L0).toString());
        }
        return L0;
    }
}
