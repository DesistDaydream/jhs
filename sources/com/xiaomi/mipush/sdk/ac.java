package com.xiaomi.mipush.sdk;

/* loaded from: classes3.dex */
public class ac implements Runnable {
    public final /* synthetic */ NotificationClickedActivity a;

    public ac(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.a.a.a.c.f("clicked activity finish by timeout.");
        this.a.finish();
    }
}
