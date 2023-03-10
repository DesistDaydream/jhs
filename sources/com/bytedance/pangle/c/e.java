package com.bytedance.pangle.c;

import com.bytedance.pangle.ZeusConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e {
    public static Executor a = Executors.newCachedThreadPool();
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    public static ExecutorService a(int i2) {
        return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.bytedance.pangle.c.e.1
            private AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, ZeusConstants.BASE_LIB_NAME + "-Install-" + this.a.getAndIncrement());
            }
        });
    }
}
