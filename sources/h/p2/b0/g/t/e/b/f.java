package h.p2.b0.g.t.e.b;

import h.k2.v.f0;

/* loaded from: classes3.dex */
public class f<T> {
    @k.e.a.d
    private final i<T> a;
    private int b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private T f15317c;

    public void a() {
    }

    public void b() {
        if (this.f15317c == null) {
            this.b++;
        }
    }

    public void c(@k.e.a.d T t) {
        d(t);
    }

    public final void d(@k.e.a.d T t) {
        if (this.f15317c == null) {
            int i2 = this.b;
            if (i2 > 0) {
                t = this.a.a(f0.C(h.t2.u.g2("[", i2), this.a.d(t)));
            }
            this.f15317c = t;
        }
    }

    public void e(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d T t) {
        d(t);
    }
}
