package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dy;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;

/* loaded from: classes3.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.c(intent.getPackage() + " is the package name");
        if (XMPushService.j()) {
            return;
        }
        if (!an.p.equals(intent.getAction())) {
            c.a("cancel the old ping timer");
            dy.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            c.c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                com.xiaomi.push.service.a.a(context).a(intent2);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }
}
