package h.p2.b0.g.t.e.a;

import h.p2.b0.g.t.b.g;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final g a;
    @k.e.a.d
    private static final HashMap<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.c> b;

    static {
        g gVar = new g();
        a = gVar;
        b = new HashMap<>();
        gVar.c(g.a.Y, gVar.a("java.util.ArrayList", "java.util.LinkedList"));
        gVar.c(g.a.a0, gVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        gVar.c(g.a.b0, gVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        gVar.c(new h.p2.b0.g.t.g.c("java.util.function.Function"), gVar.a("java.util.function.UnaryOperator"));
        gVar.c(new h.p2.b0.g.t.g.c("java.util.function.BiFunction"), gVar.a("java.util.function.BinaryOperator"));
    }

    private g() {
    }

    private final List<h.p2.b0.g.t.g.c> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new h.p2.b0.g.t.g.c(str));
        }
        return arrayList;
    }

    private final void c(h.p2.b0.g.t.g.c cVar, List<h.p2.b0.g.t.g.c> list) {
        AbstractMap abstractMap = b;
        for (Object obj : list) {
            h.p2.b0.g.t.g.c cVar2 = (h.p2.b0.g.t.g.c) obj;
            abstractMap.put(obj, cVar);
        }
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.c b(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return b.get(cVar);
    }
}
