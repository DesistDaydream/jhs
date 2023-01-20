package com.tencent.qcloud.tuicore.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class ThreadHelper {
    public static final ThreadHelper INST = new ThreadHelper();
    private ExecutorService executors;

    private ThreadHelper() {
    }

    private ExecutorService getExecutorService() {
        if (this.executors == null) {
            this.executors = Executors.newCachedThreadPool();
        }
        return this.executors;
    }

    public void execute(Runnable runnable) {
        ExecutorService executorService = getExecutorService();
        if (executorService != null) {
            executorService.execute(runnable);
        } else {
            new Thread(runnable).start();
        }
    }
}
