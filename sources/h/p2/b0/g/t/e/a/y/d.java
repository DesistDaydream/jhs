package h.p2.b0.g.t.e.a.y;

import h.a2.u;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.i0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    private final h.p2.b0.g.t.e.a.v.c a;

    /* loaded from: classes3.dex */
    public static class a {
        @k.e.a.d
        private final z a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15293c;

        public a(@k.e.a.d z zVar, int i2, boolean z) {
            this.a = zVar;
            this.b = i2;
            this.f15293c = z;
        }

        public final int a() {
            return this.b;
        }

        @k.e.a.e
        public final z b() {
            z type = getType();
            if (c()) {
                return type;
            }
            return null;
        }

        public final boolean c() {
            return this.f15293c;
        }

        @k.e.a.d
        public z getType() {
            return this.a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends a {
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final f0 f15294d;

        public b(@k.e.a.d f0 f0Var, int i2, boolean z) {
            super(f0Var, i2, z);
            this.f15294d = f0Var;
        }

        @Override // h.p2.b0.g.t.e.a.y.d.a
        @k.e.a.d
        public f0 getType() {
            return this.f15294d;
        }
    }

    public d(@k.e.a.d h.p2.b0.g.t.e.a.v.c cVar) {
        this.a = cVar;
    }

    private final z a(z zVar, z zVar2) {
        z a2 = a1.a(zVar2);
        z a3 = a1.a(zVar);
        if (a3 == null) {
            if (a2 == null) {
                return null;
            }
            a3 = a2;
        }
        if (a2 == null) {
            return a3;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.d(x.c(a3), x.d(a2));
    }

    private final b c(f0 f0Var, h.k2.u.l<? super Integer, e> lVar, int i2, TypeComponentPosition typeComponentPosition, boolean z) {
        c e2;
        c h2;
        h.p2.b0.g.t.c.b1.e d2;
        s0 e3;
        if (l.a(typeComponentPosition) || !f0Var.H0().isEmpty()) {
            h.p2.b0.g.t.c.f c2 = f0Var.I0().c();
            if (c2 == null) {
                return new b(f0Var, 1, false);
            }
            e invoke = lVar.invoke(Integer.valueOf(i2));
            e2 = o.e(c2, invoke, typeComponentPosition);
            h.p2.b0.g.t.c.f fVar = (h.p2.b0.g.t.c.f) e2.a();
            h.p2.b0.g.t.c.b1.e b2 = e2.b();
            q0 j2 = fVar.j();
            int i3 = i2 + 1;
            boolean z2 = b2 != null;
            List<s0> H0 = f0Var.H0();
            ArrayList arrayList = new ArrayList(u.Y(H0, 10));
            int i4 = 0;
            for (Object obj : H0) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                s0 s0Var = (s0) obj;
                if (s0Var.b()) {
                    i3++;
                    if (lVar.invoke(Integer.valueOf(i3)).c() == NullabilityQualifier.NOT_NULL && !z) {
                        e3 = TypeUtilsKt.e(TypeUtilsKt.o(s0Var.getType().L0()), s0Var.c(), j2.getParameters().get(i4));
                    } else {
                        e3 = y0.s(fVar.j().getParameters().get(i4));
                    }
                } else {
                    a e4 = e(s0Var.getType().L0(), lVar, i3);
                    boolean z3 = z2 || e4.c();
                    i3 += e4.a();
                    e3 = TypeUtilsKt.e(e4.getType(), s0Var.c(), j2.getParameters().get(i4));
                    z2 = z3;
                }
                arrayList.add(e3);
                i4 = i5;
            }
            h2 = o.h(f0Var, invoke, typeComponentPosition);
            boolean booleanValue = ((Boolean) h2.a()).booleanValue();
            h.p2.b0.g.t.c.b1.e b3 = h2.b();
            int i6 = i3 - i2;
            if (z2 || b3 != null) {
                boolean z4 = false;
                d2 = o.d(CollectionsKt__CollectionsKt.N(f0Var.getAnnotations(), b2, b3));
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                f0 i7 = KotlinTypeFactory.i(d2, j2, arrayList, booleanValue, null, 16, null);
                c1 c1Var = i7;
                if (invoke.d()) {
                    c1Var = f(i7);
                }
                if (b3 != null && invoke.e()) {
                    z4 = true;
                }
                if (z4) {
                    c1Var = a1.d(f0Var, c1Var);
                }
                return new b((f0) c1Var, i6, true);
            }
            return new b(f0Var, i6, false);
        }
        return new b(f0Var, 1, false);
    }

    public static /* synthetic */ b d(d dVar, f0 f0Var, h.k2.u.l lVar, int i2, TypeComponentPosition typeComponentPosition, boolean z, int i3, Object obj) {
        return dVar.c(f0Var, lVar, i2, typeComponentPosition, (i3 & 8) != 0 ? false : z);
    }

    private final a e(c1 c1Var, h.k2.u.l<? super Integer, e> lVar, int i2) {
        c1 d2;
        boolean z = false;
        if (a0.a(c1Var)) {
            return new a(c1Var, 1, false);
        }
        if (c1Var instanceof h.p2.b0.g.t.n.u) {
            boolean z2 = c1Var instanceof e0;
            h.p2.b0.g.t.n.u uVar = (h.p2.b0.g.t.n.u) c1Var;
            b c2 = c(uVar.Q0(), lVar, i2, TypeComponentPosition.FLEXIBLE_LOWER, z2);
            b c3 = c(uVar.R0(), lVar, i2, TypeComponentPosition.FLEXIBLE_UPPER, z2);
            c2.a();
            c3.a();
            z = (c2.c() || c3.c()) ? true : true;
            z a2 = a(c2.getType(), c3.getType());
            if (z) {
                if (c1Var instanceof RawTypeImpl) {
                    d2 = new RawTypeImpl(c2.getType(), c3.getType());
                } else {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                    d2 = KotlinTypeFactory.d(c2.getType(), c3.getType());
                }
                c1Var = a1.d(d2, a2);
            }
            return new a(c1Var, c2.a(), z);
        } else if (c1Var instanceof f0) {
            return d(this, (f0) c1Var, lVar, i2, TypeComponentPosition.INFLEXIBLE, false, 8, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final f0 f(f0 f0Var) {
        if (this.a.a()) {
            return i0.h(f0Var, true);
        }
        return new f(f0Var);
    }

    @k.e.a.e
    public final z b(@k.e.a.d z zVar, @k.e.a.d h.k2.u.l<? super Integer, e> lVar) {
        return e(zVar.L0(), lVar, 0).b();
    }
}
