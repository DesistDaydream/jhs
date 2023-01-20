package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: g */
    private static final Executor f590g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp ConnectionPool", true));

    /* renamed from: h */
    public static final /* synthetic */ boolean f591h = true;
    private final int a;
    private final long b;

    /* renamed from: c */
    private final Runnable f592c;

    /* renamed from: d */
    private final Deque<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c> f593d;

    /* renamed from: e */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d f594e;

    /* renamed from: f */
    public boolean f595f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            j.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a = j.this.a(System.nanoTime());
                if (a == -1) {
                    return;
                }
                if (a > 0) {
                    long j2 = a / 1000000;
                    synchronized (j.this) {
                        try {
                            j jVar = j.this;
                            Long.signum(j2);
                            jVar.wait(j2, (int) (a - (1000000 * j2)));
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        this.f592c = new a();
        this.f593d = new ArrayDeque();
        this.f594e = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d();
        this.a = i2;
        this.b = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }

    private int a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar, long j2) {
        List<Reference<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g>> list = cVar.n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("A connection to " + cVar.a().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).a);
                list.remove(i2);
                cVar.f378k = true;
                if (list.isEmpty()) {
                    cVar.o = j2 - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long a(long j2) {
        synchronized (this) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar = null;
            long j3 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2 : this.f593d) {
                if (a(cVar2, j2) > 0) {
                    i3++;
                } else {
                    long j4 = j2 - cVar2.o;
                    if (j4 > j3) {
                        cVar = cVar2;
                        j3 = j4;
                    }
                    i2++;
                }
            }
            long j5 = this.b;
            if (j3 < j5 && i2 <= this.a) {
                if (i2 > 0) {
                    return j5 - j3;
                }
                if (i3 <= 0) {
                    this.f595f = false;
                    Log.i("ConnectionPool", "cleanup: ");
                    j5 = -1;
                }
                return j5;
            }
            this.f593d.remove(cVar);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.e());
            return 0L;
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
        if (f591h || Thread.holdsLock(this)) {
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f593d) {
                if (cVar.a(aVar, c0Var)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public Socket a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
        if (f591h || Thread.holdsLock(this)) {
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f593d) {
                if (cVar.a(aVar, null) && cVar.c() && cVar != gVar.b()) {
                    return gVar.a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (f591h || Thread.holdsLock(this)) {
            if (cVar.f378k || this.a == 0) {
                this.f593d.remove(cVar);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError();
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (!f591h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f595f) {
            this.f595f = true;
            f590g.execute(this.f592c);
        }
        this.f593d.add(cVar);
    }
}
