package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class bw extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(XMPushService xMPushService, int i2) {
        super(i2);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        j.a(this.a);
        if (com.xiaomi.push.al.c(this.a)) {
            this.a.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "prepare the mi push account.";
    }
}
