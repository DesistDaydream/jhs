package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class Threads {
    private Threads() {
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState(isMainThread(), "Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
