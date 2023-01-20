package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.ec;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hs;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes3.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: classes3.dex */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            intValue = (intValue & (-4)) + gg.a.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m74a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hs hsVar) {
        b.a aVar;
        String l2 = hsVar.l();
        if (hsVar.f() == 0 && (aVar = dataMap.get(l2)) != null) {
            aVar.a(hsVar.f8890g, hsVar.f8891h);
            b.m74a(context).a(l2, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(hsVar.f8890g)) {
            arrayList = new ArrayList();
            arrayList.add(hsVar.f8890g);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f8488k, arrayList, hsVar.f8888e, hsVar.f8889f, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(l2, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hy hyVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_UNREGISTER.f8488k, null, hyVar.f8958e, hyVar.f8959f, null, null);
        String g2 = hyVar.g();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(g2, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m74a(context).m79a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m74a(context).a(str);
            if (a != null) {
                arrayList.add(a.f8227c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f8488k, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                hq hqVar = new hq();
                hqVar.b(str2);
                hqVar.c(ha.PullOfflineMessage.ah);
                hqVar.a(com.xiaomi.push.service.ag.a());
                hqVar.a(false);
                ao.a(context).a(hqVar, gq.Notification, false, true, null, false, str, str2);
                com.xiaomi.a.a.a.c.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.a.a.a.c.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = com.xiaomi.push.ar.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        hr hrVar = new hr();
        hrVar.a(com.xiaomi.push.service.ag.a());
        hrVar.b(str2);
        hrVar.e(str3);
        hrVar.d(str);
        hrVar.f(a2);
        hrVar.c(gg.a(context, context.getPackageName()));
        hrVar.b(gg.b(context, context.getPackageName()));
        hrVar.h("4_9_1");
        hrVar.a(40091);
        hrVar.a(he.Init);
        if (!jc.g()) {
            String e2 = ii.e(context);
            if (!TextUtils.isEmpty(e2)) {
                hrVar.i(com.xiaomi.push.ar.a(e2));
            }
        }
        int a3 = ii.a();
        if (a3 >= 0) {
            hrVar.c(a3);
        }
        hq hqVar2 = new hq();
        hqVar2.c(ha.HybridRegister.ah);
        hqVar2.b(b.m74a(context).m75a());
        hqVar2.d(context.getPackageName());
        hqVar2.a(ib.a(hrVar));
        hqVar2.a(com.xiaomi.push.service.ag.a());
        ao.a(context).a((ao) hqVar2, gq.Notification, (hd) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        am.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.a.a.a.c.a("do not ack message, message is null");
            return;
        }
        try {
            hg hgVar = new hg();
            hgVar.b(b.m74a(context).m75a());
            hgVar.a(miPushMessage.getMessageId());
            hgVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hgVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hgVar.c(miPushMessage.getTopic());
            }
            ao.a(context).a((ao) hgVar, gq.AckMessage, false, com.xiaomi.push.service.au.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.a.a.a.c.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a = b.m74a(context).a(str);
        if (a == null) {
            return;
        }
        hx hxVar = new hx();
        hxVar.a(com.xiaomi.push.service.ag.a());
        hxVar.d(str);
        hxVar.b(a.f43a);
        hxVar.c(a.f8227c);
        hxVar.e(a.b);
        hq hqVar = new hq();
        hqVar.c(ha.HybridUnregister.ah);
        hqVar.b(b.m74a(context).m75a());
        hqVar.d(context.getPackageName());
        hqVar.a(ib.a(hxVar));
        hqVar.a(com.xiaomi.push.service.ag.a());
        ao.a(context).a((ao) hqVar, gq.Notification, (hd) null);
        b.m74a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.n.a(context, linkedList);
    }
}
