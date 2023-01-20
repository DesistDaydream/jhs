package h.p2.b0.g.t.k.p;

import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class b {
    private static final boolean a(h.p2.b0.g.t.c.d dVar) {
        return f0.g(DescriptorUtilsKt.i(dVar), g.f15032j);
    }

    public static final boolean b(@k.e.a.d k kVar) {
        return h.p2.b0.g.t.k.d.b(kVar) && !a((h.p2.b0.g.t.c.d) kVar);
    }

    public static final boolean c(@k.e.a.d z zVar) {
        f c2 = zVar.I0().c();
        return f0.g(c2 == null ? null : Boolean.valueOf(b(c2)), Boolean.TRUE);
    }

    private static final boolean d(z zVar) {
        f c2 = zVar.I0().c();
        t0 t0Var = c2 instanceof t0 ? (t0) c2 : null;
        if (t0Var == null) {
            return false;
        }
        return e(TypeUtilsKt.i(t0Var));
    }

    private static final boolean e(z zVar) {
        return c(zVar) || d(zVar);
    }

    public static final boolean f(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        h.p2.b0.g.t.c.c cVar = callableMemberDescriptor instanceof h.p2.b0.g.t.c.c ? (h.p2.b0.g.t.c.c) callableMemberDescriptor : null;
        if (cVar == null || r.g(cVar.getVisibility()) || h.p2.b0.g.t.k.d.b(cVar.c0()) || h.p2.b0.g.t.k.c.G(cVar.c0())) {
            return false;
        }
        List<v0> h2 = cVar.h();
        if ((h2 instanceof Collection) && h2.isEmpty()) {
            return false;
        }
        for (v0 v0Var : h2) {
            if (e(v0Var.getType())) {
                return true;
            }
        }
        return false;
    }
}
