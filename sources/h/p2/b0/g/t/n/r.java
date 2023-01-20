package h.p2.b0.g.t.n;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public class r extends f0 {
    @k.e.a.d
    private final q0 b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final MemberScope f15597c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final List<s0> f15598d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15599e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final String f15600f;

    @h.k2.h
    public r(@k.e.a.d q0 q0Var, @k.e.a.d MemberScope memberScope) {
        this(q0Var, memberScope, null, false, null, 28, null);
    }

    @h.k2.h
    public r(@k.e.a.d q0 q0Var, @k.e.a.d MemberScope memberScope, @k.e.a.d List<? extends s0> list, boolean z) {
        this(q0Var, memberScope, list, z, null, 16, null);
    }

    public /* synthetic */ r(q0 q0Var, MemberScope memberScope, List list, boolean z, String str, int i2, h.k2.v.u uVar) {
        this(q0Var, memberScope, (i2 & 4) != 0 ? CollectionsKt__CollectionsKt.E() : list, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "???" : str);
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return this.f15598d;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public q0 I0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return this.f15599e;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return new r(I0(), q(), H0(), z, null, 16, null);
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: Q0 */
    public f0 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return this;
    }

    @k.e.a.d
    public String R0() {
        return this.f15600f;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: S0 */
    public r N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
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
        return this.f15597c;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(I0());
        sb.append(H0().isEmpty() ? "" : CollectionsKt___CollectionsKt.Y2(H0(), ", ", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, -1, "...", null));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.k2.h
    public r(@k.e.a.d q0 q0Var, @k.e.a.d MemberScope memberScope, @k.e.a.d List<? extends s0> list, boolean z, @k.e.a.d String str) {
        this.b = q0Var;
        this.f15597c = memberScope;
        this.f15598d = list;
        this.f15599e = z;
        this.f15600f = str;
    }
}
