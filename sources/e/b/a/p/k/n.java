package e.b.a.p.k;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class n<Z> implements s<Z> {
    private final boolean a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final s<Z> f9572c;

    /* renamed from: d  reason: collision with root package name */
    private final a f9573d;

    /* renamed from: e  reason: collision with root package name */
    private final e.b.a.p.c f9574e;

    /* renamed from: f  reason: collision with root package name */
    private int f9575f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9576g;

    /* loaded from: classes.dex */
    public interface a {
        void d(e.b.a.p.c cVar, n<?> nVar);
    }

    public n(s<Z> sVar, boolean z, boolean z2, e.b.a.p.c cVar, a aVar) {
        this.f9572c = (s) e.b.a.v.l.d(sVar);
        this.a = z;
        this.b = z2;
        this.f9574e = cVar;
        this.f9573d = (a) e.b.a.v.l.d(aVar);
    }

    public synchronized void a() {
        if (!this.f9576g) {
            this.f9575f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<Z> b() {
        return this.f9572c.b();
    }

    public s<Z> c() {
        return this.f9572c;
    }

    public boolean d() {
        return this.a;
    }

    public void e() {
        boolean z;
        synchronized (this) {
            int i2 = this.f9575f;
            if (i2 > 0) {
                z = true;
                int i3 = i2 - 1;
                this.f9575f = i3;
                if (i3 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f9573d.d(this.f9574e, this);
        }
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Z get() {
        return this.f9572c.get();
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return this.f9572c.getSize();
    }

    @Override // e.b.a.p.k.s
    public synchronized void recycle() {
        if (this.f9575f <= 0) {
            if (!this.f9576g) {
                this.f9576g = true;
                if (this.b) {
                    this.f9572c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.f9573d + ", key=" + this.f9574e + ", acquired=" + this.f9575f + ", isRecycled=" + this.f9576g + ", resource=" + this.f9572c + '}';
    }
}
