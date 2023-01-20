package h.p2.b0.g.t.n;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class n {
    private static /* synthetic */ void a(int i2) {
        String str = i2 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 4 ? 3 : 2];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i2 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i2 == 4) {
            throw new IllegalStateException(format);
        }
    }

    @k.e.a.d
    public static TypeSubstitutor b(@k.e.a.d List<h.p2.b0.g.t.c.t0> list, @k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d List<h.p2.b0.g.t.c.t0> list2) {
        if (list == null) {
            a(0);
        }
        if (v0Var == null) {
            a(1);
        }
        if (kVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        TypeSubstitutor c2 = c(list, v0Var, kVar, list2, null);
        if (c2 != null) {
            if (c2 == null) {
                a(4);
            }
            return c2;
        }
        throw new AssertionError("Substitution failed");
    }

    @k.e.a.e
    public static TypeSubstitutor c(@k.e.a.d List<h.p2.b0.g.t.c.t0> list, @k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d List<h.p2.b0.g.t.c.t0> list2, @k.e.a.e boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (v0Var == null) {
            a(6);
        }
        if (kVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i2 = 0;
        for (h.p2.b0.g.t.c.t0 t0Var : list) {
            h.p2.b0.g.t.c.d1.g0 M0 = h.p2.b0.g.t.c.d1.g0.M0(kVar, t0Var.getAnnotations(), t0Var.l(), t0Var.o(), t0Var.getName(), i2, h.p2.b0.g.t.c.o0.a, t0Var.N());
            hashMap.put(t0Var.j(), new u0(M0.r()));
            hashMap2.put(t0Var, M0);
            list2.add(M0);
            i2++;
        }
        TypeSubstitutor h2 = TypeSubstitutor.h(v0Var, r0.i(hashMap));
        for (h.p2.b0.g.t.c.t0 t0Var2 : list) {
            h.p2.b0.g.t.c.d1.g0 g0Var = (h.p2.b0.g.t.c.d1.g0) hashMap2.get(t0Var2);
            for (z zVar : t0Var2.getUpperBounds()) {
                z p = h2.p(zVar, Variance.IN_VARIANCE);
                if (p == null) {
                    return null;
                }
                if (p != zVar && zArr != null) {
                    zArr[0] = true;
                }
                g0Var.I0(p);
            }
            g0Var.Q0();
        }
        return h2;
    }
}
