package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class AsyncRun {
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private static int threadPoolSize = 3;
    private static int maxThreadPoolSize = 6;
    private static ExecutorService executorService = new ThreadPoolExecutor(threadPoolSize, maxThreadPoolSize, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    private static void delayTimerTask(int i2, TimerTask timerTask) {
        new Timer().schedule(timerTask, i2);
    }

    public static void runInBack(Runnable runnable) {
        executorService.submit(runnable);
    }

    public static void runInMain(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            mainThreadHandler.post(runnable);
        }
    }

    public static void runInBack(int i2, final Runnable runnable) {
        delayTimerTask(i2, new TimerTask() { // from class: com.qiniu.android.utils.AsyncRun.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AsyncRun.executorService.submit(runnable);
                cancel();
            }
        });
    }

    public static void runInMain(int i2, final Runnable runnable) {
        delayTimerTask(i2, new TimerTask() { // from class: com.qiniu.android.utils.AsyncRun.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AsyncRun.mainThreadHandler.post(runnable);
                cancel();
            }
        });
    }
}
