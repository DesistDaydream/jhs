package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class bo extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(XMPushService xMPushService, int i2) {
        super(i2);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        if (this.a.q != null) {
            this.a.q.b(15, (Exception) null);
            this.a.q = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "disconnect for service destroy.";
    }
}
