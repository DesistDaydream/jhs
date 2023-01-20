package e.b.a.p.k;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.CallbackException;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.p.k.n;
import e.b.a.v.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class j<R> implements DecodeJob.b<R>, a.f {
    private static final c z = new c();
    public final e a;
    private final e.b.a.v.p.c b;

    /* renamed from: c  reason: collision with root package name */
    private final n.a f9552c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<j<?>> f9553d;

    /* renamed from: e  reason: collision with root package name */
    private final c f9554e;

    /* renamed from: f  reason: collision with root package name */
    private final k f9555f;

    /* renamed from: g  reason: collision with root package name */
    private final e.b.a.p.k.z.a f9556g;

    /* renamed from: h  reason: collision with root package name */
    private final e.b.a.p.k.z.a f9557h;

    /* renamed from: i  reason: collision with root package name */
    private final e.b.a.p.k.z.a f9558i;

    /* renamed from: j  reason: collision with root package name */
    private final e.b.a.p.k.z.a f9559j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f9560k;

    /* renamed from: l  reason: collision with root package name */
    private e.b.a.p.c f9561l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9562m;
    private boolean n;
    private boolean o;
    private boolean p;
    private s<?> q;
    public DataSource r;
    private boolean s;
    public GlideException t;
    private boolean u;
    public n<?> v;
    private DecodeJob<R> w;
    private volatile boolean x;
    private boolean y;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        private final e.b.a.t.i a;

        public a(e.b.a.t.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.g()) {
                synchronized (j.this) {
                    if (j.this.a.b(this.a)) {
                        j.this.f(this.a);
                    }
                    j.this.i();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        private final e.b.a.t.i a;

        public b(e.b.a.t.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.g()) {
                synchronized (j.this) {
                    if (j.this.a.b(this.a)) {
                        j.this.v.a();
                        j.this.g(this.a);
                        j.this.s(this.a);
                    }
                    j.this.i();
                }
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class c {
        public <R> n<R> a(s<R> sVar, boolean z, e.b.a.p.c cVar, n.a aVar) {
            return new n<>(sVar, z, true, cVar, aVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public final e.b.a.t.i a;
        public final Executor b;

        public d(e.b.a.t.i iVar, Executor executor) {
            this.a = iVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {
        private final List<d> a;

        public e() {
            this(new ArrayList(2));
        }

        private static d e(e.b.a.t.i iVar) {
            return new d(iVar, e.b.a.v.f.a());
        }

        public void a(e.b.a.t.i iVar, Executor executor) {
            this.a.add(new d(iVar, executor));
        }

        public boolean b(e.b.a.t.i iVar) {
            return this.a.contains(e(iVar));
        }

        public void clear() {
            this.a.clear();
        }

        public e d() {
            return new e(new ArrayList(this.a));
        }

        public void f(e.b.a.t.i iVar) {
            this.a.remove(e(iVar));
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.a.iterator();
        }

        public int size() {
            return this.a.size();
        }

        public e(List<d> list) {
            this.a = list;
        }
    }

    public j(e.b.a.p.k.z.a aVar, e.b.a.p.k.z.a aVar2, e.b.a.p.k.z.a aVar3, e.b.a.p.k.z.a aVar4, k kVar, n.a aVar5, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, aVar5, pool, z);
    }

    private e.b.a.p.k.z.a j() {
        if (this.n) {
            return this.f9558i;
        }
        return this.o ? this.f9559j : this.f9557h;
    }

    private boolean n() {
        return this.u || this.s || this.x;
    }

    private synchronized void r() {
        if (this.f9561l != null) {
            this.a.clear();
            this.f9561l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            this.y = false;
            this.w.x(false);
            this.w = null;
            this.t = null;
            this.r = null;
            this.f9553d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(e.b.a.t.i iVar, Executor executor) {
        this.b.c();
        this.a.a(iVar, executor);
        boolean z2 = true;
        if (this.s) {
            k(1);
            executor.execute(new b(iVar));
        } else if (this.u) {
            k(1);
            executor.execute(new a(iVar));
        } else {
            if (this.x) {
                z2 = false;
            }
            e.b.a.v.l.a(z2, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void b(s<R> sVar, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.q = sVar;
            this.r = dataSource;
            this.y = z2;
        }
        p();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void c(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        o();
    }

    @Override // e.b.a.v.p.a.f
    @NonNull
    public e.b.a.v.p.c d() {
        return this.b;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void e(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    @GuardedBy("this")
    public void f(e.b.a.t.i iVar) {
        try {
            iVar.c(this.t);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    @GuardedBy("this")
    public void g(e.b.a.t.i iVar) {
        try {
            iVar.b(this.v, this.r, this.y);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public void h() {
        if (n()) {
            return;
        }
        this.x = true;
        this.w.f();
        this.f9555f.c(this, this.f9561l);
    }

    public void i() {
        n<?> nVar;
        synchronized (this) {
            this.b.c();
            e.b.a.v.l.a(n(), "Not yet complete!");
            int decrementAndGet = this.f9560k.decrementAndGet();
            e.b.a.v.l.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                nVar = this.v;
                r();
            } else {
                nVar = null;
            }
        }
        if (nVar != null) {
            nVar.e();
        }
    }

    public synchronized void k(int i2) {
        n<?> nVar;
        e.b.a.v.l.a(n(), "Not yet complete!");
        if (this.f9560k.getAndAdd(i2) == 0 && (nVar = this.v) != null) {
            nVar.a();
        }
    }

    @VisibleForTesting
    public synchronized j<R> l(e.b.a.p.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f9561l = cVar;
        this.f9562m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        return this;
    }

    public synchronized boolean m() {
        return this.x;
    }

    public void o() {
        synchronized (this) {
            this.b.c();
            if (this.x) {
                r();
            } else if (!this.a.isEmpty()) {
                if (!this.u) {
                    this.u = true;
                    e.b.a.p.c cVar = this.f9561l;
                    e d2 = this.a.d();
                    k(d2.size() + 1);
                    this.f9555f.b(this, cVar, null);
                    Iterator<d> it = d2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.b.execute(new a(next.a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    public void p() {
        synchronized (this) {
            this.b.c();
            if (this.x) {
                this.q.recycle();
                r();
            } else if (!this.a.isEmpty()) {
                if (!this.s) {
                    this.v = this.f9554e.a(this.q, this.f9562m, this.f9561l, this.f9552c);
                    this.s = true;
                    e d2 = this.a.d();
                    k(d2.size() + 1);
                    this.f9555f.b(this, this.f9561l, this.v);
                    Iterator<d> it = d2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.b.execute(new b(next.a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    public boolean q() {
        return this.p;
    }

    public synchronized void s(e.b.a.t.i iVar) {
        boolean z2;
        this.b.c();
        this.a.f(iVar);
        if (this.a.isEmpty()) {
            h();
            if (!this.s && !this.u) {
                z2 = false;
                if (z2 && this.f9560k.get() == 0) {
                    r();
                }
            }
            z2 = true;
            if (z2) {
                r();
            }
        }
    }

    public synchronized void t(DecodeJob<R> decodeJob) {
        this.w = decodeJob;
        (decodeJob.D() ? this.f9556g : j()).execute(decodeJob);
    }

    @VisibleForTesting
    public j(e.b.a.p.k.z.a aVar, e.b.a.p.k.z.a aVar2, e.b.a.p.k.z.a aVar3, e.b.a.p.k.z.a aVar4, k kVar, n.a aVar5, Pools.Pool<j<?>> pool, c cVar) {
        this.a = new e();
        this.b = e.b.a.v.p.c.a();
        this.f9560k = new AtomicInteger();
        this.f9556g = aVar;
        this.f9557h = aVar2;
        this.f9558i = aVar3;
        this.f9559j = aVar4;
        this.f9555f = kVar;
        this.f9552c = aVar5;
        this.f9553d = pool;
        this.f9554e = cVar;
    }
}
