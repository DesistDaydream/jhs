package com.bytedance.sdk.openadsdk.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a {
    private static volatile a b;
    private volatile ThreadPoolExecutor a = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0089a(), new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.b.a.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.bytedance.sdk.openadsdk.api.a.d("TTThreadManager", "TTThreadManager rejectedExecution:  ");
        }
    });

    /* renamed from: com.bytedance.sdk.openadsdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0089a implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;

        /* renamed from: c  reason: collision with root package name */
        private final String f2446c;

        public ThreadFactoryC0089a() {
            this("csj_g_pl_mgr");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.f2446c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

        public ThreadFactoryC0089a(String str) {
            this.b = new AtomicInteger(1);
            this.a = new ThreadGroup("csj_g_pl_mgr");
            this.f2446c = str;
        }
    }

    public a() {
        this.a.allowCoreThreadTimeOut(true);
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                b = new a();
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                this.a.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
