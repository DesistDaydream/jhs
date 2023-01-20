package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;

/* loaded from: classes3.dex */
public final class e {
    @k.e.a.d
    public static final c1 a(@k.e.a.d List<? extends c1> list) {
        f0 Q0;
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                ArrayList arrayList = new ArrayList(h.a2.u.Y(list, 10));
                boolean z = false;
                boolean z2 = false;
                for (c1 c1Var : list) {
                    z = z || a0.a(c1Var);
                    if (c1Var instanceof f0) {
                        Q0 = (f0) c1Var;
                    } else if (c1Var instanceof h.p2.b0.g.t.n.u) {
                        if (h.p2.b0.g.t.n.q.a(c1Var)) {
                            return c1Var;
                        }
                        Q0 = ((h.p2.b0.g.t.n.u) c1Var).Q0();
                        z2 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(Q0);
                }
                if (z) {
                    return h.p2.b0.g.t.n.s.j(h.k2.v.f0.C("Intersection of error types: ", list));
                }
                if (!z2) {
                    return TypeIntersector.a.c(arrayList);
                }
                ArrayList arrayList2 = new ArrayList(h.a2.u.Y(list, 10));
                for (c1 c1Var2 : list) {
                    arrayList2.add(x.d(c1Var2));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                TypeIntersector typeIntersector = TypeIntersector.a;
                return KotlinTypeFactory.d(typeIntersector.c(arrayList), typeIntersector.c(arrayList2));
            }
            return (c1) CollectionsKt___CollectionsKt.U4(list);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
