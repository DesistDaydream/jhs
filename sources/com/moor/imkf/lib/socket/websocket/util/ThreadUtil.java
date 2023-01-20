package com.moor.imkf.lib.socket.websocket.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class ThreadUtil {
    private static Handler sMainHandler;

    private static void checkMainHandlerIsNull() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static boolean checkMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void runOnMainThread(Runnable runnable) {
        checkMainHandlerIsNull();
        sMainHandler.post(runnable);
    }
}
