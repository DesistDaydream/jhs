package h.p2.b0.g.t.o.k;

import java.util.Collection;
import java.util.LinkedHashSet;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @e
    public static final <T> Collection<T> a(@e Collection<? extends T> collection, @d Collection<? extends T> collection2) {
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    @d
    public static final h.p2.b0.g.t.p.d<MemberScope> b(@d Iterable<? extends MemberScope> iterable) {
        h.p2.b0.g.t.p.d<MemberScope> dVar = new h.p2.b0.g.t.p.d<>();
        for (MemberScope memberScope : iterable) {
            MemberScope memberScope2 = memberScope;
            if ((memberScope2 == null || memberScope2 == MemberScope.b.b) ? false : true) {
                dVar.add(memberScope);
            }
        }
        return dVar;
    }
}
