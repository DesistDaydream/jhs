package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.ba;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class k extends ba.a {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ cp b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str, long j2, XMPushService xMPushService, cp cpVar) {
        super(str, j2);
        this.a = xMPushService;
        this.b = cpVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public void a(ba baVar) {
        String a = baVar.a("GAID", "gaid");
        String a2 = ii.a(this.a);
        if (TextUtils.isEmpty(a2) || TextUtils.equals(a, a2)) {
            return;
        }
        baVar.a("GAID", "gaid", a2);
        hq hqVar = new hq();
        hqVar.b(this.b.f9168d);
        hqVar.c(ha.ClientInfoUpdate.ah);
        hqVar.a(ag.a());
        hqVar.a(new HashMap());
        hqVar.k().put("gaid", a2);
        byte[] a3 = ib.a(j.a(this.a.getPackageName(), this.b.f9168d, hqVar, gq.Notification));
        XMPushService xMPushService = this.a;
        xMPushService.a(xMPushService.getPackageName(), a3, true);
    }
}
