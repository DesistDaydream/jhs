package h.p2.b0.g.t.n.e1;

import h.k2.v.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* loaded from: classes3.dex */
public final class w {
    private static final z a(z zVar) {
        return CapturedTypeApproximationKt.a(zVar).d();
    }

    private static final String b(q0 q0Var) {
        StringBuilder sb = new StringBuilder();
        c(f0.C("type: ", q0Var), sb);
        c(f0.C("hashCode: ", Integer.valueOf(q0Var.hashCode())), sb);
        c(f0.C("javaClass: ", q0Var.getClass().getCanonicalName()), sb);
        for (h.p2.b0.g.t.c.k c2 = q0Var.c(); c2 != null; c2 = c2.b()) {
            c(f0.C("fqName: ", DescriptorRenderer.f16750g.s(c2)), sb);
            c(f0.C("javaClass: ", c2.getClass().getCanonicalName()), sb);
        }
        return sb.toString();
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    @k.e.a.e
    public static final z d(@k.e.a.d z zVar, @k.e.a.d z zVar2, @k.e.a.d v vVar) {
        boolean z;
        boolean z2;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(zVar, null));
        q0 I0 = zVar2.I0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            z type = sVar.getType();
            q0 I02 = type.I0();
            if (vVar.a(I02, I0)) {
                boolean J0 = type.J0();
                for (s a = sVar.a(); a != null; a = a.a()) {
                    z type2 = a.getType();
                    List<s0> H0 = type2.H0();
                    if (!(H0 instanceof Collection) || !H0.isEmpty()) {
                        for (s0 s0Var : H0) {
                            if (s0Var.c() != Variance.INVARIANT) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        type = a(CapturedTypeConstructorKt.f(r0.f15601c.a(type2), false, 1, null).c().n(type, Variance.INVARIANT));
                    } else {
                        type = r0.f15601c.a(type2).c().n(type, Variance.INVARIANT);
                    }
                    J0 = J0 || type2.J0();
                }
                q0 I03 = type.I0();
                if (vVar.a(I03, I0)) {
                    return y0.p(type, J0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(I03) + ", \n\nsupertype: " + b(I0) + " \n" + vVar.a(I03, I0));
            }
            for (z zVar3 : I02.j()) {
                arrayDeque.add(new s(zVar3, sVar));
            }
        }
        return null;
    }
}
