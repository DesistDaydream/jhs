package e.j.a.b.c.n.u;

import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public abstract class u0 implements Runnable {
    private final /* synthetic */ k0 a;

    private u0(k0 k0Var) {
        this.a = k0Var;
    }

    @WorkerThread
    public abstract void a();

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        Lock lock;
        Lock lock2;
        f1 f1Var;
        lock = this.a.b;
        lock.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
        } catch (RuntimeException e2) {
            f1Var = this.a.a;
            f1Var.p(e2);
        } finally {
            lock2 = this.a.b;
            lock2.unlock();
        }
    }

    public /* synthetic */ u0(k0 k0Var, l0 l0Var) {
        this(k0Var);
    }
}
