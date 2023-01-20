package e.j.a.b.c.x;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class h {
    private h() {
    }

    @e.j.a.b.c.m.a
    public static boolean a(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> List<T> b() {
        return Collections.emptyList();
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> List<T> c(T t) {
        return Collections.singletonList(t);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> List<T> d(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return Collections.unmodifiableList(Arrays.asList(tArr));
            }
            return c(tArr[0]);
        }
        return b();
    }

    @e.j.a.b.c.m.a
    public static <K, V> Map<K, V> e(K k2, V v, K k3, V v2, K k4, V v3) {
        Map l2 = l(3, false);
        l2.put(k2, v);
        l2.put(k3, v2);
        l2.put(k4, v3);
        return Collections.unmodifiableMap(l2);
    }

    @e.j.a.b.c.m.a
    public static <K, V> Map<K, V> f(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        Map l2 = l(6, false);
        l2.put(k2, v);
        l2.put(k3, v2);
        l2.put(k4, v3);
        l2.put(k5, v4);
        l2.put(k6, v5);
        l2.put(k7, v6);
        return Collections.unmodifiableMap(l2);
    }

    @e.j.a.b.c.m.a
    public static <K, V> Map<K, V> g(K[] kArr, V[] vArr) {
        if (kArr.length == vArr.length) {
            int length = kArr.length;
            if (length != 0) {
                if (length != 1) {
                    Map l2 = l(kArr.length, false);
                    for (int i2 = 0; i2 < kArr.length; i2++) {
                        l2.put(kArr[i2], vArr[i2]);
                    }
                    return Collections.unmodifiableMap(l2);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.emptyMap();
        }
        int length2 = kArr.length;
        int length3 = vArr.length;
        StringBuilder sb = new StringBuilder(66);
        sb.append("Key and values array lengths not equal: ");
        sb.append(length2);
        sb.append(" != ");
        sb.append(length3);
        throw new IllegalArgumentException(sb.toString());
    }

    @e.j.a.b.c.m.a
    public static <T> Set<T> h(int i2) {
        if (i2 == 0) {
            return new ArraySet();
        }
        return k(i2, true);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> Set<T> i(T t, T t2, T t3) {
        Set k2 = k(3, false);
        k2.add(t);
        k2.add(t2);
        k2.add(t3);
        return Collections.unmodifiableSet(k2);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> Set<T> j(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2) {
                    T t = tArr[0];
                    T t2 = tArr[1];
                    Set k2 = k(2, false);
                    k2.add(t);
                    k2.add(t2);
                    return Collections.unmodifiableSet(k2);
                } else if (length != 3) {
                    if (length != 4) {
                        Set k3 = k(tArr.length, false);
                        Collections.addAll(k3, tArr);
                        return Collections.unmodifiableSet(k3);
                    }
                    T t3 = tArr[0];
                    T t4 = tArr[1];
                    T t5 = tArr[2];
                    T t6 = tArr[3];
                    Set k4 = k(4, false);
                    k4.add(t3);
                    k4.add(t4);
                    k4.add(t5);
                    k4.add(t6);
                    return Collections.unmodifiableSet(k4);
                } else {
                    return i(tArr[0], tArr[1], tArr[2]);
                }
            }
            return Collections.singleton(tArr[0]);
        }
        return Collections.emptySet();
    }

    private static <T> Set<T> k(int i2, boolean z) {
        float f2 = z ? 0.75f : 1.0f;
        if (i2 <= (z ? 128 : 256)) {
            return new ArraySet(i2);
        }
        return new HashSet(i2, f2);
    }

    private static <K, V> Map<K, V> l(int i2, boolean z) {
        if (i2 <= 256) {
            return new ArrayMap(i2);
        }
        return new HashMap(i2, 1.0f);
    }
}
