package e.k.a.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "CommonWorkingThread";
    private static HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f11775c;

    /* renamed from: e.k.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0382b {
        public static b a = new b();
    }

    public static b b() {
        c();
        return C0382b.a;
    }

    private static void c() {
        try {
            HandlerThread handlerThread = b;
            if (handlerThread == null || !handlerThread.isAlive() || b.isInterrupted() || b.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.baseapi.thread");
                b = handlerThread2;
                handlerThread2.start();
                Looper looper = b.getLooper();
                if (looper != null) {
                    f11775c = new Handler(looper);
                } else {
                    Log.e(a, ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th) {
            Log.e(a, "unexpected for initHandler", th);
        }
    }

    public boolean a(Runnable runnable) {
        Handler handler = f11775c;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }

    private b() {
    }
}
