package h.p2.b0.g.t.n;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class e extends f0 {
    @k.e.a.d
    private final q0 b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15556c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final q0 f15557d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final MemberScope f15558e;

    public e(@k.e.a.d q0 q0Var, boolean z, @k.e.a.d q0 q0Var2, @k.e.a.d MemberScope memberScope) {
        this.b = q0Var;
        this.f15556c = z;
        this.f15557d = q0Var2;
        this.f15558e = memberScope;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public q0 I0() {
        return this.f15557d;
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return this.f15556c;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return z == J0() ? this : S0(z);
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: Q0 */
    public f0 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return this;
    }

    @k.e.a.d
    public final q0 R0() {
        return this.b;
    }

    @k.e.a.d
    public abstract e S0(boolean z);

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: T0 */
    public e N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return this;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return h.p2.b0.g.t.c.b1.e.w0.b();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public MemberScope q() {
        return this.f15558e;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    public String toString() {
        return h.k2.v.f0.C("NonFixed: ", this.b);
    }
}
