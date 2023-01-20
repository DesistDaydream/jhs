package kotlin.reflect.jvm.internal.impl.builtins;

import h.a2.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class CompanionObjectMapping {
    @d
    public static final CompanionObjectMapping a = new CompanionObjectMapping();
    @d
    private static final Set<b> b;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        CompanionObjectMapping$classIds$1 companionObjectMapping$classIds$1 = new CompanionObjectMapping$classIds$1(g.a);
        ArrayList arrayList = new ArrayList(u.Y(set, 10));
        for (Object obj : set) {
            arrayList.add(companionObjectMapping$classIds$1.invoke((CompanionObjectMapping$classIds$1) obj));
        }
        List<c> r4 = CollectionsKt___CollectionsKt.r4(CollectionsKt___CollectionsKt.r4(CollectionsKt___CollectionsKt.r4(arrayList, g.a.f15041h.l()), g.a.f15043j.l()), g.a.s.l());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c cVar : r4) {
            linkedHashSet.add(b.m(cVar));
        }
        b = linkedHashSet;
    }

    private CompanionObjectMapping() {
    }

    @d
    public final Set<b> a() {
        return b;
    }

    @d
    public final Set<b> b() {
        return b;
    }
}
