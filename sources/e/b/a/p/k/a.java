package e.b.a.p.k;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e.b.a.p.k.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class a {
    private final boolean a;
    private final Executor b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.b.a.p.c, d> f9482c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<n<?>> f9483d;

    /* renamed from: e  reason: collision with root package name */
    private n.a f9484e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9485f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private volatile c f9486g;

    /* renamed from: e.b.a.p.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ThreadFactoryC0306a implements ThreadFactory {

        /* renamed from: e.b.a.p.k.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0307a implements Runnable {
            public final /* synthetic */ Runnable a;

            public RunnableC0307a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0307a(runnable), "glide-active-resources");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class d extends WeakReference<n<?>> {
        public final e.b.a.p.c a;
        public final boolean b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f9487c;

        public d(@NonNull e.b.a.p.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.a = (e.b.a.p.c) e.b.a.v.l.d(cVar);
            this.f9487c = (nVar.d() && z) ? (s) e.b.a.v.l.d(nVar.c()) : null;
            this.b = nVar.d();
        }

        public void a() {
            this.f9487c = null;
            clear();
        }
    }

    public a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0306a()));
    }

    public synchronized void a(e.b.a.p.c cVar, n<?> nVar) {
        d put = this.f9482c.put(cVar, new d(cVar, nVar, this.f9483d, this.a));
        if (put != null) {
            put.a();
        }
    }

    public void b() {
        while (!this.f9485f) {
            try {
                c((d) this.f9483d.remove());
                c cVar = this.f9486g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(@NonNull d dVar) {
        s<?> sVar;
        synchronized (this) {
            this.f9482c.remove(dVar.a);
            if (dVar.b && (sVar = dVar.f9487c) != null) {
                this.f9484e.d(dVar.a, new n<>(sVar, true, false, dVar.a, this.f9484e));
            }
        }
    }

    public synchronized void d(e.b.a.p.c cVar) {
        d remove = this.f9482c.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    @Nullable
    public synchronized n<?> e(e.b.a.p.c cVar) {
        d dVar = this.f9482c.get(cVar);
        if (dVar == null) {
            return null;
        }
        n<?> nVar = dVar.get();
        if (nVar == null) {
            c(dVar);
        }
        return nVar;
    }

    @VisibleForTesting
    public void f(c cVar) {
        this.f9486g = cVar;
    }

    public void g(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f9484e = aVar;
            }
        }
    }

    @VisibleForTesting
    public void h() {
        this.f9485f = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            e.b.a.v.f.c((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    public a(boolean z, Executor executor) {
        this.f9482c = new HashMap();
        this.f9483d = new ReferenceQueue<>();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }
}
