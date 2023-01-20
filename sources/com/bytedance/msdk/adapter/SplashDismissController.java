package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class SplashDismissController {
    private WeakReference<Activity> a;

    /* renamed from: d  reason: collision with root package name */
    private CallBack f1743d;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1742c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1744e = false;

    /* loaded from: classes.dex */
    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity) {
        this.a = new WeakReference<>(activity);
        c();
    }

    private void c() {
        Activity activity = this.a.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.f1743d = null;
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2) {
                        return;
                    }
                    SplashDismissController.this.f1742c = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (SplashDismissController.this.a == null || SplashDismissController.this.a.get() != activity2 || SplashDismissController.this.f1743d == null) {
                        return;
                    }
                    SplashDismissController.this.f1743d.onResume();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }
            });
        }
    }

    public boolean isCallDismiss() {
        return this.f1744e;
    }

    public boolean jumpToAdPage() {
        return this.b && this.f1742c;
    }

    public void setCallBack(CallBack callBack) {
        this.f1743d = callBack;
    }

    public void setCallDismiss(boolean z) {
        this.f1744e = z;
    }

    public void setClick(boolean z) {
        this.b = z;
    }
}
