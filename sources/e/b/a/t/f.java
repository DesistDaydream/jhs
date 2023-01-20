package e.b.a.t;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.t.k.o;
import e.b.a.t.k.p;
import e.b.a.v.n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class f<R> implements d<R>, g<R> {

    /* renamed from: k  reason: collision with root package name */
    private static final a f9884k = new a();
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9885c;

    /* renamed from: d  reason: collision with root package name */
    private final a f9886d;
    @Nullable
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private R f9887e;
    @Nullable
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private e f9888f;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private boolean f9889g;
    @GuardedBy("this")

    /* renamed from: h  reason: collision with root package name */
    private boolean f9890h;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    private boolean f9891i;
    @Nullable
    @GuardedBy("this")

    /* renamed from: j  reason: collision with root package name */
    private GlideException f9892j;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f9884k);
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f9885c && !isDone()) {
            n.a();
        }
        if (!this.f9889g) {
            if (!this.f9891i) {
                if (this.f9890h) {
                    return this.f9887e;
                }
                if (l2 == null) {
                    this.f9886d.b(this, 0L);
                } else if (l2.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l2.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f9886d.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f9891i) {
                        if (!this.f9889g) {
                            if (this.f9890h) {
                                return this.f9887e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f9892j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f9892j);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f9889g = true;
            this.f9886d.a(this);
            e eVar = null;
            if (z) {
                e eVar2 = this.f9888f;
                this.f9888f = null;
                eVar = eVar2;
            }
            if (eVar != null) {
                eVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // e.b.a.t.k.p
    @Nullable
    public synchronized e getRequest() {
        return this.f9888f;
    }

    @Override // e.b.a.t.k.p
    public void getSize(@NonNull o oVar) {
        oVar.e(this.a, this.b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f9889g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f9889g && !this.f9890h) {
            z = this.f9891i;
        }
        return z;
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
    }

    @Override // e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    public synchronized void onResourceReady(@NonNull R r, @Nullable e.b.a.t.l.f<? super R> fVar) {
    }

    @Override // e.b.a.q.m
    public void onStart() {
    }

    @Override // e.b.a.q.m
    public void onStop() {
    }

    @Override // e.b.a.t.k.p
    public void removeCallback(@NonNull o oVar) {
    }

    @Override // e.b.a.t.k.p
    public synchronized void setRequest(@Nullable e eVar) {
        this.f9888f = eVar;
    }

    public f(int i2, int i3, boolean z, a aVar) {
        this.a = i2;
        this.b = i3;
        this.f9885c = z;
        this.f9886d = aVar;
    }

    @Override // e.b.a.t.g
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p<R> pVar, boolean z) {
        this.f9891i = true;
        this.f9892j = glideException;
        this.f9886d.a(this);
        return false;
    }

    @Override // e.b.a.t.g
    public synchronized boolean onResourceReady(R r, Object obj, p<R> pVar, DataSource dataSource, boolean z) {
        this.f9890h = true;
        this.f9887e = r;
        this.f9886d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
