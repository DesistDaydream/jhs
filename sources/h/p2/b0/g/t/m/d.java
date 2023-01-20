package h.p2.b0.g.t.m;

import h.k2.v.u;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class d implements j {
    @k.e.a.d
    private final Lock b;

    public d() {
        this(null, 1, null);
    }

    public d(@k.e.a.d Lock lock) {
        this.b = lock;
    }

    @k.e.a.d
    public final Lock a() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.m.j
    public void lock() {
        this.b.lock();
    }

    @Override // h.p2.b0.g.t.m.j
    public void unlock() {
        this.b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i2, u uVar) {
        this((i2 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
