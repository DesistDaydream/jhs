package h.p2.b0.g.t.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;

/* loaded from: classes3.dex */
public final class i0 {
    @k.e.a.e
    public static final a a(@k.e.a.d z zVar) {
        c1 L0 = zVar.L0();
        if (L0 instanceof a) {
            return (a) L0;
        }
        return null;
    }

    @k.e.a.e
    public static final f0 b(@k.e.a.d z zVar) {
        a a = a(zVar);
        if (a == null) {
            return null;
        }
        return a.U0();
    }

    public static final boolean c(@k.e.a.d z zVar) {
        return zVar.L0() instanceof j;
    }

    private static final IntersectionTypeConstructor d(IntersectionTypeConstructor intersectionTypeConstructor) {
        z zVar;
        Collection<z> j2 = intersectionTypeConstructor.j();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(j2, 10));
        Iterator<T> it = j2.iterator();
        boolean z = false;
        while (true) {
            zVar = null;
            if (!it.hasNext()) {
                break;
            }
            z zVar2 = (z) it.next();
            if (y0.l(zVar2)) {
                zVar2 = f(zVar2.L0(), false, 1, null);
                z = true;
            }
            arrayList.add(zVar2);
        }
        if (z) {
            z g2 = intersectionTypeConstructor.g();
            if (g2 != null) {
                if (y0.l(g2)) {
                    g2 = f(g2.L0(), false, 1, null);
                }
                zVar = g2;
            }
            return new IntersectionTypeConstructor(arrayList).l(zVar);
        }
        return null;
    }

    @k.e.a.d
    public static final c1 e(@k.e.a.d c1 c1Var, boolean z) {
        j b = j.f15584d.b(c1Var, z);
        if (b == null) {
            f0 g2 = g(c1Var);
            return g2 == null ? c1Var.M0(false) : g2;
        }
        return b;
    }

    public static /* synthetic */ c1 f(c1 c1Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return e(c1Var, z);
    }

    private static final f0 g(z zVar) {
        IntersectionTypeConstructor d2;
        q0 I0 = zVar.I0();
        IntersectionTypeConstructor intersectionTypeConstructor = I0 instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) I0 : null;
        if (intersectionTypeConstructor == null || (d2 = d(intersectionTypeConstructor)) == null) {
            return null;
        }
        return d2.f();
    }

    @k.e.a.d
    public static final f0 h(@k.e.a.d f0 f0Var, boolean z) {
        j b = j.f15584d.b(f0Var, z);
        if (b == null) {
            f0 g2 = g(f0Var);
            return g2 == null ? f0Var.P0(false) : g2;
        }
        return b;
    }

    public static /* synthetic */ f0 i(f0 f0Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return h(f0Var, z);
    }

    @k.e.a.d
    public static final f0 j(@k.e.a.d f0 f0Var, @k.e.a.d f0 f0Var2) {
        return a0.a(f0Var) ? f0Var : new a(f0Var, f0Var2);
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.n.e1.j k(@k.e.a.d h.p2.b0.g.t.n.e1.j jVar) {
        return new h.p2.b0.g.t.n.e1.j(jVar.R0(), jVar.I0(), jVar.T0(), jVar.getAnnotations(), jVar.J0(), true);
    }
}
