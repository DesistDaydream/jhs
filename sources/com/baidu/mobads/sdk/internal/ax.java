package com.baidu.mobads.sdk.internal;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ax implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            threadPoolExecutor2 = au.f1452d;
            if (threadPoolExecutor2 == null) {
                LinkedBlockingQueue unused = au.f1453e = new LinkedBlockingQueue();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                linkedBlockingQueue = au.f1453e;
                threadFactory = au.f1454f;
                ThreadPoolExecutor unused2 = au.f1452d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        threadPoolExecutor3 = au.f1452d;
        threadPoolExecutor3.execute(runnable);
    }
}
