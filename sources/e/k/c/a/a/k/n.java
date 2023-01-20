package e.k.c.a.a.k;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class n {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a.post(runnable);
    }
}
