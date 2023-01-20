package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.core.os.HandlerCompat;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class MainThreadAsyncHandler {
    private static volatile Handler sHandler;

    private MainThreadAsyncHandler() {
    }

    public static Handler getInstance() {
        if (sHandler != null) {
            return sHandler;
        }
        synchronized (MainThreadAsyncHandler.class) {
            if (sHandler == null) {
                sHandler = HandlerCompat.createAsync(Looper.getMainLooper());
            }
        }
        return sHandler;
    }
}
