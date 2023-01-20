package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import c.b.b.d;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraExecutor implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final String TAG = "CameraExecutor";
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() { // from class: androidx.camera.core.CameraExecutor.1
        private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, THREAD_NAME_STEM, Integer.valueOf(this.mThreadId.getAndIncrement())));
            return thread;
        }
    };
    private final Object mExecutorLock = new Object();
    @NonNull
    @GuardedBy("mExecutorLock")
    private ThreadPoolExecutor mThreadPoolExecutor = createExecutor();

    private static ThreadPoolExecutor createExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        threadPoolExecutor.setRejectedExecutionHandler(d.a);
        return threadPoolExecutor;
    }

    public void deinit() {
        synchronized (this.mExecutorLock) {
            if (!this.mThreadPoolExecutor.isShutdown()) {
                this.mThreadPoolExecutor.shutdown();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.mExecutorLock) {
            this.mThreadPoolExecutor.execute(runnable);
        }
    }

    public void init(@NonNull CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull(cameraFactory);
        synchronized (this.mExecutorLock) {
            if (this.mThreadPoolExecutor.isShutdown()) {
                this.mThreadPoolExecutor = createExecutor();
            }
            threadPoolExecutor = this.mThreadPoolExecutor;
        }
        int max = Math.max(1, cameraFactory.getAvailableCameraIds().size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }
}
