package com.moor.imkf.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.MoorBaseLibManager;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class YKFUtils implements Application.ActivityLifecycleCallbacks {
    private static YKFUtils INSTANCE;
    private Runnable check;
    @NonNull
    private final Application mApplication;
    public final long CHECK_DELAY = 500;
    private boolean foreground = false;
    private boolean paused = true;
    private final Handler handler = new Handler();
    private final List<Activity> mActivityStack = new LinkedList();

    private YKFUtils(@NonNull Application application) {
        this.mApplication = application;
        MoorBaseLibManager.getInstance().initBaseLib(application);
        application.registerActivityLifecycleCallbacks(this);
    }

    @NonNull
    public static YKFUtils getInstance() {
        return INSTANCE;
    }

    public static void init(@NonNull Application application) {
        if (INSTANCE == null) {
            INSTANCE = new YKFUtils(application);
        }
    }

    @NonNull
    public Application getApplication() {
        return this.mApplication;
    }

    @Nullable
    public Activity getCurrentActivity() {
        if (this.mActivityStack.isEmpty()) {
            return null;
        }
        List<Activity> list = this.mActivityStack;
        return list.get(list.size() - 1);
    }

    public boolean isForeground() {
        return this.foreground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        this.mActivityStack.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.mActivityStack.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        this.paused = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Handler handler = this.handler;
        Runnable runnable2 = new Runnable() { // from class: com.moor.imkf.utils.YKFUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (YKFUtils.this.foreground && YKFUtils.this.paused) {
                    YKFUtils.this.foreground = false;
                }
            }
        };
        this.check = runnable2;
        handler.postDelayed(runnable2, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        this.paused = false;
        this.foreground = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }
}
