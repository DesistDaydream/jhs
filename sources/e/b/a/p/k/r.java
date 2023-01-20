package e.b.a.p.k;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import e.b.a.v.p.a;

/* loaded from: classes.dex */
public final class r<Z> implements s<Z>, a.f {

    /* renamed from: e  reason: collision with root package name */
    private static final Pools.Pool<r<?>> f9579e = e.b.a.v.p.a.e(20, new a());
    private final e.b.a.v.p.c a = e.b.a.v.p.c.a();
    private s<Z> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9580c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9581d;

    /* loaded from: classes.dex */
    public class a implements a.d<r<?>> {
        @Override // e.b.a.v.p.a.d
        /* renamed from: b */
        public r<?> a() {
            return new r<>();
        }
    }

    private void a(s<Z> sVar) {
        this.f9581d = false;
        this.f9580c = true;
        this.b = sVar;
    }

    @NonNull
    public static <Z> r<Z> c(s<Z> sVar) {
        r<Z> rVar = (r) e.b.a.v.l.d(f9579e.acquire());
        rVar.a(sVar);
        return rVar;
    }

    private void e() {
        this.b = null;
        f9579e.release(this);
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<Z> b() {
        return this.b.b();
    }

    @Override // e.b.a.v.p.a.f
    @NonNull
    public e.b.a.v.p.c d() {
        return this.a;
    }

    public synchronized void f() {
        this.a.c();
        if (this.f9580c) {
            this.f9580c = false;
            if (this.f9581d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Z get() {
        return this.b.get();
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return this.b.getSize();
    }

    @Override // e.b.a.p.k.s
    public synchronized void recycle() {
        this.a.c();
        this.f9581d = true;
        if (!this.f9580c) {
            this.b.recycle();
            e();
        }
    }
}
