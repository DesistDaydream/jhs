package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.a.a.a.c;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.af;
import com.xiaomi.mipush.sdk.ao;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.al;
import com.xiaomi.push.gi;
import com.xiaomi.push.je;

/* loaded from: classes3.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    private static boolean a = false;
    private boolean b;

    public NetworkStatusReceiver() {
        this.b = false;
        this.b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.b = false;
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ao.a(context).m67a() && b.m74a(context).m83c() && !b.m74a(context).m86f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                com.xiaomi.push.service.a.a(context).a(intent);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
        gi.a(context);
        if (al.c(context) && ao.a(context).m70b()) {
            ao.a(context).m71c();
        }
        if (al.c(context)) {
            if ("syncing".equals(af.a(context).a(au.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(af.a(context).a(au.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static boolean a() {
        return a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.b) {
            return;
        }
        je.a().post(new a(this, context));
    }
}
