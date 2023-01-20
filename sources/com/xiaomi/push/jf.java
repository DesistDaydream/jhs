package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes3.dex */
public final class jf implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ComponentName b;

    public jf(Context context, ComponentName componentName) {
        this.a = context;
        this.b = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager.getComponentEnabledSetting(this.b) != 2) {
                packageManager.setComponentEnabledSetting(this.b, 2, 1);
            }
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("close static register of network status receiver failed:" + th);
        }
    }
}
