package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import java.util.concurrent.ScheduledExecutorService;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class MainThreadExecutor {
    private static volatile ScheduledExecutorService sInstance;

    private MainThreadExecutor() {
    }

    public static ScheduledExecutorService getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (MainThreadExecutor.class) {
            if (sInstance == null) {
                sInstance = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));
            }
        }
        return sInstance;
    }
}
