package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class av implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new aw(this));
        return thread;
    }
}
