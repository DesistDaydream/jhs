package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import com.xiaomi.push.jd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class aw implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f37a;

    public aw(Context context, boolean z) {
        this.a = context;
        this.f37a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d2;
        String d3;
        Map<String, String> map;
        String d4;
        String str;
        String c2;
        String c3;
        com.xiaomi.a.a.a.c.a("do sync info");
        hq hqVar = new hq(com.xiaomi.push.service.ag.a(), false);
        b m74a = b.m74a(this.a);
        hqVar.c(ha.SyncInfo.ah);
        hqVar.b(m74a.m75a());
        hqVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        hqVar.f8869h = hashMap;
        Context context = this.a;
        jd.a(hashMap, "app_version", gg.a(context, context.getPackageName()));
        Map<String, String> map2 = hqVar.f8869h;
        Context context2 = this.a;
        jd.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(gg.b(context2, context2.getPackageName())));
        jd.a(hqVar.f8869h, "push_sdk_vn", "4_9_1");
        jd.a(hqVar.f8869h, "push_sdk_vc", Integer.toString(40091));
        jd.a(hqVar.f8869h, "token", m74a.b());
        if (!jc.g()) {
            String a = com.xiaomi.push.ar.a(ii.d(this.a));
            String f2 = ii.f(this.a);
            if (!TextUtils.isEmpty(f2)) {
                a = a + Constants.ACCEPT_TIME_SEPARATOR_SP + f2;
            }
            if (!TextUtils.isEmpty(a)) {
                jd.a(hqVar.f8869h, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        com.xiaomi.push.ac.a(this.a).a(hqVar.f8869h);
        jd.a(hqVar.f8869h, Constants.EXTRA_KEY_REG_ID, m74a.m82c());
        jd.a(hqVar.f8869h, Constants.EXTRA_KEY_REG_SECRET, m74a.d());
        jd.a(hqVar.f8869h, "accept_time", MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f37a) {
            Map<String, String> map3 = hqVar.f8869h;
            c2 = av.c(MiPushClient.getAllAlias(this.a));
            jd.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c2);
            Map<String, String> map4 = hqVar.f8869h;
            c3 = av.c(MiPushClient.getAllTopic(this.a));
            jd.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c3);
            map = hqVar.f8869h;
            d4 = av.c(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map5 = hqVar.f8869h;
            d2 = av.d(MiPushClient.getAllAlias(this.a));
            jd.a(map5, Constants.EXTRA_KEY_ALIASES, d2);
            Map<String, String> map6 = hqVar.f8869h;
            d3 = av.d(MiPushClient.getAllTopic(this.a));
            jd.a(map6, Constants.EXTRA_KEY_TOPICS, d3);
            map = hqVar.f8869h;
            d4 = av.d(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        jd.a(map, str, d4);
        ao.a(this.a).a((ao) hqVar, gq.Notification, false, (hd) null);
    }
}
