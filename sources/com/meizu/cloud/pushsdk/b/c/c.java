package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class c implements Executor {
    private final ThreadPoolExecutor a;

    /* loaded from: classes2.dex */
    public static class a {
        private static c a = new c();
    }

    private c() {
        this.a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a("single-pool-%d").a());
    }

    public static c a() {
        return a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
