package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class fk extends XMPushService.j {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ fj f8593c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fk(fj fjVar, int i2, long j2, long j3) {
        super(i2);
        this.f8593c = fjVar;
        this.a = j2;
        this.b = j3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        Thread.yield();
        if (!this.f8593c.k() || this.f8593c.a(this.a)) {
            return;
        }
        com.xiaomi.push.service.ck.a(this.f8593c.r).b();
        this.f8593c.r.a(22, (Exception) null);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "check the ping-pong." + this.b;
    }
}
