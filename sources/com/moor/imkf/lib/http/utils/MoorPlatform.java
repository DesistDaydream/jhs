package com.moor.imkf.lib.http.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class MoorPlatform {
    private static final MoorPlatform PLATFORM = findPlatform();

    /* loaded from: classes2.dex */
    public static class Android extends MoorPlatform {

        /* loaded from: classes2.dex */
        public static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        @Override // com.moor.imkf.lib.http.utils.MoorPlatform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    private static MoorPlatform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        return new MoorPlatform();
    }

    public static MoorPlatform get() {
        return PLATFORM;
    }

    public Executor defaultCallbackExecutor() {
        return Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable) {
        defaultCallbackExecutor().execute(runnable);
    }
}
