package com.tencent.tpns.baseapi.base.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.lang.Thread;

/* loaded from: classes3.dex */
public class CommonWorkingThread {
    private static HandlerThread a;
    private static Handler b;

    /* loaded from: classes3.dex */
    public static class CommonWorkingThreadHolder {
        public static CommonWorkingThread instance = new CommonWorkingThread();
    }

    private static void a() {
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
                    Logger.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th) {
            Logger.e("CommonWorkingThread", "unexpected for initHandler", th);
        }
    }

    public static CommonWorkingThread getInstance() {
        a();
        return CommonWorkingThreadHolder.instance;
    }

    public boolean execute(TTask tTask) {
        Handler handler = b;
        if (handler != null) {
            return handler.post(tTask);
        }
        return false;
    }

    public boolean executeAtTime(TTask tTask, int i2, long j2) {
        Handler handler = b;
        if (handler != null) {
            return handler.postAtTime(tTask, Integer.valueOf(i2), SystemClock.uptimeMillis() + j2);
        }
        return false;
    }

    public Handler getHandler() {
        return b;
    }

    public void remove(int i2) {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(Integer.valueOf(i2));
        }
    }

    private CommonWorkingThread() {
    }

    public boolean execute(TTask tTask, long j2) {
        Handler handler = b;
        if (handler != null) {
            return handler.postDelayed(tTask, j2);
        }
        return false;
    }

    public void remove(TTask tTask) {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacks(tTask);
        }
    }
}
