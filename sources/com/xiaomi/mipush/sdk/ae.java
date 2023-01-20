package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.xiaomi.push.gq;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hj;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class ae extends m.a {
    private Context a;

    public ae(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.ad a = com.xiaomi.push.service.ad.a(this.a);
        hj hjVar = new hj();
        hjVar.a(com.xiaomi.push.service.ae.a(a, gw.MISC_CONFIG));
        hjVar.b(com.xiaomi.push.service.ae.a(a, gw.PLUGIN_CONFIG));
        hq hqVar = new hq(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE, false);
        hqVar.c(ha.DailyCheckClientConfig.ah);
        hqVar.a(ib.a(hjVar));
        ao.a(this.a).a((ao) hqVar, gq.Notification, (hd) null);
    }
}
