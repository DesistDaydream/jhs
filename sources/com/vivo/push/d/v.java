package com.vivo.push.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Map b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f8122c;

    public v(u uVar, Context context, Map map) {
        this.f8122c = uVar;
        this.a = context;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        u.b(intent, this.b);
                        this.a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
            u.b(launchIntentForPackage, this.b);
            this.a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
    }
}
