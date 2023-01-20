package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class bu implements aj.a {
    public final /* synthetic */ XMPushService a;

    public bu(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.aj.a
    public void a() {
        this.a.s();
        if (aj.a().c() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.g(12, null));
        }
    }
}
