package h.p2.b0.g.t.e.b;

import h.k2.v.f0;
import h.p2.b0.g.t.b.k.c;
import h.p2.b0.g.t.n.x0;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class w {
    @k.e.a.d
    public static final <T> T a(@k.e.a.d i<T> iVar, @k.e.a.d T t, boolean z) {
        return z ? iVar.b(t) : t;
    }

    @k.e.a.e
    public static final <T> T b(@k.e.a.d x0 x0Var, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, @k.e.a.d i<T> iVar, @k.e.a.d v vVar) {
        h.p2.b0.g.t.n.g1.m S = x0Var.S(gVar);
        if (x0Var.e0(S)) {
            PrimitiveType B = x0Var.B(S);
            boolean z = true;
            if (B != null) {
                T c2 = iVar.c(B);
                if (!x0Var.E(gVar) && !h.p2.b0.g.t.e.a.y.m.b(x0Var, gVar)) {
                    z = false;
                }
                return (T) a(iVar, c2, z);
            }
            PrimitiveType L = x0Var.L(S);
            if (L != null) {
                return iVar.a(f0.C("[", JvmPrimitiveType.get(L).getDesc()));
            }
            if (x0Var.f(S)) {
                h.p2.b0.g.t.g.d X = x0Var.X(S);
                h.p2.b0.g.t.g.b o = X == null ? null : h.p2.b0.g.t.b.k.c.a.o(X);
                if (o != null) {
                    if (!vVar.a()) {
                        List<c.a> j2 = h.p2.b0.g.t.b.k.c.a.j();
                        if (!(j2 instanceof Collection) || !j2.isEmpty()) {
                            for (c.a aVar : j2) {
                                if (f0.g(aVar.d(), o)) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            return null;
                        }
                    }
                    return iVar.e(h.p2.b0.g.t.k.p.d.b(o).f());
                }
            }
            return null;
        }
        return null;
    }
}
