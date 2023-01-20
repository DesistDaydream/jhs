package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.cq;

/* loaded from: classes3.dex */
public class bx implements cq.a {
    public final /* synthetic */ XMPushService.j a;
    public final /* synthetic */ XMPushService b;

    public bx(XMPushService xMPushService, XMPushService.j jVar) {
        this.b = xMPushService;
        this.a = jVar;
    }

    @Override // com.xiaomi.push.service.cq.a
    public void a() {
        this.b.a(this.a);
    }
}
