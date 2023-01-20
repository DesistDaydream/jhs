package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class ak implements aj.b.a {
    public final /* synthetic */ aj.b a;

    public ak(aj.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public void a(aj.c cVar, aj.c cVar2, int i2) {
        XMPushService.c cVar3;
        XMPushService.c cVar4;
        if (cVar2 == aj.c.binding) {
            XMPushService xMPushService = this.a.t;
            cVar4 = this.a.v;
            xMPushService.a(cVar4, com.heytap.mcssdk.constant.a.f3314d);
            return;
        }
        XMPushService xMPushService2 = this.a.t;
        cVar3 = this.a.v;
        xMPushService2.b(cVar3);
    }
}
