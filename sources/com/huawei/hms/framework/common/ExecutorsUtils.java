package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class ExecutorsUtils {
    private static final String THREADNAME_HEADER = "NetworkKit_";

    public static ThreadFactory createThreadFactory(final String str) {
        if (str != null && !str.trim().isEmpty()) {
            return new ThreadFactory() { // from class: com.huawei.hms.framework.common.ExecutorsUtils.1
                private final AtomicInteger threadNumbers = new AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, ExecutorsUtils.THREADNAME_HEADER + str + "_" + this.threadNumbers.getAndIncrement());
                }
            };
        }
        throw new NullPointerException("ThreadName is empty");
    }

    public static ExecutorService newCachedThreadPool(String str) {
        return new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
    }

    public static ExecutorService newFixedThreadPool(int i2, String str) {
        return new ThreadPoolExcutorEnhance(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i2, String str) {
        return new ScheduledThreadPoolExecutorEnhance(i2, createThreadFactory(str));
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
    }
}
