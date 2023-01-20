package com.tencent.android.mipush;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;

/* loaded from: classes3.dex */
public class a {
    private static HandlerThread a;
    private static Handler b;

    /* renamed from: com.tencent.android.mipush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0217a {
        public static a a = new a();
    }

    public static a a() {
        b();
        return C0217a.a;
    }

    private static void b() {
        try {
            HandlerThread handlerThread = a;
            if (handlerThread == null || !handlerThread.isAlive() || a.isInterrupted() || a.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.baseapi.thread");
                a = handlerThread2;
                handlerThread2.start();
                Looper looper = a.getLooper();
                if (looper != null) {
                    b = new Handler(looper);
                } else {
                    Log.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th) {
            Log.e("CommonWorkingThread", "unexpected for initHandler", th);
        }
    }

    private a() {
    }

    public boolean a(Runnable runnable) {
        Handler handler = b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }
}
