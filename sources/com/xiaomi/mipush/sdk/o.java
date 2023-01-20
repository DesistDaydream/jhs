package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.di;
import com.xiaomi.push.dk;
import com.xiaomi.push.gv;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.jc;
import com.xiaomi.push.m;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class o {
    public static void a(Context context, Intent intent, Uri uri) {
        di a;
        dk dkVar;
        if (context == null) {
            return;
        }
        ao.a(context).m65a();
        if (di.a(context.getApplicationContext()).a() == null) {
            di.a(context.getApplicationContext()).a(b.m74a(context.getApplicationContext()).m75a(), context.getPackageName(), com.xiaomi.push.service.ad.a(context.getApplicationContext()).a(gv.AwakeInfoUploadWaySwitch.a(), 0), new c());
            com.xiaomi.push.service.ad.a(context).a(new q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a = di.a(context.getApplicationContext());
            dkVar = dk.ACTIVITY;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            di.a(context.getApplicationContext()).a(dk.PROVIDER, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a = di.a(context.getApplicationContext());
            dkVar = dk.SERVICE_COMPONENT;
        } else {
            a = di.a(context.getApplicationContext());
            dkVar = dk.SERVICE_ACTION;
        }
        a.a(dkVar, context, intent, (String) null);
    }

    private static void a(Context context, hq hqVar) {
        boolean a = com.xiaomi.push.service.ad.a(context).a(gv.AwakeAppPingSwitch.a(), false);
        int a2 = com.xiaomi.push.service.ad.a(context).a(gv.AwakeAppPingFrequency.a(), 0);
        if (a2 >= 0 && a2 < 30) {
            com.xiaomi.a.a.a.c.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        boolean z = a2 >= 0 ? a : false;
        if (!jc.a()) {
            a(context, hqVar, z, a2);
        } else if (z) {
            com.xiaomi.push.m.a(context.getApplicationContext()).a((m.a) new p(hqVar, context), a2);
        }
    }

    public static final <T extends ic<T, ?>> void a(Context context, T t, boolean z, int i2) {
        byte[] a = ib.a(t);
        if (a == null) {
            com.xiaomi.a.a.a.c.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i2);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ao.a(context).m66a(intent);
    }

    public static void a(Context context, String str) {
        com.xiaomi.a.a.a.c.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put(com.heytap.mcssdk.constant.b.f3341i, "ping message");
        hq hqVar = new hq();
        hqVar.b(b.m74a(context).m75a());
        hqVar.d(context.getPackageName());
        hqVar.c(ha.AwakeAppResponse.ah);
        hqVar.a(com.xiaomi.push.service.ag.a());
        hqVar.f8869h = hashMap;
        a(context, hqVar);
    }

    public static void a(Context context, String str, int i2, String str2) {
        hq hqVar = new hq();
        hqVar.b(str);
        hqVar.a(new HashMap());
        hqVar.k().put("extra_aw_app_online_cmd", String.valueOf(i2));
        hqVar.k().put("extra_help_aw_info", str2);
        hqVar.a(com.xiaomi.push.service.ag.a());
        byte[] a = ib.a(hqVar);
        if (a == null) {
            com.xiaomi.a.a.a.c.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        ao.a(context).m66a(intent);
    }
}
