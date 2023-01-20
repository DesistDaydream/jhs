package h.p2.b0.g.t.k.m.a;

import h.k2.v.u;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class a extends f0 implements h.p2.b0.g.t.n.g1.b {
    @d
    private final s0 b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final b f15472c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15473d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e f15474e;

    public /* synthetic */ a(s0 s0Var, b bVar, boolean z, e eVar, int i2, u uVar) {
        this(s0Var, (i2 & 2) != 0 ? new c(s0Var) : bVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? e.w0.b() : eVar);
    }

    @Override // h.p2.b0.g.t.n.z
    @d
    public List<s0> H0() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return this.f15473d;
    }

    @Override // h.p2.b0.g.t.n.z
    @d
    /* renamed from: R0 */
    public b I0() {
        return this.f15472c;
    }

    @Override // h.p2.b0.g.t.n.f0
    @d
    /* renamed from: S0 */
    public a P0(boolean z) {
        return z == J0() ? this : new a(this.b, I0(), z, getAnnotations());
    }

    @Override // h.p2.b0.g.t.n.c1
    @d
    /* renamed from: T0 */
    public a N0(@d h hVar) {
        return new a(this.b.a(hVar), I0(), J0(), getAnnotations());
    }

    @Override // h.p2.b0.g.t.n.f0
    @d
    /* renamed from: U0 */
    public a Q0(@d e eVar) {
        return new a(this.b, I0(), J0(), eVar);
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @d
    public e getAnnotations() {
        return this.f15474e;
    }

    @Override // h.p2.b0.g.t.n.z
    @d
    public MemberScope q() {
        return s.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    }

    @Override // h.p2.b0.g.t.n.f0
    @d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(J0() ? "?" : "");
        return sb.toString();
    }

    public a(@d s0 s0Var, @d b bVar, boolean z, @d e eVar) {
        this.b = s0Var;
        this.f15472c = bVar;
        this.f15473d = z;
        this.f15474e = eVar;
    }
}
