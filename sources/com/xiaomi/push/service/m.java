package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public final class m implements aj.b.a {
    public final /* synthetic */ XMPushService a;

    public m(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public void a(aj.c cVar, aj.c cVar2, int i2) {
        if (cVar2 == aj.c.binded) {
            ct.a(this.a, true);
            ct.a(this.a);
        } else if (cVar2 == aj.c.unbind) {
            com.xiaomi.a.a.a.c.a("onChange unbind");
            ct.a(this.a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
