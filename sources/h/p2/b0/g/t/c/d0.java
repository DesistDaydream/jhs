package h.p2.b0.g.t.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class d0 {
    public static final void a(@k.e.a.d c0 c0Var, @k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d Collection<b0> collection) {
        if (c0Var instanceof e0) {
            ((e0) c0Var).b(cVar, collection);
        } else {
            collection.addAll(c0Var.a(cVar));
        }
    }

    public static final boolean b(@k.e.a.d c0 c0Var, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return c0Var instanceof e0 ? ((e0) c0Var).c(cVar) : c(c0Var, cVar).isEmpty();
    }

    @k.e.a.d
    public static final List<b0> c(@k.e.a.d c0 c0Var, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
        ArrayList arrayList = new ArrayList();
        a(c0Var, cVar, arrayList);
        return arrayList;
    }
}
