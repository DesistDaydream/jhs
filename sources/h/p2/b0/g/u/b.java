package h.p2.b0.g.u;

import kotlin.reflect.jvm.internal.pcollections.MapEntry;

/* loaded from: classes3.dex */
public final class b<K, V> {

    /* renamed from: c  reason: collision with root package name */
    private static final b<Object, Object> f15635c = new b<>(d.a(), 0);
    private final d<a<MapEntry<K, V>>> a;
    private final int b;

    private b(d<a<MapEntry<K, V>>> dVar, int i2) {
        this.a = dVar;
        this.b = i2;
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i2 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    @k.e.a.d
    public static <K, V> b<K, V> c() {
        b<K, V> bVar = (b<K, V>) f15635c;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    private a<MapEntry<K, V>> e(int i2) {
        a<MapEntry<K, V>> b = this.a.b(i2);
        return b == null ? a.b() : b;
    }

    private static <K, V> int f(a<MapEntry<K, V>> aVar, Object obj) {
        int i2 = 0;
        while (aVar != null && aVar.size() > 0) {
            if (aVar.a.key.equals(obj)) {
                return i2;
            }
            aVar = aVar.b;
            i2++;
        }
        return -1;
    }

    public boolean b(Object obj) {
        return f(e(obj.hashCode()), obj) != -1;
    }

    public V d(Object obj) {
        for (a e2 = e(obj.hashCode()); e2 != null && e2.size() > 0; e2 = e2.b) {
            MapEntry mapEntry = (MapEntry) e2.a;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
        }
        return null;
    }

    @k.e.a.d
    public b<K, V> g(Object obj) {
        a<MapEntry<K, V>> e2 = e(obj.hashCode());
        int f2 = f(e2, obj);
        if (f2 == -1) {
            return this;
        }
        a<MapEntry<K, V>> e3 = e2.e(f2);
        if (e3.size() == 0) {
            return new b<>(this.a.c(obj.hashCode()), this.b - 1);
        }
        return new b<>(this.a.d(obj.hashCode(), e3), this.b - 1);
    }

    @k.e.a.d
    public b<K, V> h(K k2, V v) {
        a<MapEntry<K, V>> e2 = e(k2.hashCode());
        int size = e2.size();
        int f2 = f(e2, k2);
        if (f2 != -1) {
            e2 = e2.e(f2);
        }
        a<MapEntry<K, V>> g2 = e2.g(new MapEntry<>(k2, v));
        return new b<>(this.a.d(k2.hashCode(), g2), (this.b - size) + g2.size());
    }

    public int i() {
        return this.b;
    }
}
