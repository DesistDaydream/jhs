package com.meizu.cloud.pushsdk.b;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class j {
    private String a = null;
    private Boolean b = null;

    /* renamed from: c  reason: collision with root package name */
    private Integer f4658c = null;

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f4659d = null;

    /* renamed from: e  reason: collision with root package name */
    private ThreadFactory f4660e = null;

    private static ThreadFactory a(j jVar) {
        final String str = jVar.a;
        final Boolean bool = jVar.b;
        final Integer num = jVar.f4658c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.f4659d;
        ThreadFactory threadFactory = jVar.f4660e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory2 = threadFactory;
        final AtomicLong atomicLong = str != null ? new AtomicLong(0L) : null;
        return new ThreadFactory() { // from class: com.meizu.cloud.pushsdk.b.j.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory2.newThread(runnable);
                String str2 = str;
                if (str2 != null) {
                    newThread.setName(String.format(str2, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool2 = bool;
                if (bool2 != null) {
                    newThread.setDaemon(bool2.booleanValue());
                }
                Integer num2 = num;
                if (num2 != null) {
                    newThread.setPriority(num2.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler2 != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                }
                return newThread;
            }
        };
    }

    public j a(String str) {
        String.format(str, 0);
        this.a = str;
        return this;
    }

    public ThreadFactory a() {
        return a(this);
    }
}
