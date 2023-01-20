package h.p2.b0.g.t.n;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class n0 {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15590e = new a(null);
    @k.e.a.e
    private final n0 a;
    @k.e.a.d
    private final h.p2.b0.g.t.c.s0 b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final List<s0> f15591c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final Map<h.p2.b0.g.t.c.t0, s0> f15592d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final n0 a(@k.e.a.e n0 n0Var, @k.e.a.d h.p2.b0.g.t.c.s0 s0Var, @k.e.a.d List<? extends s0> list) {
            List<h.p2.b0.g.t.c.t0> parameters = s0Var.j().getParameters();
            ArrayList arrayList = new ArrayList(h.a2.u.Y(parameters, 10));
            for (h.p2.b0.g.t.c.t0 t0Var : parameters) {
                arrayList.add(t0Var.a());
            }
            return new n0(n0Var, s0Var, list, h.a2.t0.B0(CollectionsKt___CollectionsKt.V5(arrayList, list)), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n0(n0 n0Var, h.p2.b0.g.t.c.s0 s0Var, List<? extends s0> list, Map<h.p2.b0.g.t.c.t0, ? extends s0> map) {
        this.a = n0Var;
        this.b = s0Var;
        this.f15591c = list;
        this.f15592d = map;
    }

    public /* synthetic */ n0(n0 n0Var, h.p2.b0.g.t.c.s0 s0Var, List list, Map map, h.k2.v.u uVar) {
        this(n0Var, s0Var, list, map);
    }

    @k.e.a.d
    public final List<s0> a() {
        return this.f15591c;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.s0 b() {
        return this.b;
    }

    @k.e.a.e
    public final s0 c(@k.e.a.d q0 q0Var) {
        h.p2.b0.g.t.c.f c2 = q0Var.c();
        if (c2 instanceof h.p2.b0.g.t.c.t0) {
            return this.f15592d.get(c2);
        }
        return null;
    }

    public final boolean d(@k.e.a.d h.p2.b0.g.t.c.s0 s0Var) {
        if (!h.k2.v.f0.g(this.b, s0Var)) {
            n0 n0Var = this.a;
            if (!(n0Var == null ? false : n0Var.d(s0Var))) {
                return false;
            }
        }
        return true;
    }
}
