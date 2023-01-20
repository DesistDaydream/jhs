package com.bytedance.sdk.openadsdk.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean a = false;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0086a f2398c;

    /* renamed from: com.bytedance.sdk.openadsdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0086a {
        void a();

        void b();
    }

    public Boolean a() {
        return Boolean.valueOf(a);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.b++;
        a = false;
        InterfaceC0086a interfaceC0086a = this.f2398c;
        if (interfaceC0086a != null) {
            interfaceC0086a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 == 0) {
            a = true;
            InterfaceC0086a interfaceC0086a = this.f2398c;
            if (interfaceC0086a != null) {
                interfaceC0086a.a();
            }
        }
    }

    public void a(InterfaceC0086a interfaceC0086a) {
        this.f2398c = interfaceC0086a;
    }
}
