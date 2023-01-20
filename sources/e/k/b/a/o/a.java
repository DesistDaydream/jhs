package e.k.b.a.o;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a {
    private static final a b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final int f11793c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f11794d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f11795e;
    private final Executor a = new ExecutorC0383a((byte) 0);

    /* renamed from: e.k.b.a.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ExecutorC0383a implements Executor {
        private ExecutorC0383a() {
        }

        public /* synthetic */ ExecutorC0383a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f11793c = availableProcessors;
        f11794d = availableProcessors + 1;
        f11795e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f11794d, f11795e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return b.a;
    }
}
