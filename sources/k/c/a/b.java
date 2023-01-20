package k.c.a;

import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class b implements Runnable, k {
    private final j a = new j();
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f16246c;

    public b(c cVar) {
        this.b = cVar;
    }

    @Override // k.c.a.k
    public void a(p pVar, Object obj) {
        i a = i.a(pVar, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.f16246c) {
                this.f16246c = true;
                this.b.g().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                i c2 = this.a.c(1000);
                if (c2 == null) {
                    synchronized (this) {
                        c2 = this.a.b();
                        if (c2 == null) {
                            return;
                        }
                    }
                }
                this.b.l(c2);
            } catch (InterruptedException e2) {
                f h2 = this.b.h();
                Level level = Level.WARNING;
                h2.a(level, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f16246c = false;
            }
        }
    }
}
