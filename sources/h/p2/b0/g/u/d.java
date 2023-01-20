package h.p2.b0.g.u;

/* loaded from: classes3.dex */
public final class d<V> {
    private static final d<Object> b = new d<>(c.f15636f);
    private final c<V> a;

    private d(c<V> cVar) {
        this.a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) b;
    }

    private d<V> e(c<V> cVar) {
        return cVar == this.a ? this : new d<>(cVar);
    }

    public V b(int i2) {
        return this.a.a(i2);
    }

    public d<V> c(int i2) {
        return e(this.a.c(i2));
    }

    public d<V> d(int i2, V v) {
        return e(this.a.d(i2, v));
    }
}
