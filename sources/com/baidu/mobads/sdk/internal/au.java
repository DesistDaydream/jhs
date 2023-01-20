package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class au {
    private static final String a = "ThreadPoolFactory";
    private static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1451c = 60;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f1452d;

    /* renamed from: e  reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f1453e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f1454f = new av();

    /* renamed from: g  reason: collision with root package name */
    private static final RejectedExecutionHandler f1455g = new ax();

    public static ThreadPoolExecutor a(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f1454f);
        threadPoolExecutor.setRejectedExecutionHandler(f1455g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i2) {
        return new ScheduledThreadPoolExecutor(i2, f1454f);
    }
}
