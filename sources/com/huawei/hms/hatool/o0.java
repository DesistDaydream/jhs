package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class o0 {
    public static o0 b;

    /* renamed from: c  reason: collision with root package name */
    public static o0 f3591c;

    /* renamed from: d  reason: collision with root package name */
    public static o0 f3592d;
    public ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, (long) com.heytap.mcssdk.constant.a.f3314d, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    y.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements ThreadFactory {

        /* renamed from: d  reason: collision with root package name */
        public static final AtomicInteger f3593d = new AtomicInteger(1);
        public final ThreadGroup a;
        public final AtomicInteger b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        public final String f3594c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f3594c = "FormalHASDK-base-" + f3593d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            return new Thread(threadGroup, runnable, this.f3594c + this.b.getAndIncrement(), 0L);
        }
    }

    static {
        new o0();
        new o0();
        b = new o0();
        f3591c = new o0();
        f3592d = new o0();
    }

    public static o0 a() {
        return f3592d;
    }

    public static o0 b() {
        return f3591c;
    }

    public static o0 c() {
        return b;
    }

    public void a(n0 n0Var) {
        try {
            this.a.execute(new a(n0Var));
        } catch (RejectedExecutionException unused) {
            y.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
