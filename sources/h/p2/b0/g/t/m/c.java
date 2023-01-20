package h.p2.b0.g.t.m;

import h.t1;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class c extends d {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f15552c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final h.k2.u.l<InterruptedException, t1> f15553d;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@k.e.a.d Lock lock, @k.e.a.d Runnable runnable, @k.e.a.d h.k2.u.l<? super InterruptedException, t1> lVar) {
        super(lock);
        this.f15552c = runnable;
        this.f15553d = lVar;
    }

    @Override // h.p2.b0.g.t.m.d, h.p2.b0.g.t.m.j
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f15552c.run();
            } catch (InterruptedException e2) {
                this.f15553d.invoke(e2);
                return;
            }
        }
    }

    public c(@k.e.a.d Runnable runnable, @k.e.a.d h.k2.u.l<? super InterruptedException, t1> lVar) {
        this(new ReentrantLock(), runnable, lVar);
    }
}
