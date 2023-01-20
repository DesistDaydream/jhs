package com.bytedance.msdk.adapter.util;

import android.os.AsyncTask;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class AsyncTasks {
    private static Executor a;

    static {
        b();
    }

    private static void b() {
        a = ThreadHelper.getMSDKExecutor();
    }

    public static <P> void safeExecuteOnExecutor(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(a, pArr);
            return;
        }
        Logger.e(AsyncTasks.class.getSimpleName(), "Posting AsyncTask to main thread for execution.");
        ThreadHelper.postOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.util.AsyncTasks.1
            @Override // java.lang.Runnable
            public void run() {
                asyncTask.executeOnExecutor(AsyncTasks.a, pArr);
            }
        });
    }

    public static void setExecutor(Executor executor) {
        a = executor;
    }
}
