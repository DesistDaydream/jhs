package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class h {
    private static volatile HandlerThread a;
    private static volatile Handler b;

    public static Handler a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static HandlerThread b() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new HandlerThread("default_npth_thread");
                    a.start();
                    b = new Handler(a.getLooper());
                }
            }
        }
        return a;
    }
}
