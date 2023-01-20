package kotlin.reflect.jvm.internal.impl.resolve;

import h.k2.u.l;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.p.e;
import java.util.Collection;
import java.util.LinkedList;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <H> Collection<H> a(@d Collection<? extends H> collection, @d l<? super H, ? extends a> lVar) {
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        e a = e.f15632c.a();
        while (!linkedList.isEmpty()) {
            Object o2 = CollectionsKt___CollectionsKt.o2(linkedList);
            e a2 = e.f15632c.a();
            Collection<? super H> q = OverridingUtil.q(o2, linkedList, lVar, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(a2));
            if (q.size() == 1 && a2.isEmpty()) {
                a.add(CollectionsKt___CollectionsKt.S4(q));
            } else {
                Object obj = (Object) OverridingUtil.M(q, lVar);
                a invoke = lVar.invoke(obj);
                for (Object obj2 : q) {
                    if (!OverridingUtil.C(invoke, lVar.invoke(obj2))) {
                        a2.add(obj2);
                    }
                }
                if (!a2.isEmpty()) {
                    a.addAll(a2);
                }
                a.add(obj);
            }
        }
        return a;
    }
}
