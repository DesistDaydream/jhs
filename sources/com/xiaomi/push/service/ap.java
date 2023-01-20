package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.dc;
import com.xiaomi.push.di;
import com.xiaomi.push.dm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ap implements dm {
    @Override // com.xiaomi.push.dm
    public void a(Context context, HashMap<String, String> hashMap) {
        hq hqVar = new hq();
        hqVar.b(di.a(context).b());
        hqVar.d(di.a(context).c());
        hqVar.c(ha.AwakeAppResponse.ah);
        hqVar.a(ag.a());
        hqVar.f8869h = hashMap;
        byte[] a = ib.a(j.a(hqVar.m(), hqVar.f(), hqVar, gq.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.a.a.a.c.a("MoleInfo : context is not correct in pushLayer " + hqVar.d());
            return;
        }
        com.xiaomi.a.a.a.c.a("MoleInfo : send data directly in pushLayer " + hqVar.d());
        ((XMPushService) context).a(context.getPackageName(), a, true);
    }

    @Override // com.xiaomi.push.dm
    public void b(Context context, HashMap<String, String> hashMap) {
        gn a = gn.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1L, dc.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.dm
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.a.a.a.c.a("MoleInfo：\u3000" + dc.b(hashMap));
    }
}
