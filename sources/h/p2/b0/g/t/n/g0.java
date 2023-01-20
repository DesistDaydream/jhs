package h.p2.b0.g.t.n;

import h.p2.b0.g.t.n.s;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class g0 extends f0 {
    @k.e.a.d
    private final q0 b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final List<s0> f15575c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15576d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final MemberScope f15577e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final h.k2.u.l<h.p2.b0.g.t.n.e1.h, f0> f15578f;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(@k.e.a.d q0 q0Var, @k.e.a.d List<? extends s0> list, boolean z, @k.e.a.d MemberScope memberScope, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.n.e1.h, ? extends f0> lVar) {
        this.b = q0Var;
        this.f15575c = list;
        this.f15576d = z;
        this.f15577e = memberScope;
        this.f15578f = lVar;
        if (q() instanceof s.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + q() + '\n' + I0());
        }
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return this.f15575c;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public q0 I0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return this.f15576d;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        if (z == J0()) {
            return this;
        }
        if (z) {
            return new d0(this);
        }
        return new b0(this);
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: Q0 */
    public f0 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return eVar.isEmpty() ? this : new g(this, eVar);
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: R0 */
    public f0 N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        f0 invoke = this.f15578f.invoke(hVar);
        return invoke == null ? this : invoke;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return h.p2.b0.g.t.c.b1.e.w0.b();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public MemberScope q() {
        return this.f15577e;
    }
}
