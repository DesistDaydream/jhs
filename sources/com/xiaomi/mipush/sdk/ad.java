package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class ad extends BroadcastReceiver {
    public final /* synthetic */ NotificationClickedActivity a;

    public ad(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.xiaomi.a.a.a.c.b("clicked activity finish by normal.");
        this.a.finish();
    }
}
