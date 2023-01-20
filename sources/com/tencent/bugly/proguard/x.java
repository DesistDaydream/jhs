package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class x {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static x b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f6813c;

    public x() {
        this.f6813c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.x.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + x.a.getAndIncrement());
                return thread;
            }
        });
        this.f6813c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            y.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            if (b == null) {
                b = new x();
            }
            xVar = b;
        }
        return xVar;
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f6813c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            y.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f6813c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.f6813c;
        if (scheduledExecutorService != null) {
            z = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z;
    }

    public final synchronized boolean a(Runnable runnable, long j2) {
        if (!c()) {
            y.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            y.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j2 <= 0) {
                j2 = 0;
            }
            y.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
            this.f6813c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            y.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            y.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            y.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f6813c.execute(runnable);
            return true;
        }
    }
}
