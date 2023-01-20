package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.ConcurrencyHelpers;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private ConcurrencyHelpers() {
    }

    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    @NonNull
    @Deprecated
    public static Executor convertHandlerToExecutor(@NonNull final Handler handler) {
        Objects.requireNonNull(handler);
        return new Executor() { // from class: c.e.a.e
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public static ThreadPoolExecutor createBackgroundPriorityExecutor(@NonNull final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: c.e.a.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ConcurrencyHelpers.a(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.createAsync(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }
}
