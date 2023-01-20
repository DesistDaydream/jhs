package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private Runnable f614c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f615d;
    private int a = 64;
    private int b = 5;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<x.a> f616e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<x.a> f617f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<x> f618g = new ArrayDeque();

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                c();
            }
            b = b();
            runnable = this.f614c;
        }
        if (b != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int c(x.a aVar) {
        int i2 = 0;
        for (x.a aVar2 : this.f617f) {
            if (aVar2.c().equals(aVar.c())) {
                i2++;
            }
        }
        return i2;
    }

    private void c() {
        if (this.f617f.size() < this.a && !this.f616e.isEmpty()) {
            Iterator<x.a> it = this.f616e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (c(next) < this.b) {
                    it.remove();
                    this.f617f.add(next);
                    a().execute(next);
                }
                if (this.f617f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    public ExecutorService a() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.f615d == null) {
                this.f615d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Dispatcher", false));
            }
            executorService = this.f615d;
        }
        return executorService;
    }

    public void a(int i2) {
        synchronized (this) {
            if (i2 < 1) {
                throw new IllegalArgumentException("max < 1: " + i2);
            }
            this.a = i2;
            c();
        }
    }

    public void a(x.a aVar) {
        synchronized (this) {
            if (this.f617f.size() >= this.a || c(aVar) >= this.b) {
                this.f616e.add(aVar);
            } else {
                this.f617f.add(aVar);
                a().execute(aVar);
            }
        }
    }

    public void a(x xVar) {
        synchronized (this) {
            this.f618g.add(xVar);
        }
    }

    public int b() {
        int size;
        int size2;
        synchronized (this) {
            size = this.f617f.size();
            size2 = this.f618g.size();
        }
        return size + size2;
    }

    public void b(x.a aVar) {
        a(this.f617f, aVar, true);
    }

    public void b(x xVar) {
        a(this.f618g, xVar, false);
    }
}
