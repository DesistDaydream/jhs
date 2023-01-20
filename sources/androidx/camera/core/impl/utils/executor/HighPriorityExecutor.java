package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class HighPriorityExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mHighPriorityService = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: androidx.camera.core.impl.utils.executor.HighPriorityExecutor.1
        private static final String THREAD_NAME = "CameraX-camerax_high_priority";

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            thread.setName(THREAD_NAME);
            return thread;
        }
    });

    public static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (HighPriorityExecutor.class) {
            if (sExecutor == null) {
                sExecutor = new HighPriorityExecutor();
            }
        }
        return sExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.mHighPriorityService.execute(runnable);
    }
}
