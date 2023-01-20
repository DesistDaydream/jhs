package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.jm;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class bk implements XMPushService.n {
    private static final boolean a = Log.isLoggable("UNDatas", 3);
    private static final Map<Integer, Map<String, List<String>>> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Context f9132c;

    public bk(Context context) {
        f9132c = context;
    }

    private static hq a(String str, String str2, String str3, String str4) {
        hq hqVar = new hq();
        if (str3 != null) {
            hqVar.c(str3);
        }
        if (str != null) {
            hqVar.b(str);
        }
        if (str2 != null) {
            hqVar.a(str2);
        }
        if (str4 != null) {
            hqVar.d(str4);
        }
        hqVar.a(false);
        return hqVar;
    }

    private static void a(Context context, hq hqVar) {
        if (a) {
            com.xiaomi.a.a.a.c.b("UNDatas upload message notification:" + hqVar);
        }
        com.xiaomi.push.m.a(context).a(new bl(hqVar));
    }

    private static void c() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(b);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map.get(str);
                        if (!jm.a(list)) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                if (i2 != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i2));
                            }
                        }
                        sb.append(";");
                    }
                    hq a2 = a(null, ag.a(), ha.NotificationRemoved.ah, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.a.a.a.c.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f9132c, a2);
                }
                b.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    public void a() {
        Map<Integer, Map<String, List<String>>> map = b;
        if (map.size() > 0) {
            synchronized (map) {
                c();
            }
        }
    }
}
