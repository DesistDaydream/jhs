package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.eq;
import com.xiaomi.push.fb;
import com.xiaomi.push.fn;
import com.xiaomi.push.ft;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ih;
import com.xiaomi.push.service.aj;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes3.dex */
public final class j {
    public static eq a(XMPushService xMPushService, byte[] bArr) {
        hn hnVar = new hn();
        try {
            ib.a(hnVar, bArr);
            return a(cq.a(xMPushService), xMPushService, hnVar);
        } catch (ih e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return null;
        }
    }

    public static eq a(cp cpVar, Context context, hn hnVar) {
        try {
            eq eqVar = new eq();
            eqVar.a(5);
            eqVar.c(cpVar.a);
            eqVar.b(a(hnVar));
            eqVar.a("SECMSG", "message");
            String str = cpVar.a;
            hnVar.f8860g.b = str.substring(0, str.indexOf(TIMMentionEditText.TIM_MENTION_TAG));
            hnVar.f8860g.f8799d = str.substring(str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
            eqVar.a(ib.a(hnVar), cpVar.f9167c);
            eqVar.a((short) 1);
            com.xiaomi.a.a.a.c.a("try send mi push message. packagename:" + hnVar.f8859f + " action:" + hnVar.a);
            return eqVar;
        } catch (NullPointerException e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return null;
        }
    }

    public static hn a(String str, String str2) {
        hq hqVar = new hq();
        hqVar.b(str2);
        hqVar.c("package uninstalled");
        hqVar.a(ft.j());
        hqVar.a(false);
        return a(str, str2, hqVar, gq.Notification);
    }

    public static <T extends ic<T, ?>> hn a(String str, String str2, T t, gq gqVar) {
        return a(str, str2, t, gqVar, true);
    }

    private static <T extends ic<T, ?>> hn a(String str, String str2, T t, gq gqVar, boolean z) {
        byte[] a = ib.a(t);
        hn hnVar = new hn();
        hf hfVar = new hf();
        hfVar.a = 5L;
        hfVar.b = "fakeid";
        hnVar.a(hfVar);
        hnVar.a(ByteBuffer.wrap(a));
        hnVar.a(gqVar);
        hnVar.c(z);
        hnVar.b(str);
        hnVar.a(false);
        hnVar.a(str2);
        return hnVar;
    }

    private static String a(hn hnVar) {
        Map<String, String> map;
        hd hdVar = hnVar.f8861h;
        if (hdVar != null && (map = hdVar.f8785k) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hnVar.f8859f;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        cp a = cq.a(xMPushService.getApplicationContext());
        if (a != null) {
            aj.b a2 = cq.a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.a.a.a.c.a("prepare account. " + a2.a);
            a(xMPushService, a2);
            aj.a().a(a2);
            ba.a(xMPushService).a(new k("GAID", 172800L, xMPushService, a));
            a(xMPushService, a, 172800);
        }
    }

    public static void a(XMPushService xMPushService, hn hnVar) {
        com.xiaomi.push.cf.a(hnVar.j(), xMPushService.getApplicationContext(), hnVar, -1);
        fb h2 = xMPushService.h();
        if (h2 == null) {
            throw new fn("try send msg while connection is null.");
        }
        if (!h2.b()) {
            throw new fn("Don't support XMPP connection.");
        }
        eq a = a(cq.a(xMPushService), xMPushService, hnVar);
        if (a != null) {
            h2.b(a);
        }
    }

    public static void a(XMPushService xMPushService, aj.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new m(xMPushService));
    }

    private static void a(XMPushService xMPushService, cp cpVar, int i2) {
        ba.a(xMPushService).a(new l("MSAID", i2, xMPushService, cpVar));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        com.xiaomi.push.cf.a(str, xMPushService.getApplicationContext(), bArr);
        fb h2 = xMPushService.h();
        if (h2 == null) {
            throw new fn("try send msg while connection is null.");
        }
        if (!h2.b()) {
            throw new fn("Don't support XMPP connection.");
        }
        eq a = a(xMPushService, bArr);
        if (a != null) {
            h2.b(a);
        } else {
            ct.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    public static hn b(String str, String str2) {
        hq hqVar = new hq();
        hqVar.b(str2);
        hqVar.c(ha.AppDataCleared.ah);
        hqVar.a(ag.a());
        hqVar.a(false);
        return a(str, str2, hqVar, gq.Notification);
    }

    public static <T extends ic<T, ?>> hn b(String str, String str2, T t, gq gqVar) {
        return a(str, str2, t, gqVar, false);
    }
}
