package h.p2.b0.g.t.e.a;

import h.a2.s0;
import h.a2.t0;
import h.a2.u;
import h.p2.b0.g.t.b.g;
import h.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();
    @k.e.a.d
    private static final Map<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.f> b;
    @k.e.a.d

    /* renamed from: c */
    private static final Map<h.p2.b0.g.t.g.f, List<h.p2.b0.g.t.g.f>> f15236c;
    @k.e.a.d

    /* renamed from: d */
    private static final Set<h.p2.b0.g.t.g.c> f15237d;
    @k.e.a.d

    /* renamed from: e */
    private static final Set<h.p2.b0.g.t.g.f> f15238e;

    static {
        h.p2.b0.g.t.g.c d2;
        h.p2.b0.g.t.g.c d3;
        h.p2.b0.g.t.g.c c2;
        h.p2.b0.g.t.g.c c3;
        h.p2.b0.g.t.g.c d4;
        h.p2.b0.g.t.g.c c4;
        h.p2.b0.g.t.g.c c5;
        h.p2.b0.g.t.g.c c6;
        h.p2.b0.g.t.g.d dVar = g.a.s;
        d2 = d.d(dVar, "name");
        d3 = d.d(dVar, "ordinal");
        c2 = d.c(g.a.P, "size");
        h.p2.b0.g.t.g.c cVar = g.a.T;
        c3 = d.c(cVar, "size");
        d4 = d.d(g.a.f15040g, "length");
        c4 = d.c(cVar, "keys");
        c5 = d.c(cVar, "values");
        c6 = d.c(cVar, "entries");
        Map<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.f> W = t0.W(z0.a(d2, h.p2.b0.g.t.g.f.f("name")), z0.a(d3, h.p2.b0.g.t.g.f.f("ordinal")), z0.a(c2, h.p2.b0.g.t.g.f.f("size")), z0.a(c3, h.p2.b0.g.t.g.f.f("size")), z0.a(d4, h.p2.b0.g.t.g.f.f("length")), z0.a(c4, h.p2.b0.g.t.g.f.f("keySet")), z0.a(c5, h.p2.b0.g.t.g.f.f("values")), z0.a(c6, h.p2.b0.g.t.g.f.f("entrySet")));
        b = W;
        Set<Map.Entry<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.f>> entrySet = W.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(u.Y(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((h.p2.b0.g.t.g.c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            h.p2.b0.g.t.g.f fVar = (h.p2.b0.g.t.g.f) pair.getSecond();
            Object obj = linkedHashMap.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(fVar, obj);
            }
            ((List) obj).add((h.p2.b0.g.t.g.f) pair.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(s0.j(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt___CollectionsKt.N1((Iterable) entry2.getValue()));
        }
        f15236c = linkedHashMap2;
        Set<h.p2.b0.g.t.g.c> keySet = b.keySet();
        f15237d = keySet;
        ArrayList arrayList2 = new ArrayList(u.Y(keySet, 10));
        for (h.p2.b0.g.t.g.c cVar2 : keySet) {
            arrayList2.add(cVar2.g());
        }
        f15238e = CollectionsKt___CollectionsKt.N5(arrayList2);
    }

    private c() {
    }

    @k.e.a.d
    public final Map<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.f> a() {
        return b;
    }

    @k.e.a.d
    public final List<h.p2.b0.g.t.g.f> b(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        List<h.p2.b0.g.t.g.f> list = f15236c.get(fVar);
        return list == null ? CollectionsKt__CollectionsKt.E() : list;
    }

    @k.e.a.d
    public final Set<h.p2.b0.g.t.g.c> c() {
        return f15237d;
    }

    @k.e.a.d
    public final Set<h.p2.b0.g.t.g.f> d() {
        return f15238e;
    }
}
