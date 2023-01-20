package com.meizu.cloud.pushsdk.d.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class b {
    private static ExecutorService a = null;
    private static int b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (a == null) {
                a = Executors.newScheduledThreadPool(b);
            }
        }
        return a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
