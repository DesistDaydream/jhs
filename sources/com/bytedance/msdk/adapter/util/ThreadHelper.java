package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadHelper {
    public static final String THREDA_NAME_PREFIX = "gm_t_";
    private static final Object a = new Object();
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f1869c = null;

    /* renamed from: d  reason: collision with root package name */
    private static HandlerThread f1870d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Handler f1871e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final int f1872f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f1873g;

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f1874h;

    /* renamed from: i  reason: collision with root package name */
    private static final Executor f1875i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ boolean f1876j = true;

    static {
        initMSDKThread();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1872f = availableProcessors;
        f1873g = Math.min(availableProcessors, 4);
        f1874h = a();
        f1875i = c();
    }

    private static Executor a() {
        int i2 = f1873g;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), createNamedThreadFactory("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e2) {
            Log.e("ThreadHelper", "stackerror:", e2);
        } catch (NoSuchMethodError e3) {
            e3.printStackTrace();
        }
        return threadPoolExecutor;
    }

    public static void assertOnUiThread() {
        if (!f1876j && !runningOnUiThread()) {
            throw new AssertionError();
        }
    }

    private static boolean b(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e2) {
            Log.e("ThreadHelper", "stackerror:", e2);
            return false;
        }
    }

    private static Executor c() {
        return new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), createNamedThreadFactory("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ThreadFactory createNamedThreadFactory(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.adapter.util.ThreadHelper.1
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str + " # " + this.a.getAndIncrement());
            }
        };
    }

    private static boolean d() {
        HandlerThread handlerThread = f1870d;
        return (handlerThread == null || !handlerThread.isAlive() || f1871e == null) ? false : true;
    }

    public static int getGroMoreThreadCount() {
        int i2 = 0;
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && thread.getName() != null && thread.getName().contains(THREDA_NAME_PREFIX)) {
                i2++;
                Logger.d("TMe", "--==-- thread: " + thread.getName());
            }
        }
        return i2;
    }

    public static Executor getLogUploadExecutor() {
        return f1875i;
    }

    public static Executor getMSDKExecutor() {
        return f1874h;
    }

    public static Looper getMSDKThreadLooper() {
        if (d()) {
            return f1870d.getLooper();
        }
        return null;
    }

    public static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (a) {
            if (f1869c == null) {
                if (b) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                f1869c = new Handler(Looper.getMainLooper());
            }
            handler = f1869c;
        }
        return handler;
    }

    public static void initMSDKThread() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            f1870d = handlerThread;
            handlerThread.start();
            f1871e = new Handler(f1870d.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static ExecutorService initSingleThreadExecutor(String str, int i2, RejectedExecutionHandler rejectedExecutionHandler) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(i2);
        return new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, createNamedThreadFactory("gm_t_single_" + str), rejectedExecutionHandler);
    }

    public static void postDelayOnMSDKThread(Runnable runnable, long j2) {
        if (d()) {
            f1871e.postDelayed(runnable, j2);
        } else {
            initMSDKThread();
        }
    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> futureTask) {
        getUiThreadHandler().post(futureTask);
        return futureTask;
    }

    public static void postOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static void postOnUiThreadDelayed(Runnable runnable, long j2) {
        getUiThreadHandler().postDelayed(runnable, j2);
    }

    public static void revokeOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    public static void runOnMSDKThread(Runnable runnable) {
        if (!d()) {
            initMSDKThread();
        } else if (runningOnMSDKThread()) {
            runnable.run();
        } else {
            f1871e.post(runnable);
        }
    }

    public static void runOnThreadPool(Runnable runnable) {
        b(f1874h, runnable);
    }

    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> futureTask) {
        if (runningOnUiThread()) {
            futureTask.run();
        } else {
            postOnUiThread((FutureTask) futureTask);
        }
        return futureTask;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            getUiThreadHandler().post(runnable);
        }
    }

    public static <T> T runOnUiThreadBlocking(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        runOnUiThread(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted waiting for callable", e2);
        }
    }

    public static void runOnUiThreadBlocking(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        postOnUiThread(futureTask);
        try {
            futureTask.get();
        } catch (Exception e2) {
            throw new RuntimeException("Exception occured while waiting for runnable", e2);
        }
    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            return (T) runOnUiThreadBlocking(callable);
        } catch (ExecutionException e2) {
            throw new RuntimeException("Error occured waiting for callable", e2);
        }
    }

    public static boolean runningOnMSDKThread() {
        return d() && f1870d.getLooper() == Looper.myLooper();
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }
}
