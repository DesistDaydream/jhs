package h.p2.b0.g.t.n;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public abstract class r0 extends v0 {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f15601c = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: h.p2.b0.g.t.n.r0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0470a extends r0 {

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Map<q0, s0> f15602d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f15603e;

            /* JADX WARN: Multi-variable type inference failed */
            public C0470a(Map<q0, ? extends s0> map, boolean z) {
                this.f15602d = map;
                this.f15603e = z;
            }

            @Override // h.p2.b0.g.t.n.v0
            public boolean a() {
                return this.f15603e;
            }

            @Override // h.p2.b0.g.t.n.v0
            public boolean f() {
                return this.f15602d.isEmpty();
            }

            @Override // h.p2.b0.g.t.n.r0
            @k.e.a.e
            public s0 j(@k.e.a.d q0 q0Var) {
                return this.f15602d.get(q0Var);
            }
        }

        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        public static /* synthetic */ r0 e(a aVar, Map map, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return aVar.d(map, z);
        }

        @h.k2.k
        @k.e.a.d
        public final v0 a(@k.e.a.d z zVar) {
            return b(zVar.I0(), zVar.H0());
        }

        @h.k2.k
        @k.e.a.d
        public final v0 b(@k.e.a.d q0 q0Var, @k.e.a.d List<? extends s0> list) {
            List<h.p2.b0.g.t.c.t0> parameters = q0Var.getParameters();
            h.p2.b0.g.t.c.t0 t0Var = (h.p2.b0.g.t.c.t0) CollectionsKt___CollectionsKt.i3(parameters);
            if (h.k2.v.f0.g(t0Var == null ? null : Boolean.valueOf(t0Var.S()), Boolean.TRUE)) {
                List<h.p2.b0.g.t.c.t0> parameters2 = q0Var.getParameters();
                ArrayList arrayList = new ArrayList(h.a2.u.Y(parameters2, 10));
                for (h.p2.b0.g.t.c.t0 t0Var2 : parameters2) {
                    arrayList.add(t0Var2.j());
                }
                return e(this, h.a2.t0.B0(CollectionsKt___CollectionsKt.V5(arrayList, list)), false, 2, null);
            }
            return new y(parameters, list);
        }

        @h.k2.h
        @h.k2.k
        @k.e.a.d
        public final r0 c(@k.e.a.d Map<q0, ? extends s0> map) {
            return e(this, map, false, 2, null);
        }

        @h.k2.h
        @h.k2.k
        @k.e.a.d
        public final r0 d(@k.e.a.d Map<q0, ? extends s0> map, boolean z) {
            return new C0470a(map, z);
        }
    }

    @h.k2.k
    @k.e.a.d
    public static final v0 h(@k.e.a.d q0 q0Var, @k.e.a.d List<? extends s0> list) {
        return f15601c.b(q0Var, list);
    }

    @h.k2.h
    @h.k2.k
    @k.e.a.d
    public static final r0 i(@k.e.a.d Map<q0, ? extends s0> map) {
        return f15601c.c(map);
    }

    @Override // h.p2.b0.g.t.n.v0
    @k.e.a.e
    public s0 e(@k.e.a.d z zVar) {
        return j(zVar.I0());
    }

    @k.e.a.e
    public abstract s0 j(@k.e.a.d q0 q0Var);
}
