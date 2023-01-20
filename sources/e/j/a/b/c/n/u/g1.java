package e.j.a.b.c.n.u;

import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public abstract class g1 {
    private final e1 a;

    public g1(e1 e1Var) {
        this.a = e1Var;
    }

    public abstract void a();

    public final void b(f1 f1Var) {
        Lock lock;
        Lock lock2;
        e1 e1Var;
        lock = f1Var.a;
        lock.lock();
        try {
            e1Var = f1Var.f10220k;
            if (e1Var != this.a) {
                return;
            }
            a();
        } finally {
            lock2 = f1Var.a;
            lock2.unlock();
        }
    }
}
