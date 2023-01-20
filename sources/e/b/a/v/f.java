package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class f {
    private static final Executor a = new a();
    private static final Executor b = new b();

    /* loaded from: classes.dex */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            n.x(runnable);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private f() {
    }

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return a;
    }

    @VisibleForTesting
    public static void c(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            throw new RuntimeException("Failed to shutdown");
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
