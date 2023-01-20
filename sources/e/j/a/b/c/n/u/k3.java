package e.j.a.b.c.n.u;

import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class k3 implements Runnable {
    private final /* synthetic */ j3 a;

    public k3(j3 j3Var) {
        this.a = j3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.a.f10272m;
        lock.lock();
        try {
            this.a.B();
        } finally {
            lock2 = this.a.f10272m;
            lock2.unlock();
        }
    }
}
