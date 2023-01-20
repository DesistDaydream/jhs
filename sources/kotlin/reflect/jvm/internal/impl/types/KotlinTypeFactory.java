package kotlin.reflect.jvm.internal.impl.types;

import h.k2.k;
import h.k2.u.l;
import h.p2.b0.g.t.c.d1.s;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.g;
import h.p2.b0.g.t.n.g0;
import h.p2.b0.g.t.n.m0;
import h.p2.b0.g.t.n.n0;
import h.p2.b0.g.t.n.o0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.v;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class KotlinTypeFactory {
    @d
    public static final KotlinTypeFactory a = new KotlinTypeFactory();
    @d
    private static final l<h, f0> b = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;

    /* loaded from: classes3.dex */
    public static final class a {
        @e
        private final f0 a;
        @e
        private final q0 b;

        public a(@e f0 f0Var, @e q0 q0Var) {
            this.a = f0Var;
            this.b = q0Var;
        }

        @e
        public final f0 a() {
            return this.a;
        }

        @e
        public final q0 b() {
            return this.b;
        }
    }

    private KotlinTypeFactory() {
    }

    @k
    @d
    public static final f0 b(@d s0 s0Var, @d List<? extends h.p2.b0.g.t.n.s0> list) {
        return new m0(o0.a.a, false).i(n0.f15590e.a(null, s0Var, list), h.p2.b0.g.t.c.b1.e.w0.b());
    }

    private final MemberScope c(q0 q0Var, List<? extends h.p2.b0.g.t.n.s0> list, h hVar) {
        f c2 = q0Var.c();
        if (c2 instanceof t0) {
            return ((t0) c2).r().q();
        }
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            if (hVar == null) {
                hVar = DescriptorUtilsKt.k(DescriptorUtilsKt.l(c2));
            }
            if (list.isEmpty()) {
                return s.b((h.p2.b0.g.t.c.d) c2, hVar);
            }
            return s.a((h.p2.b0.g.t.c.d) c2, r0.f15601c.b(q0Var, list), hVar);
        } else if (c2 instanceof s0) {
            return h.p2.b0.g.t.n.s.i(h.k2.v.f0.C("Scope for abbreviation: ", ((s0) c2).getName()), true);
        } else {
            if (q0Var instanceof IntersectionTypeConstructor) {
                return ((IntersectionTypeConstructor) q0Var).e();
            }
            throw new IllegalStateException("Unsupported classifier: " + c2 + " for constructor: " + q0Var);
        }
    }

    @k
    @d
    public static final c1 d(@d f0 f0Var, @d f0 f0Var2) {
        return h.k2.v.f0.g(f0Var, f0Var2) ? f0Var : new v(f0Var, f0Var2);
    }

    @k
    @d
    public static final f0 e(@d h.p2.b0.g.t.c.b1.e eVar, @d IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        return j(eVar, integerLiteralTypeConstructor, CollectionsKt__CollectionsKt.E(), z, h.p2.b0.g.t.n.s.i("Scope for integer literal type", true));
    }

    public final a f(q0 q0Var, h hVar, List<? extends h.p2.b0.g.t.n.s0> list) {
        f c2 = q0Var.c();
        f e2 = c2 == null ? null : hVar.e(c2);
        if (e2 == null) {
            return null;
        }
        if (e2 instanceof s0) {
            return new a(b((s0) e2, list), null);
        }
        return new a(null, e2.j().a(hVar));
    }

    @k
    @d
    public static final f0 g(@d h.p2.b0.g.t.c.b1.e eVar, @d h.p2.b0.g.t.c.d dVar, @d List<? extends h.p2.b0.g.t.n.s0> list) {
        return i(eVar, dVar.j(), list, false, null, 16, null);
    }

    @h.k2.h
    @k
    @d
    public static final f0 h(@d h.p2.b0.g.t.c.b1.e eVar, @d q0 q0Var, @d List<? extends h.p2.b0.g.t.n.s0> list, boolean z, @e h hVar) {
        if (eVar.isEmpty() && list.isEmpty() && !z && q0Var.c() != null) {
            return q0Var.c().r();
        }
        return k(eVar, q0Var, list, z, a.c(q0Var, list, hVar), new KotlinTypeFactory$simpleType$1(q0Var, list, eVar, z));
    }

    public static /* synthetic */ f0 i(h.p2.b0.g.t.c.b1.e eVar, q0 q0Var, List list, boolean z, h hVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            hVar = null;
        }
        return h(eVar, q0Var, list, z, hVar);
    }

    @k
    @d
    public static final f0 j(@d h.p2.b0.g.t.c.b1.e eVar, @d q0 q0Var, @d List<? extends h.p2.b0.g.t.n.s0> list, boolean z, @d MemberScope memberScope) {
        g0 g0Var = new g0(q0Var, list, z, memberScope, new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(q0Var, list, eVar, z, memberScope));
        return eVar.isEmpty() ? g0Var : new g(g0Var, eVar);
    }

    @k
    @d
    public static final f0 k(@d h.p2.b0.g.t.c.b1.e eVar, @d q0 q0Var, @d List<? extends h.p2.b0.g.t.n.s0> list, boolean z, @d MemberScope memberScope, @d l<? super h, ? extends f0> lVar) {
        g0 g0Var = new g0(q0Var, list, z, memberScope, lVar);
        return eVar.isEmpty() ? g0Var : new g(g0Var, eVar);
    }
}
