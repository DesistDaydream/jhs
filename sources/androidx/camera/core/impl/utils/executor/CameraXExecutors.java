package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraXExecutors {
    private CameraXExecutors() {
    }

    @NonNull
    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    @NonNull
    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    @NonNull
    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    public static boolean isSequentialExecutor(@NonNull Executor executor) {
        return executor instanceof SequentialExecutor;
    }

    @NonNull
    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    @NonNull
    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }

    @NonNull
    public static ScheduledExecutorService newHandlerExecutor(@NonNull Handler handler) {
        return new HandlerScheduledExecutorService(handler);
    }

    @NonNull
    public static Executor newSequentialExecutor(@NonNull Executor executor) {
        return new SequentialExecutor(executor);
    }
}
