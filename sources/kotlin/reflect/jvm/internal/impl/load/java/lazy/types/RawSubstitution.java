package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.a2.t;
import h.a2.u;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.v0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.z;
import h.t2.y;
import h.z0;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class RawSubstitution extends v0 {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final RawSubstitution f16552c = new RawSubstitution();
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final h.p2.b0.g.t.e.a.v.j.a f16553d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final h.p2.b0.g.t.e.a.v.j.a f16554e;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        f16553d = JavaTypeResolverKt.f(typeUsage, false, null, 3, null).g(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        f16554e = JavaTypeResolverKt.f(typeUsage, false, null, 3, null).g(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    private RawSubstitution() {
    }

    public static /* synthetic */ s0 j(RawSubstitution rawSubstitution, t0 t0Var, h.p2.b0.g.t.e.a.v.j.a aVar, z zVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            zVar = JavaTypeResolverKt.c(t0Var, true, aVar, null, 4, null);
        }
        return rawSubstitution.i(t0Var, aVar, zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<f0, Boolean> k(f0 f0Var, h.p2.b0.g.t.c.d dVar, h.p2.b0.g.t.e.a.v.j.a aVar) {
        Boolean bool = Boolean.FALSE;
        if (f0Var.I0().getParameters().isEmpty()) {
            return z0.a(f0Var, bool);
        }
        if (f.b0(f0Var)) {
            s0 s0Var = f0Var.H0().get(0);
            List k2 = t.k(new u0(s0Var.c(), l(s0Var.getType(), aVar)));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return z0.a(KotlinTypeFactory.i(f0Var.getAnnotations(), f0Var.I0(), k2, f0Var.J0(), null, 16, null), bool);
        } else if (a0.a(f0Var)) {
            return z0.a(s.j(h.k2.v.f0.C("Raw error type: ", f0Var.I0())), bool);
        } else {
            MemberScope o0 = dVar.o0(f16552c);
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
            e annotations = f0Var.getAnnotations();
            q0 j2 = dVar.j();
            List<t0> parameters = dVar.j().getParameters();
            ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
            for (t0 t0Var : parameters) {
                arrayList.add(j(f16552c, t0Var, aVar, null, 4, null));
            }
            return z0.a(KotlinTypeFactory.k(annotations, j2, arrayList, f0Var.J0(), o0, new RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(dVar, f0Var, aVar)), Boolean.TRUE);
        }
    }

    private final z l(z zVar, h.p2.b0.g.t.e.a.v.j.a aVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 instanceof t0) {
            return l(JavaTypeResolverKt.c((t0) c2, true, aVar, null, 4, null), aVar);
        }
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            h.p2.b0.g.t.c.f c3 = x.d(zVar).I0().c();
            if (c3 instanceof h.p2.b0.g.t.c.d) {
                Pair<f0, Boolean> k2 = k(x.c(zVar), (h.p2.b0.g.t.c.d) c2, f16553d);
                f0 component1 = k2.component1();
                boolean booleanValue = k2.component2().booleanValue();
                Pair<f0, Boolean> k3 = k(x.d(zVar), (h.p2.b0.g.t.c.d) c3, f16554e);
                f0 component12 = k3.component1();
                boolean booleanValue2 = k3.component2().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                    return KotlinTypeFactory.d(component1, component12);
                }
                return new RawTypeImpl(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + c3 + "\" while for lower it's \"" + c2 + y.a).toString());
        }
        throw new IllegalStateException(h.k2.v.f0.C("Unexpected declaration kind: ", c2).toString());
    }

    public static /* synthetic */ z m(RawSubstitution rawSubstitution, z zVar, h.p2.b0.g.t.e.a.v.j.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = new h.p2.b0.g.t.e.a.v.j.a(TypeUsage.COMMON, null, false, null, 14, null);
        }
        return rawSubstitution.l(zVar, aVar);
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean f() {
        return false;
    }

    @d
    public final s0 i(@d t0 t0Var, @d h.p2.b0.g.t.e.a.v.j.a aVar, @d z zVar) {
        int i2 = a.a[aVar.c().ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!t0Var.o().getAllowsOutPosition()) {
                return new u0(Variance.INVARIANT, DescriptorUtilsKt.g(t0Var).H());
            }
            if (!zVar.I0().getParameters().isEmpty()) {
                return new u0(Variance.OUT_VARIANCE, zVar);
            }
            return JavaTypeResolverKt.d(t0Var, aVar);
        }
        return new u0(Variance.INVARIANT, zVar);
    }

    @Override // h.p2.b0.g.t.n.v0
    @d
    /* renamed from: n */
    public u0 e(@d z zVar) {
        return new u0(m(this, zVar, null, 2, null));
    }
}
