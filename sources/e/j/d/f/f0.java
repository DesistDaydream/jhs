package e.j.d.f;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class f0 {
    private static final Executor a = g0.a;

    public static final /* synthetic */ Thread a(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }

    public static Executor b() {
        return a;
    }

    public static Executor c() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e0.a);
    }
}
