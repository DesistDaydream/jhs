package com.xiaomi.push.service;

import com.xiaomi.push.fn;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hi;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public final class h extends XMPushService.j {
    public final /* synthetic */ hq a;
    public final /* synthetic */ hn b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ XMPushService f9181c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i2, hq hqVar, hn hnVar, XMPushService xMPushService) {
        super(i2);
        this.a = hqVar;
        this.b = hnVar;
        this.f9181c = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            hi hiVar = new hi();
            hiVar.c(ha.CancelPushMessageACK.ah);
            hiVar.a(this.a.d());
            hiVar.a(this.a.b());
            hiVar.b(this.a.f());
            hiVar.e(this.a.m());
            hiVar.a(0L);
            hiVar.d("success clear push message.");
            j.a(this.f9181c, j.b(this.b.j(), this.b.h(), hiVar, gq.Notification));
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.d("clear push message. " + e2);
            this.f9181c.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send ack message for clear push message.";
    }
}
