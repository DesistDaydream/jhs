package h.p2.b0.g.t.n;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;

/* loaded from: classes3.dex */
public final class w0 {
    @k.e.a.d
    public static final f0 a(@k.e.a.d z zVar) {
        c1 L0 = zVar.L0();
        f0 f0Var = L0 instanceof f0 ? (f0) L0 : null;
        if (f0Var != null) {
            return f0Var;
        }
        throw new IllegalStateException(h.k2.v.f0.C("This is should be simple type: ", zVar).toString());
    }

    @h.k2.h
    @k.e.a.d
    public static final z b(@k.e.a.d z zVar, @k.e.a.d List<? extends s0> list, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return e(zVar, list, eVar, null, 4, null);
    }

    @h.k2.h
    @k.e.a.d
    public static final z c(@k.e.a.d z zVar, @k.e.a.d List<? extends s0> list, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d List<? extends s0> list2) {
        if ((list.isEmpty() || list == zVar.H0()) && eVar == zVar.getAnnotations()) {
            return zVar;
        }
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            u uVar = (u) L0;
            return KotlinTypeFactory.d(d(uVar.Q0(), list, eVar), d(uVar.R0(), list2, eVar));
        } else if (L0 instanceof f0) {
            return d((f0) L0, list, eVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @h.k2.h
    @k.e.a.d
    public static final f0 d(@k.e.a.d f0 f0Var, @k.e.a.d List<? extends s0> list, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (list.isEmpty() && eVar == f0Var.getAnnotations()) {
            return f0Var;
        }
        if (list.isEmpty()) {
            return f0Var.Q0(eVar);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.i(eVar, f0Var.I0(), list, f0Var.J0(), null, 16, null);
    }

    public static /* synthetic */ z e(z zVar, List list, h.p2.b0.g.t.c.b1.e eVar, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = zVar.H0();
        }
        if ((i2 & 2) != 0) {
            eVar = zVar.getAnnotations();
        }
        if ((i2 & 4) != 0) {
            list2 = list;
        }
        return c(zVar, list, eVar, list2);
    }

    public static /* synthetic */ f0 f(f0 f0Var, List list, h.p2.b0.g.t.c.b1.e eVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = f0Var.H0();
        }
        if ((i2 & 2) != 0) {
            eVar = f0Var.getAnnotations();
        }
        return d(f0Var, list, eVar);
    }
}
