package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class at {
    private static final String a = "TaskScheduler";

    /* renamed from: d  reason: collision with root package name */
    private static volatile at f1449d;
    private ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f1450c;

    private at() {
        b();
    }

    public static at a() {
        if (f1449d == null) {
            synchronized (at.class) {
                if (f1449d == null) {
                    f1449d = new at();
                }
            }
        }
        return f1449d;
    }

    private void b() {
        this.b = au.a(1, 1);
        this.f1450c = au.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (hVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            ThreadPoolExecutor threadPoolExecutor2 = this.b;
            if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                futureTask = (FutureTask) this.b.submit(hVar);
            }
            hVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f1450c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f1450c.schedule(hVar, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, long j3, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f1450c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f1450c.scheduleAtFixedRate(hVar, j2, j3, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
