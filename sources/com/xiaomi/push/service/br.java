package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;

/* loaded from: classes3.dex */
public class br implements Runnable {
    public final /* synthetic */ XMPushService a;

    public br(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("[Alarm] disable ping receiver may be failure. " + th);
        }
    }
}
