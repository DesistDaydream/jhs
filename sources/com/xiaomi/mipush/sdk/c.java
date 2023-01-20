package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dc;
import com.xiaomi.push.di;
import com.xiaomi.push.dm;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class c implements dm {
    @Override // com.xiaomi.push.dm
    public void a(Context context, HashMap<String, String> hashMap) {
        hq hqVar = new hq();
        hqVar.b(di.a(context).b());
        hqVar.d(di.a(context).c());
        hqVar.c(ha.AwakeAppResponse.ah);
        hqVar.a(com.xiaomi.push.service.ag.a());
        hqVar.f8869h = hashMap;
        ao.a(context).a((ao) hqVar, gq.Notification, true, (hd) null, true);
        com.xiaomi.a.a.a.c.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.dm
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dc.a(hashMap));
        com.xiaomi.a.a.a.c.a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.dm
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.a.a.a.c.a("MoleInfo：\u3000" + dc.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            o.a(context, str);
        }
    }
}
