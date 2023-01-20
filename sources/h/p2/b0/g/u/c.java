package h.p2.b0.g.u;

/* loaded from: classes3.dex */
public final class c<V> {

    /* renamed from: f  reason: collision with root package name */
    public static final c<Object> f15636f = new c<>();
    private final long a;
    private final V b;

    /* renamed from: c  reason: collision with root package name */
    private final c<V> f15637c;

    /* renamed from: d  reason: collision with root package name */
    private final c<V> f15638d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15639e;

    private c() {
        this.f15639e = 0;
        this.a = 0L;
        this.b = null;
        this.f15637c = null;
        this.f15638d = null;
    }

    private long b() {
        c<V> cVar = this.f15637c;
        if (cVar.f15639e == 0) {
            return this.a;
        }
        return cVar.b() + this.a;
    }

    private static <V> c<V> e(long j2, V v, c<V> cVar, c<V> cVar2) {
        int i2 = ((c) cVar).f15639e;
        int i3 = ((c) cVar2).f15639e;
        if (i2 + i3 > 1) {
            if (i2 >= i3 * 5) {
                c<V> cVar3 = ((c) cVar).f15637c;
                c<V> cVar4 = ((c) cVar).f15638d;
                if (((c) cVar4).f15639e < ((c) cVar3).f15639e * 2) {
                    long j3 = ((c) cVar).a;
                    return new c<>(j3 + j2, ((c) cVar).b, cVar3, new c(-j3, v, cVar4.g(((c) cVar4).a + j3), cVar2));
                }
                c<V> cVar5 = ((c) cVar4).f15637c;
                c<V> cVar6 = ((c) cVar4).f15638d;
                long j4 = ((c) cVar4).a;
                long j5 = ((c) cVar).a + j4 + j2;
                V v2 = ((c) cVar4).b;
                c cVar7 = new c(-j4, ((c) cVar).b, cVar3, cVar5.g(((c) cVar5).a + j4));
                long j6 = ((c) cVar).a;
                long j7 = ((c) cVar4).a;
                return new c<>(j5, v2, cVar7, new c((-j6) - j7, v, cVar6.g(((c) cVar6).a + j7 + j6), cVar2));
            } else if (i3 >= i2 * 5) {
                c<V> cVar8 = ((c) cVar2).f15637c;
                c<V> cVar9 = ((c) cVar2).f15638d;
                if (((c) cVar8).f15639e < ((c) cVar9).f15639e * 2) {
                    long j8 = ((c) cVar2).a;
                    return new c<>(j8 + j2, ((c) cVar2).b, new c(-j8, v, cVar, cVar8.g(((c) cVar8).a + j8)), cVar9);
                }
                c<V> cVar10 = ((c) cVar8).f15637c;
                c<V> cVar11 = ((c) cVar8).f15638d;
                long j9 = ((c) cVar8).a;
                long j10 = ((c) cVar2).a;
                long j11 = j9 + j10 + j2;
                V v3 = ((c) cVar8).b;
                c cVar12 = new c((-j10) - j9, v, cVar, cVar10.g(((c) cVar10).a + j9 + j10));
                long j12 = ((c) cVar8).a;
                return new c<>(j11, v3, cVar12, new c(-j12, ((c) cVar2).b, cVar11.g(((c) cVar11).a + j12), cVar9));
            }
        }
        return new c<>(j2, v, cVar, cVar2);
    }

    private c<V> f(c<V> cVar, c<V> cVar2) {
        return (cVar == this.f15637c && cVar2 == this.f15638d) ? this : e(this.a, this.b, cVar, cVar2);
    }

    private c<V> g(long j2) {
        return (this.f15639e == 0 || j2 == this.a) ? this : new c<>(j2, this.b, this.f15637c, this.f15638d);
    }

    public V a(long j2) {
        if (this.f15639e == 0) {
            return null;
        }
        long j3 = this.a;
        if (j2 < j3) {
            return this.f15637c.a(j2 - j3);
        }
        if (j2 > j3) {
            return this.f15638d.a(j2 - j3);
        }
        return this.b;
    }

    public c<V> c(long j2) {
        if (this.f15639e == 0) {
            return this;
        }
        long j3 = this.a;
        if (j2 < j3) {
            return f(this.f15637c.c(j2 - j3), this.f15638d);
        }
        if (j2 > j3) {
            return f(this.f15637c, this.f15638d.c(j2 - j3));
        }
        c<V> cVar = this.f15637c;
        if (cVar.f15639e == 0) {
            c<V> cVar2 = this.f15638d;
            return cVar2.g(cVar2.a + j3);
        }
        c<V> cVar3 = this.f15638d;
        if (cVar3.f15639e == 0) {
            return cVar.g(cVar.a + j3);
        }
        long b = cVar3.b();
        long j4 = this.a;
        long j5 = b + j4;
        V a = this.f15638d.a(j5 - j4);
        c<V> c2 = this.f15638d.c(j5 - this.a);
        c<V> g2 = c2.g((c2.a + this.a) - j5);
        c<V> cVar4 = this.f15637c;
        return e(j5, a, cVar4.g((cVar4.a + this.a) - j5), g2);
    }

    public c<V> d(long j2, V v) {
        if (this.f15639e == 0) {
            return new c<>(j2, v, this, this);
        }
        long j3 = this.a;
        if (j2 < j3) {
            return f(this.f15637c.d(j2 - j3, v), this.f15638d);
        }
        if (j2 > j3) {
            return f(this.f15637c, this.f15638d.d(j2 - j3, v));
        }
        return v == this.b ? this : new c<>(j2, v, this.f15637c, this.f15638d);
    }

    private c(long j2, V v, c<V> cVar, c<V> cVar2) {
        this.a = j2;
        this.b = v;
        this.f15637c = cVar;
        this.f15638d = cVar2;
        this.f15639e = cVar.f15639e + 1 + cVar2.f15639e;
    }
}
