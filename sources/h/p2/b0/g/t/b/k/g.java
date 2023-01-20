package h.p2.b0.g.t.b.k;

import h.a2.u;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.r0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final r0 a(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.c.d dVar2) {
        dVar.s().size();
        dVar2.s().size();
        r0.a aVar = r0.f15601c;
        List<t0> s = dVar.s();
        ArrayList arrayList = new ArrayList(u.Y(s, 10));
        for (t0 t0Var : s) {
            arrayList.add(t0Var.j());
        }
        List<t0> s2 = dVar2.s();
        ArrayList arrayList2 = new ArrayList(u.Y(s2, 10));
        for (t0 t0Var2 : s2) {
            arrayList2.add(TypeUtilsKt.a(t0Var2.r()));
        }
        return r0.a.e(aVar, h.a2.t0.B0(CollectionsKt___CollectionsKt.V5(arrayList, arrayList2)), false, 2, null);
    }
}
