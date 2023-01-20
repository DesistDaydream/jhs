package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;

/* loaded from: classes3.dex */
public final class j extends f0 implements h.p2.b0.g.t.n.g1.b {
    @k.e.a.d
    private final CaptureStatus b;
    @k.e.a.d

    /* renamed from: c */
    private final NewCapturedTypeConstructor f15566c;
    @k.e.a.e

    /* renamed from: d */
    private final c1 f15567d;
    @k.e.a.d

    /* renamed from: e */
    private final h.p2.b0.g.t.c.b1.e f15568e;

    /* renamed from: f */
    private final boolean f15569f;

    /* renamed from: g */
    private final boolean f15570g;

    public /* synthetic */ j(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, c1 c1Var, h.p2.b0.g.t.c.b1.e eVar, boolean z, boolean z2, int i2, h.k2.v.u uVar) {
        this(captureStatus, newCapturedTypeConstructor, c1Var, (i2 & 8) != 0 ? h.p2.b0.g.t.c.b1.e.w0.b() : eVar, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return this.f15569f;
    }

    @k.e.a.d
    public final CaptureStatus R0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    /* renamed from: S0 */
    public NewCapturedTypeConstructor I0() {
        return this.f15566c;
    }

    @k.e.a.e
    public final c1 T0() {
        return this.f15567d;
    }

    public final boolean U0() {
        return this.f15570g;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    /* renamed from: V0 */
    public j P0(boolean z) {
        return new j(this.b, I0(), this.f15567d, getAnnotations(), z, false, 32, null);
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: W0 */
    public j N0(@k.e.a.d h hVar) {
        CaptureStatus captureStatus = this.b;
        NewCapturedTypeConstructor a = I0().a(hVar);
        c1 c1Var = this.f15567d;
        return new j(captureStatus, a, c1Var == null ? null : hVar.g(c1Var).L0(), getAnnotations(), J0(), false, 32, null);
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    /* renamed from: X0 */
    public j Q0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return new j(this.b, I0(), this.f15567d, eVar, J0(), false, 32, null);
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.f15568e;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public MemberScope q() {
        return h.p2.b0.g.t.n.s.i("No member resolution should be done on captured type!", true);
    }

    public j(@k.e.a.d CaptureStatus captureStatus, @k.e.a.d NewCapturedTypeConstructor newCapturedTypeConstructor, @k.e.a.e c1 c1Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, boolean z2) {
        this.b = captureStatus;
        this.f15566c = newCapturedTypeConstructor;
        this.f15567d = c1Var;
        this.f15568e = eVar;
        this.f15569f = z;
        this.f15570g = z2;
    }

    public j(@k.e.a.d CaptureStatus captureStatus, @k.e.a.e c1 c1Var, @k.e.a.d s0 s0Var, @k.e.a.d t0 t0Var) {
        this(captureStatus, new NewCapturedTypeConstructor(s0Var, null, null, t0Var, 6, null), c1Var, null, false, false, 56, null);
    }
}
