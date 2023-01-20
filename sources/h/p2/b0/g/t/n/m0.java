package h.p2.b0.g.t.n;

import h.p2.b0.g.t.n.o0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class m0 {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f15588c = new a(null);
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final m0 f15589d = new m0(o0.a.a, false);
    @k.e.a.d
    private final o0 a;
    private final boolean b;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i2, h.p2.b0.g.t.c.s0 s0Var) {
            if (i2 > 100) {
                throw new AssertionError(h.k2.v.f0.C("Too deep recursion while expanding type alias ", s0Var.getName()));
            }
        }
    }

    public m0(@k.e.a.d o0 o0Var, boolean z) {
        this.a = o0Var;
        this.b = z;
    }

    private final void a(h.p2.b0.g.t.c.b1.e eVar, h.p2.b0.g.t.c.b1.e eVar2) {
        HashSet hashSet = new HashSet();
        Iterator<h.p2.b0.g.t.c.b1.c> it = eVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().e());
        }
        for (h.p2.b0.g.t.c.b1.c cVar : eVar2) {
            if (hashSet.contains(cVar.e())) {
                this.a.c(cVar);
            }
        }
    }

    private final void b(z zVar, z zVar2) {
        TypeSubstitutor f2 = TypeSubstitutor.f(zVar2);
        int i2 = 0;
        for (Object obj : zVar2.H0()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            s0 s0Var = (s0) obj;
            if (!s0Var.b() && !TypeUtilsKt.d(s0Var.getType())) {
                s0 s0Var2 = zVar.H0().get(i2);
                h.p2.b0.g.t.c.t0 t0Var = zVar.I0().getParameters().get(i2);
                if (this.b) {
                    this.a.a(f2, s0Var2.getType(), s0Var.getType(), t0Var);
                }
            }
            i2 = i3;
        }
    }

    private final p c(p pVar, h.p2.b0.g.t.c.b1.e eVar) {
        return pVar.O0(h(pVar, eVar));
    }

    private final f0 d(f0 f0Var, h.p2.b0.g.t.c.b1.e eVar) {
        return a0.a(f0Var) ? f0Var : w0.f(f0Var, null, h(f0Var, eVar), 1, null);
    }

    private final f0 e(f0 f0Var, z zVar) {
        return y0.r(f0Var, zVar.J0());
    }

    private final f0 f(f0 f0Var, z zVar) {
        return d(e(f0Var, zVar), zVar.getAnnotations());
    }

    private final f0 g(n0 n0Var, h.p2.b0.g.t.c.b1.e eVar, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.j(eVar, n0Var.b().j(), n0Var.a(), z, MemberScope.b.b);
    }

    private final h.p2.b0.g.t.c.b1.e h(z zVar, h.p2.b0.g.t.c.b1.e eVar) {
        return a0.a(zVar) ? zVar.getAnnotations() : h.p2.b0.g.t.c.b1.g.a(eVar, zVar.getAnnotations());
    }

    private final s0 j(s0 s0Var, n0 n0Var, int i2) {
        c1 L0 = s0Var.getType().L0();
        if (q.a(L0)) {
            return s0Var;
        }
        f0 a2 = w0.a(L0);
        if (a0.a(a2) || !TypeUtilsKt.t(a2)) {
            return s0Var;
        }
        q0 I0 = a2.I0();
        h.p2.b0.g.t.c.f c2 = I0.c();
        I0.getParameters().size();
        a2.H0().size();
        if (c2 instanceof h.p2.b0.g.t.c.t0) {
            return s0Var;
        }
        if (c2 instanceof h.p2.b0.g.t.c.s0) {
            h.p2.b0.g.t.c.s0 s0Var2 = (h.p2.b0.g.t.c.s0) c2;
            if (n0Var.d(s0Var2)) {
                this.a.b(s0Var2);
                return new u0(Variance.INVARIANT, s.j(h.k2.v.f0.C("Recursive type alias: ", s0Var2.getName())));
            }
            List<s0> H0 = a2.H0();
            ArrayList arrayList = new ArrayList(h.a2.u.Y(H0, 10));
            int i3 = 0;
            for (Object obj : H0) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                arrayList.add(l((s0) obj, n0Var, I0.getParameters().get(i3), i2 + 1));
                i3 = i4;
            }
            f0 k2 = k(n0.f15590e.a(n0Var, s0Var2, arrayList), a2.getAnnotations(), a2.J0(), i2 + 1, false);
            f0 m2 = m(a2, n0Var, i2);
            if (!q.a(k2)) {
                k2 = i0.j(k2, m2);
            }
            return new u0(s0Var.c(), k2);
        }
        f0 m3 = m(a2, n0Var, i2);
        b(a2, m3);
        return new u0(s0Var.c(), m3);
    }

    private final f0 k(n0 n0Var, h.p2.b0.g.t.c.b1.e eVar, boolean z, int i2, boolean z2) {
        s0 l2 = l(new u0(Variance.INVARIANT, n0Var.b().r0()), n0Var, null, i2);
        f0 a2 = w0.a(l2.getType());
        if (a0.a(a2)) {
            return a2;
        }
        l2.c();
        a(a2.getAnnotations(), eVar);
        f0 r = y0.r(d(a2, eVar), z);
        return z2 ? i0.j(r, g(n0Var, eVar, z)) : r;
    }

    private final s0 l(s0 s0Var, n0 n0Var, h.p2.b0.g.t.c.t0 t0Var, int i2) {
        z f2;
        Variance variance;
        Variance variance2;
        f15588c.b(i2, n0Var.b());
        if (s0Var.b()) {
            return y0.s(t0Var);
        }
        z type = s0Var.getType();
        s0 c2 = n0Var.c(type.I0());
        if (c2 == null) {
            return j(s0Var, n0Var, i2);
        }
        if (c2.b()) {
            return y0.s(t0Var);
        }
        c1 L0 = c2.getType().L0();
        Variance c3 = c2.c();
        Variance c4 = s0Var.c();
        if (c4 != c3 && c4 != (variance2 = Variance.INVARIANT)) {
            if (c3 == variance2) {
                c3 = c4;
            } else {
                this.a.d(n0Var.b(), t0Var, L0);
            }
        }
        Variance o = t0Var == null ? null : t0Var.o();
        if (o == null) {
            o = Variance.INVARIANT;
        }
        if (o != c3 && o != (variance = Variance.INVARIANT)) {
            if (c3 == variance) {
                c3 = variance;
            } else {
                this.a.d(n0Var.b(), t0Var, L0);
            }
        }
        a(type.getAnnotations(), L0.getAnnotations());
        if (L0 instanceof p) {
            f2 = c((p) L0, type.getAnnotations());
        } else {
            f2 = f(w0.a(L0), type);
        }
        return new u0(c3, f2);
    }

    private final f0 m(f0 f0Var, n0 n0Var, int i2) {
        q0 I0 = f0Var.I0();
        List<s0> H0 = f0Var.H0();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(H0, 10));
        int i3 = 0;
        for (Object obj : H0) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            s0 s0Var = (s0) obj;
            s0 l2 = l(s0Var, n0Var, I0.getParameters().get(i3), i2 + 1);
            if (!l2.b()) {
                l2 = new u0(l2.c(), y0.q(l2.getType(), s0Var.getType().J0()));
            }
            arrayList.add(l2);
            i3 = i4;
        }
        return w0.f(f0Var, arrayList, null, 2, null);
    }

    @k.e.a.d
    public final f0 i(@k.e.a.d n0 n0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return k(n0Var, eVar, false, 0, true);
    }
}
