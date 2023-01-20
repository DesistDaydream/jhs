package h.p2.b0.g.t.p;

import h.a2.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class a {
    public static final <T> void a(@k.e.a.d Collection<T> collection, @k.e.a.e T t) {
        if (t != null) {
            collection.add(t);
        }
    }

    private static final int b(int i2) {
        if (i2 < 3) {
            return 3;
        }
        return i2 + (i2 / 3) + 1;
    }

    @k.e.a.d
    public static final <T> List<T> c(@k.e.a.d ArrayList<T> arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                arrayList.trimToSize();
                return arrayList;
            }
            return t.k(CollectionsKt___CollectionsKt.o2(arrayList));
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @k.e.a.d
    public static final <K> Map<K, Integer> d(@k.e.a.d Iterable<? extends K> iterable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        for (K k2 : iterable) {
            linkedHashMap.put(k2, Integer.valueOf(i2));
            i2++;
        }
        return linkedHashMap;
    }

    @k.e.a.d
    public static final <K, V> HashMap<K, V> e(int i2) {
        return new HashMap<>(b(i2));
    }

    @k.e.a.d
    public static final <E> HashSet<E> f(int i2) {
        return new HashSet<>(b(i2));
    }

    @k.e.a.d
    public static final <E> LinkedHashSet<E> g(int i2) {
        return new LinkedHashSet<>(b(i2));
    }
}
