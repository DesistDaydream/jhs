package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.ba;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class l extends ba.a {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ cp b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, long j2, XMPushService xMPushService, cp cpVar) {
        super(str, j2);
        this.a = xMPushService;
        this.b = cpVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public void a(ba baVar) {
        com.xiaomi.push.ac a = com.xiaomi.push.ac.a(this.a);
        String a2 = baVar.a("MSAID", "msaid");
        String str = a.d() + a.b() + a.e() + a.f();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a2, str)) {
            return;
        }
        baVar.a("MSAID", "msaid", str);
        hq hqVar = new hq();
        hqVar.b(this.b.f9168d);
        hqVar.c(ha.ClientInfoUpdate.ah);
        hqVar.a(ag.a());
        hqVar.a(new HashMap());
        a.a(hqVar.k());
        byte[] a3 = ib.a(j.a(this.a.getPackageName(), this.b.f9168d, hqVar, gq.Notification));
        XMPushService xMPushService = this.a;
        xMPushService.a(xMPushService.getPackageName(), a3, true);
    }
}
