package h.p2.b0.g.t;

import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class a {
    @d
    public static final a a = new a();
    @d
    private static final Set<b> b;

    static {
        List<c> L = CollectionsKt__CollectionsKt.L(p.a, p.f15250i, p.f15251j, p.f15245d, p.f15246e, p.f15248g);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c cVar : L) {
            linkedHashSet.add(b.m(cVar));
        }
        b = linkedHashSet;
    }

    private a() {
    }

    @d
    public final Set<b> a() {
        return b;
    }
}
