package com.xiaomi.push.service;

import com.xiaomi.push.eq;
import com.xiaomi.push.fh;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class bm implements fh {
    public final /* synthetic */ XMPushService a;

    public bm(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fh
    public void a(eq eqVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.d(eqVar));
    }

    @Override // com.xiaomi.push.fh
    public void b(ft ftVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.m(ftVar));
    }
}
