package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.dt;
import com.xiaomi.push.eq;
import com.xiaomi.push.fn;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class cu {
    public static Intent a(byte[] bArr, long j2) {
        hn a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j2));
        intent.setPackage(a.f8859f);
        return intent;
    }

    public static hn a(Context context, hn hnVar) {
        return a(context, hnVar, (Map<String, String>) null);
    }

    public static hn a(Context context, hn hnVar, Map<String, String> map) {
        hg hgVar = new hg();
        hgVar.b(hnVar.h());
        hd m2 = hnVar.m();
        if (m2 != null) {
            hgVar.a(m2.b());
            hgVar.a(m2.d());
            if (!TextUtils.isEmpty(m2.f())) {
                hgVar.c(m2.f());
            }
        }
        hgVar.a(ib.a(context, hnVar));
        hn a = j.a(hnVar.j(), hnVar.h(), hgVar, gq.AckMessage);
        hd m3 = hnVar.m();
        if (m3 != null) {
            m3 = au.a(m3.a());
        }
        m3.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        m3.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a.a(m3);
        return a;
    }

    public static hn a(byte[] bArr) {
        hn hnVar = new hn();
        try {
            ib.a(hnVar, bArr);
            return hnVar;
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a(th);
            return null;
        }
    }

    public static void a(Context context, hn hnVar, byte[] bArr) {
        try {
            n.a(hnVar);
            hnVar.m();
            n.c a = n.a(context, hnVar, bArr);
            if (a.b > 0 && !TextUtils.isEmpty(a.a)) {
                gi.a(context, a.a, a.b, true, false, System.currentTimeMillis());
            }
            if (!jc.a(context) || !i.a(context, hnVar, a.f9185c)) {
                b(context, hnVar, bArr);
                return;
            }
            i.a(context, hnVar);
            com.xiaomi.a.a.a.c.a("consume this broadcast by tts");
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    private static void a(XMPushService xMPushService, hn hnVar) {
        xMPushService.a(new cv(4, xMPushService, hnVar));
    }

    private static void a(XMPushService xMPushService, hn hnVar, hq hqVar) {
        xMPushService.a(new h(4, hqVar, hnVar, xMPushService));
    }

    private static void a(XMPushService xMPushService, hn hnVar, String str) {
        xMPushService.a(new f(4, xMPushService, hnVar, str));
    }

    private static void a(XMPushService xMPushService, hn hnVar, String str, String str2) {
        xMPushService.a(new g(4, xMPushService, hnVar, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 1209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.cu.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j2) {
        Map<String, String> s;
        hn a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f8859f)) {
            com.xiaomi.a.a.a.c.a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = n.a(a);
        gi.a(xMPushService, a3, j2, true, true, System.currentTimeMillis());
        hd m2 = a.m();
        if (m2 != null && m2.b() != null) {
            com.xiaomi.a.a.a.c.f(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.h(), ag.a(m2.b()), a.a()));
        }
        if (m2 != null) {
            m2.a("mrt", Long.toString(valueOf.longValue()));
        }
        gq gqVar = gq.SendMessage;
        String str = "";
        if (gqVar == a.a() && cr.a(xMPushService).a(a.f8859f) && !n.b(a)) {
            if (m2 != null) {
                str = m2.b();
                if (n.f(a)) {
                    dt.a(xMPushService.getApplicationContext()).a(a.j(), n.g(a), str, "1");
                }
            }
            com.xiaomi.a.a.a.c.a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f8859f);
        } else if (gqVar == a.a() && cr.a(xMPushService).c(a.f8859f) && !n.b(a)) {
            if (m2 != null) {
                str = m2.b();
                if (n.f(a)) {
                    dt.a(xMPushService.getApplicationContext()).a(a.j(), n.g(a), str, "2");
                }
            }
            com.xiaomi.a.a.a.c.a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f8859f);
        } else if (gqVar == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f8859f)) {
            com.xiaomi.a.a.a.c.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f8859f);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f8859f);
            if (m2 == null || !n.f(a)) {
                return;
            }
            dt.a(xMPushService.getApplicationContext()).a(a.j(), n.g(a), m2.b(), "3");
        } else if (gqVar != a.a() || ii.a() != 999 || !ii.a(xMPushService, a3)) {
            if (m2 == null || (s = m2.s()) == null || !s.containsKey("hide") || !"true".equalsIgnoreCase(s.get("hide"))) {
                a(xMPushService, a3, bArr, a2);
            } else {
                b(xMPushService, a);
            }
        } else {
            com.xiaomi.a.a.a.c.a("Receive the uninstalled dual app message");
            try {
                j.a(xMPushService, j.a(a3, a.h()));
                com.xiaomi.a.a.a.c.a("uninstall " + a3 + " msg sent");
            } catch (fn e2) {
                com.xiaomi.a.a.a.c.d("Fail to send Message: " + e2.getMessage());
                xMPushService.a(10, e2);
            }
            n.b(xMPushService, a3);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (gg.c(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                com.xiaomi.a.a.a.c.a("broadcast message arrived.");
                context.sendBroadcast(intent, j.a(str));
                return true;
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a("meet error when broadcast message arrived. " + e2);
                return false;
            }
        }
        return false;
    }

    private static boolean a(hn hnVar) {
        return "com.xiaomi.xmsf".equals(hnVar.f8859f) && hnVar.m() != null && hnVar.m().s() != null && hnVar.m().s().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, hn hnVar, hd hdVar) {
        boolean z = true;
        if (hdVar != null && hdVar.s() != null && hdVar.s().containsKey("__check_alive") && hdVar.s().containsKey("__awake")) {
            hq hqVar = new hq();
            hqVar.b(hnVar.h());
            hqVar.d(str);
            hqVar.c(ha.AwakeSystemApp.ah);
            hqVar.a(hdVar.b());
            hqVar.f8869h = new HashMap();
            boolean c2 = gg.c(xMPushService.getApplicationContext(), str);
            hqVar.f8869h.put("app_running", Boolean.toString(c2));
            if (!c2) {
                boolean parseBoolean = Boolean.parseBoolean(hdVar.s().get("__awake"));
                hqVar.f8869h.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                j.a(xMPushService, j.a(hnVar.j(), hnVar.h(), hqVar, gq.Notification));
            } catch (fn e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
        return z;
    }

    private static void b(Context context, hn hnVar, byte[] bArr) {
        if (n.b(hnVar)) {
            return;
        }
        String a = n.a(hnVar);
        if (TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        dt.a(context).b(a, n.g(hnVar), hnVar.m().b(), "1");
    }

    private static void b(XMPushService xMPushService, hn hnVar) {
        xMPushService.a(new c(4, xMPushService, hnVar));
    }

    private static boolean b(hn hnVar) {
        Map<String, String> s = hnVar.m().s();
        return s != null && s.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, hn hnVar) {
        xMPushService.a(new d(4, xMPushService, hnVar));
    }

    private static boolean c(hn hnVar) {
        if (hnVar.m() == null || hnVar.m().s() == null) {
            return false;
        }
        return "1".equals(hnVar.m().s().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, hn hnVar) {
        xMPushService.a(new e(4, xMPushService, hnVar));
    }

    public void a(Context context, aj.b bVar, boolean z, int i2, String str) {
        cp a;
        if (z || (a = cq.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        cq.a(context, a.f9170f, a.f9168d, a.f9169e);
    }

    public void a(XMPushService xMPushService, eq eqVar, aj.b bVar) {
        try {
            a(xMPushService, eqVar.d(bVar.f9081i), eqVar.l());
        } catch (IllegalArgumentException e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    public void a(XMPushService xMPushService, ft ftVar, aj.b bVar) {
        if (!(ftVar instanceof fs)) {
            com.xiaomi.a.a.a.c.a("not a mipush message");
            return;
        }
        fs fsVar = (fs) ftVar;
        fq p = fsVar.p("s");
        if (p != null) {
            try {
                a(xMPushService, as.a(as.a(bVar.f9081i, fsVar.k()), p.c()), gi.a(ftVar.c()));
            } catch (IllegalArgumentException e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
    }
}
